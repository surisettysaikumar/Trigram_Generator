# Trigram_Generator
Contents:
1. /src/code/Main.java is the entry point main class 
2. /src/code/InputParser.java file is used for parsing Input file,log starter,trigramDisplay,populate trigrams
3. /src/code/TrigramGenerator.java is used to create output strings based on trigram words list as input and writes ouput to a file
4. output.txt is the final output file
5. testoutput.txt is the output file of one of the Junit Testcase 
6. TrigramsBookGenerator.log is the log file generated
7. build.xml is Ant Build file
8. input.txt,input_2.txt and input_3.txt are some sample inputs for the program(To change the input filename, change in config.properties file)
9. config.properties ( Contains configurationdetails like word_limit, Input file name, output file name)
10./src/testcases contains JUnit Testcases

Implementation steps followed:
This project is implementation of CodeKata 14 article from http://codekata.com/kata/kata14-tom-swift-under-the-milkwood/
The objective of CodeKata 14 is to generate trigrams from the book and then re generate a different version of the book using the trigrams. 
I divided the task into two main steps:
1. Parsing through the input text file and generating trigrams
2. populate new strings/rewrite the input file content using trigrams randomly choosen everytime

Main.java is the entry point class for this solution and 2 more classes.

There are few additional things done like logging and exceptions thrown to make the code production level code. I belive still there can be more optimisations done if time permits.
