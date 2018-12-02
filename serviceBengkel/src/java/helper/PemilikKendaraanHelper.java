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
import org.hibernate.Transaction;
import pojos.PemilikKendaraan;

public class PemilikKendaraanHelper {

    public PemilikKendaraanHelper() {

    }

    public List<PemilikKendaraan> getPemilikKendaraan() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from PemilikKendaraan";
        Query q = session.createQuery(query);
        List<PemilikKendaraan> list = q.list();
        return list;
    }

    public static String toJson() {
        PemilikKendaraanHelper helper = new PemilikKendaraanHelper();
        List<PemilikKendaraan> list = helper.getPemilikKendaraan();
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

    public void addNewPK(
            String nama,
            String email,
            String password
    ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PemilikKendaraan PB = new PemilikKendaraan(nama, email, password);
        session.saveOrUpdate(PB);
        tx.commit();
        session.close();
    }

    public PemilikKendaraan login(String email, String password) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String q = "From PemilikKendaraan k where k.email=:email AND k.password =:password";

        Query query = session.createQuery(q);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return (PemilikKendaraan) query.uniqueResult();
    }
}
