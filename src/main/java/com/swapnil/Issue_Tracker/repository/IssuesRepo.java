package com.swapnil.Issue_Tracker.repository;

import com.swapnil.Issue_Tracker.entity.Issue;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Issue> getAllIssues() {
        Session session = sessionFactory.openSession();
        try{
            Query<Issue> issues = session.createQuery("From Issue", Issue.class);
            return issues.list();
        }finally {

        session.close();}
    }
}
