package Main.Java;

import java.util.Objects;

public class MoodAnalyser {
    String message;
    public MoodAnalyser() {
    }
    public MoodAnalyser(String message) {
        this.message = message;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyser");
    }
    public String moodAnalyseMethod() throws MoodAnalyserCustomException {
        try
        {
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MoodAnalyser that = (MoodAnalyser) obj;
        return Objects.equals(message, that.message);
    }
}