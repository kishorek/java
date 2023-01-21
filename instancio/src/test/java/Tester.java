import com.kishorek.models.Student;
import org.instancio.Instancio;
import org.instancio.Model;
import org.instancio.Select;
import org.instancio.TypeToken;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Tester {
    @Test
    public void testStudent() {
        //Creating an object using Shorthand method
        Student student = Instancio.create(Student.class);
        System.out.println(student);

        //Creating the object using builder
        student = Instancio.of(Student.class).create();
        System.out.println(student);

        // Setting the name field to Carl
        Student namedStudent = Instancio.of(Student.class)
                .set(Select.field(Student::getName), "Carl").create();
        System.out.println(namedStudent);

        // Setting all the String fields to some value
        Student allSelectStudent = Instancio.of(Student.class).set(Select.all(String.class),"Some String").create();
        System.out.println(allSelectStudent);

        Student selectorSample = Instancio.of(Student.class)
                .set(Select.field(Student::getName), "Carl")
                .generate(Select.field(Student::getCgpa), gen -> gen.doubles().range(0.0, 10.0))
                .generate(Select.field(Student::getId),gen->gen.text().pattern("LSV#d"))
                .generate(Select.field(Student::getHouse),gen->gen.oneOf("White","Blue","Red","Green"))
                .generate(Select.field(Student::getDateOfJoining),gen->gen.temporal().date().past())
                .create();
        System.out.println(selectorSample);

        //Creating Maps
        Map<String, Long> map = Instancio.create(new TypeToken<Map<String, Long>>() {
        });
        System.out.println(map);

        System.out.println(Instancio.ofMap(String.class, Long.class).size(20).create());
    }
}
