/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.entidades;

import java.util.Date;

/**
 *
 * @author Pedro Bermeo
 */
public class PeliculaVista {
    private int idPeliculaVista;
    private Usuario idUsuario;
    private Pelicula  idPelicula;
    private Date fecha;

    public PeliculaVista() {
    }

    public int getIdPeliculaVista() {
        return idPeliculaVista;
    }

    public void setIdPeliculaVista(int idPeliculaVista) {
        this.idPeliculaVista = idPeliculaVista;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "PeliculaVista{" + "idPeliculaVista=" + idPeliculaVista + ", idUsuario=" + idUsuario + ", idPelicula=" + idPelicula + ", fecha=" + fecha + '}';
    }
        
}
