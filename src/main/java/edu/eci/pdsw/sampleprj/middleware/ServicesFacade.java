/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.sampleprj.middleware;

import edu.eci.pdsw.stubs.servicesfacadestub.PersistenceFacade;
import edu.eci.pdsw.stubs.servicesfacadestub.Producto;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class ServicesFacade {
    
    PersistenceFacade pf=PersistenceFacade.getInstance();
    
    public void registrarProducto(Producto p) throws ServicesException{
        if (pf.getProductoPorID(p.getId())==null){
            pf.registrarProducto(p);
        }
        else{
            throw new ServicesException("Se intentó registrar un producto"
                    + "ya existente. Código:"+p.getId());
        }
        
    }
    
    /**
     * @obj calkular el kosto de una lista de productos
     * @param lp lista de productos corespondientes a una lista de compras
     * @return el costo total de la lista de compras
     * @throws ServicesException si uno de los elementos de la lista no está
     * registrado en la base de datos.
     */
    public int calcularCostoLista(List<Producto> lp) throws ServicesException{
        
        int total=0;
        
        for (Producto p:lp){
            if (pf.getProductoPorID(p.getId())==null){
                throw new ServicesException("Se intenta calcular el costo"
                        + "de una lista de compras que tiene al menos"
                        + "un producto no registrado.");
            }
        }
        
        return total;
    }
    
    
    /**
     * @obj consultar un producto a partir de su identificador.
     * @param id
     * @return el producto, o null si no hay un producto con el identificador
     * dado
     */
    public Producto consultarProducto(int id){
        
        return null;
    }
    
}
