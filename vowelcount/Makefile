all: jar

jar: main
	jar -cvfm main.jar manifest.txt VowelCount.class
	chmod +x main.jar

main: src/VowelCount.java
	javac src/VowelCount.java -d .
