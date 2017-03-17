package nl.han.ica.icss.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.checker.Checker;
import nl.han.ica.icss.checker.SemanticError;
import nl.han.ica.icss.generator.Generator;
import nl.han.ica.icss.parser.ASTListener;
import nl.han.ica.icss.parser.ICSSLexer;
import nl.han.ica.icss.parser.ICSSParser;

import nl.han.ica.icss.transforms.EvalOperations;
import nl.han.ica.icss.transforms.InlineConstants;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

@SuppressWarnings("restriction")
public class Main extends Application implements ANTLRErrorListener {

	//UI Components
	private InputPane inputPane;
	private ASTPane astPane;
	private OutputPane outputPane;
	private FeedbackPane feedbackPane;

    //Toolbar buttons
    private Button parseButton;
    private Button checkButton;
    private Button transformButton;
    private Button generateButton;

	//Model
	private AST ast;

	public static void main(String[] args) throws IOException {
		launch(args);
	}
	@Override
	public void start(Stage stage) {
		//Setup UI
		stage.setTitle("ICSS Tool 2017");

		inputPane = new InputPane();
		astPane = new ASTPane();
		outputPane = new OutputPane();
		feedbackPane = new FeedbackPane();

		//Reference for the callbacks
		final Main me = this;
		
		//Create buttons
		parseButton = new Button("Parse");
		parseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { me.parse(); }
		});

		checkButton = new Button("Check");
		checkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { me.check(); }
		});
		transformButton = new Button("Transform");
		transformButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { me.transform(); }
		});
		generateButton = new Button("Generate");
		generateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { me.generate(); }
		});

		//Create menus
		MenuBar menuBar = new MenuBar();
		
		Menu fileMenu = new Menu("File");
		MenuItem loadInput = new MenuItem("Load input ICSS...");
		loadInput.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open input ICSS...");
				fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ICSS", "*.icss"));

				File file = fileChooser.showOpenDialog(stage);
				if(file != null) {
					inputPane.setTextFromFile(file);
				}
			}
		});

		MenuItem saveOutput = new MenuItem("Save generated CSS...");
		saveOutput.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//Create file dialog
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save generated CSS...");
				fileChooser.setInitialFileName("output.css");

				File file = fileChooser.showSaveDialog(stage);
				if (file != null) {
					outputPane.writeToFile(file);
				}
			}
		});
		
		MenuItem quit = new MenuItem("Quit");
		quit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Platform.exit();
			}
		});
		
		fileMenu.getItems().addAll(loadInput,new SeparatorMenuItem(),
				saveOutput,new SeparatorMenuItem(),quit);
		menuBar.getMenus().addAll(fileMenu);
		
		//Layout components
		BorderPane main = new BorderPane();
		HBox center = new HBox();
		center.getChildren().addAll(inputPane,astPane,outputPane);

		//Toolbar
		HBox toolbar = new HBox();
        toolbar.setPadding(new Insets(5, 5, 5, 5));
		toolbar.getChildren().addAll(new Label("Pipeline: "), parseButton,checkButton,transformButton,generateButton);
		updateToolbar();

		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(10, 10, 10, 10));
		bottom.setTop(toolbar);
		bottom.setCenter(feedbackPane);

		main.setTop(menuBar);
		main.setCenter(center);
		main.setBottom(bottom);
	
		Scene scene = new Scene(main, 1200, 600);
		scene.getStylesheets().add("gui.css");
		
		stage.setScene(scene);
		stage.show();
	}

	private void parse() {
	    feedbackPane.clear();
		feedbackPane.addLine("Lexing...");
		//Lex (with Antlr's generated lexer)
		ANTLRInputStream inputStream = new ANTLRInputStream(inputPane.getText());
		ICSSLexer lexer = new ICSSLexer(inputStream);
		lexer.addErrorListener(this);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		feedbackPane.addLine("Parsing...");

		//Parse (with Antlr's generated parser)
		ICSSParser parser = new ICSSParser(tokens);
		parser.addErrorListener(this);
		ParseTree parseTree = parser.stylesheet();

		//Extract AST from the Antlr parse tree
		feedbackPane.addLine("Building AST...");
		ASTListener listener = new ASTListener();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener,parseTree);

		this.ast = listener.getAST();

		//Update the AST Pane
		astPane.update(this.ast);
        updateToolbar();
	}
	private void check() {
		if(this.ast != null) {
            feedbackPane.clear();
			feedbackPane.addLine("Checking...");

            (new Checker()).check(this.ast);

			ArrayList<SemanticError> errors = this.ast.getErrors();
			if (!errors.isEmpty()) {
				for (SemanticError e : errors) {
					feedbackPane.addLine(e.toString());
				}
			} else {
			    feedbackPane.addLine("AST is ok!");
            }

            astPane.update(this.ast);
            updateToolbar();
		}
	}
	private void transform() {
	    if(this.ast != null && ast.checked) {
            feedbackPane.clear();
			feedbackPane.addLine("Applying transformations...");

			new InlineConstants().apply(ast);
			new EvalOperations().apply(ast);

            //Update the AST Pane
            astPane.update(this.ast);

            updateToolbar();
		}
	}
	private void generate() {
		if(this.ast != null && ast.checked) {
            feedbackPane.clear();
			feedbackPane.addLine("Generating output...");

			Generator generator = new Generator();
			outputPane.setText(generator.generate(ast));

			updateToolbar();
		}
	}

	private void updateToolbar() {

	    //Quick and ugly way...
        checkButton.setDisable(true);
        transformButton.setDisable(true);
        generateButton.setDisable(true);
        if(this.ast != null) {
            checkButton.setDisable(false);
            if(this.ast.checked) {
                transformButton.setDisable(false);
                generateButton.setDisable(false);
            }
        }
	}

	//Catch ANTLR errors
	@Override
	public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3,
			boolean arg4, BitSet arg5, ATNConfigSet arg6) {
	}
	@Override
	public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2,
			int arg3, BitSet arg4, ATNConfigSet arg5) {
	}
	@Override
	public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2,
			int arg3, int arg4, ATNConfigSet arg5) {
	}
	@Override
	public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2,
			int arg3, String arg4, RecognitionException arg5) {
	    feedbackPane.addLine(arg5.getMessage());
	}
}
