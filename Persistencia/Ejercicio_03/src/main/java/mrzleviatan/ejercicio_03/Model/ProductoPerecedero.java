package mrzleviatan.ejercicio_03.Model;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto{

   private LocalDate fechaVencimiento;


   public ProductoPerecedero (){    }



    public ProductoPerecedero(String nombre, int codigo, String descripcion, Double valorMonetario, int cantidad, LocalDate fechaVencimiento) {
        super(nombre, codigo, descripcion, valorMonetario, cantidad);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
