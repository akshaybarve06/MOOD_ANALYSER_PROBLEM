package Test.Java;

import Main.Java.MoodAnalyserCustomException;
import Main.Java.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;

import java.lang.reflect.Constructor;

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
    @Test
    public void givenObject_WhenEquals_ThenTrue() throws MoodAnalyserCustomException {
        MoodAnalyser MoodAnalyser = new MoodAnalyser();
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer");
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
        boolean result = MoodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }
}