/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.PemilikBengkelHelper;
import java.util.List;
import pojos.PemilikBengkel;

/**
 *
 * @author Acer
 */
public class testPemilikBengkel {

    public static void main(String[] args) {
        PemilikBengkelHelper helper = new PemilikBengkelHelper();
        List<PemilikBengkel> list = helper.getPemilikBengkel();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNama());
            System.out.println(list.get(i).getEmail());
            System.out.println(list.get(i).getPassword());
            System.out.println(list.get(i).getAlamat());
        }
    }
}
