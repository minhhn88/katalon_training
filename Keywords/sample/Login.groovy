package sample


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

/**
 * General description: abc <br>
 * Keyword list: <br>
 * {@link #loginIntoApplication loginIntoApplication} <br>
 * {@link loginIntoApplicationWithGlobalVariable}
 * @author GreenCSR Team
 * @version 1.0 14/02/2023
 *
 */

public class Login {
	/**
	 * Description: abc <br>
	 * xyz
	 * @author Minh
	 * @version 1.0 14/02/2023
	 * @return 1: successful <br> 2: unsuccessful 
	 * @param applicationURL
	 * @param username
	 * @param password
	 */
	@Keyword
	def static void loginIntoApplication(String applicationURL,String username,String password){

		WebUI.openBrowser(applicationURL)
		WebUI.waitForPageLoad(GlobalVariable.gWaitPresentTimeout)
		WebUI.maximizeWindow()

		WebUI.waitForElementVisible(findTestObject('Pages/MyAccount page/nav_HomeMyaccount'), GlobalVariable.gWaitPresentTimeout)

		WebUI.sendKeys(findTestObject('Pages/MyAccount page/txtUsername'), username)
		WebUI.sendKeys(findTestObject('Pages/MyAccount page/txtPassword'), password)
		WebUI.click(findTestObject('Pages/MyAccount page/btnLogin'))
		WebUI.delay(1)
	}

	@Keyword
	def static void loginIntoApplicationWithGlobalVariable(){
		loginIntoApplication(GlobalVariable.urlLogin, GlobalVariable.username, GlobalVariable.password)
	}

	@Keyword
	def static void logoutFromApplication(){
		WebUI.waitForElementPresent(findTestObject('Pages/MyAccount page/lnkMyAccount'), GlobalVariable.gWaitPresentTimeout)
		WebUI.click(findTestObject('Pages/MyAccount page/lnkMyAccount'))
		WebUI.waitForElementPresent(findTestObject('Pages/MyAccount page/lnkLogout'), GlobalVariable.gWaitPresentTimeout)
		WebUI.click(findTestObject('Pages/MyAccount page/lnkLogout'))
		WebUI.waitForElementVisible(findTestObject('Pages/MyAccount page/nav_HomeMyaccount'), GlobalVariable.gWaitPresentTimeout)
	}
}
