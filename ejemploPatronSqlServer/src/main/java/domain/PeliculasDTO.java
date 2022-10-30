/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Windows 10
 */
public class PeliculasDTO {
     private int id_pelicula;
    private String titulo;
    private int estreno;
    private String genero;
    private float valoracion;

    /**
     * @return the id_pelicula
     */
    public int getId_pelicula() {
        return id_pelicula;
    }

    /**
     * @param id_pelicula the id_pelicula to set
     */
    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the estreno
     */
    public int getEstreno() {
        return estreno;
    }

    /**
     * @param estreno the estreno to set
     */
    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the valoracion
     */
    public float getValoracion() {
        return valoracion;
    }

    /**
     * @param valoracion the valoracion to set
     */
    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
    
    @Override
    public String toString() {
        return "PeliculasDTO{" + "id_pelicula=" + id_pelicula + ", titulo=" + titulo + ", genero=" + genero + ", valoracion=" + valoracion + '}';
    }
}
