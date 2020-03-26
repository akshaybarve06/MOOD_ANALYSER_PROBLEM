package Main.Java;

public class MoodAnalyserCustomException extends Exception {

    public UserDefinedDataType userDefinedObject;

    public enum UserDefinedDataType
    {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION,
        NO_SUCH_CLASS_EXCEPTION,
        NO_SUCH_METHOD_EXCEPTION,
        NO_SUCH_FIELD_EXCEPTION,
        ILLEGAL_ACCESS_EXCEPTION,
        INVOCATION_TARGET_EXCEPTION
    }
    public MoodAnalyserCustomException(String message, UserDefinedDataType userDefinedObject)
    {
        super(message);
        this.userDefinedObject = userDefinedObject;
    }
}