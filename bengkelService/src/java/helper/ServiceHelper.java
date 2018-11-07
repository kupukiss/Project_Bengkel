/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Pojos.Service;
import util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ServiceHelper {

    public ServiceHelper() {

    }

    public List<Service> getService(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Service";
        Query q = session.createQuery(query);
        List<Service> list = q.list();
        return list;
    }

}


