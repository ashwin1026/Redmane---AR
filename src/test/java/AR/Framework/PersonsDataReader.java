/*
 * package AR.Framework;
 * 
 * //import org.json.JSONArray; //import org.json.JSONObject;
 * 
 * import AR.Model.PersonModel;
 * 
 * import java.io.BufferedReader; import java.io.FileReader; import
 * java.io.IOException; import java.util.ArrayList; import java.util.List;
 * 
 * public class PersonsDataReader {
 * 
 * public static List<PersonModel> Parse(String filePath) { List<PersonModel>
 * personsList = new ArrayList<>();
 * 
 * try { BufferedReader br = new BufferedReader(new FileReader(filePath));
 * StringBuilder sb = new StringBuilder(); String line; while ((line =
 * br.readLine()) != null) { sb.append(line); } br.close();
 * 
 * // JSONObject json = new JSONObject(sb.toString()); // JSONArray records =
 * json.getJSONArray("records");
 * 
 * for (int i = 0; i < records.length(); i++) { // JSONObject record =
 * records.getJSONObject(i);
 * 
 * PersonsModel person = new PersonsModel();
 * person.setFirstName(record.getString("firstName"));
 * person.setMiddleName(record.getString("middleName"));
 * person.setLastName(record.getString("lastName"));
 * person.setSuffix(record.getString("suffix"));
 * person.setDateOfBirth(record.getString("dateOfBirth"));
 * person.setSocialSecurityNumber(record.getString("socialSecurityNumber"));
 * person.setAliases(record.getString("aliases"));
 * 
 * personsList.add(person); }
 * 
 * } catch (IOException e) { e.printStackTrace(); }
 * 
 * return personsList; } }
 */