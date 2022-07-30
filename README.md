# Mobile Automation with Appium and Cucumber in Java
<p align="center">
  <td><img src="https://user-images.githubusercontent.com/75911392/181994947-185926d9-212d-4b6f-baea-41191d425e99.png" /></td>
</p>


# Desired Capabilities for Appium (Androig/iOS)
* Desired Capabilities are keys and values encoded in a JSON objecti sentby Appium clients to the server when a new automation session is requested
* Desired Capabilities can be scripted in the WebDriver test or set within the Appium Server GUI (via an Inspector Session)
# Get the Device ID
* iOS
From command line : $ xcrun simctl list

* Android
From command line : $ adb devices

![adb](https://user-images.githubusercontent.com/75911392/181945455-b8b8f764-87fc-44fe-80dd-441bbbd4b403.PNG)

# Appium Inspector in Appium Desktop
* Appium Desktop offers an Inspector that you can use to look up or locate elements of an application.
* It alsı lets you perform basic actions on these elements (such as tap and send keys)

![appium_inspector](https://user-images.githubusercontent.com/75911392/181945934-e128ae6c-4360-401a-80a1-5ceac0e1c19a.PNG)


![appium_inspector_win](https://user-images.githubusercontent.com/75911392/181947137-897527ee-d705-4b13-ad2c-a64da1ddb986.PNG)

# Dependencies

* Appium Java Client 

```
        <!-- https://mvnrepository.com/artifact/io.appium/java-client -->
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>7.0.0</version>
        </dependency>
```


* TestNG

```
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.4.0</version>
            <scope>test</scope>
        </dependency>
```

# Identifying UI Elements
Appium supports a subset of the WebDriver locator strategies such as:
* find by "class"
* find by "xpath"
Appium additionally supports some of the Mobile JSON Wire Protocol locator strategies.


# Android and iOS Locator Strategies

![locator](https://user-images.githubusercontent.com/75911392/181971332-9f52ce59-46f8-4dd0-85d9-0d1ba87b0796.PNG)

# Cucumber
* Cucumber was created to drive Behavior Driven Development (BDD) process.
* In Cucumber world, these files are called Feature files.
* Once development is ready, the developers and(or QA will write Step Definitions.

# Dependencies

* Cucumber JUnit

```
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.0.0</version>
            <scope>test</scope>
        </dependency>
```

* Cucumber Java

```
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java8</artifactId>
            <version>7.0.0</version>
            <scope>test</scope>
        </dependency>
```

* Gherkin

```
<!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>gherkin</artifactId>
    <version>23.0.1</version>
</dependency>
```
# Requirements for Windows
* Java JDK 8 Installation -> https://www.oracle.com/tr/java/technologies/javase-downloads.html
* Jetbrains IntelliJ IDEA Installation -> https://www.jetbrains.com/idea/
* Gherkin IntelliJ Plugin -> https://plugins.jetbrains.com/plugin/9164-gherkin
* Cucumber for Java -> Cucumber for Java IntelliJ Plugin -> https://plugins.jetbrains.com/plugin/7212-cucumber-for-java
* Appium Server and Documentation -> https://appium.io/
* Android Mobile Devices
