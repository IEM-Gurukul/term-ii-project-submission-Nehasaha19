[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title

---Student Management System with Automated Tracking

## Problem Statement (max 150 words)

---Managing student records manually or through basic systems often leads to inefficiencies, errors, and lack of real-time insights into student performance and attendance. Institutions struggle with tracking attendance consistently, generating timely reports, and monitoring academic progress in an automated manner.

This project aims to develop a Student Management System with Automated Tracking that streamlines student data handling, automates attendance tracking, and generates performance reports dynamically. The system reduces manual effort, minimizes errors, and provides timely insights through automated processes such as scheduled updates and report generation. It enhances decision-making for educators and improves transparency for students.

## Target User

---School/College Administrators
Teachers / Faculty Members
Students (for viewing records and reports)

## Core Features

- 
- 
- 

---Student record management (add, update, delete, search)
Automated attendance tracking system
Performance report generation (grades, attendance summary)
Background processing for tracking updates (automation)
User-friendly console/GUI interface

## OOP Concepts Used

- Abstraction:
Abstract classes/interfaces like Person or User to define common properties.
- Inheritance:
Student and Teacher classes inherit from a base Person class.
- Polymorphism:
Method overriding (e.g., generateReport() behaves differently for students and admins).
- Exception Handling:
Handles invalid inputs, missing data, and runtime errors (e.g., student not found).
- Collections / Threads:
Collections: ArrayList, HashMap to store student records efficiently
Threads (Improved as per feedback):
Used for:
Background attendance tracking updates
Periodic report generation (e.g., every few seconds/minutes using timers)
Asynchronous data processing without blocking the main program

---

## Proposed Architecture Description

---The system follows a modular object-oriented architecture:

Student Module: Handles student data (ID, name, grades, attendance)
Attendance/Tracking Module: Automatically updates attendance using scheduled or triggered events
Report Module: Generates performance summaries and attendance reports
Main Controller: Coordinates interaction between modules

Automation is achieved through thread-based background services, which periodically update attendance records and generate reports without user intervention. This ensures smooth performance and real-time updates.

## How to Run

---Install Java (JDK 8 or above)
Clone the repository

Compile the project:

javac Main.java


Run the program:

java Main

Follow on-screen instructions

## Git Discipline Notes
Minimum 10 meaningful commits required.
Each commit reflects a logical development step:
Feature implementation
Bug fixes
Refactoring
Documentation updates
