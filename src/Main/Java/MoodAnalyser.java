package Main.Java;

public class MoodAnalyser {

    String message;

    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyser");
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String moodAnalyseMethod(String message)
    {
        this.message=message;
        return moodAnalyseMethod();
    }
    public String moodAnalyseMethod()
    {
        try {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException e){
            return "HAPPY";
        }
    }
}