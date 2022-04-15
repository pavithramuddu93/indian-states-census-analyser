package blz;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        INCORRECT_FIlE, FILE_TYPE_INCORRECT, IMPROPER_DELIMITER, HEADER_IMPROPER
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}