all: jar

jar: main
	jar -cvfm main.jar manifest.txt CreditCardNumber.class
	chmod +x main.jar

main: src/CreditCardNumber.java
	javac src/CreditCardNumber.java -d .
