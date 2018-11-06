/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Pojos.Service;
import helper.ServiceHelper;
import java.util.List;

public class TestService {
    public static void main(String[] args) {
        ServiceHelper helper = new ServiceHelper();
        List<Service> list = helper.getService();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNoAntrian());
        }
    }
}
