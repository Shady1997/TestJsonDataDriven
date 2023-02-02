package testcases;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestJsonDataDriven {

    @Test(priority = 1,dataProvider = "testdata")
    void login1(String uname,String password) throws InterruptedException {
//        String user[] = data.split(",");
        System.out.println("starting testing 1");
        System.out.println(uname);
        System.out.println("finish testing 1");
//        driver.get("http://thedemosite.co.uk/login.php");
//        driver.findElement(By.name("username")).sendKeys(user[0]);
//        driver.findElement(By.name("password")).sendKeys(user[1]);
//        driver.findElement(By.name("FormsButton2")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 2,dataProvider = "testdata")
    void login2(String uname,String password) throws InterruptedException {
//        String user[] = data.split(",");
        System.out.println("starting testing 2");
        System.out.println(uname);
        System.out.println("finish testing 2");
//        driver.get("http://thedemosite.co.uk/login.php");
//        driver.findElement(By.name("username")).sendKeys(user[0]);
//        driver.findElement(By.name("password")).sendKeys(user[1]);
//        driver.findElement(By.name("FormsButton2")).click();
        Thread.sleep(1000);
    }

    @DataProvider(name = "testdata")
    public Object[][] TestDataFeed() {

// Create object array with 2 rows and 2 column- first parameter is row and second is //column
        Object[][] twitterdata = new Object[2][2];

// Enter data to row 0 column 0
        twitterdata[0][0] = "username1@gmail.com";
// Enter data to row 0 column 1
        twitterdata[0][1] = "Password1";
// Enter data to row 1 column 0
        twitterdata[1][0] = "username2@gmail.com";
// Enter data to row 1 column 0
        twitterdata[1][1] = "Password2";
// return arrayobject to testscript
        return twitterdata;
    }

//    @DataProvider(name = "dp")
    public static String[] readjson(String jsonFilePath, String jsonField) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray array = (JSONArray) jsonObject.get(jsonField);

        String arr[] = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONObject users = (JSONObject) array.get(i);
            String username = (String) users.get("street");
            String password = (String) users.get("city");

            arr[i] = username + "," + password;
        }
        return arr;
    }

    public static String getSingleJsonData(String jsonFilePath, String jsonField) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/employee.json", "firstName"));
        String user[] = readjson(System.getProperty("user.dir") + "/src/test/resources/data_driven/employee.json", "address");
        System.out.println(user[1]);
    }
}
