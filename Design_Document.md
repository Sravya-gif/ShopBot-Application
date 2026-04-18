

\## Introduction



The ShopBot Automation Framework is a Selenium-Java based test automation solution developed to validate the functionality of a retail e-commerce web application.



\## Tools \& Technologies

\*Java

\*Selenium WebDriver

\*TestNG

\*Maven

\*WebDriverManager

\*Extent Reports

\*Apache POI (Excel handling)



\## Project Structure



```

ShopBot-Automation-Framework

│

├── src/main/java

│   ├── com.srm.base

│   │   ├── BasePage.java

│   │   └── BaseTest.java

│   │

│   ├── com.srm.driver

│   │   └── DriverFactory.java

│   │

│   ├── com.srm.pages

│   │   ├── LoginPage.java

│   │   ├── ProductsPage.java

│   │   ├── CartPage.java

│   │   ├── CheckoutPage.java

│   │   └── MenuPage.java

│   │

│   ├── com.srm.utils

│   │   ├── ConfigReader.java

│   │   ├── ExcelReader.java

│   │   ├── ScreenshotUtil.java

│   │   └── ExtentManager.java

│   │

│   ├── com.srm.listeners

│   │   └── TestListener.java

│

├── src/main/resources

│   ├── config.properties

│   └── LoginData2.xlsx

│

├── src/test/java

│   └── com.srm.tests

│       ├── LoginTest.java

│       ├── ProductTest.java

│       ├── CartTest.java

│       ├── CheckoutTest.java

│       └── ProblemUserTest.java

│

├── screenshots

│   

│

├── reports

│   

├── testng.xml

├── pom.xml

```

