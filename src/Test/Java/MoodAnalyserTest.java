package Test.Java;

import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;

public class MoodAnalyserTest {

    @Test
    public void message_whenResponseSad(){
        MoodAnalyser object=new MoodAnalyser();
        Assert.assertEquals("SAD",object.moodAnalyseMethod("I'm in sad mood"));
    }
}
