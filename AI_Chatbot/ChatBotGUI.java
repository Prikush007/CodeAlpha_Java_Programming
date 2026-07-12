package com.codealpha.chatbot;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ChatBotGUI {

    public static void main(String[] args) {

    	JFrame frame = new JFrame("CodeAlpha AI ChatBot");

        JTextArea chatArea = new JTextArea();
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(350, 35));
        JButton sendButton = new JButton("Send");
       
        sendButton.setBackground(new Color(0, 120, 215));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.setFont(new Font("Arial", Font.BOLD, 15));

        frame.setLayout(new BorderLayout());

        chatArea.setEditable(false);
        chatArea.setBackground(new Color(245,245,245));
        chatArea.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        frame.add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> {

            String message = inputField.getText().trim();

            if (message.isEmpty()) {
                return;
            }

            chatArea.append("You : " + message + "\n");
            try (FileWriter writer = new FileWriter("ChatHistory_GUI.txt", true)) {
                writer.write("You : " + message + "\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String reply;

            if (message.equalsIgnoreCase("hello") || message.equalsIgnoreCase("hi")) {
                reply = "Hello! How can I help you?";
            }
            else if (message.equalsIgnoreCase("how are you")) {
                reply = "I am doing great!";
            }
            else if (message.equalsIgnoreCase("what is java")) {
                reply = "Java is an object-oriented programming language.";
            }
            else if (message.equalsIgnoreCase("what is ai")) {
                reply = "AI stands for Artificial Intelligence.";
            }
            else if (message.equalsIgnoreCase("date")) {
                reply = java.time.LocalDate.now().toString();
            }
            else if (message.equalsIgnoreCase("time")) {
                reply = java.time.LocalTime.now().withNano(0).toString();
            }
            else if (message.equalsIgnoreCase("tell me a joke")) {
                reply = "Why do Java developers wear glasses? Because they don't C#.";
            }
            else if (message.equalsIgnoreCase("motivate me")) {
                reply = "Believe in yourself. Every expert was once a beginner!";
            }
            else if (message.equalsIgnoreCase("bye")) {
                reply = "Goodbye! Have a nice day.";
            }
            else if(message.equalsIgnoreCase("weather")){
                reply="I can't access live weather yet.";
            }
            else if(message.equalsIgnoreCase("who made you")){
                reply="I was developed by Preeti Kushwaha using Java.";
            }
            else if(message.equalsIgnoreCase("good morning")){
                reply="Good Morning! Have a wonderful day.";
            }
            else if(message.equalsIgnoreCase("good night")){
                reply="Good Night! Sweet dreams.";
            }
            else if(message.equalsIgnoreCase("thank you")){
                reply="You're welcome!";
            }
            else if(message.equalsIgnoreCase("who are you")){
                reply="I am an AI ChatBot created using Java for the CodeAlpha Internship.";
            }
            else if(message.equalsIgnoreCase("your name")){
                reply="My name is CodeAlpha AI ChatBot.";
            }
            else if(message.equalsIgnoreCase("help")){
            	reply = "Available Commands:\n\n"
            	        + "hello\n"
            	        + "hi\n"
            	        + "how are you\n"
            	        + "what is java\n"
            	        + "what is ai\n"
            	        + "date\n"
            	        + "time\n"
            	        + "weather\n"
            	        + "motivate me\n"
            	        + "tell me a joke\n"
            	        + "good morning\n"
            	        + "good night\n"
            	        + "who made you\n"
            	        + "who are you\n"
            	        + "your name\n"
            	        + "thank you\n"
            	        + "bye";
            }
            else {
            	reply = "Sorry, I don't understand your question.\nType 'help' to see all available commands.";
            }

            chatArea.append("Bot : " + reply + "\n\n");
            try (FileWriter writer = new FileWriter("ChatHistory_GUI.txt", true)) {
                writer.write("Bot : " + reply + "\n\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            chatArea.setCaretPosition(chatArea.getDocument().getLength());

            inputField.setText("");

        });
        inputField.addActionListener(e -> sendButton.doClick());
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        chatArea.append("====================================\n");
        chatArea.append("     Welcome to CodeAlpha AI ChatBot\n");
        chatArea.append("====================================\n");
        chatArea.append("Type 'help' to see available commands.\n\n");
        frame.setVisible(true);

    }

}