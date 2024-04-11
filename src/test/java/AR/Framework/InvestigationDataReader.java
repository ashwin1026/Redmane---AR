package AR.Framework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class InvestigationDataReader {

    private String familyName;
    private String familyAddress;
    private String startDate;
    private String country;
    private String extensionComment;
    private String caseConnectionConnectDetails;
    private String investigationClosure;
    private String closureMeeting;

    public void readJsonFile(String fileName) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;

            familyName = (String) jsonObject.get("Familyname");
            familyAddress = (String) jsonObject.get("FamilyAddress");
            startDate = (String) jsonObject.get("StartDate");
            country = (String) jsonObject.get("Country");
            extensionComment = (String) jsonObject.get("ExtensionComment");
            caseConnectionConnectDetails = (String) jsonObject.get("CaseConnectionConnectDetails");
            investigationClosure = (String) jsonObject.get("InvestigationClosure");
            closureMeeting = (String) jsonObject.get("ClosureMeeting");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getCountry() {
        return country;
    }

    public String getExtensionComment() {
        return extensionComment;
    }

    public String getCaseConnectionConnectDetails() {
        return caseConnectionConnectDetails;
    }

    public String getInvestigationClosure() {
        return investigationClosure;
    }

    public String getClosureMeeting() {
        return closureMeeting;
    }
}