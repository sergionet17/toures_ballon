package com.hellokoding.springboot;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.free.pojo.Car;
import spring.free.pojo.Producto;
import spring.free.pojo.Usuario;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    
        private static List<Car> carList = new ArrayList<Car>();
        private static List<Usuario> userList = new ArrayList<Usuario>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/cars";
    }

    static {
        carList.add(new Car("Honda", "Civic"));
        carList.add(new Car("Toyota", "Camry"));
        carList.add(new Car("Nissan", "Altima"));
        userList.add(new Usuario("Camilo","Villegas"));
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("carList", carList);
        return "hello";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String initUser(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("userList", userList);
        return "user";
    }
    
    @RequestMapping(value = "/crearProducto", method = RequestMethod.GET)
    public String crearProducto(@ModelAttribute("model") ModelMap model) {
        List<Producto> productolts = new ArrayList<Producto>();
        String varString = "test";
        Producto producto = new Producto();
        producto.setId("12");
        producto.setNombre("12");
        productolts.add(producto);
        
        Producto producto_2 = new Producto();
        producto_2.setId("12");
        producto_2.setNombre("12");
        productolts.add(producto);
        
        Producto producto_3 = new Producto();
        producto_3.setId("12");
        producto_3.setNombre("12");
        productolts.add(producto);
        
        model.addAttribute("productolts", productolts);
        model.addAttribute("varString", varString);
        return "producto";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") Car car) {
        if (null != car && null != car.getMake() && null != car.getModel() && !car.getMake().isEmpty() && !car.getModel().isEmpty()) {
            carList.add(car);
        }
        return "redirect:/cars";
    }
}
