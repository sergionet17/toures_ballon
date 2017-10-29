/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.utils;

/**
 *
 * @author sergio
 */
public class Util {

    public static String numerToState(String valor) {
        String estado = "";

        if (valor.equals("1") ) {
            estado = "En Validacion";
        } else if (valor.equals("2")) {
            estado = "En Reservacion";
        } else if (valor.equals("3")) {
            estado = "Cerrada";
        } else if (valor.equals("4")) {
            estado = "En Validacion";
        } else if (valor.equals("5")) {
            estado = "Cancelada";
        } 
        return estado;
    }

}
