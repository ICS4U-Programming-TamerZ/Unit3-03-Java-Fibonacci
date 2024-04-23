package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class reads an integer from a file, generates the Fibonacci sequence up to that integer, and writes the sequence to an output file.
 *
 * @author Tamer Zreg
 * @version 1.0
 * @since 2024-04-23
 */
public class Fibonacci {
    public static void main(String[] args) {
        // File paths
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        try {
            // Read integer from file
            int n = readIntegerFromFile(inputFileName);
            // Generate and print Fibonacci sequence
            String sequence = generateFibonacciSequence(n);
            System.out.println("Fibonacci sequence up to " + n + ":");
            System.out.println(sequence);
            // Write the sequence to output file
            writeToFile(outputFileName, "Fibonacci sequence up to " + n + ":\n" + sequence);
            System.out.println("Output written to " + outputFileName);
        } catch (IOException e) {
            // Handle file reading errors
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Function to read an integer from a file
    public static int readIntegerFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        }
    }

    // Function to generate Fibonacci sequence up to n
    public static String generateFibonacciSequence(int n) {
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 1;
        sb.append(a).append(" ");
        for (int i = 1; i < n; i++) {
            sb.append(b).append(" ");
            int next = a + b;
            a = b;
            b = next;
        }
        return sb.toString();
    }

    // Function to write content to a file
    public static void writeToFile(String fileName, String content) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        }
    }
}