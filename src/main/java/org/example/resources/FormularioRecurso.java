package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entities.Formulario;
import org.example.repositorios.FormularioRepository;
import org.example.service.FormularioService;

import java.util.List;

    @Path("formularios")
    public class FormularioRecurso {

        private FormularioRepository repositorio = new FormularioRepository();
        private FormularioService formularioService = new FormularioService();

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Formulario> getFormularios() {
            try {
                return repositorio.findAll();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addFormulario(Formulario formulario) {
            try {
                boolean emailCadastrado = formularioService.verificaEmailCadastrado(formulario);
                if (emailCadastrado){
                    return Response.ok("Email já cadastrado.").build();
                }
                return Response.ok("Usuario cadastrado com sucesso.").build();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @PUT
        @Path("{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public void updateFormulario(@PathParam("id") int id, Formulario formulario) {
            try {
                if (repositorio.findById(id).isPresent()) {
                    formulario.setId(id);
                    repositorio.update(formulario);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DELETE
        @Path("{id}")
        public void deleteFormulario(@PathParam("id") int id) {
            try {
                repositorio.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


