package lambda.practice;
import com.hospital_management.users.Hospital;
import com.hospital_management.users.Patient;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaPractice{
    public static void printThing(Printable printable){
        printable.print();
    }

    public static void main(String[] args) {
        printThing(()-> System.out.println("Hello World"));
        List<String> cities = Arrays.asList("Chicago","Des Plaines","Ohio","Detroit");
        Predicate<String> predicate = (s)->s.startsWith("D");
        for (String city:cities) {
            if(predicate.test(city)){
                System.out.println(city);
            }
        }
        Predicate<Patient> name = patient -> patient.getFirstName().startsWith("H");
        boolean test = name.test(Hospital.getPatientDir().get(0));
        System.out.println(test);
        BiPredicate<String,String> biPredicate = (x,y)-> x.length()==y.length();
        System.out.println(biPredicate.test("test","tes"));
        UnaryOperator<String> unaryOperator = s -> s.concat("!");
        System.out.println(unaryOperator.apply("Hello"));
    }
}