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
package edu.eci.pdsw.sampleprj.services.test;

import edu.eci.pdsw.sampleprj.middleware.ServicesException;
import edu.eci.pdsw.sampleprj.middleware.ServicesFacade;
import edu.eci.pdsw.stubs.servicesfacadestub.Producto;
import java.util.Arrays;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class servicesFacadeTest {
    
    ServicesFacade sf;
    
    public servicesFacadeTest() {
    }
    
    @Before
    public void setUp() {
        sf=new ServicesFacade();
    }
    private static final Logger LOG = Logger.getLogger(servicesFacadeTest.class.getName());
    
    @Test
    public void testCalculoListaCompras() throws ServicesException {
        
        Producto p1=new Producto(9999,"p1",100);
        Producto p2=new Producto(8888,"p2",200);
        Producto p3=new Producto(7777,"p3",300);
        
        sf.registrarProducto(p1);
        sf.registrarProducto(p2);
        sf.registrarProducto(p3);
        
        assertEquals("El cálculo de una lista de productos existentes no es correcto.",600,sf.calcularCostoLista(Arrays.asList(new Producto[]{p1,p2,p3})));
        
    }

    @Test
    public void testCalculoListaComprasInvalida()  {
        
        try{
            Producto p1=new Producto(2222,"p1",100);
            Producto p2=new Producto(3333,"p2",200);
            Producto p3=new Producto(4444,"p3",300);

            sf.registrarProducto(p1);
            sf.registrarProducto(p2);        
            
            sf.calcularCostoLista(Arrays.asList(new Producto[]{p1,p2,p3}));
            
            fail("La fachada de servicios calculó el total de una lista de compras"
                    + "con productos que no han sido registrados");
            
        }
        catch (ServicesException e){
            //bloque catch en el cual la prueba debería entrar
            //para no generar un fallo.
        }
        
        
        
    }

    
}
