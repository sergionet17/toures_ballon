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
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/test")
    public Greeting greeting_test(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/lista")
    public List<Greeting> greeting_test() {
        List<Greeting> lista =  new ArrayList<Greeting>();
        Greeting greeting = new Greeting(0, "test_lista");
        Greeting greeting_2 = new Greeting(1, "este es un test de git");
        lista.add(greeting_2);
        lista.add(greeting);
        return lista;
    }
   
  @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      Campaña campaña = campañaDao.getByEmail(email);
      userId = String.valueOf(campaña.getId());
    }
    catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }
  
  @RequestMapping(value="/create")
  @ResponseBody
  public String create(String email, String name) {
    try {
      Campaña campaña = new Campaña("test", "test");
      campañaDao.create(campaña);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created!";
  }
    
}
