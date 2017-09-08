/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import netgloo.models.Campaña;
import netgloo.models.CampañaDao;
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
public class GreetingController {

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
    @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
    public Campaña getUser(@PathVariable("email") String email) throws IndexOutOfBoundsException {
        Campaña campaña = new Campaña();
        try {
            List<Campaña> listCampaña = new ArrayList<Campaña>();
            listCampaña = campañaDao.getById(email);
            campaña = listCampaña.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return campaña;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createCampana(@RequestParam("id") String id,
            @RequestParam("name") String name, @RequestParam("value") int value) {
        try {
            Campaña campaña = new Campaña(id, name, value);
            campañaDao.create(campaña);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Campana succesfully created!";
    }

    // Metodo para obtner la campaña segun el email
    //localhost:8080/user/12
    @RequestMapping(value = "/campana/{id}", method = RequestMethod.GET)
    public Campaña getCampana(@PathVariable("id") String id) throws IndexOutOfBoundsException {
        Campaña campaña = new Campaña();
        try {
            List<Campaña> listCampaña = new ArrayList<Campaña>();
            listCampaña = campañaDao.getById(id);
            campaña = listCampaña.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return campaña;
    }

    // Metodo para eliminar la campaña
    //localhost:8080/user/12
    @RequestMapping(value = "/campana/{id}", method = RequestMethod.DELETE)
    public String deleteCampana(@PathVariable("id") String id) throws IndexOutOfBoundsException {
        try {
            Campaña campaña = new Campaña(id);
            campañaDao.delete(campaña);

        } catch (Exception e) {
            e.printStackTrace();
            return "No existe una campaña con el id referenciado";
        }
        return "Se elimino la campana correctamente";
    }

}
