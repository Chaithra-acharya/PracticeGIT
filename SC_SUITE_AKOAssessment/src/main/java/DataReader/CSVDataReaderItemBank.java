package DataReader;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Data Reader to read values from CSV for LaunchpadData
public class CSVDataReaderItemBank {

    String path = System.getProperty("user.dir");
    String CSVPath = path + "\\..\\dist\\Resources\\ItemBankData.csv";

    public String DistrictLevelItemBankName, CampusLevelItemBankName, TeacherLevelItemBankName, WorkSpaceCampusItemBankHISD, CampusWorkSpaceShortNameHISD;
    public String Description, BankAlertMessage, campusBankLevel, teacherBankLevel, WorkSpaceItemBankHISD, WorkSpaceShortNameHISD;
    public String WorkSpaceTeacherItemBankHISD, TeacherWorkSpaceShortNameHISD, itemBankTitle, createBankText, bankCreatedSuccessFully, districtSelectItemWorkSpaceDropDownName;
    public String campusSelectItemWorkSpaceDropDownName, teacherSelectItemWorkSpaceDropDownName;

    public Map<String, String> getCsv() {
        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);

            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                DistrictLevelItemBankName = readercsv.get("DistrictLevelItemBankName");
                CampusLevelItemBankName = readercsv.get("CampusLevelItemBankName");
                TeacherLevelItemBankName = readercsv.get("TeacherLevelItemBankName");
                Description = readercsv.get("Description");
                BankAlertMessage = readercsv.get("BankAlertMessage");
                campusBankLevel = readercsv.get("campusBankLevel");
                teacherBankLevel = readercsv.get("teacherBankLevel");
                WorkSpaceItemBankHISD = readercsv.get("WorkSpaceItemBankHISD");
                WorkSpaceShortNameHISD = readercsv.get("WorkSpaceShortNameHISD");
                WorkSpaceCampusItemBankHISD = readercsv.get("WorkSpaceCampusItemBankHISD");
                CampusWorkSpaceShortNameHISD = readercsv.get("CampusWorkSpaceShortNameHISD");
                WorkSpaceTeacherItemBankHISD = readercsv.get("WorkSpaceTeacherItemBankHISD");
                TeacherWorkSpaceShortNameHISD = readercsv.get("TeacherWorkSpaceShortNameHISD");
                itemBankTitle = readercsv.get("ItemBankText");
                createBankText = readercsv.get("CreateBankText");
                bankCreatedSuccessFully = readercsv.get("BankCreatedSuccessfully");
                districtSelectItemWorkSpaceDropDownName = readercsv.get("DistrictSelectItemWorkSpaceDropDownName");
                campusSelectItemWorkSpaceDropDownName = readercsv.get("CampusSelectItemWorkSpaceDropDownName");
                teacherSelectItemWorkSpaceDropDownName = readercsv.get("TeacherSelectItemWorkSpaceDropDownName");

                Maprecords.put("DistrictLevelItemBankName", DistrictLevelItemBankName);
                Maprecords.put("CampusLevelItemBankName", CampusLevelItemBankName);
                Maprecords.put("TeacherLevelItemBankName", TeacherLevelItemBankName);
                Maprecords.put("Description", Description);
                Maprecords.put("BankAlertMessage", BankAlertMessage);
                Maprecords.put("campusBankLevel", campusBankLevel);
                Maprecords.put("teacherBankLevel", teacherBankLevel);
                Maprecords.put("WorkSpaceItemBankHISD", WorkSpaceItemBankHISD);
                Maprecords.put("WorkSpaceShortNameHISD", WorkSpaceShortNameHISD);
                Maprecords.put("WorkSpaceCampusItemBankHISD", WorkSpaceCampusItemBankHISD);
                Maprecords.put("CampusWorkSpaceShortNameHISD", CampusWorkSpaceShortNameHISD);
                Maprecords.put("WorkSpaceTeacherItemBankHISD", WorkSpaceTeacherItemBankHISD);
                Maprecords.put("TeacherWorkSpaceShortNameHISD", TeacherWorkSpaceShortNameHISD);
                Maprecords.put("ItemBankText", itemBankTitle);
                Maprecords.put("CreateBankText", createBankText);
                Maprecords.put("BankCreatedSuccessfully", bankCreatedSuccessFully);
                Maprecords.put("DistrictSelectItemWorkSpaceDropDownName", districtSelectItemWorkSpaceDropDownName);
                Maprecords.put("CampusSelectItemWorkSpaceDropDownName", campusSelectItemWorkSpaceDropDownName);
                Maprecords.put("TeacherSelectItemWorkSpaceDropDownName", teacherSelectItemWorkSpaceDropDownName);
            }
            readercsv.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    public String getDistrictLevelItemBankName() {
        DistrictLevelItemBankName = getCsv().get("DistrictLevelItemBankName");
        return DistrictLevelItemBankName;
    }

    public String getCampusLevelItemBankName() {
        CampusLevelItemBankName = getCsv().get("CampusLevelItemBankName");
        return CampusLevelItemBankName;
    }

    public String getTeacherLevelItemBankName() {
        TeacherLevelItemBankName = getCsv().get("TeacherLevelItemBankName");
        return TeacherLevelItemBankName;
    }

    public String getDescription() {
        Description = getCsv().get("Description");
        return Description;
    }

    public String getBankAlertMessage() {
        BankAlertMessage = getCsv().get("BankAlertMessage");
        return BankAlertMessage;
    }

    public String getcampusBankLevel() {
        campusBankLevel = getCsv().get("campusBankLevel");
        return campusBankLevel;
    }

    public String getteacherBankLevel() {
        teacherBankLevel = getCsv().get("teacherBankLevel");
        return teacherBankLevel;
    }

    public String getItemBankTitleText() {
        teacherBankLevel = getCsv().get("ItemBankText");
        return itemBankTitle;
    }

    public String getCreateBankText() {
        teacherBankLevel = getCsv().get("CreateBankText");
        return itemBankTitle;
    }
    public String getItemSuccessfullyCreatedPopUpText() {
        bankCreatedSuccessFully = getCsv().get("BankCreatedSuccessfully");
        return bankCreatedSuccessFully;
    }

    public String getDistrictSelectItemWorkSpaceDropDownName() {
        districtSelectItemWorkSpaceDropDownName = getCsv().get("DistrictSelectItemWorkSpaceDropDownName");
        return districtSelectItemWorkSpaceDropDownName;
    }

    public String getCampusSelectItemWorkSpaceDropDownName() {
        campusSelectItemWorkSpaceDropDownName = getCsv().get("CampusSelectItemWorkSpaceDropDownName");
        return campusSelectItemWorkSpaceDropDownName;
    }

    public String getTeacherSelectItemWorkSpaceDropDownName() {
        teacherSelectItemWorkSpaceDropDownName = getCsv().get("TeacherSelectItemWorkSpaceDropDownName");
        return teacherSelectItemWorkSpaceDropDownName;
    }
}
