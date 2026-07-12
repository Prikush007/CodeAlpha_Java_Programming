package com.codealpha.chatbot;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Chatbot 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("=================================");
		System.out.println("      Welcome to AI ChatBot");
		System.out.println("Type 'bye' to exit.");
		System.out.println("=================================");
		
		System.out.print("Enter your name: ");
		String name = sc.nextLine();

		FileWriter writer = null;

		try {
		    writer = new FileWriter("ChatHistory.txt", true);
		} catch (IOException e) {
		    System.out.println("Error creating file.");
		}
		
		System.out.println("Hello " + name + "! Welcome to AI ChatBot.");

		while (true) {

		    System.out.print("\nYou : ");
		    String message = sc.nextLine();
		    
		    try {
		        writer.write("You : " + message + "\n");
		        writer.flush();
		    } catch (IOException e) {
		        System.out.println("Error writing to file.");
		    }

		    if (message.equalsIgnoreCase("bye")) {
		    	botReply(writer, "Goodbye! Have a nice day.");
		    	break;
		    }

		    if (message.equalsIgnoreCase("hello") || message.equalsIgnoreCase("hi"))
		    {
		    	botReply(writer, "Hello " + name + "! How can I help you?");
		    }
		    else if (message.equalsIgnoreCase("how are you")) {
		    	botReply(writer, "I am doing great, " + name + "!");
		    }
		    else if (message.equalsIgnoreCase("what is java")) {
		    	botReply(writer, "Java is an object-oriented programming language.");
		    }
		    else if (message.equalsIgnoreCase("what is ai")) {
		    	botReply(writer, "AI stands for Artificial Intelligence.");
		    }
		    else if (message.equalsIgnoreCase("who created you")) {
		    	botReply(writer, "I was created as a Java internship project.");
		    }
		    else if (message.equalsIgnoreCase("thank you")) {
		    	botReply(writer, "You're welcome!");
		    }
		    else if (message.equalsIgnoreCase("your name")) {
		    	botReply(writer, "My name is CodeAlpha AI ChatBot.");
		    }
		    else if (message.equalsIgnoreCase("who are you")) {
		    	botReply(writer, "I am an AI ChatBot developed in Java for the CodeAlpha Internship.");
		    }
		    else if (message.equalsIgnoreCase("date")) {
		    	botReply(writer, "Today's date is " + LocalDate.now());
		    }
		    else if (message.equalsIgnoreCase("time")) {
		    	botReply(writer, "Current time is " + LocalTime.now().withNano(0));
		    }
		    else if (message.equalsIgnoreCase("motivate me")) {
		    	botReply(writer, "Believe in yourself. Every expert was once a beginner!");
		    }
		    else if (message.equalsIgnoreCase("tell me a joke")) {
		    	botReply(writer, "Why do Java developers wear glasses? Because they don't C#.");
		    }
		    else if (message.equalsIgnoreCase("help")) {
		    	botReply(writer,
		    			"You can ask me:\n" +
		    			"- hello\n" +
		    			"- hi\n" +
		    			"- how are you\n" +
		    			"- what is java\n" +
		    			"- what is ai\n" +
		    			"- your name\n" +
		    			"- who are you\n" +
		    			"- who created you\n" +
		    			"- date\n" +
		    			"- time\n" +
		    			"- motivate me\n" +
		    			"- tell me a joke\n" +
		    			"- thank you\n" +
		    			"- bye");
		    }
		    else {
		    	botReply(writer,
		    			"Sorry " + name + ", I don't understand that.\nType 'help' to see the list of available commands.");
		    }

		}
		
		try {
		    writer.close();
		} catch (IOException e) {
		    System.out.println("Error closing file.");
		}
		
		sc.close();

	}

	public static void botReply(FileWriter writer, String reply) {

	    System.out.println("Bot : " + reply);

	    try {
	        writer.write("Bot : " + reply + "\n\n");
	        writer.flush();
	    }
	    catch(IOException e) {
	        System.out.println("Error writing to file.");
	    }

	}
	
	
}
