package Main.Java;

public class MoodAnalyserCustomException extends Exception {

    public UserDefinedDataType userDefinedObject;

    public enum UserDefinedDataType
    {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION,
        NO_SUCH_CLASS,
        NO_SUCH_METHOD
    }
    public MoodAnalyserCustomException(String message, UserDefinedDataType userDefinedObject)
    {
        super(message);
        this.userDefinedObject = userDefinedObject;
    }
}