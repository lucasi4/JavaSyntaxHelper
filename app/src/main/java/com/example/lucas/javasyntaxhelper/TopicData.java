package com.example.lucas.javasyntaxhelper;

/**
 * Created by Lucas on 6/13/2015.
 */
public interface TopicData {

    String [] topics = {
            "Variables",  //1
            "Comments", //2
            "Data Types",  //3
            "Constants", //4
            "if Statements", //5
            "Multiple Alternative if",  //6
            "Comparing Values ", //7
            "While Loop",  //8
            "Do While Loop",//0
            "For Loop",   //11
            "Arrays", //12
            "Two-Dimensional Arrays",
            "ArrayList"
    };

    String [] descriptions = {
            "A variable is a storage location in a computer program." +
                    " Shown above is an example of a variable being declared and initialized.", //variables
            "Comments are text ignored by the compiler. They can be used to describe and " +
                    "explain your code to other programmers and they can be useful when you" +
                    " review your own code in the future.", //comments
            "In Java, every value is either a reference to an object, or it belongs to one of " +
                    "the eight primitive types." + "\nSix of the primitive types are number types;" +
            " four of them for integers and two for floating-point numbers." +
                    "Shown above are some example data types and their declarations.", //data types
            "A final variable is a constant. Once its value has been set, it cannot be changed." +
                    " Constants are commonly declared using all upper-case letters.", //constants
            "The if statement is used to implement a decision. When a condition is fulfilled " +
                    "one set of statements is executed.", //if statement
            "In a multiple alternative if statement, else if (condition) is used to include "+
                "more than two alternatives. Much like the if-else statement, when a condition is" +
                " fulfilled, the set of statements within will be executed.",  //multiple alternative if
            "Every if statement contains a condition. In many cases the condition involves" +
             " comparing two values. A relational operator tests the relationship between two values", //comparing
            "Loops repeatedly execute instructions until some condition is satisfied. " +
                "In a while loop, the statements within the loop will be executed while the condition remains true.", //while loop
            "Loops repeatedly execute instructions until some condition is satisfied. " +
            "Using the do-while loop guarantees that the statement will be executed at least one" +
            " time before checking if the condition remains.", //do while
            "Using a for loop, you can execute a sequence of statements a given number of times "+
            "The for loop groups the initialization, condition, and update expressions together. ", //for loop
            "Arrays are the fundamental mechanism in Java for collecting multiple values. "+
            "Arrays are used to store a sequence of values of the same type. " +
                    "The size of an array is fixed and cannot be changed.", //arrays
            "Two-dimensional arrays can be used to store collections of values that have a "+
            "two dimensional layout. As with one dimensional arrays, you cannot change the size  "+
            "of a two-dimensional array once it has been declared.", //2d array
            "ArrayList can be used when you are unsure of how many inputs you will have."+
                    "Unlike ararys, ArrayList can grow and shrink as needed. In order to use" +
                     " the ArrayList class, you must import java.util.ArrayList" //arraylist
    };

    String [] imgFilenames = {
            "filename1",
            "filename2",
            "filename3",
            "filename4",
            "filename5",
            "filename6",
            "filename7",
            "filename8",
            "filename0",
            "filename11",
            "filename12",
            "filename13",
            "filename14"
    };
}
