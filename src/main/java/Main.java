
import org.apache.commons.lang3.StringUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author links
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(StringUtils.leftPad("2811", 8));
        System.out.println(StringUtils.leftPad("2811", 8, "0"));
    }
    
}
