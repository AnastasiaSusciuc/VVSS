package ssvv.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import ssvv.example.repository.NotaXMLRepository;
import ssvv.example.repository.StudentXMLRepository;
import ssvv.example.repository.TemaXMLRepository;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;
import ssvv.example.validation.ValidationException;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ServiceTests {

    @Test
    public void TestCase1() {
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

        try{
            service.saveTema(null, "ceva", 7,5);
            assert(false);
        }catch (ValidationException e){
            assert(Objects.equals(e.getMessage(), "ID invalid! \n"));
            assert(true);
        }
    }

    @Test
    public void TestCase2() {
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

        try{
            service.saveTema("123", null, 7,5);
            assert(false);
        }catch (ValidationException e){
            assert(Objects.equals(e.getMessage(), "Descriere invalida! \n"));
            assert(true);
        }
    }

    @Test
    public void TestCase3() {
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

        try{
            service.saveTema("123", "descriere", -1,5);
            assert(false);
        }catch (ValidationException e){
            assert(Objects.equals(e.getMessage(), "Deadline invalid! \n"));
            assert(true);
        }
    }

    @Test
    public void TestCase4() {
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

        try{
            service.saveTema("123", "descriere", 5,-1);
            assert(false);
        }catch (ValidationException e){
            assert(Objects.equals(e.getMessage(), "Data de primire invalida! \n"));
            assert(true);
        }
    }

    @Test
    public void TestCase5() {
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

        try{
            service.saveTema("123", "descriere", 7,6);
            service.saveTema("123", "descriere", 8,7);
            assert(false);
        }catch (ValidationException e){
            assert(Objects.equals(e.getMessage(), "Id existent!\n"));
            assert(true);
        }
    }

    @Test
    public void TestCase6() {
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
        service.deleteTema("1299");
        assertEquals(service.saveTema("1299", "descriere", 7,6), 1);
    }

}
