import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrettyPrinter {

    public void printPublicMethodsOf(Object object){
        Method[] methods=object.getClass().getMethods();
        for (Method method : methods) {
            System.out.println("method="+method.getName());
        }
    }

    public void printParameterTypesOfConstructorsOf(Object object){
        Constructor[] constructors =  object.getClass().getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType + " ");
            }
            System.out.println();
        }
    }

    public Object createNewObjectOf(Object object,String... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //get constructor that takes a String as argument
        Constructor constructor = object.getClass().getConstructor(String.class, String.class);
        return  constructor.newInstance(args[0],args[1]);
    }


    public void printAllPublicFieldsOfClassOfGivenObject(Object object){
        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            System.out.println("field="+field.getName());
        }
    }

    public Object getFieldOfName(String fieldName) throws NoSuchFieldException {
        Demo demo = new Demo(2,3);
        return demo.getClass().getField(fieldName);
    }

    public void printAllPrivateFieldsOfClassOfGivenObject(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field="+field);
        }
    }

    public void printAllPrivateMethodsOfClassOfGivenObject(Object object) {
         Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method="+method);
        }
    }
}
