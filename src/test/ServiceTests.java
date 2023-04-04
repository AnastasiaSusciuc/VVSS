package test;

import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

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

        assertEquals(service.saveTema("15", "", 2,5), 1);
        assertEquals(service.findAllTeme().iterator().next().getID(), "1");
    }
}
