package Main.Java;

public class MoodAnalyser {

    String message;

    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyser");
    }
    public String moodAnalyseMethod(String message)
    {
        if (message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}