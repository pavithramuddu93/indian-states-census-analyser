package blz;

public class StateCensusAnalyser {

    public static void main(String[] args) {
        CSVStateCensus csvStateCensus = new CSVStateCensus();
        int statesCensus;
        statesCensus = csvStateCensus.readStatesCensusCsv("E:\\BridgeLabs Training\\Java\\Advance Java\\IndianStatesCensusAnalyser\\src\\main\\java\\blz\\StateCensusData.csv");
        System.out.println(statesCensus);
    }
}