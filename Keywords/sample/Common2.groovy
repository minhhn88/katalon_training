import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

/**
 * General description: List out some common keywords used for web application
 * 
 * Keyword list:
 *                  verifyObjectPresent					: Custom keyword is used for verify if the given object is existence on a web page
 * 					verifyObjectEnabled					: Custom keyword is used for verify if the given object is enabled on a web page
 * 					verifyObjectEnabled					: Custom keyword is used for verify if the given object is checked on a web page
 *                  inputDataToTestObject				: Custom keyword is used for inputting a text string to object on a web page
 *                  printStepMessage					: Custom keyword is used for print step message to console
 *					clickToRadioButton					: Custom keyword is used for clicked a radio button on a web page
 *					clickToCheckBox						: Custom keyword is used for clicked a check box on a web page
 *					clickToButton						: Custom keyword is used for clicked a button on a web page
 *					getTextFromTestObject				: Custom keyword is used for getting a text string from object(button, radio button, label,...) on a web page
 *					getTextFromInput					: Custom keyword is used for getting a text string from object(with html tag name input) on a web page
 *					selectComboBoxItemByIndex			: Custom keyword is used for select all items that have a index matching the "index" argument on a web page
 *					selectComboBoxItemByValue			: Custom keyword is used for select all options that have a value matching the "value" argument on a web pagef
 *					selectListViewItem					: Custom keyword is used for selected a item from list view on a web page
 *					selectMenuItem						: Custom keyword is used for selected a item from menu on a web page
 * 
 * @since 08/02/2023 
 * 
 * @author ABA Automation team
 */
