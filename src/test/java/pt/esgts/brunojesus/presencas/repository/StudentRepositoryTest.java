package pt.esgts.brunojesus.presencas.repository;

import org.junit.jupiter.api.Test;
import pt.esgts.brunojesus.presencas.model.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private StudentRepository subject = new StudentRepository();

    @Test
    void findAll() {
        final List<Student> result = subject.findAll();

        assertNotNull(result);
        assertEquals(3, result.size());

        final Student primeiro = result.get(0);
        assertNotNull(primeiro);
        assertEquals(10, primeiro.getId());
        assertEquals("Rui Manuel", primeiro.getName());

        final Student ultimo = result.get(result.size() - 1);
        assertNotNull(ultimo);
        assertEquals(30, ultimo.getId());
        assertEquals("Manuel Jorge", ultimo.getName());
    }
}