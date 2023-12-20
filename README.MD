# Cron Expression Parser

## Overview

This project is a command line application developed in Kotlin, designed to parse cron strings and expand each field to show the times at which it will run. It adheres to the standard cron format with five time fields (minute, hour, day of month, month, and day of week) plus a command.

## Features

- Parses standard cron strings passed as a single argument.
- Outputs the parsed data in a user-friendly table format.

## Getting Started

### Prerequisites

- Java JDK 17 or higher
- Kotlin Compiler 1.9 or higher
- Git

### Installation

Clone the repository using Git:

```
git clone git@github.com:nybble16/olx-cron-expression.git
```

Build the project using Gradle:

```
./gradlew build
```

### Running the Application

## Usage

Pass a cron string as a single argument to the application. Example:

```
java -jar OlxCronExpression.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

### Output

The application will output a table with the following columns: Minute, Hour, Day of Month, Month, Day of Week and Command.

For the above example it will produce the following output:

```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```

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
