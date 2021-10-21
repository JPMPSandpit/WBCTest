# WBCTest



**Prerequisites:**

* Java JDK (https://www.oracle.com/java/technologies/downloads/)

* Maven (https://maven.apache.org/download.cgi)

* Java IDE (IntelliJ Community used) (https://www.jetbrains.com/idea/download/)

**Setup:**
1. Download and install Java JDK
2. Set JAVA_HOME system environment variable to Java installation path
3. Download and extract Maven to a directory
4. Set MAVEN_HOME system environment variable to Maven extraction path
5. Add %MAVEN_HOME% to PATH system environment variable
5. Download and install IntelliJ Community Edition
6. In IntelliJ, go to File > Settings > Build, Execution, Deployment > Maven and set Maven home path to extraction path. Click Ok.


**Running the test:**
1. In IntelliJ > File > New > Project from Version Control, set Version control = GIT, set local directory to clone files to, then set URL to clone path: https://github.com/JPMPSandpit/WBCTest.git. Click Clone to clone repo from GitHub.
2. Once the project has been successfully loaded, build project.
3. Find testng.xml, right click and Run.
4. Once test run is completed, find the test-output folder and open the html files in a browser to see test run results.


**Additional files**

* Test Approach (BuggyCars Test Approach.pdf)
* Bug logs (Bug1.pdf, Bug2.pdf, Bug3.pdf)
