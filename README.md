# Automation Test Store - Selenium Test Framework

This project is a test automation framework for [automationteststore.com](https://automationteststore.com/) using Selenium WebDriver, Java, JUnit 5, and Page Object Model.

## Project Structure 

## Test Commands

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Classes

1. Run Menu Navigation Tests:
```bash
mvn test -Dtest=SelectMenuPageObjectsTst
```

2. Run Fluent Menu Tests:
```bash
mvn test -Dtest=SelectMenuFluentTst
```

### Run Specific Test Methods

1. Run Complete Shopping Flow Test:
```bash
mvn test -Dtest=SelectMenuPageObjectsTst#testCompleteShoppingFlow
```

2. Run Men Skincare Navigation Test:
```bash
mvn test -Dtest=SelectMenuFluentTst#testMenSkincareNavigation
```

### Run Tests with Specific Tags
```bash
mvn test -Dgroups=smoke
mvn test -Dgroups=regression
```

### Run Tests in Parallel
```bash
mvn test -Dparallel=true
```

### Run Tests with Specific Browser
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
```

### Run Tests with Debug Logging
```bash
mvn test -Dmaven.test.failure.ignore=true -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN
```

### Run Tests with Specific Configuration
```bash
mvn test -Dconfig=qa
mvn test -Dconfig=staging
```

## Test Reports
After test execution, reports can be found in:
```bash
target/surefire-reports/
```

## View Test Results
```bash
mvn surefire-report:report
```
Then open: `target/site/surefire-report.html` 