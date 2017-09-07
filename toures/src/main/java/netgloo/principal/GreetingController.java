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

    @RequestMapping("/test")
    public Greeting greeting_test(@RequestParam(value = "name", defaultValue = "World") String name) {
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

    /*
  @RequestMapping(value="/get-by-email",method = RequestMethod.GET)
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
//      Campaña campaña = campañaDao.getByEmail(email);
 //     userId = String.valueOf(campaña.getEmail());
    }
    catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }*/
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam("email") String email, @RequestParam("name") String name) {
        try {
            Campaña campaña = new Campaña(email, name);
            campañaDao.create(campaña);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created!";
    }

    @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
    public Campaña getUser(@PathVariable("email") String email) throws IndexOutOfBoundsException {
        Campaña campaña = new Campaña();
        try {
            List<Campaña> listCampaña = new ArrayList<Campaña>();
            listCampaña = campañaDao.getByEmail(email);
            campaña = listCampaña.get(0);

        } catch (Exception e) {
            e.printStackTrace();            
        }
        return campaña;
    }

}
