/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa06_bien;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Itzel
 */
public class Programa06_Bien {

    public static void main(String[] args) {
        
        DAOVenta dao = new DAOVenta();
        Venta venta = new Venta();
        
        Date fecha = Date.from(Instant.now());
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        venta.setFecha(fechaSQL);
//        venta.setFecha(new java.sql.Date(fecha.getTime()));
        
        DetalleVenta dv = new DetalleVenta();
        dv.setCantidad(10);
        dv.setPrecio(20);
        dv.setSubtotal(10*20);
        dv.setVenta(venta);
        venta.getDetalleVenta().add(dv);
        
        DetalleVenta dv2 = new DetalleVenta();
        dv2.setCantidad(3);
        dv2.setPrecio(10);
        dv2.setSubtotal(3*10);
        dv2.setVenta(venta);
        venta.getDetalleVenta().add(dv2);
        
        venta.setMonto(30+200);
        dao.create(venta);
        
    }
}
