📘 Java Lab Assignment 2
Inheritance, Interfaces, and Modular Design
Student Management System (Single-File Version)
📌 Project Overview

This project implements a Student Management System using core Object-Oriented Programming concepts:

Abstract Classes

Inheritance

Method Overloading & Overriding

Interfaces

Polymorphism (static + dynamic)

Final Class & Final Method

finalize() method demonstration

HashMap-based student storage

All code combined into one single Java file for easy execution

The system supports Add, Delete, Update, Search, and View operations for student records.

🧱 Features Implemented
✔ Abstract Class

Person with abstract method displayInfo()

✔ Inheritance

Student → Person

ResearchStudent → Student

✔ Method Overriding

displayInfo() overridden in Student and ResearchStudent

✔ Method Overloading

displayInfo(boolean showMarks) demonstrating compile-time polymorphism

✔ Interface Implementation

RecordActions with CRUD operations:

addStudent()
deleteStudent()
updateStudent()
searchStudent()
viewAllStudents()

✔ Final Class & Final Method

ResearchStudent marked as final

showFinalNote() method is final

✔ Dynamic Polymorphism
Person p = new Student();
p.displayInfo();

✔ HashMap Data Storage

Efficient management of students with duplicate roll number prevention.

📂 Files in This Project
File Name	Description
StudentManagementSystem.java	Full system implementation (all classes inside one file)
README.md	Documentation for GitHub
▶️ How to Run the Program
1. Compile
javac StudentManagementSystem.java

2. Run
java StudentManagementSystem

📤 Sample Output
Student Added Successfully.
Student Added Successfully.

Student Info:
Roll No: 101
Name: Ankit
Email: ankit@mail.com
Course: B.Tech
---------------------------

Student Info:
Roll No: 102
Name: Riya
Email: riya@mail.com
Course: M.Tech
Research Area: AI
---------------------------

Student Info:
Roll No: 101
Name: Ankit
Email: ankit@mail.com
Course: B.Tech
Marks: 0.0
Grade:
[Note] Overloaded display method:

This is a final method in a final class.
Finalize method called before object is garbage collected.

🎯 Learning Outcomes

By completing this assignment, you will learn:

How abstract classes and interfaces work

Differences between method overloading and overriding

How inheritance and polymorphism are applied

How to design modular code

How HashMap can be used to manage records

👨‍💻 Author

Sabir Ali
Java Programming Lab – Assignment 2
