package DataReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

//Data Reader to read values from CSV for Passage
public class CSVDataReaderPassage {

    String path = System.getProperty("user.dir");
    String CSVPath = path + "\\..\\dist\\Resources\\PassageData.csv";

    public String DistrictLevelItemBank, CampusLevelItemBank, TeacherLevelItemBank, DistrictLevelPassage_Name;
    public String CampusLevelPassage_Name, TeacherLevelPassage_Name, Topic, Lexile;
    public String GradeController, Single_Grade, Multiple_Grade, Passage_Text, Properties_Dropdown_option;
    public String Properties_Text, Passage_Save_alert_message, Passage_Move_alert_message, TeacherLevelMoveWorkSpace;
    public String SDHC_Permission_Passage, SDHC_Passage_Source, SDHC_Permission_Audio, SDHC_Audio_Source;
    public String SDHC_Permission_Graphic, SDHC_Graphic_Source, SDHC_Permission_Video, SDHC_Video_Source;
    public String HISD_Single_Grade, HISD_Multiple_Grade, HISD_Subject, HISD_Version, HISD_Type, HISD_Qualifier;

    public Map<String, String> getCsv() {
        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);

            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                DistrictLevelItemBank = readercsv.get("DistrictLevelItemBank");
                CampusLevelItemBank = readercsv.get("CampusLevelItemBank");
                TeacherLevelItemBank = readercsv.get("TeacherLevelItemBank");
                DistrictLevelPassage_Name = readercsv.get("DistrictLevelPassage_Name");
                CampusLevelPassage_Name = readercsv.get("CampusLevelPassage_Name");
                TeacherLevelPassage_Name = readercsv.get("TeacherLevelPassage_Name");
                Topic = readercsv.get("Topic");
                Lexile = readercsv.get("Lexile");
                GradeController = readercsv.get("GradeController");
                Single_Grade = readercsv.get("Single_Grade");
                Multiple_Grade = readercsv.get("Multiple_Grade");
                Passage_Text = readercsv.get("Passage_Text");
                Properties_Dropdown_option = readercsv.get("Properties_Dropdown_option");
                Properties_Text = readercsv.get("Properties_Text");
                Passage_Save_alert_message = readercsv.get("Passage_Save_alert_message");
                Passage_Move_alert_message = readercsv.get("Passage_Move_alert_message");
                TeacherLevelMoveWorkSpace = readercsv.get("TeacherLevelMoveWorkSpace");
                SDHC_Permission_Passage = readercsv.get("SDHC_Permission_Passage");
                SDHC_Passage_Source = readercsv.get("SDHC_Passage_Source");
                SDHC_Permission_Audio = readercsv.get("SDHC_Permission_Audio");
                SDHC_Audio_Source = readercsv.get("SDHC_Audio_Source");
                SDHC_Permission_Graphic = readercsv.get("SDHC_Permission_Graphic");
                SDHC_Graphic_Source = readercsv.get("SDHC_Graphic_Source");
                SDHC_Permission_Video = readercsv.get("SDHC_Permission_Video");
                SDHC_Video_Source = readercsv.get("SDHC_Video_Source");
                HISD_Single_Grade = readercsv.get("HISD_Single_Grade");
                HISD_Multiple_Grade = readercsv.get("HISD_Multiple_Grade");
                HISD_Subject = readercsv.get("HISD_Subject");
                HISD_Version = readercsv.get("HISD_Version");
                HISD_Type = readercsv.get("HISD_Type");
                HISD_Qualifier = readercsv.get("HISD_Qualifier");

