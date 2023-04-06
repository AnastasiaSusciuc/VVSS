package ssvv.example;

import org.junit.Test;
import ssvv.example.repository.NotaXMLRepository;
import ssvv.example.repository.StudentXMLRepository;
import ssvv.example.repository.TemaXMLRepository;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;

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

        try {
            service.saveTema("14", "", 2,5);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Descriere invalida!");
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

        assertEquals(service.saveTema("15", "ceva", 7,5), 0);
    }
}
