/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetoaccesodatos;

import ec.edu.ups.entidades.Pelicula;
import ec.edu.ups.entidades.PeliculaVista;
import ec.edu.ups.entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class OAD {

    private String url;
    private Connection conexion;
    private PreparedStatement consulta;
    private DateFormat formatoFecha;

    public OAD() {
        url = null;
        conexion = null;
        consulta = null;
    }

    public boolean obtenerConexion() {

        String url = "jdbc:postgresql://localhost:5432/BDPeliculas";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, "postgres", "manager");
        } catch (SQLException ex) {
            System.out.println("Error de Conexion" + ex.getMessage());
        }

        try {
            conexion = DriverManager.getConnection(url, "postgresql", "1219MaPe");

        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }

    public boolean insertarUsuario(Usuario u) {

        return false;
    }

    public boolean modificarUsuario(Usuario u) {

        return false;
    }

    public boolean eliminarUsuario(int id) {

        try {
            consulta = conexion.prepareStatement("DELETE FROM \"Usuario\" WHERE \""
                    + "idUsuario\"='" + id + "';");
            consulta.executeQuery();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al eliminar un Usuario: " + ex.getMessage());
        }
        return false;
    }

    public Usuario buscarUsuario(String cedula) {

        return null;
    }

    public List<Usuario> listarUsuarios() {

        return null;
    }

    public boolean insertarPelicula(Pelicula p) {
        return false;
    }

    public boolean modificarPelicula(Pelicula p) {
        return false;
    }

    public boolean eliminarPelicula(int id) {
        try {
            consulta = conexion.prepareStatement("DELETE FROM \"Pelicula\" WHERE \""
                    + "idPelicula\"='" + id + "';");
            consulta.executeQuery();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al eliminar una Pelicula: " + ex.getMessage());
        }
        return false;
    }

    public Pelicula buscarPelicula(String nombre) {
        Pelicula p = new Pelicula();

        try {
            consulta = conexion.prepareStatement("Select * From \"Pelicula\" "
                    + "where\" nombre\"=" + nombre + "");
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                p.setIdPelicula(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setDescripcion(resultado.getString(3));

            }

            return p;
        } catch (SQLException ex) {
            System.out.println("Error de leer una Pelicula: " + ex.getMessage());
        }

        return null;
    }

    public List<Pelicula> listarPelicula() {
        List<Pelicula> lista = new ArrayList<>();

        try {
            consulta = conexion.prepareStatement("Select * from \"Pelicula\"");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                Pelicula p = new Pelicula();
                p.setIdPelicula(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setDescripcion(resultado.getString(3));

                lista.add(p);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println("Error el Listar Peliculas: " + ex.getMessage());
        }

        return null;
    }

    public boolean insertarPeliculaVista(PeliculaVista pv) {
         
        try {
            consulta = conexion.prepareStatement("INSERT INTO public.\"PeliculaVista\"(\n"
                    + "            \"idPeliculaVista\", \"idUsuario\", \"idPelicula\", \"fecha\")\n"
                    + "    VALUES (" + pv.getIdPeliculaVista() + ", '" + pv.getIdUsuario().getIdUsuario() + "', '" 
                    + pv.getIdPelicula().getIdPelicula() + "', '" + pv.getFecha() + ");");
            consulta.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar una Pelicula Vista: " + ex.getMessage());
        }
        
        return false;
    }

    public boolean modificarPeliculaVista(PeliculaVista pv) {
        
         try {
            consulta = conexion.prepareStatement("UPDATE \"PeliculaVista\" Set \"idPeliculaVista\"='" + pv.getIdPeliculaVista() + 
                    "', \"idUsuario\"='" + pv.getIdUsuario().getIdUsuario() + "', \"idPelicula\"='" + pv.getIdPelicula().getIdPelicula()
                    + "', \"fecha\"='" + pv.getFecha() + "'Where \"idPeliculaVista\"= " + pv.getIdPeliculaVista() + "");
            consulta.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error en actualizar una pelicula vista: " + ex.getMessage());
        }
         
         
        return false;
    }

    public boolean eliminarPeliculaVista(int id) {
        try {
            consulta = conexion.prepareStatement("DELETE FROM \"PeliculaVista\" WHERE \""
                    + "idPeliculaVista\"='" + id + "';");
            consulta.executeQuery();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al eliminar una Pelicula Vista: " + ex.getMessage());
        }
        return false;
    }

    public List<PeliculaVista> listarPeliculaVista() {
         List<PeliculaVista> lista = new ArrayList<>();
         /*
         Me falta aqui ver como hago para setear los Objetos Pelicula y Usuario a las variables 
         con error y les comente
         */

        try {
            consulta = conexion.prepareStatement("Select * from \"PeliculaVista\"");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                PeliculaVista pv = new PeliculaVista();
                pv.setIdPeliculaVista(resultado.getInt(1));
               /* pv.setIdUsuario(resultado.getInt(2));
                pv.setIdPelicula(resultado.getInt(3));*/
                pv.setFecha(resultado.getDate(4));
                
                lista.add(pv);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println("Error el Listar Peliculas: " + ex.getMessage());
        }

        return null;
    }

}
