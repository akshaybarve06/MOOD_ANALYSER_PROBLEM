package Main.Java;

public class MoodAnalyser {

    String message;

    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyser");
    }

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String moodAnalyseMethod()
    {
        if (message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}