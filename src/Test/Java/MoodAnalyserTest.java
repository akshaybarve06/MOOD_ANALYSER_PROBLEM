package Test.Java;

import Main.Java.MoodAnalyserCustomException;
import Main.Java.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    MoodAnalyser object = new MoodAnalyser("I'm in Happy Mood..");

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
            MoodAnalyser moodAnalyserObject = new MoodAnalyser("");
            moodAnalyserObject.moodAnalyseMethod();
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.EMPTY_EXCEPTION, e.userDefinedObject);
        }
    }
    @Test
    public void givenObjectEqualsWithParameter_ReturnTrue() throws MoodAnalyserCustomException {
        MoodAnalyser MoodAnalyser = new MoodAnalyser("Hello");
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor, "Hello");
        boolean result = MoodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true", result);
    }
    @Test
    public void givenClassWithParameterWrong_ReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_CLASS,e.userDefinedObject);
        }
    }
    @Test
    public void givenConstructorWithParameterWrong_ReturnNoSuchMethod() {
        try
        {
            MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class ,Integer.class);
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }
    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappy() {
        try
        {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class);
            Object moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I am in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserCustomException e) {
            e.printStackTrace();
        }
    }
}