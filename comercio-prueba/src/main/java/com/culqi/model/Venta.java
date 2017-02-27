package com.culqi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by willyaguirre on 31/01/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Venta {

    @JsonProperty
    private String token;

    @JsonProperty
    private String codigo_comercio;

    @JsonProperty
    private String moneda;

    @JsonProperty
    private String monto;

    @JsonProperty
    private String descripcion;

    @JsonProperty
    private String pedido;

    @JsonProperty
    private String codigo_pais;

    @JsonProperty
    private String ciudad;

    @JsonProperty
    private String usuario;

    @JsonProperty
    private String direccion;

    @JsonProperty
    private String telefono;

    @JsonProperty
    private String nombres;

    @JsonProperty
    private String apellidos;

    @JsonProperty
    private String correo_electronico;

    @JsonProperty
    private String llave_secreta;

    public String getToken() {
        return token;
    }

    public Venta setToken(String token) {
        this.token = token;
        return this;
    }

    public String getCodigo_comercio() {
        return codigo_comercio;
    }

    public Venta setCodigo_comercio(String codigo_comercio) {
        this.codigo_comercio = codigo_comercio;
        return this;
    }

    public String getMoneda() {
        return moneda;
    }

    public Venta setMoneda(String moneda) {
        this.moneda = moneda;
        return this;
    }

    public String getMonto() {
        return monto;
    }

    public Venta setMonto(String monto) {
        this.monto = monto;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Venta setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public String getPedido() {
        return pedido;
    }

    public Venta setPedido(String pedido) {
        this.pedido = pedido;
        return this;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public Venta setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
        return this;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Venta setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public String getUsuario() {
        return usuario;
    }

    public Venta setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Venta setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public Venta setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getNombres() {
        return nombres;
    }

    public Venta setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Venta setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public Venta setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
        return this;
    }

    public String getLlave_secreta() {
        return llave_secreta;
    }

    public Venta setLlave_secreta(String llave_secreta) {
        this.llave_secreta = llave_secreta;
        return this;
    }

    @Override
    public String toString() {
        return "VentaData{" +
                "token='" + this.token + '\'' +
                ", codigo_comercio='" + this.codigo_comercio + '\'' +
                ", moneda='" + this.moneda + '\'' +
                ", monto='" + this.monto + '\'' +
                ", descripcion='" + this.descripcion + '\'' +
                ", pedido='" + this.pedido + '\'' +
                ", codigo_pais='" + this.codigo_pais + '\'' +
                ", ciudad='" + this.ciudad + '\'' +
                ", usuario='" + this.usuario + '\'' +
                ", direccion='" + this.direccion + '\'' +
                ", telefono='" + this.telefono + '\'' +
                ", nombres='" + this.nombres + '\'' +
                ", apellidos='" + this.apellidos + '\'' +
                ", correo_electronico='" + this.correo_electronico + '\'' +
                '}';
    }

}
