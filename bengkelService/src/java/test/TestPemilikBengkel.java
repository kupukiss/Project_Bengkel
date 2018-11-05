/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import Pojos.PemilikBengkel;
import helper.PemilikBengkelHelper;
import java.util.List;

public class TestPemilikBengkel {
    public static void main(String[] args) {
        PemilikBengkelHelper helper = new PemilikBengkelHelper();
        List<PemilikBengkel> list = helper.getPemilikBengkel();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getEmail());
            System.out.println(list.get(i).getPassword());
            System.out.println(list.get(i).getNamaBengkel());
            System.out.println(list.get(i).getAlamat());
            System.out.println(list.get(i).getJamBuka());
            System.out.println(list.get(i).getJenisKendaraan());
            System.out.println(list.get(i).getLongitud());
            System.out.println(list.get(i).getLatitude());
            System.out.println(list.get(i).getJamTutup());
        }
    }
}
