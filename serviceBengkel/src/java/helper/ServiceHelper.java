/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Service;

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
   public static String toJson() {
        ServiceHelper helper = new ServiceHelper();
        List<Service> list = helper.getService();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                result = result + list.get(i).toJson() + ",\n";
            } else {
                result = result + list.get(i).toJson() + "\n";
            }
        }
        result = result + "]";
        return result;
    }
}


