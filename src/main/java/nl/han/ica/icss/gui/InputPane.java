package nl.han.ica.icss.gui;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

@SuppressWarnings("restriction")
public class InputPane extends BorderPane {
	private TextArea content;
	private Label title;
	
	public InputPane() {
		super();
		
		title = new Label("Input (ICSS):");
		content = new TextArea();
		//TODO: Remove this crap for the teacher.
		content.setText("$linkcolor = #ff0000;\n" +
                "$parwidth = 500px;\n" +
                "\n" +
                "p {\n" +
                "\tbackground-color: #ffffff;\n" +
                "\twidth: $parwidth;\n" +
                "}\n" +
                "\n" +
                "a {\n" +
                "\tcolor: $linkcolor;\n" +
                "}\n" +
                "\n" +
                "#menu {\n" +
                "\twidth: 520px;\n" +
                "}\n" +
                "\n" +
                ".menu {\n" +
                "\tcolor: #000000;\n" +
                "}\n" +
                "");
		title.setPadding(new Insets(5, 5, 5, 5));
		
		this.setTop(title);
		this.setCenter(content);
	}
	public void setText(String text) {
		this.content.setText(text);
	}
	public void setTextFromFile(File file) {
		try {
			this.setText(new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset()));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	public String getText() {
		return content.getText();
	}
}
