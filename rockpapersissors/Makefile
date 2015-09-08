all: jar

jar: main
	jar -cvfm main.jar manifest.txt RockPaperSissors.class
	chmod +x main.jar

main: src/RockPaperSissors.java
	javac src/RockPaperSissors.java -d .
