package reflection;
import com.hospital_management.runner.AppRunner;
import com.hospital_management.users.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public class ReflectionTest {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionTest.class);
    public static void main(String[] args) {

        List<Class<?>> classes = new ArrayList<>();
        classes.add(Doctor.class);
        classes.add(Hospital.class);
        classes.add(Intern.class);
        classes.add(Nurse.class);
        classes.add(Patient.class);
        classes.add(Person.class);
        classes.add(AppRunner.class);
        for (Class<?> myClass : classes){
        LOGGER.info("Class name: " + myClass.getName());
        LOGGER.info("Access modifier: " + Modifier.toString(myClass.getModifiers()));
        LOGGER.info("All fields from - " + myClass.getName());
            Class<?>[] interfaces = myClass.getInterfaces();
            LOGGER.info("Implemented interfaces are : ");
            for (Class<?> class1 : interfaces)	{
                LOGGER.info(class1.getName() + " ");
            }
                Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            LOGGER.info("-----------------------------------------------------------------------------");
            LOGGER.info("Variable name: " + field.getName());
            LOGGER.info("Data type of variable: " + field.getType());
            LOGGER.info("Access modifiers of the variable:  " + Modifier.toString(field.getModifiers()));
            LOGGER.info("-----------------------------------------------------------------------------");
        }
        LOGGER.info("All methods from " + myClass.getName());
        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            LOGGER.info("-----------------------------------------------------------------------------");
            LOGGER.info("Name of the method : " + method.getName());
            LOGGER.info("Return type of the method : " + method.getReturnType());
            LOGGER.info("Method access modifiers : " + Modifier.toString(method.getModifiers()));
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            LOGGER.info("Exception thrown by method :");
            for (Class<?> class1 : exceptionTypes) {
                LOGGER.info(class1.getName() + " ");
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            LOGGER.info("Method parameter types : ");
            for (Class<?> class1 : parameterTypes) {
                LOGGER.info(class1.getName() + " ");
            }
        }


    }
}
}
