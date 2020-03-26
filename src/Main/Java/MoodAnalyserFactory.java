package Main.Java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor getConstructor(String className, Class... parameter) {
        try
        {
            Class<?>  moodAnalyserClass=Class.forName(className);
            return moodAnalyserClass.getConstructor(parameter);
        }catch (Exception e){
            System.out.println(e);;
        }
        return null;
    }
    public static MoodAnalyser createMoodAnalyserObject(Constructor constructor) {
        try {
            return (MoodAnalyser) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
       }
        return null;
    }
}