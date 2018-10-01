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
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String nueveDig = "";
        int pares = 0;
        int impares = 0;
        int mayorimpa = 0;
        int mayorimp = 0;
        int menorimpa = 0;
        int sumaImpares = 0;
        int resultado;
        int res;
        int resFinal;

        if (cedula.matches("[0-9]*")) {
            if (cedula.length() == 10) {
                if (Integer.parseInt(cedula.substring(0, 2)) >= 01 && Integer.parseInt(cedula.substring(0, 2)) <= 24) {
                    // System.out.println("el numero es correcto");
                    // System.out.println(Integer.parseInt(cedula.substring(2,3)));
                    if (Integer.parseInt(cedula.substring(2, 3)) >= 0 && Integer.parseInt(cedula.substring(2, 3)) <= 5) {
                        nueveDig = cedula.substring(0, 9);
                        char[] digitos = nueveDig.toCharArray();

                        for (int i = 0; i < digitos.length; i++) {
                            if (i % 2 == 0) {
                                //System.out.println("numeros impares  "+digitos[i]);
                                impares = Integer.parseInt("" + digitos[i]) * 2;
                                //  System.out.println("impares    " + impares[i]);

                                if (impares > 9) {
                                    mayorimp = impares - 9;
                                    mayorimpa += mayorimp;

                                    //  System.out.println("impares mayores a 9     " + mayorimpa);
                                } else {
                                    menorimpa = menorimpa + impares;
                                    //System.out.println("impares menores a 9    " + menorimpa);
                                }
                            } else {
                                pares += Integer.parseInt("" + digitos[i]);
                            }
                        }
                        sumaImpares = menorimpa + mayorimpa;

                        resultado = sumaImpares + pares;

                        res = resultado % 10;

                        if (res == 0) {
                            System.out.println("Cedula correcta");
                            return true;
                        } else {
                            resFinal = 10 - res;

                            if (resFinal == Integer.parseInt(cedula.substring(9, 10))) {
                                System.out.println("resFinal  " + resFinal);
                                System.out.println("Cedula " + cedula.substring(9, 10));
                                System.out.println("Cedula Correcta");
                                return true;
                            } else {
                                System.out.println("Cedula incorrecta");
                            }
                        }
                    } else {
                        System.out.println("fuera de rango de 0 a 5");
                        return false;
                    }
                } else {
                    System.out.println("fuera de rango de 01 a 24");
                    return false;
                }

            } else {
                System.out.println("Fuera de rango 10");
                return false;
            }
        } else {
            System.out.println("no valido");
            return false;
        }

        return false;
    }

    public boolean validarFechaNacimiento(String fecha) {

        int dia=Integer.parseInt(fecha.substring(0,2));
        int mes=Integer.parseInt(fecha.substring(3,5));
        int anio=Integer.parseInt(fecha.substring(6,fecha.length()));
       
        System.out.println(dia);
        System.out.println(mes);
        System.out.println(anio);
        if(anio<1900){
            try{
                
            }catch(IllegalArgumentException i){
                i.printStackTrace();
                System.out.println("Año invalido: "+i.getMessage());
            }
            return false;
        }
        try{
            LocalDate hoy = LocalDate.of(anio,mes,dia);
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
             System.out.println(formatter.format(hoy));
        }catch(DateTimeException e){
            System.out.println("La fecha ingresada es invalido: "+e.getMessage());
        }
             
            
        return true;
    }

    public boolean validarCorreoElectronico(String correo) {

        if(correo.contains("@")){
            System.out.println("es valido el correo");
            return true;
            
        }
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

    public boolean eliminarUsuario(String cedula) {
        
        if(oad.obtenerConexion()){
            oad.eliminarUsuario(cedula);
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
    
   
}
