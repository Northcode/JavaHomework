all: jar

jar: main
	jar -cvfm main.jar manifest.txt Average.class
	chmod +x main.jar

main: src/Average.java
	javac src/Average.java -d .
