package Main.Java;

public class MoodAnalyserCustomException extends Exception {

    public UserDefinedDataType userDefinedObject;

    public enum UserDefinedDataType
    {
        NULL_EXCEPTION
    };
    public MoodAnalyserCustomException(String message, UserDefinedDataType userDefinedObject)
    {
        super(message);
        this.userDefinedObject = userDefinedObject;
    }
}