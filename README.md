# GreenTrakPlayGround00

##### Proof of Concept platform for UI5 services:
* "GTplayGround00:war exploded", deployable web archive package.
   * Dependencies are Maven based.
* Static HTTP server, default powered by Eclipse Jetty 11+ application server.
* OData v4 (UI5 Capita Selecta) REST service based on Jakarta® EE 9 specified, Java Persistence API (JPA) with EclipseLink.
   * Single user HyperSQL database, conditional maintained by Flyway (see VXX__DEV_GREENTRAK00.sql scripts)

##### Stack:
0. OS shell - the bare command line.
   1. (Optional startup shell script.)
    1. JVM
        1. Eclipse Jetty application server
            1. Exploded web archive (war)
                1. Static HTML files and supporting files, ECMA script, config JSON's, view XML's
                1. OData v4 data service to populate the clients pages.

##### Installation:
0. Download and install JDK 11 a Long-Term-Support (LTS) release or higher. (Test with 'java -version')
0. Install Jetbrains IntelliJ Idea with the Scala option.
0. Put the undermentioned content in your .m2 user home directory as a settings.xml file.
0. Download and install Eclipse Jetty 11.
0. Clone this GTplayGround00 project with the Idea IDE.
0. Embed the Jetty server as a New Local Run/Debug Configuration
0. Use the configuration file in the .run directory.
0. Check the Run/Debug configation and use the Fix button if there are red highlighted errors.
    1. 'GTplayGround00:war exploded' has to be used as a 'Web Application: Exploded' type.
    0. Click right for Putting into Output Root in the column Available Elements in the Artifact of the Project Structure or Module Settings form.
    0. Discard other artifacts then 'GTplayGround00:war exploded'.
0. Run the configuration.
    1. Use the Reload All Projects button in the Maven vertical tab.
    0. (The IDE is sometimes stubborn, closing and opening will help.)
    0. Deleting the GreentrakData folder of the database files could also help.
    0. All dependencies can be deleted in Project Structure or Module Settings form, they will reloaded accordingly to the Maven dependencies.


##### settings.xml file
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
    <!--<server></server>-->
    </servers>

    <profiles>
        <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-serioussoftware-repo1</id>
                    <name>bintray</name>
                    <url>https://dl.bintray.com/serioussoftware/repo1</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-serioussoftware-repo</id>
                    <name>bintray-plugins</name>
                    <url>https://dl.bintray.com/serioussoftware/repo</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>bintray</activeProfile>
    </activeProfiles>
</settings>
```


Notice:
>When Oracle donated the JavaEE project to the Eclipse foundation, they maintained the copyright to the javax.* namespace. Subsequently, future versions of JavaEE, now called JakartaEE, would be required to use a new namespace for those packages. Instead of an incremental process, the Eclipse foundation opted for a big bang approach and packages formerly under the javax.* namespace has been refactored under the new jakarta.* namespace.
  