package com.example.mvp.Presentador;

import com.example.mvp.Modelo.ProductoModelo;

import java.util.ArrayList;

public class ProductoPresentador {

    // almacenando todos los arraylist de lo que ocupare sobre el presentador :p
    private ProductoModelo productoModelo;
    private View view;

    ArrayList<String> proveedores = new ArrayList<>();
    ArrayList<Integer> status = new ArrayList<>();
    ArrayList<String> folios = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> precios = new ArrayList<>();
    ArrayList<String> descripciones = new ArrayList<>();
    ArrayList<String> tipoProductos = new ArrayList<>();

    public ProductoPresentador(View view) {
        this.view = view;
        this.productoModelo = new ProductoModelo();
    }

    public void setDataToken(String Token){
        productoModelo.setToken(Token);
        view.sendDataToken(Token);
    }

    public interface View {
        void sendDataToken(String Token);
    }

    public void showDatas(){
        productoModelo.getData();
    }

    public ArrayList<Integer> getIds() {
        ids = productoModelo.getIds();
        return ids;
    }

    public ArrayList<String> getNombres() {
        nombres = productoModelo.getNames();
        return nombres;
    }

    public ArrayList<String> getPrecios() {
        precios = productoModelo.getPrecios();
        return precios;
    }

    public ArrayList<String> getDescripciones() {
        descripciones = productoModelo.getDescripciones();
        return descripciones;
    }

    public ArrayList<String> getTipoProductos() {
        tipoProductos = productoModelo.getTipoProductos();
        return tipoProductos;
    }

    public ArrayList<String> getProveedores() {
        proveedores = productoModelo.getProveedores();
        return proveedores;
    }

    public ArrayList<Integer> getStatuses() {
        status = productoModelo.getStatuses();
        return status;
    }

    public ArrayList<String> getFolios() {
        folios = productoModelo.getFolios();
        return folios;
    }
}
