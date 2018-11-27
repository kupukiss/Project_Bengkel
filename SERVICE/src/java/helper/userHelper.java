/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Location;
import pojos.User;
import util.NewHibernateUtil;

/**
 *
 * @author Acer
 */
public class userHelper {

    public userHelper() {
    }

    public List<User> getUser() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from User";
        Query q = session.createQuery(query);
        List<User> list = q.list();
        return list;
    }

    public static String toJson() {
        userHelper helper = new userHelper();
        List<User> list = helper.getUser();
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
