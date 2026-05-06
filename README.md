[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23508972)
# Air Filter Tracker — Java Console Application
A Java console application for managing air filters, tracking their usage, and running countdown timers that automatically update filter hours.
Filters are stored in a 3×3 dynamic grid, and the program provides warnings, progress bars, and status insights.

# Who made it?
Code was made by Ayres Wright with some assist by Microsoft Copilot for suggestions and java documentation.

## Features
- Create filters with a **name** and **hour-based time limit**
- Store filters in a **3-row dynamic grid**
- Start and pause a **countdown timer** for any filter
- Automatically update filter usage as time passes
- Display expiration warnings:
  - 50% used → WARNING
  - 75% used → CRITICAL
  - 100% used → EXPIRED
- Reset filter usage back to zero
- View a formatted grid with:
  - Usage percentages
  - Progress bars
  - Status insights


## Class Overview

### **Filter**
Represents a single air filter.

Stores:
- `nameOfFilter` — filter name
- `timeLimit` — total hours before expiration
- `hoursUsed` — hours already used

Key methods:
- `addUsage(int hours)`
- `resetUsage()`
- `isExpired()`
- `updateTimeUsed(int i)`

### **TimerManger**
Handles countdown logic and updates the attached filter.

Stores:
- `countdownValue` — remaining time
- `isRunning` — whether the timer is active
- `currentFilter` — filter being updated

Key methods:
- `attachFilter(Filter f)`
- `startCountdown()`
- `pauseCountdown()`
- `tick()` — decreases countdown and updates filter
- `isFinished()`

### **MainApp**
The main console interface.

Responsibilities:
- Display menu
- Create filters
- Start/pause timers
- Reset filters
- Display expiration warnings
- Render the filter grid with progress bars and insights

Helper methods:
- `getPositiveInt()` — validates numeric input
- `formatFilterDisplay()` — builds progress bar + status
- `formatFilterInsights()` — gives usage advice

<img width="852" height="501" alt="filters-Page-1 drawio (1)" src="https://github.com/user-attachments/assets/88fd1493-8234-4de9-b920-55f588b55cbc" />
