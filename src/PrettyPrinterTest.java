import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class PrettyPrinterTest {

    @Test
    public void shouldPrintAllMethodsOfGivenClassObject() {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        Demo demo = new Demo(2, 3);
        prettyPrinter.printPublicMethodsOf(demo);
    }

    @Test
    public void shouldPrintPublicFieldsOfGivenClassObject() {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        Demo demo = new Demo(2, 3);
        prettyPrinter.printAllPublicFieldsOfClassOfGivenObject(demo);
    }


    @Test
    public void shouldPrintParametersOfConstructorsOfGivenClassObject() {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        Demo demo = new Demo(2, 3);
        prettyPrinter.printParameterTypesOfConstructorsOf(demo);
    }

    @Test
    public void shouldCreateAnObjectOfGivenClassObject() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        Demo demo = new Demo(2, 3);

        Demo demo1 = (Demo) prettyPrinter.createNewObjectOf(demo, "Ravi", "Sharma");

        assertThat(demo1.publicStringVariable, IsEqual.equalTo("Sharma"));
    }

    //    If you know the name of the field you want to access, you can access it like this
    @Test
    public void shouldGiveFieldIfPresent() throws NoSuchFieldException {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        Field field = (Field) prettyPrinter.getFieldOfName("publicIntVariable");
        assertThat(field.getName(), IsEqual.equalTo("publicIntVariable"));
    }


//   Accessing Private Fields
//------------------------------

//   To access a private field you will need to call the Class.getDeclaredField(String name) or
//   Class.getDeclaredFields() method.
//   The methods Class.getField(String name) and Class.getFields() methods only return public fields,
//   so they won't work.

    @Test
    public void shouldPrintPrivateFieldsOfGivenClassObject() throws IllegalAccessException {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        Demo demo = new Demo(2, 3);
        prettyPrinter.printAllPrivateFieldsOfClassOfGivenObject(demo);
    }


//By calling Field.setAcessible(true)
// you turn off the access checks for this particular Field instance, for reflection only.
// Now you can access it even if it is private, protected or package scope,
// even if the caller is not part of those scopes.

    @Test
    public void shouldSetTheValueOfPrivateIntVariableToGivenValue() throws NoSuchFieldException, IllegalAccessException {
        Demo demo = new Demo(2, 3);
        Field privateIntVariable=demo.getClass().getDeclaredField("privateIntVariable"); //
        privateIntVariable.setAccessible(true);
        Integer value = (Integer) privateIntVariable.get(demo);  //i want to extract field privateIntVariable from Object Demo
        System.out.println("fieldValue = " + value);

        privateIntVariable.set(demo,4); //"obj" the object whose field should be modified
                                       //"value" the new value for the field of {@code obj}
        System.out.println("NewfieldValue = " + (Integer) privateIntVariable.get(demo));
    }


  //Accessing Private Methods
//----------------------------

//To access a private method you will need to call the
// Class.getDeclaredMethod(String name, Class[] parameterTypes) or
// Class.getDeclaredMethods() method.
// The methods Class.getMethod(String name, Class[] parameterTypes) and
// Class.getMethods()
// methods only return public methods, so they won't work.

    @Test
    public void shouldPrintPrivateMethodsOfGivenClassObject() throws IllegalAccessException {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        Demo demo = new Demo(2, 3);
        prettyPrinter.printAllPrivateMethodsOfClassOfGivenObject(demo);
    }


    @Test
    public void getTheReturnValueOfGivenMethodName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Demo demo = new Demo(2, 3);
        Method getSum=demo.getClass().getDeclaredMethod("getSum",int.class,int.class); //name the name of the method
                                                                  //param parameterTypes the parameter array
        getSum.setAccessible(true);
        Integer sum = (Integer) getSum.invoke(demo, 2,3); //"obj" the object the underlying method is invoked from
//                                                          "args" the arguments used for the method call
        assertThat(5,IsEqual.equalTo(sum));
    }


}
