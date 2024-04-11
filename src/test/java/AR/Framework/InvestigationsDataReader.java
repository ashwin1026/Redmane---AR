
package AR.Framework;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import AR.Model.InvestigationPersonModel;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InvestigationsDataReader {

    public List<InvestigationPersonModel> Parse(String filePath) {
        List<InvestigationPersonModel> personList = new ArrayList<>();

        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(new FileReader(filePath));
            JsonArray records = jsonObject.getAsJsonArray("records");

            for (int i = 0; i < records.size(); i++) {
                JsonObject record = (JsonObject) records.get(i);

                InvestigationPersonModel person = new InvestigationPersonModel();
                person.setFamilyname(record.get("Familyname").getAsString());
                person.setFamilyaddress(record.get("Familyaddress").getAsString());
                person.setStartdate(record.get("Startdate").getAsString());
                person.setCountry(record.get("Country").getAsString());
                person.setExtensioncomment(record.get("Extensioncomment").getAsString());
      
                person.setCaseConnectionconnectdetails(record.get("CaseConnectionconnectdetails").getAsString());
                person.setInvestigationclosure(record.get("Investigationclosure").getAsString());
              
                person.setClosuremeeting(record.get("Closuremeeting").getAsString());

                personList.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personList;
    }
}