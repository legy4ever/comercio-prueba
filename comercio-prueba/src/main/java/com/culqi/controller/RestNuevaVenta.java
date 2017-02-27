package com.culqi.controller;

import com.culqi.model.Venta;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin_InSolutions on 12/09/2016.
 */
@RestController
@RequestMapping
public class RestNuevaVenta {

    private static final Logger log = Logger.getLogger(RestNuevaVenta.class);

    @Value("${mod_pago_cargos}")
    private String URLModuloPagoCargos;

    @RequestMapping(value = "/nueva-venta", method = RequestMethod.POST)
    public ResponseEntity<String> create(@Validated @RequestBody Venta ventaData){
        RestTemplate restTemplateNuevaVenta = new RestTemplate();

        Map<String, Object> requestVenta = new HashMap<>();
        requestVenta.put("token", ventaData.getToken());
        requestVenta.put("codigoComercio", ventaData.getCodigo_comercio());
        requestVenta.put("moneda", ventaData.getMoneda());
        requestVenta.put("monto", ventaData.getMonto());
        requestVenta.put("descripcion", ventaData.getDescripcion());
        requestVenta.put("pedido", ventaData.getPedido());
        requestVenta.put("codigo_pais", ventaData.getCodigo_pais());
        requestVenta.put("ciudad", ventaData.getCiudad());
        requestVenta.put("usuario", ventaData.getUsuario());
        requestVenta.put("direccion", ventaData.getDireccion());
        requestVenta.put("telefono", ventaData.getTelefono());
        requestVenta.put("nombres", ventaData.getNombres());
        requestVenta.put("apellidos", ventaData.getApellidos());
        requestVenta.put("correo_electronico", ventaData.getCorreo_electronico());

        Gson gson = new Gson();
        String body = gson.toJson(requestVenta);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + ventaData.getLlave_secreta());

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseVenta;
        HashMap<String, Object> respuestaVenta = new HashMap<>();

        try {

            responseVenta = restTemplateNuevaVenta.exchange(URLModuloPagoCargos, HttpMethod.POST, entity, String.class);

            log.info("Respuesta de la venta: " + responseVenta.toString());

            respuestaVenta.put("respuesta", "Venta creada exitosamente.");

            ObjectMapper objectMapper = new ObjectMapper();
            String test = "";
            try {
                test = objectMapper.writeValueAsString(respuestaVenta);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return ResponseEntity.ok(test);

        } catch (HttpClientErrorException e) {

            log.info("Respuesta de la creación de la Venta: " + e.getResponseBodyAsString());

            respuestaVenta.put("error", "Error al crear una venta.");

            ObjectMapper objectMapper = new ObjectMapper();
            String test = "";
            try {
                test = objectMapper.writeValueAsString(respuestaVenta);
            } catch (JsonProcessingException x) {
                x.printStackTrace();
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(test);

        }

    }
}
