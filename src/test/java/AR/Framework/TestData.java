package AR.Framework;

import java.util.List;

import AR.Model.IntakePersonModel;
//import AR.Model.PersonModel;
//import AR.Model.PersonsModel;

public class TestData {

    private static List<IntakePersonModel> IntakeData;
    private static List<IntakePersonModel> PersonsData;
    private static int Iteration = -1;

    public static List<IntakePersonModel> getIntakeData() {
        return IntakeData;
    }

	/*
	 * public static List<PersonsModel> getPersonsData() { return PersonsData; }
	 */

    public static void LoadIntakeData() {
        IntakeDataReader datareader = new IntakeDataReader();
        IntakeData = datareader.Parse("C:\\Users\\ashwi\\git\\AR Automated Testing\\AR\\src\\test\\java\\AR\\TestData\\IntakeMultiple.json");
        ///AR/TestData/IntakeMultiple.json
    }

	/*
	 * public static void LoadPersonsData() { PersonsDataReader datareader = new
	 * PersonsDataReader(); PersonsData =
	 * datareader.Parse("/AR/TestData/IntakeMultiple.json"); }
	 */

    public static void Increment() {
        Iteration++;
    }

    public static IntakePersonModel GetCurrentIntakePersonModel() {
        return IntakeData.get(Iteration);
    }

	/*
	 * public static PersonsModel GetCurrentPerson() { return
	 * PersonsData.get(Iteration); }
	 */
}