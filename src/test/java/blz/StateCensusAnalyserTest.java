package blz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;

public class StateCensusAnalyserTest {
    CSVStateCensus csvStateCensus;
    InputStream filePath = getClass().getClassLoader().getResourceAsStream("file.txt");

    @Before
    public void setup() {
        csvStateCensus = new CSVStateCensus();
    }

    @Test
    public void givenCSVFile_shouldReturnNumberOfRecords() {
        int result = csvStateCensus.readStatesCensusCsv("src/main/resources/StateCensusData.csv").size();
        Assert.assertEquals(3, result);
    }

    @Test
    public void givenCSVFileIfIncorrect_shouldReturnCustomException() throws CensusAnalyserException {
        try {
            int result = csvStateCensus.readStatesCensusCsv("src/test/java/StateCensusAnalyserTest.java").size();
            Assert.assertEquals(3, result);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FIlE, e.type);
        }
    }

    @Test
    public void givenFile_IfIncorrectType_shouldReturnCustomException() throws CensusAnalyserException {
        try {
            int result = csvStateCensus.readStatesCensusCsv("src/test/java/StateCensusAnalyserTest.txt").size();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_TYPE_INCORRECT, e.type);
        }
    }

    @Test
    public void givenFile_IfCorrectTypeButImproperDelimiter_shouldReturnCustomException() throws CensusAnalyserException {
        try {
            int result = csvStateCensus.readStatesCensusCsv("src/main/resources/StateCensusImproperDelimiter.csv").size();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.IMPROPER_DELIMITER, e.type);
        }
    }

    @Test
    public void givenFile_IfCorrectTypeButHeaderIncorrect_shouldReturnCustomException() throws CensusAnalyserException {
        try {
            int result = csvStateCensus.readStatesCensusCsv("src/main/resources/StateCensusImproperDelimiter.csv").size();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.HEADER_IMPROPER, e.type);
        }
    }
}

