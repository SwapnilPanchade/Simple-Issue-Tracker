package com.swapnil.Issue_Tracker.repository;

import com.swapnil.Issue_Tracker.entity.Project;
import com.swapnil.Issue_Tracker.model.ProjectResponse;
import com.swapnil.Issue_Tracker.service.ProjectService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
}
