package Main.Java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {

    public static Constructor getConstructor(String className, Class... parameter) throws MoodAnalyserCustomException {
        try
        {
            Class<?>  moodAnalyserClass=Class.forName(className);
            return moodAnalyserClass.getConstructor(parameter);
        }catch (ClassNotFoundException e){
            throw new MoodAnalyserCustomException("Class not found",MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_CLASS_EXCEPTION);
        }catch (NoSuchMethodException e) {
            throw new MoodAnalyserCustomException("Method not found",MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD_EXCEPTION);
        }
    }
    public static MoodAnalyser createMoodAnalyserObject(Constructor constructor, Object... objects) {
        try {
            return (MoodAnalyser) constructor.newInstance(objects);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object invokeMethod(Object moodAnalyserObject, String analyseMood) throws MoodAnalyserCustomException{
        try {
            Class objectClass = moodAnalyserObject.getClass();
            Method moodMethod = objectClass.getMethod(analyseMood);
            Object result = moodMethod.invoke(moodAnalyserObject);
            return result;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserCustomException("Method not found",MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD_EXCEPTION);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void moodAnalyserFieldMethod(Object object, String message, String fieldValue) throws MoodAnalyserCustomException {
        try {
            Class<?> classObject = object.getClass();
            Field fieldObject = classObject.getDeclaredField(message);
            fieldObject.set(object,fieldValue);
        } catch (NoSuchFieldException e ) {
            throw new MoodAnalyserCustomException("No Such Field Found",MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_FIELD_EXCEPTION);
        }
        catch ( IllegalAccessException e) {
            throw new MoodAnalyserCustomException("Message Shouldn't Be NULL",MoodAnalyserCustomException.UserDefinedDataType.ILLEGAL_ACCESS_EXCEPTION);
        }
    }

}