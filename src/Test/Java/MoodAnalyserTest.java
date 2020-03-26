package Test.Java;

import Main.Java.MoodAnalyserCustomException;
import Main.Java.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;
import Main.Java.MoodAnalyser;
import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

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
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        MoodAnalyser moodObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor, "Hello");
        boolean expectedResult = MoodAnalyser.equals(moodObject);
        Assert.assertTrue("true", expectedResult);
    }
    @Test
    public void classWithParameterWrong_ReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_CLASS_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void constructorWithParameterWrong_ReturnNoSuchMethod() {
        try
        {
            MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class ,Integer.class);
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void happyMessage_WhenProper_ReturnHappy() {
        try
        {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",Integer.class);
            Object moodObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I'm Happy");
            Object moodObj = MoodAnalyserFactory.invokeMethod(moodObject, "analyseMood");
            Assert.assertEquals("HAPPY",moodObj);
        } catch (MoodAnalyserCustomException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void happy_WhenImproper_ReturnHappy() {
        try
        {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",Integer.class);
            Object moodObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I'm  Happy..");
            Object moodObj = MoodAnalyserFactory.invokeMethod(moodObject, "AnalyseMood");
            Assert.assertEquals("HAPPY",moodObj);
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void happy_whenProper_returnHappy() {
        try
        {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser object1 = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserFieldMethod(object1,"message","I'm Happy ");
            Object moodObj = MoodAnalyserFactory.invokeMethod(object1, "analyseMood");
            Assert.assertEquals("HAPPY",moodObj);
        } catch (MoodAnalyserCustomException e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void happyImproper_returnThrowException() throws MoodAnalyserCustomException{
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser object = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserFieldMethod(object,"Message","I'm Happy ");
            Object moodObj = MoodAnalyserFactory.invokeMethod(object, "analyseMood");
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_FIELD_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void nullMessageProper_returnThrowException() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser object = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserFieldMethod(object,"message",null);
            Object mood = MoodAnalyserFactory.invokeMethod(object, "analyseMood");
        } catch (MoodAnalyserCustomException e) {
            Assert.assertEquals(MoodAnalyserCustomException.UserDefinedDataType.INVOCATION_TARGET_EXCEPTION,e.userDefinedObject);
        }
    }
}