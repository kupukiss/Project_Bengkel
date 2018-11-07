/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Pojos.PemilikBengkel;
import util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PemilikBengkelHelper {

    public PemilikBengkelHelper() {

    }

    public List<PemilikBengkel> getPemilikBengkel(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from PemilikBengkel";
        Query q = session.createQuery(query);
        List<PemilikBengkel> list = q.list();
        return list;
    }

}


