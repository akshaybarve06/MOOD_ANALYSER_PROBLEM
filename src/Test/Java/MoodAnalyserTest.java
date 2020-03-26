package Test.Java;

import Main.Java.MoodAnalyserCustomException;
import Main.Java.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;
import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    MoodAnalyser object = new MoodAnalyser("I'm Happy..");

    @Test
    public void message_whenResponseSad() throws MoodAnalyserCustomException {
        MoodAnalyser object = new MoodAnalyser("I'm Sad..");
        Assert.assertEquals("SAD", object.moodAnalyseMethod());
    }
    @Test
    public void message_whenResponseHappy() throws MoodAnalyserCustomException {
        MoodAnalyser object = new MoodAnalyser("I'm Happy..");
        Assert.assertEquals("HAPPY", object.moodAnalyseMethod());
    }

    @Test
    public void givenNULL_thenResponseHappy() throws MoodAnalyserCustomException {
        MoodAnalyser object = new MoodAnalyser(null);
        Assert.assertEquals("HAPPY", object.moodAnalyseMethod());
    }
    @Test
    public void whenNull_thenCustomException() {
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser(null);
            moodAnalyserObject.moodAnalyseMethod();
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NULL_EXCEPTION, e.userDefinedObject);
        }
    }
    @Test
    public void emptyMessage_thenEmptyMoodException() {
        try {
            MoodAnalyser moodObject = new MoodAnalyser("");
            moodObject.moodAnalyseMethod();
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.EMPTY_EXCEPTION, e.userDefinedObject);
        }
    }
    @Test
    public void givenObjectEqualsWithParameter_ReturnTrue() throws MoodAnalyserCustomException {
        MoodAnalyser MoodAnalyser = new MoodAnalyser("Hello");
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
        MoodAnalyser moodObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor, "Hello");
        boolean result = MoodAnalyser.equals(moodObject);
        Assert.assertTrue("true", result);
    }
    @Test
    public void classWithParameterWrong_ReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_CLASS,e.userDefinedObject);
        }
    }
    @Test
    public void constructorWithParameterWrong_ReturnNoSuchMethod() {
        try
        {
            MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class ,Integer.class);
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }
    @Test
    public void happyMessageWhenProper_ReturnHappy() {
        try
        {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
            Object moodObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I'm Happy");
            Object mood = MoodAnalyserFactory.invokeMethod(moodObject, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserCustomException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void happyMessageWhenImproper_ReturnHappy() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
            Object moodObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I'm  Happy..");
            Object mood = MoodAnalyserFactory.invokeMethod(moodObject, "AnalyseMood");
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }
}