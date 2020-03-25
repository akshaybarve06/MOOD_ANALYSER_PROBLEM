package Test.Java;

import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;

public class MoodAnalyserTest {

    MoodAnalyser object=new MoodAnalyser("I'm in Happy Mood..");

    @Test
    public void message_whenResponseSad(){
        String firstResult=object.moodAnalyseMethod("I'm in Sad Mood..");
        Assert.assertEquals("SAD",firstResult);
    }
    @Test
    public void message_whenResponseHappy(){
        String secondResult=object.moodAnalyseMethod("I'm in Happy Mood..");
        Assert.assertEquals("HAPPY",secondResult);
    }
    @Test
    public void givenNULL_thenResponseHappy(){
        String secondResult=object.moodAnalyseMethod(null);
        Assert.assertEquals("HAPPY",secondResult);
    }
}