package com.example.tsdmhp3p1fggv;

import android.os.Parcel;
import android.os.Parcelable;

public class Datos implements Parcelable {
    private String nombre;
    private String edad;
    private String correo;
    private String sexo;
    private String telefono;

    public Datos(String nombre, String edad, String correo, String sexo, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    protected Datos(Parcel in) {
        nombre = in.readString();
        edad = in.readString();
        correo = in.readString();
        sexo = in.readString();
        telefono = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(nombre);
        parcel.writeString(edad);
        parcel.writeString(correo);
        parcel.writeString(sexo);
        parcel.writeString(telefono);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Datos> CREATOR = new Creator<Datos>() {
        @Override
        public Datos createFromParcel(Parcel in) {
            return new Datos(in);
        }

        @Override
        public Datos[] newArray(int size) {
            return new Datos[size];
        }
    };

    // Getters para acceder a los datos
    public String getNombre() { return nombre; }
    public String getEdad() { return edad; }
    public String getCorreo() { return correo; }
    public String getSexo() { return sexo; }
    public String getTelefono() { return telefono; }
}