/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import netgloo.models.Biblioteca;
import netgloo.models.Campaña;
import netgloo.models.CampañaDao;
import netgloo.models.Libro;
import netgloo.models.User;
import netgloo.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampanaController {

    //injection del DAO
    @Autowired
    private CampañaDao campañaDao;
    @Autowired
    private UserDao userDao;
    private static final String template = "Hola_espanol, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public List<Greeting> greeting_test() {
        List<Greeting> lista = new ArrayList<Greeting>();
        Greeting greeting = new Greeting(0, "test_lista");
        Greeting greeting_2 = new Greeting(1, "este es un test de git");
        lista.add(greeting_2);
        lista.add(greeting);
        return lista;
    }

    // Metodo para obtner la campaña segun el email
    //localhost:8080/user/12
    @RequestMapping(value = "/campaniaConsulta/{idCampania}", method = RequestMethod.GET)
    public Campaña getUser(@PathVariable("idCampania") int idCampania) throws IndexOutOfBoundsException {
        Campaña campaña = new Campaña();
        try {
            List<Campaña> listCampaña = new ArrayList<Campaña>();
            listCampaña = campañaDao.getById(idCampania);
            campaña = listCampaña.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return campaña;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createCampana(@RequestParam("codigo_campana") int codigo_campana,
            @RequestParam("nombre_campana") String nombre_campana, @RequestParam("codigo_producto") int codigo_producto ,
            @RequestParam("fecha_inicio") String fecha_inicio,@RequestParam("fecha_fin") String fecha_fin,
            @RequestParam("estado") String estado,@RequestParam("cantidad") String cantidad,@RequestParam("precio") String precio) {
        try {
            Campaña campaña = new Campaña(codigo_campana, nombre_campana, codigo_producto,fecha_inicio,fecha_fin,
            estado,cantidad,precio);
            campañaDao.create(campaña);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Campana succesfully created!";
    }

    // Metodo para obtner la campaña segun el email
    //localhost:8080/user/12
    @RequestMapping(value = "/campana/{codigo_campana}", method = RequestMethod.GET)
    public Campaña getCampana(@PathVariable("codigo_campana") int codigo_campana) throws IndexOutOfBoundsException {
        Campaña campaña = new Campaña();
        try {
            List<Campaña> listCampaña = new ArrayList<Campaña>();
            listCampaña = campañaDao.getByCodigoCampana(codigo_campana);
            campaña = listCampaña.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return campaña;
    }

    // Metodo para eliminar la campaña
    //localhost:8080/user/12
    @RequestMapping(value = "/campana/{codigo_campana}", method = RequestMethod.DELETE)
    public String deleteCampana(@PathVariable("codigo_campana") int codigo_campana) throws IndexOutOfBoundsException {
        try {
            Campaña campaña = new Campaña(codigo_campana);
            campañaDao.delete(campaña);

        } catch (Exception e) {
            e.printStackTrace();
            return "No existe una campaña con el id referenciado";
        }
        return "Se elimino la campana correctamente";
    }
    
@RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateCampana(@RequestParam("codigo_campana") int codigo_campana,
            @RequestParam("nombre_campana") String nombre_campana, @RequestParam("codigo_producto") int codigo_producto ,
            @RequestParam("fecha_inicio") String fecha_inicio,@RequestParam("fecha_fin") String fecha_fin,
            @RequestParam("estado") String estado,@RequestParam("cantidad") String cantidad,@RequestParam("precio") String precio) {
        try {
            Campaña campaña = new Campaña(codigo_campana, nombre_campana, codigo_producto,fecha_inicio,fecha_fin,
            estado,cantidad,precio);
            campañaDao.update(campaña);

        } catch (Exception e) {
            e.printStackTrace();
            return "No existe una campaña con el id referenciado";
        }
        return "Se actualizo la campaña";
    }
    
    
     // Metodo para eliminar la campaña
    //localhost:8080/user/12
    @RequestMapping(value = "/libro", method = RequestMethod.POST)
    public String createLibro()throws IndexOutOfBoundsException {
        try {
            Libro libro = new Libro();
            libro.setId_libro(2);
            libro.setNombre("este");
            campañaDao.createLibro(libro);

        } catch (Exception e) {
            e.printStackTrace();
            return "No existe una campaña con el id referenciado";
        }
        return "Se elimino la campana correctamente";
    }
    
        // Metodo para eliminar la campaña
    //localhost:8080/user/12
    @RequestMapping(value = "/biblioteca", method = RequestMethod.POST)
    public String createBiblioteca()throws IndexOutOfBoundsException {
        try {
            Libro libro = new Libro();
            libro.setId_libro(2);
            libro.setNombre("este");
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setId_biblioteca(2);
            biblioteca.setLibro(libro);
            biblioteca.setNombre("central");
            campañaDao.createBilblioteca(biblioteca);

        } catch (Exception e) {
            e.printStackTrace();
            return "No existe una campaña con el id referenciado";
        }
        return "Se elimino la campana correctamente";
    }

}
