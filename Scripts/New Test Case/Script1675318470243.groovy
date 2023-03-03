import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://cms.demo.katalon.com/')

WebUI.waitForElementVisible(findTestObject('Select2/Page_Katalon Shop  Katalon Ecommerce/a_My account'), GlobalVariable.pre)

WebUI.click(findTestObject('Object Repository/Select2/Page_Katalon Shop  Katalon Ecommerce/a_My account'))

WebUI.click(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/label_Username or email address'))

WebUI.setText(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/input__username'), 'customer')

WebUI.setEncryptedText(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/input_password'), 'fcttOx1e+dws0mP0AWb2uMRTnZbRfS0W')

WebUI.click(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/input__rememberme'))

WebUI.click(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/button_Log in'))

WebUI.click(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/a_Account details'))

WebUI.click(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/button_Save changes'))

WebUI.click(findTestObject('Object Repository/Select2/Page_My account  Katalon Shop/a_Logout'))

WebUI.closeBrowser()

