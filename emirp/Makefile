all: jar

jar: main
	jar -cvfm main.jar manifest.txt Emirp.class
	chmod +x main.jar

main: src/Emirp.java
	javac src/Emirp.java -d .
