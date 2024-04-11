package AR.Framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import AR.Model.IntakePersonModel;

public class IntakeDataReader {

	public List<IntakePersonModel> Parse(String filePath) {
		
		List<IntakePersonModel> intakePersonList = new ArrayList<>();
        Gson gson = new Gson();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
            JsonArray records = jsonObject.getAsJsonArray("records");

            for (JsonElement record : records) {
                JsonObject recordObj = record.getAsJsonObject();

                IntakePersonModel intakePerson = new IntakePersonModel();

                intakePerson.setDateTime(recordObj.get("dateTime").getAsString());
                intakePerson.setReferralSource(recordObj.get("referralSource").getAsString());
                intakePerson.setReporterInput(recordObj.get("reporterInput").getAsString());
                intakePerson.setPrimaryRelationship(recordObj.get("primaryRelationship").getAsString());
                intakePerson.setSecondaryRelationship(recordObj.get("secondaryRelationship").getAsString());
                
                intakePerson.setFamilyName(recordObj.get("familyName").getAsString());
                intakePerson.setFamilyAddress(recordObj.get("familyAddress").getAsString());
                intakePerson.setRole(recordObj.get("role").getAsString());
                intakePerson.setLocatingInformation(recordObj.get("locatingInformation").getAsString());
                
                intakePerson.setDateOfIncident(recordObj.get("dateOfIncident").getAsString());
                intakePerson.setCountyOfIncident(recordObj.get("countyOfIncident").getAsString());
                intakePerson.setStatementsForAllegations(recordObj.get("statementsForAllegations").getAsString());
                intakePerson.setReporterWorries(recordObj.get("reporterWorries").getAsString());
                intakePerson.setLawEnforcement(recordObj.get("lawEnforcement").getAsString());
                intakePerson.setSafetyIssue(recordObj.get("safetyIssue").getAsString());
                intakePerson.setAdditionalInfo(recordObj.get("additionalInfo").getAsString());
                intakePerson.setFamilySupport(recordObj.get("familySupport").getAsString());
                intakePerson.setOtherFamilySupport(recordObj.get("otherFamilySupport").getAsString());
                
                intakePerson.setChildDeath(recordObj.get("childDeath").getAsString());
                intakePerson.setMentalInjury(recordObj.get("mentalInjury").getAsString());
                intakePerson.setNeglect1(recordObj.get("neglect1").getAsString());
                intakePerson.setNeglect2(recordObj.get("neglect2").getAsString());
                intakePerson.setNeglect3(recordObj.get("neglect3").getAsString());
                
                intakePerson.setScreeningOverride(recordObj.get("screeningOverride").getAsString());
                intakePerson.setRationale(recordObj.get("rationale").getAsString());
                                
                intakePerson.setCollateralName(recordObj.get("collateralName").getAsString());
                intakePerson.setRelationshipToFamily(recordObj.get("relationshipToFamily").getAsString());
                intakePerson.setDuplicateReferral(recordObj.get("DuplicateReferral").getAsString());
                intakePerson.setDate(recordObj.get("Date").getAsString());
                intakePerson.setIntakeRef(recordObj.get("IntakeRef").getAsString());
                intakePerson.setMandatedReport(recordObj.get("MandatedReport").getAsString());
                intakePerson.setReporter(recordObj.get("Reporter").getAsString());
                

                intakePersonList.add(intakePerson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return intakePersonList;
	}
}