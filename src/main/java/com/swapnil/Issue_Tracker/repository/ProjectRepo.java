package com.swapnil.Issue_Tracker.repository;

import com.swapnil.Issue_Tracker.entity.Project;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepo {

    @Autowired
    private SessionFactory sessionFactory;

    public Project addProject(Project project) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(project);
            transaction.commit();
            project.setId(id);
            return project;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save project", e);
        }
    }

    public List<Project> getAllProjects() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("From Project", Project.class).list();
        } finally {
            session.close();
        }

    }
    public Project getProjectById(long id) {
        Session session = sessionFactory.openSession();
        try{
            Project project = session.get(Project.class, id);
            return project;
        }catch (Exception e){
            System.err.println("exception occurred  in project repo "+e);
        }finally {
        session.close();
        }
        return null;
    }

    @Transactional
    public Project updateProject(Project project, long id) {
        Session session = sessionFactory.openSession();
        try{
            Project project1 = session.get(Project.class, id);
            project1.setUpdatedAt(project.getUpdatedAt());
            project1.setName(project.getName());
            project1.setIssues(project.getIssues());
            project1.setDescription(project.getDescription());
            session.saveOrUpdate(project1);
            return project1;
        }finally {
        session.close();
        }
    }
}
