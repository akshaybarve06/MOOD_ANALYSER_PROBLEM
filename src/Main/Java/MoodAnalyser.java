package Main.Java;

public class MoodAnalyser {

    String message;

    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyser");
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String moodAnalyseMethod() throws MoodAnalyserCustomException {
        try {
            if (message.length() == 0)
                throw new MoodAnalyserCustomException("Please Enter Value..Mood Cant be NULL", MoodAnalyserCustomException.UserDefinedDataType.NULL_EXCEPTION);
            else if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserCustomException("Please Enter Value..Mood Cant be NULL", MoodAnalyserCustomException.UserDefinedDataType.NULL_EXCEPTION);
        }
    }
}