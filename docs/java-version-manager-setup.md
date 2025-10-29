# Java Version Manager Setup for macOS

## Overview
This guide shows how to set up **jenv** as a Java version manager on macOS with Homebrew, specifically for working with the Keycloak project which requires Java 17.

## Why jenv for macOS + Homebrew?
- Integrates perfectly with Homebrew-installed Java versions
- Simple, focused on just Java (unlike SDKMAN! which manages many tools)
- Works seamlessly with macOS environment
- Lightweight and fast
- Perfect for per-project Java version management

## Setup Instructions

### 1. Install jenv
```bash
brew install jenv
```

### 2. Install Java Versions via Homebrew
```bash
# Install Java 17 (required for Keycloak)
brew install openjdk@17

# Install other versions you might need
brew install openjdk@11
brew install openjdk@21

# Optional: Install Java 8 if needed for legacy projects
brew install openjdk@8
```

### 3. Configure .zshrc
Add the following to your `~/.zshrc` file:

```bash
# Java Version Manager (jenv) Configuration
export PATH="$HOME/.jenv/bin:$PATH"
eval "$(jenv init -)"

# Enable jenv plugins for better integration
jenv enable-plugin maven
jenv enable-plugin gradle
jenv enable-plugin export

# Optional: Add JAVA_HOME export (jenv export plugin handles this)
# export JAVA_HOME="$(jenv javahome)"
```

### 4. Apply Changes
```bash
source ~/.zshrc
```

### 5. Add Java Versions to jenv
```bash
# Add Java 17 (primary for Keycloak)
jenv add /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk/Contents/Home

# Add Java 11
jenv add /opt/homebrew/opt/openjdk@11/libexec/openjdk.jdk/Contents/Home

# Add Java 21
jenv add /opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home

# Add Java 8 (if installed)
jenv add /opt/homebrew/opt/openjdk@8/libexec/openjdk.jdk/Contents/Home
```

**Note**: If you're on an Intel Mac, use `/usr/local/opt/` instead of `/opt/homebrew/opt/`


### 6. Set Global Java Version
```bash
# Set Java 17 as global default
jenv global 17

# Verify global setting
jenv global
```

### 7. Restart your shell (important)

### 8. Verify Installation
```bash
# List available Java versions
jenv versions

# Check current Java version
java -version
javac -version

# Verify JAVA_HOME is properly set
echo $JAVA_HOME
```

### Project-Specific Java Version
```bash
# Navigate to your project directory
cd /Users/DBenoy/src/keycloak

# Set Java 17 for this project
jenv local 17

# This creates a .java-version file in the project directory
# Java 17 will automatically be used when you're in this directory
```

### Useful jenv Commands
```bash
# List all available Java versions
jenv versions

# Show current Java version
jenv version

# Set global Java version
jenv global <version>

# Set local Java version for current directory
jenv local <version>

# Remove a Java version from jenv
jenv remove <version>

# Refresh jenv (useful after adding new Java versions)
jenv refresh-plugins
```

## Keycloak Project Setup

### For Your Keycloak Project:
```bash
cd /Users/DBenoy/src/keycloak
jenv local 17
```

This ensures that:
- Java 17 is automatically used when working in the Keycloak directory
- Maven builds will use the correct Java version
- Both `java` and `javac` commands point to Java 17
- `JAVA_HOME` is properly set to Java 17

### Verify Setup for Keycloak:
```bash
cd /Users/DBenoy/src/keycloak
java -version    # Should show Java 17
javac -version   # Should show Java 17
echo $JAVA_HOME  # Should point to Java 17 installation
mvn -version     # Should show Java 17 as the Java version
```

## Troubleshooting

### Common Issues:
1. **Java versions not found**: Make sure the paths in `jenv add` commands match your Homebrew installation
2. **Commands not found**: Ensure `.zshrc` is properly sourced
3. **JAVA_HOME not set**: Make sure the export plugin is enabled: `jenv enable-plugin export`

### Check Installation Paths:
```bash
# Find where Homebrew installed Java
brew --prefix openjdk@17
brew --prefix openjdk@11
```

### Reset jenv if needed:
```bash
# Remove all Java versions from jenv
jenv versions --bare | xargs -I {} jenv remove {}

# Re-add Java versions
# (repeat the jenv add commands from step 5)
```

## Benefits of This Setup

1. **Automatic switching**: Java version changes automatically when you enter project directories
2. **Build tool integration**: Maven/Gradle will use the correct Java version
3. **JAVA_HOME management**: Automatically sets JAVA_HOME for each version
4. **Path management**: Both `java` and `javac` are properly managed
5. **Per-project configuration**: Different projects can use different Java versions seamlessly

## Project Requirements

- **Keycloak**: Requires Java 17 (as specified in pom.xml)
- **Maven version**: 3.9.8 (as specified in pom.xml)
- **Quarkus**: 3.27.0 (as specified in pom.xml)

This setup ensures you're using the exact Java version required by the Keycloak project while maintaining flexibility for other projects that might need different Java versions.

----
note from install openjdk17 command

For the system Java wrappers to find this JDK, symlink it with
  sudo ln -sfn /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk

openjdk@17 is keg-only, which means it was not symlinked into /opt/homebrew,
because this is an alternate version of another formula.

If you need to have openjdk@17 first in your PATH, run:
  echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc

For compilers to find openjdk@17 you may need to set:
  export CPPFLAGS="-I/opt/homebrew/opt/openjdk@17/include"