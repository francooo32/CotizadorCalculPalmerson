package com.palmerson.cotizador.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Document(indexName = "stock")
@Setting(settingPath = "static/es-settings.json")
public class Stock {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    
    @Field(type = FieldType.Text)
    private String modelo;
    
    @Field(type = FieldType.Integer)
    private int precio;
    
    @Field(type = FieldType.Text)
    private String color;
    
    @Field(type = FieldType.Integer)
    private int kilometraje;

    public Stock(String id, String modelo, int precio, String color, int kilometraje) {
        this.id = id;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
        this.kilometraje = kilometraje;
    }
    

    public Stock() {
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getKilometraje() {
		return kilometraje;
	}


	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

}

