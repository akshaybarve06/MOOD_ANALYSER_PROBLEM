package Main.Java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor getConstructor(String className, Class... parameter) throws MoodAnalyserCustomException
    {
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
}
