/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salezilla;

/**
 *
 * @author ADJones
 */
public class SaleZillaMain {

    public static void main(String[] args) {
        // TODO code application logic here
        RevzillaSalesPage page = new RevzillaSalesPage();
        page.setPage("MARCH", 2017);
        System.out.println(page.getPage());
        page.jsoupConnect();
        page.listProducts();
    }
    
}

