package com.swapnil.Issue_Tracker.repository;

import com.swapnil.Issue_Tracker.entity.Issue;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssuesRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addIssue(Issue issue) {
        Session session = sessionFactory.openSession();
        try{
            session.save(issue);
            System.err.println("Issue is added to the DB successfully ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
        session.close();
        }
    }
}
