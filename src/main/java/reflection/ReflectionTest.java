package reflection;
import com.hospital_management.runner.AppRunner;
import com.hospital_management.users.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {

    private static final Logger LOGGER = LogManager.getLogger(ReflectionTest.class);

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> list = new ArrayList<>();
        list.add(new Doctor());
        list.add(new Intern());
        list.add(new Nurse());
        list.add(new Patient());
        list.add(new Person());
        list.add(new AppRunner());
        list.add(new Hospital());
        for (Object object : list) {
            LOGGER.info("----------------------------------------------------------------------------------");
            LOGGER.info("Class name: " + object.getClass().getName());
            LOGGER.info("Access modifier: " + Modifier.toString(object.getClass().getModifiers()));
            LOGGER.info("Declared fields: ");
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (Field field : declaredFields){
                LOGGER.info(field.getName());
            }
            Class<?>[] interfaces = object.getClass().getInterfaces();
            LOGGER.info("Implemented interfaces are : ");
            for (Class<?> class1 : interfaces) {
                LOGGER.info(class1.getName() + " ");
            }
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                LOGGER.info("Variable name: " + field.getName());
                LOGGER.info("Data type of variable: " + field.getType());
                LOGGER.info("Access modifiers of the variable:  " + Modifier.toString(field.getModifiers()));
            }
            LOGGER.info("All methods from " + object.getClass().getName());
            Method[] methods = object.getClass().getDeclaredMethods();
            for (Method method : methods) {
             if (method.getDeclaringClass().getName().equals("com.hospital_management.runner.AppRunner")){
                 if (method.getName().startsWith("print")&&Modifier.toString(method.getModifiers()).equals("public static")){
                     LOGGER.info("---printOption method from AppRunner invoked---");
                     method.invoke(new Object());
                 }
             }
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
            LOGGER.info("----------------------------------------------------------------------------------");
        }
    }
}
