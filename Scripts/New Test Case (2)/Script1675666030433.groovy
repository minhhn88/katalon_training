import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint


import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Custom keyword name: inputDataToTestObject(TestObject objPath, String sText, integer iTimeOut)
    //
    //
    // General description: Custom keyword is used for inputting a text string to object on a web page
    //
    // Parameter list:
    //                  objectPath    : The test object path in the Object Repository
    //                  sText        : The text string is input in object
    //                  iTimeOut    : the time for waiting object is displayed on web page
    // Return values:
    //                  1    : The object is input data successful 
    //                  0    : The object is not existence
    //                  -1    : The object is disabled
    //
    // Last updated: 05/02/2023 
    // Author: 
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

@Keyword
    def static int checkelement(TestObject objPath, int iTimeOut) {
        try{
            //Verify that the object exists or not
            if(WebUI.verifyElementPresent(objPath, iTimeOut) == true) {
                //Verify that the object is enabled or not
                if (WebUI.verifyElementAttributeValue(objPath, "enabled", "true", 0) == true) {
                    //Input data in object
                    WebUI.setText(objPath, sText)
                    System.out.println("The object is inputed data successful.")
                    return 1
                } else {
                    System.out.println("The object is disabled.")
                    return -1
                }
            } else {
                System.out.println("The object is not existence.")
                return 0
            }
        } catch(Exception ex) {
            //Throw message if there is any other errors
            System.out.println("Please verify test object by hand.")
            throw ex
        }
    }


