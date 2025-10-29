# Java Game API - 1311.uk

A Java-based game API project for the 1311.uk domain, built with Java 17 to learn elements from the Keycloack stack.

## Documentation

### 📚 Study Plans & Learning Paths
- **[Full-Stack Learning Plan](docs/keycloak-stack-learning-plan.md)** - Comprehensive roadmap for Java backend + React frontend development, including Keycloak authentication integration
- **[Java Version Manager Setup](docs/java-version-manager-setup.md)** - Complete guide for setting up jenv on macOS with Java 17 for this project

### 🚀 Project Management
- **[Next Steps](NEXT-STEPS.md)** - Current project status, priorities, and session continuity tracking
- **[AI Shortcuts](.ai-shortcuts.md)** - Development workflow shortcuts and conventional commit setup


## Project Structure

- **Domain**: 1311.uk
- **Package**: `uk.thirteen11.game`
- **Java Version**: 17
- **Build Tool**: Maven 3.9.11

## Quick Start

```bash
# Compile the project
mvn clean compile

# Run tests
mvn test

# Run the main application
mvn exec:java -Dexec.mainClass="uk.thirteen11.game.GameAPI"
```

## Development Setup

This project uses Java 17 with automatic version management via jenv. When you enter this directory, Java 17 will be automatically selected.