package com.culqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.SecureRandom;

/**
 * Created by willyaguirre on 31/01/17.
 */

@Controller
public class Ventas {

    @Autowired
    Environment env;

    private SecureRandom secureRandom = new SecureRandom();
    private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private char[] VALID_CHARS = abc.toCharArray();

    @RequestMapping(value={"/","/index"})
    public String index(Model model) {
        model.addAttribute("titulo", "Comercios de Prueba");
        return "index";
    }

    @RequestMapping(value = "/manchego_tours")
    public String VentaComercioUno(Model model) {
        datosComercio(model, "1");
        return "demo-venta";
    }

    @RequestMapping(value = "/rudem_fitness")
    public String VentaComercioDos(Model model) {
        datosComercio(model, "2");
        return "demo-venta";
    }

    @RequestMapping(value = "/rumbos_tours")
    public String VentaComercioTres(Model model) {
        datosComercio(model, "3");
        return "demo-venta";
    }

    @RequestMapping(value = "/wolf_lubes")
    public String VentaComercioCuatro(Model model) {
        datosComercio(model, "4");
        return "demo-venta";
    }

    private void datosComercio(Model model, String numero) {
        char[] result = new char[9];

        for(int i = 0; i < 9; i++) {
            result[i] = VALID_CHARS[secureRandom.nextInt(VALID_CHARS.length)];
        }

        String nroPedido = String.valueOf(result);

        model.addAttribute("llave_secreta", env.getProperty("llaveSecreta"+numero));
        model.addAttribute("codigo_comercio",  env.getProperty("codigoComercio"+numero));
        model.addAttribute("servidorBase", env.getProperty("servidorBase"));
        model.addAttribute("nombreComercial", env.getProperty("nombreComercial"+numero));
        model.addAttribute("nroPedido", nroPedido);

    }

}
