all: jar

jar: main
	jar -cvfm main.jar manifest.txt CoinToss.class
	chmod +x main.jar

main: src/CoinToss.java
	javac src/CoinToss.java -d .
