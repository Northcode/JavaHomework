all: jar

jar: main
	jar -cvfm main.jar manifest.txt Weekdays.class
	chmod +x main.jar

main: src/Weekdays.java
	javac src/Weekdays.java -d .
