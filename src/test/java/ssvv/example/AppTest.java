package ssvv.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ssvv.example.domain.Student;
import ssvv.example.repository.NotaXMLRepository;
import ssvv.example.repository.StudentRepository;
import ssvv.example.repository.StudentXMLRepository;
import ssvv.example.repository.TemaXMLRepository;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;
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

    @Test
    public void testAddStudentTH2EC1()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("100", "Edi", 927);
        assertEquals(0, res);
        studentXMLRepository.delete("100");
    }

    @Test
    public void testAddStudentTH2EC2()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("", "Maria",100);
        assertEquals(1, res);

    }

    @Test
    public void testAddStudentTH2EC3()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("1", "Maria",111);
        assertEquals(0, res);

        res = service.saveStudent("1", "Maria",111);
        assertEquals(1, res);

        studentXMLRepository.delete("1");
    }

    @Test
    public void testAddStudentTH2BVA1()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent(null, "Maria",111);
        assertEquals(1, res);
    }

    @Test
    public void testAddStudentTH2BVA2()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("", "Maria",111);
        assertEquals(1, res);
    }

    @Test
    public void testAddStudentTH2BVA3()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("a", "Maria",111);
        assertEquals(0, res);
        res = service.saveStudent("aa", "Maria",111);
        assertEquals(0, res);
        String a255 = new String(new char[255]).replace('\0', 'a');
        String a254 = new String(new char[254]).replace('\0', 'a');

        res = service.saveStudent(a254, "Maria",111);
        assertEquals(0, res);

        res = service.saveStudent(a255, "Maria",111);
        assertEquals(0, res);

        studentXMLRepository.delete("a");
        studentXMLRepository.delete("aa");
        studentXMLRepository.delete(a254);
        studentXMLRepository.delete(a255);
    }

    @Test
    public void testAddStudentTH2BVA4()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("1", null,111);
        assertEquals(1, res);
    }

    @Test
    public void testAddStudentTH2BVA5()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("1", "",111);
        assertEquals(1, res);
    }

    @Test
    public void testAddStudentTH2BVA6()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("1", "a",111);
        assertEquals(0, res);
        res = service.saveStudent("2", "aa",111);
        assertEquals(0, res);
        String a255 = new String(new char[255]).replace('\0', 'a');
        String a254 = new String(new char[254]).replace('\0', 'a');

        res = service.saveStudent("3", a254,111);
        assertEquals(0, res);

        res = service.saveStudent("4", a255,111);
        assertEquals(0, res);

        studentXMLRepository.delete("1");
        studentXMLRepository.delete("2");
        studentXMLRepository.delete("3");
        studentXMLRepository.delete("4");
    }

    @Test
    public void testAddStudentTH2BVA7()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("1", "a",110);
        assertEquals(1, res);
        res = service.saveStudent("2", "aa",111);
        assertEquals(0, res);
        studentXMLRepository.delete("1");
        studentXMLRepository.delete("2");
    }

    @Test
    public void testAddStudentTH2BVA8()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("1", "a",110);
        assertEquals(1, res);
        res = service.saveStudent("2", "aa",111);
        assertEquals(0, res);
        res = service.saveStudent("3", "aa",112);
        assertEquals(0, res);
        studentXMLRepository.delete("1");
        studentXMLRepository.delete("2");
        studentXMLRepository.delete("3");
        res = service.saveStudent("4", "aa",936);
        assertEquals(0, res);
        res = service.saveStudent("5", "aa",937);
        assertEquals(0, res);
        res = service.saveStudent("6", "aa",938);
        assertEquals(1, res);
        studentXMLRepository.delete("4");
        studentXMLRepository.delete("5");
        studentXMLRepository.delete("6");
    }

    @Test
    public void testAddStudentTH2BVA9()
    {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, filenameStudent);
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, filenameTema);
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository notaXMLRepository = new NotaXMLRepository(notaValidator, filenameNota);
        Service service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);

        int res = service.saveStudent("5", "aa",938);
        assertEquals(1, res);
        res = service.saveStudent("6", "aa",937);
        assertEquals(0, res);
        studentXMLRepository.delete("5");
        studentXMLRepository.delete("6");
    }

}
