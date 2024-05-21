package org.example.service;

import org.example.entities.Formulario;
import org.example.repositorios.FormularioRepository;

import java.sql.SQLException;

public class FormularioService {

    private FormularioRepository formularioRepository = new FormularioRepository();
    public boolean verificaEmailCadastrado(Formulario formulario) throws SQLException {
        if (formularioRepository.readFormByEmail(formulario.getEmailcorporativo())){
            return true;
        }
        formularioRepository.add(formulario);
        return false;
    }

}
