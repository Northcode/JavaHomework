all: jar

jar: main
	jar -cvfm main.jar manifest.txt *.class
	chmod +x main.jar

main: src/CompareCosts.java
	javac src/CompareCosts.java -d .
