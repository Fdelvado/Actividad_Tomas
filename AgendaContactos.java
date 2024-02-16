package modelo.javabean;

import java.util.ArrayList;

public class AgendaContactos {
    private String nombreAgenda;
    private ArrayList<Contacto> contactos;

    public AgendaContactos(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
        this.contactos = new ArrayList<>();
    }

    public boolean agregarContacto(Contacto contacto) {
        if (buscarContacto(contacto.getNombre()) != null) {
            System.out.println("Ya existe un contacto con ese nombre.");
            return false;
        }
        contactos.add(contacto);
        return true;
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    
    public String getNombreAgenda() {
        return nombreAgenda;
    }

    public void setNombreAgenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
    }
}

