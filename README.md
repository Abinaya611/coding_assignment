
# Java Assignment  

This repository contains two parts:  
1. **patterns** – Exercise 1 with design pattern demos.  
2. **astronaut-scheduler** – Exercise 2 starter code for the Astronaut Daily Schedule Organizer.  



##  Exercise 1: Design Patterns in Java  

### Description  
This module demonstrates the implementation of **three categories of design patterns** in Java:  
- **Creational** (e.g., Singleton, Factory)  
- **Structural** (e.g., Adapter, Decorator)  
- **Behavioral** (e.g., Strategy, Observer)  

Each pattern is implemented with simple examples to understand usage and benefits.  

###  How to Run  

```bash
# 1. Clone the repository
git clone https://github.com/Abinaya611/coding_assignment.git
cd coding_assignment

# 2. Move into patterns project
cd patterns

# 3. Compile any pattern demo, e.g., Singleton
javac creational/Singleton.java

# 4. Run the program
java creational.Singleton
```

###  Sample Output  

**Singleton Pattern**  

```
Object created
Using the same instance...
```

**Strategy Pattern**  

```
Sorting using Bubble Sort...
Sorting using Quick Sort...
```

---

##  Exercise 2: Astronaut Daily Schedule Organizer  

### Description  
A console-based Java application that allows astronauts (or users) to manage daily tasks.  

### Features  
- Add tasks with name, time, and priority (High/Medium/Low)  
- List all tasks in a structured format  
- Mark tasks as done  
- Remove tasks from the schedule  
- Simple command-line interface  

###  How to Run  

```bash
# 1. Move into astronaut-scheduler project
cd astronaut-scheduler

# 2. Compile the main program
javac App.java

# 3. Run the program
java App
```

###  Sample Output  

```
>>>>>>> 74cb6ec (Updated README.md with correct structure and run instructions)
Astronaut Daily Schedule Organizer (type 'help' for commands)

> help
Commands:
  add "Task Name" HH:MM HH:MM priority(1=high,2=med,3=low)
  list
  remove <Task Name>
  done <Task Name>
  exit
<<<<<<< HEAD

# Repository Structure
=======
```

---

##  Repository Structure  

```
>>>>>>> 74cb6ec (Updated README.md with correct structure and run instructions)
coding_assignment/
│
├── astronaut-scheduler/       # Astronaut Daily Scheduler Project
│   ├── App.java
│   └── ... (other classes)
│
├── patterns/                  # Design Patterns Project
│   ├── behavioural/
│   ├── creational/
│   ├── structural/
│
└── README.md                  # Project Documentation
<<<<<<< HEAD

 **Note**

This repository is created only for educational and learning purposes.
Not intended for production use.
=======
```

---

##  Note  
This repository is created **only for educational and learning purposes**.  
Not intended for production use.  

