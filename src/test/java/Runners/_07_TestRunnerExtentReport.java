package Runners;

import JDBC.Tests.Test01;
import com.aventstack.extentreports.service.ExtentService;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import org.junit.runner.notification.Failure;
import org.testng.annotations.AfterClass;


public class _07_TestRunnerExtentReport  {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(Test01.class);

        for (Failure failure : result.getFailures()){
            System.out.println("failure.toString() = " + failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
//    @AfterClass
//    public static void writeExtentReport() {
//        ExtentService.getInstance().setSystemInfo("User Name", "İsmet Temur");
//        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
//        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
//        ExtentService.getInstance().setSystemInfo("Department", "QA");
//        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
//    }
}
