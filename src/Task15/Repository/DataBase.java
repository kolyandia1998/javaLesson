package Task15.Repository;

import Task14v1.Rewards;
import Task14v1.User.Users;
import javafx.collections.ObservableList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;
public class DataBase implements IRepository{



    private String authenticationResult = authentication("sni@infostandart.com", "b54c2506694c8c9b82c9c9c49c3956c603da5a603db4ec029b4ead69a1933f6e");
    private String ssid = authorize();


   private String authentication (String login, String password) throws IOException {
       URL url = new URL("https://login.odant.org/api?method=authentication&login=" + login + "&" + "password="+ password);
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setRequestMethod("GET");
       connection.setConnectTimeout(10000);
       connection.setReadTimeout(10000);
       InputStream responseAuthentication = connection.getInputStream();
       String responseContent = "";
       try (Scanner scanner = new Scanner(responseAuthentication)) {
           String responseBody = scanner.useDelimiter("\\A").next();
           responseContent = responseBody;
       }
       responseAuthentication.close();
         return responseContent;
   }

   private String authorize () throws IOException {
       CookieManager cookieManager = new CookieManager();
       CookieHandler.setDefault(cookieManager);
       URL url = new URL("http://127.0.0.1:8080/api?method=authorize&ssid");
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setRequestMethod("GET");
       connection.setConnectTimeout(10000);
       connection.setReadTimeout(10000);
       connection.setDoOutput(true);
       OutputStream outputStream = connection.getOutputStream();
       OutputStreamWriter outStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
       outStreamWriter.write(authenticationResult);
       outStreamWriter.flush();
       outputStream.close();
       connection.getContent();
       HttpCookie cookie = cookieManager.getCookieStore().getCookies().get(0);
       return cookie.getValue();
   }

     public String getObjFromID (int ID ) throws IOException {
      URL url = new URL( "http://127.0.0.1:8080/api/H:1D78CE772EF8F60/D:WORK/D:1D8E5437BDA93FE/C:1D8E543854A1B7C/I:Pack?method=xquery_index&ssid="+ssid);
       String xquery =  "for $a in PACK/OBJECT[@ID='" + ID + "'] return element OBJECT {$a/@*,$a/*}";
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setDoInput(true);
      connection.setDoOutput(true);
         OutputStream outputStream = connection.getOutputStream();
         OutputStreamWriter outStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
         outStreamWriter.write(xquery);
         outStreamWriter.flush();
         outputStream.close();


         InputStream responseAuthentication = connection.getInputStream();
         String responseContent ="";
         try (Scanner scanner = new Scanner(responseAuthentication)) {
             String responseBody = scanner.useDelimiter("\\A").next();
             responseContent = responseBody;
         }
         return responseContent;


     }









    public DataBase() throws IOException {
    }

    @Override
    public void AddUser(Users user) {
    }
    @Override
    public void AddReward(Rewards reward) {
    }
    @Override
    public boolean RemoveUser(Integer ID) {

        return false;
    }
    @Override
    public boolean RemoveReward(Integer ID) {
        return false;
    }
    @Override
    public ObservableList<Users> getUsersRepository() {
        return null;
    }
    @Override
    public ObservableList<Rewards> getRewardsRepository() {
        return null;
    }
    @Override
    public boolean RewardUser(Integer userID, Integer rewardID) {
        return false;
    }
    @Override
    public boolean UpdateUser(Users user) {
        return false;
    }
    @Override
    public boolean UpdateReward(Rewards reward) {
        return false;
    }
    @Override
    public boolean DeleteRewardFromUser(Integer userID, Integer rewardID) {
        return false;
    }
    @Override
    public Users GetUserFromID(Integer userID) {
        return null;
    }
    @Override
    public Rewards GetRewardFromID(Integer rewardID) {
        return null;
    }
}
