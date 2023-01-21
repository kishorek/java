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
        Student sample = Instancio.create(Student.class);
        System.out.println(sample);

        Map<String, Long> map = Instancio.create(new TypeToken<Map<String, Long>>() {
        });
        System.out.println(map);

        System.out.println(Instancio.ofMap(String.class, Long.class).size(20).create());

        Model<Student> studentModel = Instancio.of(Student.class).toModel();
        System.out.println(Instancio.of(studentModel).create());

        Student selectorSample = Instancio.of(Student.class)
                .set(Select.field(Student::getName), "NewStudent")
                .generate(Select.field(Student::getCgpa), gen -> gen.doubles().range(0.0, 10.0))
                .generate(Select.field(Student::getId),gen->gen.text().pattern("LSV#d"))
                .generate(Select.field(Student::getHouse),gen->gen.oneOf("White","Blue","Red","Green"))
                .generate(Select.field(Student::getDateOfJoining),gen->gen.temporal().date().past())
                .create();
        System.out.println(selectorSample);

    }
}
