/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetonegocio;

import ec.edu.ups.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class GestionUsuario {

    public GestionUsuario() {
    }
    public boolean validarCedula(String cedula){
     String primDigito;
     String terDigito;
     String pares;
     String impares;
     
        if(cedula.length()==10){
            primDigito = cedula.substring(0,2);
            System.out.println(primDigito);
        }else{
            return false;
        }
        return true;
    }
    
    public boolean validarFechaNacimiento(String fecha){
     
        return false;
    }
    
    public boolean validarCorreoElectronico(String correo){
     
        return false;
    }
    
    public boolean registrarUsuario(List<String>u){
        
        return false;
    }
    
    public boolean actualizarUsuario(List<String>u){
        return false;
    }
    
    public boolean eliminarUsuario(int id){
        return false;
    }
    
    public Usuario buscarUsuario(String cedula){
        return null;
    }
    
    public List<Usuario> getClientes(){
        return null;
    }
}
