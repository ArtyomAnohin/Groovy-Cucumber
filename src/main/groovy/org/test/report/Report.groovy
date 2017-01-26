package org.test.report

import net.masterthought.cucumber.Configuration
import net.masterthought.cucumber.ReportBuilder
import net.masterthought.cucumber.Reportable

/**
 * Created by artyom on 01/26/17.
 */

String currentDir = new File("").getAbsolutePath().split('src')[0]
print currentDir
File reportOutputDirectory = new File(currentDir+"\\build");
List<String> jsonFiles = new ArrayList<>();
jsonFiles.add(currentDir+"\\build\\cucumber.json");


String buildNumber = "1";
String projectName = "cucumberProject";
boolean runWithJenkins = false;
boolean parallelTesting = false;

Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration
configuration.setParallelTesting(parallelTesting);
configuration.setRunWithJenkins(runWithJenkins);
configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
configuration.addClassifications("Platform", System.getProperty("os.name"));


ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
Reportable result = reportBuilder.generateReports();

println "Report avaliable in: "+ reportOutputDirectory