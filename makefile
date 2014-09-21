all:
	javac -d bin -sourcepath src src/core/Start.java

clean :
	find . -name "*.class" -type f -delete