                Maprecords.put("DistrictLevelItemBank", DistrictLevelItemBank);
                Maprecords.put("CampusLevelItemBank", CampusLevelItemBank);
                Maprecords.put("TeacherLevelItemBank", TeacherLevelItemBank);
                Maprecords.put("DistrictLevelPassage_Name", DistrictLevelPassage_Name);
                Maprecords.put("CampusLevelPassage_Name", CampusLevelPassage_Name);
                Maprecords.put("TeacherLevelPassage_Name", TeacherLevelPassage_Name);
                Maprecords.put("Topic", Topic);
                Maprecords.put("Lexile", Lexile);
                Maprecords.put("GradeController", GradeController);
                Maprecords.put("Single_Grade", Single_Grade);
                Maprecords.put("Multiple_Grade", Multiple_Grade);
                Maprecords.put("Passage_Text", Passage_Text);
                Maprecords.put("Properties_Dropdown_option", Properties_Dropdown_option);
                Maprecords.put("Properties_Text", Properties_Text);
                Maprecords.put("Passage_Save_alert_message", Passage_Save_alert_message);
                Maprecords.put("Passage_Move_alert_message", Passage_Move_alert_message);
                Maprecords.put("TeacherLevelMoveWorkSpace", TeacherLevelMoveWorkSpace);
                Maprecords.put("SDHC_Permission_Passage", SDHC_Permission_Passage);
                Maprecords.put("SDHC_Passage_Source", SDHC_Passage_Source);
                Maprecords.put("SDHC_Permission_Audio", SDHC_Permission_Audio);
                Maprecords.put("SDHC_Audio_Source", SDHC_Audio_Source);
                Maprecords.put("SDHC_Permission_Graphic", SDHC_Permission_Graphic);
                Maprecords.put("SDHC_Graphic_Source", SDHC_Graphic_Source);
                Maprecords.put("SDHC_Permission_Video", SDHC_Permission_Video);
                Maprecords.put("SDHC_Video_Source", SDHC_Video_Source);
                Maprecords.put("HISD_Single_Grade", HISD_Single_Grade);
                Maprecords.put("HISD_Multiple_Grade", HISD_Multiple_Grade);
                Maprecords.put("HISD_Subject", HISD_Subject);
                Maprecords.put("HISD_Version", HISD_Version);
                Maprecords.put("HISD_Type", HISD_Type);
                Maprecords.put("HISD_Qualifier", HISD_Qualifier);
            }
            readercsv.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    public String getTeacherLevelItemBank() {
        TeacherLevelItemBank = getCsv().get("TeacherLevelItemBank");
        return TeacherLevelItemBank;
    }

    public String getDistrictLevelPassage_Name() {
        DistrictLevelPassage_Name = getCsv().get("DistrictLevelPassage_Name");
        return DistrictLevelPassage_Name;
    }

    public String getCampusLevelPassage_Name() {
        CampusLevelPassage_Name = getCsv().get("CampusLevelPassage_Name");
        return CampusLevelPassage_Name;
    }

    public String getTeacherLevelPassage_Name() {
        TeacherLevelPassage_Name = getCsv().get("TeacherLevelPassage_Name");
        return TeacherLevelPassage_Name;
    }

    public String getTopic() {
        Topic = getCsv().get("Topic");
        return Topic;
    }

    public String getLexile() {
        Lexile = getCsv().get("Lexile");
        return Lexile;
    }

    public String getGradeController() {
        GradeController = getCsv().get("GradeController");
        return GradeController;
    }

    public String getSingle_Grade() {
        Single_Grade = getCsv().get("Single_Grade");
        return Single_Grade;
    }

    public String getMultiple_Grade() {
        Multiple_Grade = getCsv().get("Multiple_Grade");
        return Multiple_Grade;
    }

    public String getPassage_Text() {
        Passage_Text = getCsv().get("Passage_Text");
        return Passage_Text;
    }

    public String getProperties_Dropdown_option() {
        Properties_Dropdown_option = getCsv().get("Properties_Dropdown_option");
        return Properties_Dropdown_option;
    }

    public String getProperties_Text() {
        Properties_Text = getCsv().get("Properties_Text");
        return Properties_Text;
    }

    public String getPassage_Save_alert_message() {
        Passage_Save_alert_message = getCsv().get("Passage_Save_alert_message");
        return Passage_Save_alert_message;
    }

    public String getTeacherLevelMoveWorkSpace() {
        TeacherLevelMoveWorkSpace = getCsv().get("TeacherLevelMoveWorkSpace");
        return TeacherLevelMoveWorkSpace;
    }

}
