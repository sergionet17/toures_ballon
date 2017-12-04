package com.hellokoding.springboot;

import com.free.client.soap.QuoteClient;
import com.free.client.soap.QuoteConfiguration;
import com.free.client.soap.RankingCliente;
import com.free.client.soap.RankingConfiguracion;
import hello.wsdl.BuscarProductosResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.JAXBElement;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spring.free.pojo.Car;
import spring.free.pojo.Producto;
import spring.free.pojo.Usuario;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    private static List<Car> carList = new ArrayList<Car>();
    private static List<Usuario> userList = new ArrayList<Usuario>();
    private List<Producto> productoList;
    Producto productoRes = new Producto();

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/cars";
    }

    static {
        carList.add(new Car("Honda", "Civic"));
        carList.add(new Car("Toyota", "Camry"));
        carList.add(new Car("Nissan", "Altima"));
        userList.add(new Usuario("Camilo", "Villegas"));
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

        QuoteConfiguration configuration = new QuoteConfiguration();
        Jaxb2Marshaller jaxb2Marshaller = configuration.marshaller();
        QuoteClient client = configuration.quoteClient(jaxb2Marshaller);

//        BuscarProductosResponse buscarProductosResponse = client.getProducto("1");

       // String ciudad = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
       //         .get(0).getCiudad().getValue();

       // Producto producto_4 = new Producto();
       // producto_4.setId(ciudad);
       // producto_4.setNombre(ciudad);
       // productolts.add(producto_4);

        return "producto";
    }

    @RequestMapping(value = "/addProducto", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("cProducto") Producto producto) {
        // if (null != producto && null != producto.getId() && null != producto.getId() 
        //         && !producto.getNombre().isEmpty() && !producto.getId().isEmpty()) {

        // }
        productoList = new ArrayList<Producto>();
        QuoteConfiguration configuration = new QuoteConfiguration();
        Jaxb2Marshaller jaxb2Marshaller = configuration.marshaller();
        QuoteClient client = configuration.quoteClient(jaxb2Marshaller);

        BuscarProductosResponse buscarProductosResponse = client.getProducto(producto.getCodigo(),producto.getDescripcion());

        String ciudad = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getCiudad().getValue();
        
        int cantidad = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getCantidad();
        
        int codigoProducto = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getCodigoProducto();
        String descripcion = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getDescripcion().getValue();
        String fechaFin = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getFechaFinEvento().getValue();
        String fechaIni = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getFechaInicioEvento().getValue();
       String precio = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getPrecio().getValue();
        int proveedorHotele = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getProveedorHoteleria();
        int proveedorTrans = buscarProductosResponse.getBuscarProductosResult().getValue().getProducto()
                .get(0).getProveedorTransporte();
        
        productoRes.setNombre(ciudad);        
        productoRes.setCantidad(cantidad);
        productoRes.setCodigo(ciudad);
        productoRes.setCodigoProducto(codigoProducto);
        productoRes.setDescripcion(descripcion);
        productoRes.setFechaFin(fechaFin);
        productoRes.setFechaIni(fechaIni);
        productoRes.setPrecio(precio);
        productoRes.setProveedorHotele(proveedorHotele);
        productoRes.setProveedorTrans(proveedorTrans);

        productoList.add(productoRes);

        return "redirect:/consultarProductoResult";
    }

    @RequestMapping(value = "/consultarProducto", method = RequestMethod.GET)
    public String getProducto(@ModelAttribute("cProducto") Producto producto) {

        return "consultarProducto";
    }

    @RequestMapping(value = "/consultarProductoResult", method = RequestMethod.GET)
    public String getProductoLista(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("productoList", productoList);
        return "consultarProductoResult";
    }
    
    
    public static final String uploadingdir = System.getProperty("user.dir") + "/uploadingdir/";

    @RequestMapping("/")
    public String uploading(Model model) {
        File file = new File(uploadingdir);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File(uploadingdir + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }

        return "redirect:/";
    }
    
    @RequestMapping(value = "/consultarRanking", method = RequestMethod.GET)
    public String consultarRanking(@ModelAttribute("cProducto") Producto producto) {
        RankingConfiguracion configuration = new RankingConfiguracion();
        Jaxb2Marshaller jaxb2Marshaller = configuration.marshaller();
        RankingCliente client = configuration.quoteClient(jaxb2Marshaller);
        client.ranking("");
        return "consultarProducto";
    }

}
