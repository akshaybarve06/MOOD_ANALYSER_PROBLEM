package Test.Java;

import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;

public class MoodAnalyserTest {

    @Test
    public void message_whenResponseSad(){
        MoodAnalyser object=new MoodAnalyser("I'm in sad mood");
        Assert.assertEquals("SAD",object.moodAnalyseMethod());
    }
    @Test
    public void message_whenResponseHappy(){
        MoodAnalyser object=new MoodAnalyser("I'm in any mood");
        Assert.assertEquals("HAPPY",object.moodAnalyseMethod());
    }
}
