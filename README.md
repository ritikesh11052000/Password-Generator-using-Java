# Password Generator using Java

A secure password generator application built with Java and JavaFX, featuring a graphical user interface for easy password creation with customizable options.

## Features

- **Secure Password Generation**: Uses Java's `SecureRandom` for cryptographically strong random passwords
- **Customizable Options**: Choose password length and character types (lowercase, uppercase, digits, symbols)
- **Graphical User Interface**: Built with JavaFX for an intuitive desktop application experience
- **Input Validation**: Ensures at least one character type is selected and handles invalid inputs gracefully

## Tech Stack

- **Language**: Java 11
- **Framework**: JavaFX 17.0.2
- **Build Tool**: Maven 3.x
- **Security**: SecureRandom for randomness
- **IDE**: Compatible with any Java IDE (VS Code, IntelliJ IDEA, Eclipse, etc.)

## Prerequisites

- **Java Development Kit (JDK)**: Version 11 or higher
- **Maven**: Version 3.6 or higher
- **Display Support**: For GUI functionality (not required for console testing)

## Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd Password-Generator-using-Java
   ```

2. **Build the project**:
   ```bash
   mvn clean compile
   ```

3. **Run the application**:
   ```bash
   mvn javafx:run
   ```

   *Note*: The GUI requires a display environment. If running on a headless server, the application will fail to start but the core logic can be tested via console.

## Usage

### GUI Mode (Recommended)
1. Launch the application using `mvn javafx:run`
2. Enter desired password length (default: 12)
3. Select character types using checkboxes:
   - Lowercase letters (a-z)
   - Uppercase letters (A-Z)
   - Digits (0-9)
   - Symbols (!@#$%^&*()-_=+[]{}|;:,.<>?)
4. Click "Generate Password" to create and display a secure password

### Console Testing
Run the test class to verify password generation logic:
```bash
mvn compile exec:java -Dexec.mainClass="com.example.TestPasswordGenerator"
```

## Project Structure

```
Password-Generator-using-Java/
├── pom.xml                          # Maven configuration
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   ├── Main.java           # JavaFX application entry point
│                   ├── PasswordGenerator.java  # Core password generation logic
│                   └── TestPasswordGenerator.java  # Console testing class
└── README.md                       # This file
```

## Security Notes

- Passwords are generated using `SecureRandom`, which is suitable for security-sensitive applications
- No passwords are stored or logged by the application
- Character pools include all standard ASCII letters, digits, and common symbols

## Development

### Building from Source
```bash
mvn clean package
```

### Running Tests
```bash
mvn test
```

### IDE Setup
- Import as a Maven project
- Ensure JavaFX is properly configured in your IDE
- For VS Code, install the Java Extension Pack

## Troubleshooting

### GUI Won't Start
- Ensure you're running on a system with display support (desktop environment)
- Check that JavaFX dependencies are properly downloaded
- Try running with `mvn clean javafx:run`

### Build Errors
- Verify JDK 11+ is installed: `java -version`
- Verify Maven is installed: `mvn -version`
- Clear Maven cache: `mvn clean`

### Headless Environment
The GUI cannot run in headless environments (servers without displays). Use the console test to verify functionality:
```bash
mvn compile exec:java -Dexec.mainClass="com.example.TestPasswordGenerator"
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is open source. Please check the license file for details.