public class Common2 {
	/**
	 * Custom keyword name: verifyObjectPresent(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify object existence on a web page</br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 *			true if element presents; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectPresent(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(WebUI.verifyElementPresent(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE) == true) {
				//System.out.println("The object is existence.")
				return true
			} else {
				KeywordUtil.logInfo("Object '" + objPath.objectId.split('/').last() + "' is not existence.")
				return false
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed("Object is not existence in Object Repository.")
			return false
		}
	}

	/**
	 * Custom keyword name: verifyObjectEnabled(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify object enabled on a web page</br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 *			true if the element is present and clickable; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectEnabled(TestObject objPath) {
		try{
			//Verify that the object is enabled or not
			if(WebUI.verifyElementClickable(objPath, FailureHandling.CONTINUE_ON_FAILURE) == true) {
				//System.out.println("The object is enabled.")
				return true
			} else {
				KeywordUtil.logInfo("Object '" + objPath.objectId.split('/').last() + "' is disabled.")
				return false
			}
		} catch(Exception ex) {
			return false
		}
	}

	/**
	 * Custom keyword name: verifyObjectEnabled(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify if the given object is checked on a web page</br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 *			true if the element is present and clickable; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */	
	@Keyword
	def static Boolean verifyObjectChecked(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object is enabled or not
			if(WebUI.verifyElementNotChecked(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE) == true) {
				return true
			} else {
				KeywordUtil.logInfo("Object '" + objPath.objectId.split('/').last() + "' is already checked.")
				return false
			}
		} catch(Exception ex) {
			return false
		}
	}

	/**
	 * Custom keyword name: inputDataToTestObject(String sObjPath, String sText, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for inputting a text string to object on a web page</br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param sText		: The text string is input in object
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void inputDataToTestObject(TestObject objPath, String sText, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath) == true) {
					WebUI.setText(objPath, sText)
					if(getTextFromObjectByInput(objPath, iTimeOut).equals(sText)) {
						KeywordUtil.markPassed("The object is inputed data successful.")
					} else {
						KeywordUtil.markFailed("The object is input data not match with typed data.")
					}
				}
			}
		} catch(Exception ex) {

		}
	}

	/**
	 * Custom keyword name: printStepMessage(String sPageNameOrScreen, String sAction, String sObjName)</br></br>
	 *
	 * General description: Custom keyword is used for print step message to console</br></br>
	 *
	 * @param sPageNameOrScreen	: The name of page or screen
	 * @param sAction      		: The name of action
	 * @param objName    		: The name of object
	 *
	 * @return
	 * 			None
	 *
	 * @since 17/02/2023
	 *
	 * @author ABA Automation team
	 */

	@Keyword
	def static void printStepMessage(String sPageNameOrScreen, String sAction, String sObjName) {
		KeywordUtil.logInfo(sPageNameOrScreen + " - " + sAction + " - " + sObjName)
	}

	/**
	 * Custom keyword name: clickToRadioButton(String sObjPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for clicked a radio button on a web page</br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void clickToRadioButton(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object exists or not and verify that the object is enabled or not
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath) == true) {
					//Verify that the object is checked or not
					if(verifyObjectChecked(objPath, iTimeOut) == true) {
						WebUI.click(objPath)
						//System.out.println("The object is clicked successful.")
					}
				}
			}
		} catch(Exception ex) {

		}
	}

	/**
	 * Custom keyword name: clickToCheckBox(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for clicked a check box on a web page</br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void clickToCheckBox(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object exists or not and verify that the object is enabled or not
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath) == true) {
					//Verify that the object is checked or not
					if(verifyObjectChecked(objPath, iTimeOut) == true) {
						WebUI.click(objPath)
						//System.out.println("The object is clicked successful.")
					}
				}
			}
		} catch(Exception ex) {

		}
	}

	/**
	 * Custom keyword name: clickToButton(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for clicked a button on a web page</br></br>
	 *
	 * @param objPath	: The represent a web element in the Object Repository
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void clickToButton(TestObject objPath, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath) == true) {
					WebUI.click(objPath)
					//KeywordUtil.markPassed("The object is clicked successful.")
				}
			}
		} catch(Exception ex) {
			System.out.println(ex)
		}
	}

	/**
	 * Custom keyword name: getTextFromObject(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for getting a text string from object(button, radio button, label,...) on a web page</br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			innerText of the test object
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */	
	@Keyword
	def static String getTextFromObject(TestObject objPath, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath) == true) {
					return WebUI.getText(objPath)
				}
			}
		} catch(Exception ex) {

		}
	}

	/**
	 * Custom keyword name: getTextFromObjectByInput(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for getting a text string from object(with html tag name input) on a web page</br></br>
	 *
	 * @param objPath		: The object in the Object Repository
	 * @param iTimeOut		: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			innerText of the test object
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static String getTextFromObjectByInput(TestObject objPath, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath) == true) {
					return WebUI.getAttribute(objPath, "value")
				}
			}
		} catch(Exception ex) {

		}
	}


	/**
	 * Custom keyword name: selectComboBoxItemByIndex(TestObject objPath, int itemIndex, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for select all items that have a index matching the "index" argument on a web page</br></br>
	 *
	 * @param objPath		: The object in the Object Repository
	 * @param itemIndex		: The index index range of the options to select from object. Index starts from 0.
	 * @param iTimeOut		: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectComboBoxItemByIndex(TestObject objPath, int sItemIndex, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(verifyObjectPresent(objPath, iTimeOut) == 1) {
				if (verifyObjectEnabled(objPath) == 1) {
					if(sItemIndex >= 0) {
						WebUI.selectOptionByIndex(objPath, sItemIndex)
					} else {
						KeywordUtil.markFailed("The item index typed is lower than 0")
					}
				}
			}
		} catch(Exception ex) {

		}
	}

	/**
	 * Custom keyword name: selectComboBoxItemByValue(TestObject objPath, String itemValue, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for select all items that have a value matching the "value" argument on a web page</br></br>
	 *
	 * @param sObjPath		: The element logical name path in the Object Repository
	 * @param itemValue		: The value of the options to select from object
	 * @param iTimeOut		: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectComboBoxItemByValue(TestObject objPath, String sItemValue, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(verifyObjectPresent(objPath, iTimeOut) == 1) {
				if (verifyObjectEnabled(objPath) == 1) {
					if(sItemValue.equals("")) {
						WebUI.selectOptionByValue(objPath, sItemValue, false)
					} else {
						KeywordUtil.markFailed("The item value typed is null")
					}
				}
			}
		} catch(Exception ex) {

		}
	}
}
