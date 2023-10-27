package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    private final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologoRepository;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        int id = odontologoRepository.size()+1;
        odontologoRepository.add(odontologo);
        Odontologo odontologoGuardado = new Odontologo(
                id,
                odontologo.getNroMatricula(),
                odontologo.getNombre(),
                odontologo.getApellido());
        LOGGER.info("Se ha registrado el odontologo: " + odontologoGuardado);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() { return odontologoRepository;}

}
