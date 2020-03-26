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
            throw new MoodAnalyserCustomException("Class not found",MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_CLASS);
        }catch (NoSuchMethodException e) {
            throw new MoodAnalyserCustomException("Method not found",MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD);
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
            throw new MoodAnalyserCustomException("Method not found",MoodAnalyserCustomException.UserDefinedDataType.NO_SUCH_METHOD);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void moodAnalyserFieldMethod(Object object1, String message, String fieldValue) {
        try {
            Class<?> classObject = object1.getClass();
            Field fieldObject = classObject.getDeclaredField(message);
            fieldObject.set(object1,fieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}