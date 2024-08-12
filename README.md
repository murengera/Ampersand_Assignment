
# Product Listing App

This is a simple Android app that displays a list of products and allows users to view detailed information about each product. The app is designed to work on both phones and tablets, with a dedicated landscape layout for tablets.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Running the App](#running-the-app)
- [Libraries and Tools Used](#libraries-and-tools-used)
- [Design Decisions](#design-decisions)
- [Assumptions](#assumptions)

## Features
- Display a list of products in a `ListView`.
- View detailed information about each product, including name, price, and color.
- Dedicated landscape layout for tablets.
- A `Toolbar` with the product name and a back arrow in the detail view.

## Installation

### Prerequisites
- Android Studio (latest version recommended)
- Android SDK

### Steps
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in Android Studio:
    - Open Android Studio and select "Open an existing project."
    - Navigate to the cloned repository and select the project folder.

3. Sync the project with Gradle:
    - Once the project is opened, Android Studio will prompt you to sync with Gradle. Click "Sync Now."

4. Build the project:
    - Go to `Build > Rebuild Project` to ensure that everything is set up correctly.

## Running the App

1. Run on an Emulator or Physical Device:
    - Connect a physical device or start an Android emulator.
    - Click the "Run" button in Android Studio or use `Shift + F10`.

2. Navigate the App:
    - The app will display a list of products.
    - Click on any product to view its details.

## Libraries and Tools Used
- AndroidX Libraries: Used for backward compatibility and modern Android development.
- ConstraintLayout: Used to create flexible and responsive layouts.
- ListView: Used to display the list of products.
- Toolbar: Used to display the app bar with the title and back navigation.

## Design Decisions
- ConstraintLayout:Chosen for its flexibility and ability to create complex layouts with ease.
- ListView: Although `RecyclerView` is more modern, `ListView` was chosen for simplicity in this context.
- Tablet Layout: A dedicated landscape layout was created to enhance the user experience on tablets.

## Assumptions
- The app assumes that the product data is fetched from a remote API or static data source.
- It assumes that the product data includes at least a name, price, and color.

