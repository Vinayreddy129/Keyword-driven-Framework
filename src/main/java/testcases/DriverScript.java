package testcases;

import KeywordMethods.Keywords;
import utilities.ExcelUtils;

public class DriverScript {
    public static void main(String[] args) throws Exception {
        Keywords keywords = new Keywords();
        String[][] testSteps = ExcelUtils.readExcelData("/home/vinay/Music/Keyword-driven-Framework/src/main/java/utilities/TestCases.xlsx", "Sheet1");

        for (int i = 1; i < testSteps.length; i++) { // Skip header row
            String keyword = testSteps[i][1];
            String locatorType = testSteps[i][2];
            String locatorValue = testSteps[i][3];
            String testData = testSteps[i][4];

            switch (keyword.toUpperCase()) {
                case "OPEN_URL":
                    keywords.openBrowser(testData);
                    break;
                case "ENTER_TEXT":
                    keywords.enterText(locatorType, locatorValue, testData);
                    break;
                case "CLICK":
                    keywords.click(locatorType, locatorValue);
                    break;
                case "CLOSE_BROWSER":
                    keywords.closeBrowser();
                    break;
                default:
                    System.out.println("Invalid Keyword: " + keyword);
            }
        }
    }
}
