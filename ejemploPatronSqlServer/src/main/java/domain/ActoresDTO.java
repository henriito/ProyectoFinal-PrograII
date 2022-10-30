package domain;

//DTO: Data Transfer Object
//Los DTO son un tipo de objetos que sirven únicamente para transportar datos. 
//EL DTO contiene las propiedades del objeto. 
//Datos que pueden tener su origen en una o más entidades de información. 
//Estos datos son incorporados a una instancia de un JavaBean.

//El patrón DTO tiene como finalidad de crear un objeto plano (POJO) 
//con una serie de atributos que puedan ser enviados o recuperados del servidor en una 
//sola invocación, de tal forma que un DTO puede contener información de múltiples fuentes 
//o tablas y concentrarlas en una única clase simple

public class ActoresDTO {
    
    private int id_actor;
    private String nombre;
    private String apellido;
    private int edad;

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
    @Override
    public String toString() {
        return "ActoresDTO{" + "id_actor=" + id_actor + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }
    
    
}
