/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.fachadadenegocio;

import ec.edu.ups.entidades.PeliculaVista;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.objetonegocio.GestionPeliculaVista;
import ec.edu.ups.objetonegocio.GestionUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class FachadaPeliculaVista {

    private GestionUsuario gestionUsuario;
    private GestionPeliculaVista gestionPeliculaVista;

    public FachadaPeliculaVista() {
        gestionUsuario = new GestionUsuario();
        gestionPeliculaVista = new GestionPeliculaVista();

    }

    public List<PeliculaVista> getPeliculasVistaUsuario(String cedula) {

        List<PeliculaVista> peliculaVistas = gestionPeliculaVista.getTodasPeliculasVista();

        List<PeliculaVista> peliculasVistasUsuario = new ArrayList<>();

        for (PeliculaVista pv : peliculaVistas) {
            if (pv.getIdUsuario().getCedula().equals(cedula)) {
                peliculasVistasUsuario.add(pv);
            }
        }
        
        return peliculaVistas;
    }
}
