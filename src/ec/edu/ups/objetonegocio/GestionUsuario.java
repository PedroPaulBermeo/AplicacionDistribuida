/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetonegocio;

import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.objetoaccesodatos.OAD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Bermeo
 */
public class GestionUsuario {

    private OAD oad;
    
    public GestionUsuario() {
        oad= new OAD();
    }

    public boolean validarCedula(String cedula) {
        String primDigito;
        String terDigito;
        String pares;
        String impares;

        if (cedula.length() == 10) {
            primDigito = cedula.substring(0, 2);
            System.out.println(primDigito);
        } else {
            return false;
        }
        return true;
    }

    public boolean validarFechaNacimiento(String fecha) {

        return false;
    }

    public boolean validarCorreoElectronico(String correo) {

        return false;
    }

    public boolean registrarUsuario(List<String> u) {

        return false;
    }

    public boolean actualizarUsuario(List<String> u) {
        Usuario usuario = convertirUsuario(u);
        if(oad.obtenerConexion()){
            oad.modificarUsuario(usuario);
            oad.cerrarConexion();
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(int id) {
        
        if(oad.obtenerConexion()){
            oad.eliminarUsuario(id);
            oad.cerrarConexion();
            return true;
        }
        return false;
    }

    public Usuario buscarUsuario(String cedula) {
        Usuario usuario=null;
        if(oad.obtenerConexion()){
            usuario=new Usuario();
            usuario=oad.buscarUsuario(cedula);
            oad.cerrarConexion();
            return usuario;
        }
        return null;
        
    }

    public List<Usuario> getClientes() {
        List<Usuario>usuarios=new ArrayList<>();
        
         if(oad.obtenerConexion()){
            
            usuarios=oad.listarUsuarios();
            oad.cerrarConexion();
            return usuarios;
        }
         
        return null;
    }

    public boolean validarDatosNulos(List<String> u) {
        for (String s : u) {
            if (s.equals(null)) {
                return false;
            }
        }
        return true;
    }

    public Usuario convertirUsuario(List<String> u) {
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(Integer.parseInt(u.get(0)));
        usuario.setCedula(u.get(1));
        usuario.setNombre(u.get(2));
        usuario.setApellido(u.get(3));
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            usuario.setFechaNacimiento(formato.parse(u.get(4)));
        } catch (ParseException ex) {
            System.out.println("No se puede transformar" + ex.getMessage());
        }
        usuario.setGenero(u.get(5));
        usuario.setEmail(u.get(6));
        return usuario;
    }
    
    public boolean buscarUsuarioExiste(List<String> u){
        
        if(oad.obtenerConexion()){
            List<Usuario>usuarios=new ArrayList<>();
            usuarios=oad.listarUsuarios();
            for(Usuario u1 : usuarios){
                if(u1.getEmail().equals(u.get(6))){
                    oad.cerrarConexion();
                    return true;
                }
            }
            
            oad.cerrarConexion();
        }
        
        return false;
        
    }
}
