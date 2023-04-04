package ssvv.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ssvv.example.domain.Student;
import ssvv.example.repository.StudentRepository;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.Validator;


public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAddStudent()
    {
        Validator<Student> studentValidator = new StudentValidator();
        StudentRepository studentRepository = new StudentRepository(studentValidator);

        Student student = new Student("1234", "Ana", 876);
        studentRepository.save(student);

        assertEquals(studentRepository.findOne("1234").getID(), "1234");
        assertEquals(studentRepository.findOne("1234").getNume(), "Ana");
        assertEquals(studentRepository.findOne("1234").getGrupa(), 876);

    }


}
