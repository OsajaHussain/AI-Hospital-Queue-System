# AI Hospital Queue Management System

A Java console application that manages hospital patient queues using data structures and AI.

## Features
- Queue: manages the waiting line of patients (FIFO)
- Stack: keeps history of served patients and supports undo (LIFO)
- Binary Search Tree: fast patient search by name and sorted listing
- Graph with Dijkstra: shortest route from Reception to any department
- AI (Google Gemini): recommends a department from the patient's symptoms, with a keyword-based fallback

## How to run
1. Install Java (JDK 17 or newer)
2. (Optional) Set your Gemini API key in PowerShell:
   $env:GEMINI_API_KEY="your_key_here"
3. Compile and run:
   javac *.java
   java Main

The program works without an API key by using the keyword-based fallback.
