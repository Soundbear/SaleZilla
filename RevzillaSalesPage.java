/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salezilla;

import java.util.ArrayList;
import java.io.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.*;
import java.time.LocalDate;

/**
 *
 * @author ADJones
 */

public class RevzillaSalesPage {
	
    public String strSaleURL = "";
    public Document doc = new Document("");

    public RevzillaSalesPage(){
        strSaleURL =  "https://revzilla.com/";
        LocalDate date = LocalDate.now();
        strSaleURL += date.getMonth().toString().toLowerCase();
        strSaleURL += Integer.toString(date.getYear()).substring(2, 4);
        
    }
    public String getPage(){
        return strSaleURL;
    }
    
    public void setPage(String inputMonth, int Year){
	strSaleURL = "https://revzilla.com/";
        strSaleURL += inputMonth.toLowerCase() + Integer.toString(Year).substring(2, 4);
        //System.out.println(strSaleURL);
    }
    
    
    
    public void jsoupConnect(){
        try {
            doc = Jsoup.connect(strSaleURL).get();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public void listProducts(){
        String strTitle = "";
        ArrayList arrProduct = new ArrayList();
        strTitle = doc.title();
        Elements links = doc.body().getElementsByAttributeValueContaining("id", "list_item_");
        for (int i = 0; i<links.size(); i++){
            Element link = links.get(i);
            Element elementName = link.select("[itemprop=name]").first();
            arrProduct.add(elementName.attr("Content"));
        }
        for(Object s:arrProduct){
            System.out.println(s);
        }
    }
    
}
