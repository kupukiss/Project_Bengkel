/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.PemilikBengkelHelper;
import helper.PemilikKendaraanHelper;
import java.util.List;
import pojos.PemilikBengkel;
import pojos.PemilikKendaraan;

/**
 *
 * @author Acer
 */
public class testPemilikKendaraan {

    public static void main(String[] args) {
        PemilikKendaraanHelper helper = new PemilikKendaraanHelper();
        List<PemilikKendaraan> list = helper.getPemilikKendaraan();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNama());
            System.out.println(list.get(i).getEmail());
        }
    }
}
