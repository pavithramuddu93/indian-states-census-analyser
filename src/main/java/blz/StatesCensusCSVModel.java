package blz;

import com.opencsv.bean.CsvBindByName;

public class StatesCensusCSVModel {
    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "state='" + state + '\'' +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                ", population=" + population +
                '}';
    }
}