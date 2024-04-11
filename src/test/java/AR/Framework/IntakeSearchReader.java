package AR.Framework;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntakeSearchReader {

    private List<String> values;

    public void parse(String filePath) {
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(new FileReader(filePath));

            JsonArray jsonValues = jsonObject.getAsJsonArray("values");
            values = new ArrayList<>();

            for (int i = 0; i < jsonValues.size(); i++) {
                values.add(jsonValues.get(i).getAsString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getValues() {
        return values;
    }

}
