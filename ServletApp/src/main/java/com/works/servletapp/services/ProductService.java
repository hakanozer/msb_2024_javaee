package com.works.servletapp.services;

import com.works.servletapp.config.HibernateUtil;
import com.works.servletapp.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductService {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    public void productAdd(String title, Integer price, String detail ) {
        Product product = new Product();
        product.setPrice(price);
        product.setDetail(detail);
        product.setTitle(title);

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(product);

        tr.commit();
        session.close();
        //tr.rollback();
    }

    public List<Product> allProduct() {
        Session session = sf.openSession();
        List<Product> ls = session.createQuery("from Product").getResultList();
        return ls;
    }

}
