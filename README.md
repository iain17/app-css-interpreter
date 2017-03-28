#CSS interpreter

This repo contains the result of a school assignment. The assignment was to create a new CSS dialect, which you can compare to something like [sass](https://github.com/sass/sass). Called ICSS-17 (ICA-CSS), this interpreter aims to showcase that I as a student am competent in writing a interpreter/compiler.

The result that this program will output eventually CSS2-compliant code, with a new language "ICSS" as input.

## Requirements

Only the GUI was given with this assignment. The rest: parser, checker, transformer and generator were developed in a short span of time. It only fulfills the requirements given at the time.

![Screenshot of the app](https://api.monosnap.com/rpc/file/download?id=8UlJDBaFu33u1AF7B8P6WqXx2apAEV)

**Below are the requirements I received, written in Dutch**

### Parser
- PA01Implementeer een parser plus listener die AST’s kan maken voor ICSS documenten die ëenvoudige opmaak”kan parseren, zoals beschreven in de taalbeschrijving. In             vindt je een voorbeeld van ICSS code die je moet kunnen parseren.

--- PA02
Breidt je grammatica en listener uit zodat nu ook assignments en het ge- bruik ervan geparseerd kunnen worden. In             vindt je voor- beeldcode die je nu zou moeten kunnen.

--- PA03Breidt je grammatica en listener uit zodat je nu ook optellen en aftrekken kunt parseren. In             vindt je voorbeeldcode die je nu zou moeten kunnen.--- PA04Breidt je grammatica en listener uit zodat je ook geneste stijlregels aan- kunt. In vindt je voorbeeldcode die je nu zou moeten kunnen.

### Checker

Tijdens het compileren van ICSS naar CSS willen we eerst controleren of de code naast syntactisch correct, ook semantisch correct is. Dit doe je door de checker component te implementeren. Als je fouten detecteert in de AST kun je deze in de knopen van de AST opslaan. Daarnaast bouw je tijdens het checken de symboltabel op. In deze tabel kun je terugvinden welke waarde bij welke constante hoort.

- CH01

Controleer of er geen constantes in declaraties worden gebruikt die nog niet gedefinieerd zijn.

--

- CH02

Controleer of er geen constantes worden gedefinieerd die al bestaan.

--

- CH03

Controleer of de operanden van de operaties (plus en min) van gelijk type. Je mag geen pixels bij kleuren optellen bijvoorbeeld.

--

- CH04

Controleer of bij declaraties het type van de waarde klopt bij de stijleigenschap. Declaraties zoals                of zijn natuurlijk onzin.

--

## Transformer

Om het genereren van de code makkelijker te maken gaan we de AST in een aantal stappen vereenvoudigen. Hiervoor zijn een tweetal transformaties gedefinieerd in.

- TR01 

Implementeer de transformatie. Deze transformatie vervangt alle knopen in de AST door de value knoop waar ze naar wijzen.

--

- TR02

Implementeer de transformatie. Deze transformatie vervangt iedere knoop in de AST door het resultaat van de operatie (dit is dus een knoop).

## Generate
De laatste stap is het generereren van CSS2-compliant vanuit ICSS code. Dit doe je door een tree-traversal op de AST te doen om een string op te bouwen.

- GE01

Implementeer de generator voor ICSS zonder geneste stijlregels.

--

- GE02

Breidt de generator uit dat je nu ook de geneste stijlregels aankunt. In CSS bestaat geen nesting, dus in de gegenereerde code staan alle stijl- regels op het topniveau. Verder moet je nu “samengestelde” selectors genereren. Een selector binnen een selector moet in de output worden.