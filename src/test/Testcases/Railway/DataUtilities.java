package Railway;

import Common.Common.Utilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataUtilities extends TestBase{

    @DataProvider
    public static Object[] dataProviderTC14(){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;

        Object object;

        try{
            object = jsonParser.parse(new FileReader(Utilities.getProjectPath() + "\\src\\main\\java\\DataObjects\\data14.json"));
            jsonObject = (JSONObject) object;
        } catch (IOException | ParseException exception){
            exception.printStackTrace();
        }

        JSONArray formBookTicketInfo = (JSONArray) jsonObject.get("TC14");

        String[] bookedTicketInfo = new String[formBookTicketInfo.size()];
        JSONObject formBookTicketInfoData = null;
        String departDate, departFrom, arriveAt, seatType, ticketAmount;

        for (int i=0; i<formBookTicketInfo.size();i++){
            formBookTicketInfoData =(JSONObject) formBookTicketInfo.get(i);
            departDate =(String) formBookTicketInfoData.get("DepartDate");
            departFrom =(String) formBookTicketInfoData.get("DepartFrom");
            arriveAt = (String) formBookTicketInfoData.get("ArriveAt");
            seatType = (String) formBookTicketInfoData.get("SeatType");
            ticketAmount = (String) formBookTicketInfoData.get("TicketAmount");

            bookedTicketInfo[i] = departDate + "," + departFrom + "," + arriveAt + "," + seatType + "," + ticketAmount;
        }

        return bookedTicketInfo;
    }

    public static void main(String[] args) {
        System.out.println(dataProviderTC14()[0]);
    }
}
