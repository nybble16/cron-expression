# Cron Expression Parser - Homework

## Overview

This project is a command line application developed in Kotlin, designed to parse cron strings and expand each field to show the times at which it will run. It adheres to the standard cron format with five time fields (minute, hour, day of month, month, and day of week) plus a command.

## Features

- Parses standard cron strings passed as a single argument.
- Outputs the parsed data in a user-friendly table format.

## Getting Started

### Prerequisites

- Java JDK 11 or higher (For Java version)
- Kotlin Compiler 1.4 or higher (For Kotlin version)
- Git

### Installation

Clone the repository using Git:

```
git clone git@github.com:nybble16/olx-cron-expression.git
```

### Running the Application

Navigate to the project directory and run the application using:

For Java:

```
java -jar CronExpressionParser.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

For Kotlin:

```
kotlin CronExpressionParser.kt "*/15 0 1,15 * 1-5 /usr/bin/find"
```

## Usage

Pass a cron string as a single argument to the application. Example:

```
DayOfMonthExpression "*/15 0 1,15 * 1-5 /usr/bin/find"
```

### Output

The application will output a table with the following columns:

- Minute
- Hour
- Day of Month
- Month
- Day of Week
- Command

## Development

This project was developed within a 3-hour window, and as such, may not be fully functional.

## Testing

Unit tests are included in the `/tests` directory. Run these tests to ensure functionality.

## Contributing

This project is not intended for extension or contribution.

## License

This project is licensed under the MIT License.

## Contact

Tomasz Zmarz - nybble16@gmail.com
