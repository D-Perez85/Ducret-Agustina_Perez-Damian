package com.backend.parcial.test;
import com.backend.parcial.dao.impl.OdontologoDaoH2;
import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OdontologoServiceTest {
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/g14parcial;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void deberiaGuardarUnOdontologo(){
        //Creacion de odontologo
        Odontologo odontologo = new Odontologo(2547, "Juana", "Viale");
        Odontologo odontologoRegistrado = odontologoService.guardarOdontologo(odontologo);
        //assert
        assertTrue(odontologoRegistrado.getId() !=0);
    }

    @Test
    void deberiaRetornarUnaListaNoVacia(){
        assertFalse(odontologoService.listarOdontologos().isEmpty());
    }



}
