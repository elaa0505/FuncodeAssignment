# Rest Assured and TestNG API Automation

This project automates the verification of user tasks using Rest Assured and TestNG. The scenario involves checking that all users from the city `FanCode` have completed more than half of their todo tasks.

## Scenario

- **Given**: User has todo tasks
- **And**: User belongs to the city `FanCode`
- **Then**: User's completed task percentage should be greater than 50%

`FanCode` city can be identified by latitude between `-40` to `5` and longitude between `5` to `100` in the users API.

## Prerequisites

- Java 8 or higher
- Maven
- Git

## Setup

1. Clone the repository:
   ```sh
   git clone [https://github.com/elaa0505/FuncodeAssignment.git]
   cd FuncodeAssignment

2. Install the dependencies:

```mvn clean install```

## Running the Tests

To execute the tests, use the following command:

```mvn clean test```

## Project Structure

```src
└── main
    └── java
        └── com
            └── elaa
		└── fancode
			├── Runner.java
			└── Common
			    └── GetMethod.java
			    └── PutMethod.java
			    └── PostMethod.java
			    └── PatchMethod.java
			    └── Utility.java
                    	└── report
			    └── ReportUtils.java
                    	└── request
	 		    └── GetRequest.java
```


## Files
**GetMethod.java,PutMethod.java,PostMethod.java,PatchMethod.java,Utility.java**
Contains Reusable methods

**Runner.java**
Contains the test scenarios for verifying the users' todos completion percentage.

**GetRequest.java**
Provides utility methods for making API calls to fetch users and todos.

**ReportUtils.java**
Handles the setup and teardown of ExtentReports for generating test reports.

## Dependencies
Ensure the following dependencies are included in your pom.xml:

```<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.7.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
		<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>5.3.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.2.3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.2.3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-scratchpad -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-scratchpad</artifactId>
			<version>5.2.3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-excelant -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-excelant</artifactId>
			<version>5.2.3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-examples -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-examples</artifactId>
			<version>5.2.3</version>
		</dependency>
		<dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.0.9</version>
        </dependency>
        <dependency>
    		<groupId>com.googlecode.json-simple</groupId>
    		<artifactId>json-simple</artifactId>
    		<version>1.1</version>
		</dependency>
  </dependencies>
  ```
## Report
The test results are generated using ExtentReports. After test execution, the report is available at target/extent-reports/.

## Test Execution
The test verifies the following:

1. Fetches users from the city FanCode based on latitude and longitude conditions and verifies the status code and response.
2. Checks that all users from FanCode city have completed more than 50% of their todos.


## License
This project is licensed under the MIT License.

This `README.md` file provides comprehensive instructions for setting up and running the tests, including a description of the scenario, project structure, dependencies, and how to generate the test report.
