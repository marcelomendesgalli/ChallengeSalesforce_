package org.example.repositorios;

import org.example.config.OracleConfig;
import org.example.config._Logger;
import org.example.entities.Formulario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class FormularioRepository implements _Logger <Formulario> {

    OracleConfig connection = new OracleConfig();

    public List<Formulario> findAll() throws Exception {
        List<Formulario> resultList = new ArrayList<>();

        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM formularios");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultList.add(new Formulario(rs.getInt("id"), rs.getString("nome"), rs.getString("empresanome"), rs.getString("emailcorporativo"), rs.getString("telefone"), rs.getString("pais"), rs.getString("idioma")));
            }
        }

        return resultList;
    }

    public Optional<Formulario> findById(int id){
        Formulario formulario = new Formulario();

        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM formularios where id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                formulario = new Formulario(rs.getInt("id"), rs.getString("nome"), rs.getString("empresanome"), rs.getString("emailcorporativo"), rs.getString("telefone"), rs.getString("pais"), rs.getString("idioma"));
            }
            logInfo("Sucesso ao recuperar formulario com ID");
        }
        catch (SQLException e){
            logError("Erro: " + e.getMessage());
        }
        return Optional.ofNullable(formulario);
    }

    public void add(Formulario formulario) {

        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO FORMULARIOS ( NOME, EMPRESANOME, EMAILCORPORATIVO, SENHA, TELEFONE, PAIS, IDIOMA) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, formulario.getNome());
            stmt.setString(2, formulario.getEmpresanome());
            stmt.setString(3, formulario.getEmailcorporativo());
            stmt.setString(5, formulario.getTelefone());
            stmt.setString(6, formulario.getPais());
            stmt.setString(7, formulario.getAceitarpolitica());
            var rs = stmt.executeUpdate();
            System.out.println("Resultado: " + rs);
        }
        catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void update(Formulario formulario) throws Exception {
        String sql = "UPDATE formularios SET nome = ?, empresanome = ?, emailcorporativo = ?, senha = ?, telefone = ?, pais = ?, idioma = ? WHERE id = ?";

        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, formulario.getNome());
            stmt.setString(2, formulario.getEmpresanome());
            stmt.setString(3, formulario.getEmailcorporativo());
            stmt.setString(5, formulario.getTelefone());
            stmt.setString(6, formulario.getPais());
            stmt.setString(7, formulario.getAceitarpolitica());
            stmt.setInt(8, formulario.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM formularios WHERE id = ?";

        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    public boolean readFormByEmail(String email) throws SQLException {
        String sql = "SELECT EMAIL FROM CLIENTE WHERE email=?";
        try (Connection conn = connection.getConnection()){
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        var rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        }
    }

}
