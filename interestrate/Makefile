all: jar

jar: main
	jar -cvfm main.jar manifest.txt InterestRate.class
	chmod +x main.jar

main: src/InterestRate.java
	javac src/InterestRate.java -d .
