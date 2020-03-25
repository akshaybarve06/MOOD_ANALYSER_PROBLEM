package Test.Java;

import Main.Java.MoodAnalyserCustomException;
import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;

public class MoodAnalyserTest {

    MoodAnalyser object=new MoodAnalyser("I'm in Happy Mood..");

    @Test
    public void message_whenResponseSad() throws MoodAnalyserCustomException {
        MoodAnalyser object=new MoodAnalyser("I'm Sad..");
        Assert.assertEquals("SAD",object.moodAnalyseMethod());
    }
    @Test
    public void message_whenResponseHappy() throws MoodAnalyserCustomException {
        MoodAnalyser object=new MoodAnalyser("I'm Happy..");
        Assert.assertEquals("HAPPY",object.moodAnalyseMethod());
    }
    @Test
    public void givenNULL_thenResponseHappy() throws MoodAnalyserCustomException {
        MoodAnalyser object=new MoodAnalyser(null);
        Assert.assertEquals("HAPPY",object.moodAnalyseMethod());
   }
    @Test
    public void whenNull_thenCustomException() {
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser(null);
            moodAnalyserObject.moodAnalyseMethod();
        }
        catch( MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NULL_EXCEPTION,e.userDefinedObject);
        }
    }
}