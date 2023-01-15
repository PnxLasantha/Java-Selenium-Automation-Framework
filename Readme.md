# Selenium /REST Assured Framework [![CircleCI](https://dl.circleci.com/status-badge/img/gh/PnxLasantha/SeleniumFramework/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/PnxLasantha/SeleniumFramework/tree/master)

This repository contains a Selenium framework for automating web browsers and REST apis. The framework is built using Java and Selenium WebDriver, and it is designed to make it easy to write reliable and efficient automated tests for web applications.

## Prerequisites

- Java JDK 8 or higher
- Maven

## Getting Started

To get started, clone the repository to your local machine and import the project into your preferred IDE.


### Running the tests

The tests can be run using the Maven command line. 

### Framework Structure
The framework is structured in a way that makes it easy to write and maintain tests. It includes the following components:
- **Page Object Model**: The framework uses the Page Object Model design pattern, which makes it easy to locate and interact with elements on a page.
- **Page Factory**: The framework uses the Page Factory pattern, which makes it easy to initialize page objects and locate elements on a page.
- **TestNG**: The framework uses TestNG as the testing framework.
- **Logging**: The framework uses log4j for logging, which makes it easy to track the execution of tests.
- **REST Assured** : The framework sue REST Assured for api automation

### Reporting
Framework also includes Extent reporting which will be generated after execution of test.

## Resources

- [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/)
- [TestNG](https://testng.org/doc/index.html)
- [Maven](https://maven.apache.org/)
- [Java](https://www.java.com/en/)
- [Rest Assured](https://rest-assured.io/)

## Contributing

If you want to contribute to this project, please fork the repository and submit a pull request.

## Author

* **Lasantha Caldera** - *Initial work* - [PnxLasantha](https://github.com/PnxLasantha)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
