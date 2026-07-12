package com.codealpha.gradetracker;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("    STUDENT GRADE TRACKER");
        System.out.println("=================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[] marks = new int[n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("\nEnter Student Name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter Marks: ");
            marks[i] = sc.nextInt();
            sc.nextLine();
        }

        int total = 0;
        int highest = marks[0];
        int lowest = marks[0];
        String topper = names[0];

        for (int i = 0; i < n; i++) {

            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                topper = names[i];
            }
            
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        double average = (double) total / n;
        System.out.println("\nStudent Details");

        for (int i = 0; i < n; i++) {

            String grade;

            if (marks[i] >= 90)
                grade = "A";
            else if (marks[i] >= 75)
                grade = "B";
            else if (marks[i] >= 60)
                grade = "C";
            else
                grade = "D";

            String result;

            if (marks[i] >= 33)
                result = "PASS";
            else
                result = "FAIL";

            System.out.println(names[i] + " : " + marks[i]
                    + " Grade : " + grade
                    + " Result : " + result);
        }

        System.out.println("\n========== SUMMARY ==========");
        System.out.printf("Average Marks : %.2f\n", average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks : " + lowest);
        System.out.println("Topper : " + topper);
        
        try {
            FileWriter writer = new FileWriter("StudentReport.txt");

            writer.write("========== STUDENT REPORT ==========\n\n");

            for (int i = 0; i < n; i++) {

                String grade;

                if (marks[i] >= 90)
                    grade = "A";
                else if (marks[i] >= 75)
                    grade = "B";
                else if (marks[i] >= 60)
                    grade = "C";
                else
                    grade = "D";

                String result;

                if (marks[i] >= 33)
                    result = "PASS";
                else
                    result = "FAIL";
                writer.write(names[i] + " : " + marks[i]
                        + " Grade : " + grade
                        + " Result : " + result + "\n");
                }

            writer.write("\nAverage Marks : " + average);
            writer.write("\nHighest Marks : " + highest);
            writer.write("\nLowest Marks : " + lowest);
            writer.write("\nTopper : " + topper);

            writer.close();

            System.out.println("\nStudent report saved successfully!");
            System.out.println("\nThank you for using Student Grade Tracker.");

        } catch (IOException e) {
            System.out.println("Error saving report.");
        }

        sc.close();
    }
}