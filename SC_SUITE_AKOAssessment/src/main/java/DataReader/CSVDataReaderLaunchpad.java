package DataReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

//Data Reader to read values from CSV for LaunchpadData
public class CSVDataReaderLaunchpad {

    String path = System.getProperty("user.dir");
    String CSVPath = path + "\\..\\dist\\Resources\\LaunchpadData.csv";
    CSVParser csvParser;
    Reader reader;

    private String LaunchpadPageTitle;

    public CSVDataReaderLaunchpad() {
        //CSV
        try {
            // read the file
            reader = Files.newBufferedReader(Paths.get(CSVPath));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLaunchpadTitle() {
        for (CSVRecord csvRecord : csvParser) {
            LaunchpadPageTitle = csvRecord.get("LaunchpadTitle");
        }
        return LaunchpadPageTitle;
    }
}
