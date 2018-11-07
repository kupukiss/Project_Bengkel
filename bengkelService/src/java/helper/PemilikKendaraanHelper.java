/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Pojos.PemilikKendaraan;
import util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PemilikKendaraanHelper {

    public PemilikKendaraanHelper() {

    }

    public List<PemilikKendaraan> getPemilikKendaraan(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from PemilikKendaraan";
        Query q = session.createQuery(query);
        List<PemilikKendaraan> list = q.list();
        return list;
    }

}


