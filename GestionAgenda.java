package modelo.javabean;

import java.util.ArrayList;

public class GestionAgenda {
    private AgendaContactos agenda;

    public GestionAgenda(String nombreAgenda) {
        this.agenda = new AgendaContactos(nombreAgenda);
    }

    public boolean altaContacto(Contacto contacto) {
        return agenda.agregarContacto(contacto);
    }

    public boolean eliminarContacto(Contacto contacto) {
        return agenda.getContactos().remove(contacto);
    }

    public Contacto buscarUno(String nombre) {
        for (Contacto c : agenda.getContactos()) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Contacto> buscarContactosPorTresPrimeros(String nombre) {
        ArrayList<Contacto> contactosEncontrados = new ArrayList<>();
        if (nombre.length() >= 3) {
            String tresPrimeros = nombre.substring(0, 3);
            for (Contacto c : agenda.getContactos()) {
                if (c.getNombre().startsWith(tresPrimeros)) {
                    contactosEncontrados.add(c);
                }
            }
        }
        return contactosEncontrados;
    }

    public boolean cambiarDatos(Contacto contacto) {
        for (Contacto c : agenda.getContactos()) {
            if (c.getNombre().equals(contacto.getNombre())) {
                if (!c.equals(contacto)) {
                    c.setApellidos(contacto.getApellidos());
                    c.setTelefono(contacto.getTelefono());
                    c.setEmpresa(contacto.getEmpresa());
                    c.setEmail(contacto.getEmail());
                    return true;
                } else {
                    System.out.println("Los datos del contacto son iguales.");
                    return false;
                }
            }
        }
        System.out.println("El contacto no existe en la agenda.");
        return false;
    }

    public ArrayList<Contacto> contactosPorEmpresa(String empresa) {
        ArrayList<Contacto> contactosEmpresa = new ArrayList<>();
        for (Contacto c : agenda.getContactos()) {
            if (c.getEmpresa().equals(empresa)) {
                contactosEmpresa.add(c);
            }
        }
        return contactosEmpresa;
    }
    
    // Ejecutable
    
    public static void main(String[] args) {
        GestionAgenda agenda = new GestionAgenda("Mi Agenda");

        Contacto contacto1 = new Contacto("Pepe", "García", "123456789", "Empresa A", "pepe@email.com");
        Contacto contacto2 = new Contacto("Marta", "López", "987654321", "Empresa B", "marta@email.com");

        agenda.altaContacto(contacto1);
        agenda.altaContacto(contacto2);

        Contacto contactoEncontrado = agenda.buscarUno("Juan");
        if (contactoEncontrado != null) {
            System.out.println("Contacto encontrado: " + contactoEncontrado.getNombre());
        } else {
            System.out.println("El contacto no está en la agenda.");
        }

        ArrayList<Contacto> contactosPorEmpresa = agenda.contactosPorEmpresa("Empresa B");
        System.out.println("Contactos de la empresa B:");
        for (Contacto c : contactosPorEmpresa) {
            System.out.println(c.getNombre());
        }

        ArrayList<Contacto> contactosPorTresPrimeros = agenda.buscarContactosPorTresPrimeros("Mar");
        System.out.println("Contactos cuyos nombres empiezan por 'Mar':");
        for (Contacto c : contactosPorTresPrimeros) {
            System.out.println(c.getNombre());
        }

        Contacto nuevoDatosContacto = new Contacto("Pepe", "Pérez", "111111111", "Empresa A", "pepote@email.com");
        if (agenda.cambiarDatos(nuevoDatosContacto)) {
            System.out.println("Datos del contacto cambiados con éxito:");
            System.out.println("Nombre: " + nuevoDatosContacto.getNombre());
            System.out.println("Apellidos: " + nuevoDatosContacto.getApellidos());
            System.out.println("Teléfono: " + nuevoDatosContacto.getTelefono());
            System.out.println("Empresa: " + nuevoDatosContacto.getEmpresa());
            System.out.println("Email: " + nuevoDatosContacto.getEmail());
        } else {
            System.out.println("No se pudo cambiar los datos del contacto.");
        }
    }
}
