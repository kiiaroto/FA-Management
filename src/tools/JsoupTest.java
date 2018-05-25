/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controller.Program;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Status;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author SR
 */
public class JsoupTest {

    public void test() {
        try {

            Document doc = Jsoup.connect("https://fr.finalfantasyxiv.com/lodestone/character/17826939/").get();
            System.out.println(doc.title());
            Elements name = doc.select(".frame__chara__name");
            System.out.println("name: " + name.text());
            Elements pic = doc.select(".character__detail__image > a > img");
            System.out.println(pic.attr("src"));
            System.out.println();

        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
