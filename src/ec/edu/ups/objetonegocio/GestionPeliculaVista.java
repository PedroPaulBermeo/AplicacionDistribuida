/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetonegocio;

import ec.edu.ups.entidades.PeliculaVista;
import ec.edu.ups.objetoaccesodatos.OAD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class GestionPeliculaVista {

    private OAD oad;

    public GestionPeliculaVista() {
        oad = new OAD();
    }

    public boolean agregarPeliculaVista(List<String> peliculaVista) {

        return false;
    }

    public boolean modificarPeliculaVista(List<String> peliculaVista) {

        return false;
    }

    public boolean eliminarPeliculaVista(int idPeliculaVista) {
         if(oad.obtenerConexion()){
             oad.eliminarPeliculaVista(idPeliculaVista);
             oad.cerrarConexion();
             return true;
         }
        
        return false;
    }

    public List<PeliculaVista> getTodasPeliculasVista() {
        if(oad.obtenerConexion()){
            List<PeliculaVista>peliculaVistas = new ArrayList<>();
            
             peliculaVistas=oad.listarPeliculaVista();
             oad.cerrarConexion();
             return peliculaVistas;
         }
        
        return null;
    }

    public PeliculaVista convertirObjetoPV(List<String> peliculaVista) {
        if (oad.obtenerConexion()) {
            PeliculaVista pv = new PeliculaVista();
            pv.setIdPeliculaVista(Integer.parseInt(peliculaVista.get(0)));
            pv.setIdUsuario(oad.buscarUsuario(peliculaVista.get(1)));
            pv.setIdPelicula(oad.buscarPelicula(peliculaVista.get(2)));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                pv.setFecha(formato.parse(peliculaVista.get(3)));
            } catch (ParseException ex) {
                System.out.println("No se puede transformar" + ex.getMessage());
            }
            oad.cerrarConexion();
            return pv;

        }
        return null;
    }
}
