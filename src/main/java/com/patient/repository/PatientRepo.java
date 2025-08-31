package com.patient.repository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.patient.entity.PatientDetail;
import com.patient.utility.PatientUtility;

public class PatientRepo {

	Scanner sc = new Scanner(System.in);

	//post data from database
	public void addPatient() {

		PatientDetail p = new PatientDetail();

		System.out.println("Enter Patient name");
		String patient = sc.next();
		p.setName(patient);

		System.out.println("Enter patient age");
		int age = sc.nextInt();
		p.setAge(age);

		System.out.println("enter patient disease");
		String disease = sc.next();
		p.setDisease(disease);

		p.setDate(new Date());

		SessionFactory factory = PatientUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(p);

		transaction.commit();
		session.close();
	}

	public void getAll() {
		SessionFactory factory = PatientUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<PatientDetail> p = session.createQuery("select p from PatientDetail p ", PatientDetail.class)
				.getResultList();

		p.stream().forEach(k -> System.out.println(k));

		transaction.commit();
		session.close();
	}

	public void updateDisease() {
		SessionFactory factory = PatientUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter patient id ");
		int p = sc.nextInt();
		PatientDetail patient = session.find(PatientDetail.class, p);

		System.out.println("Enter pationt Disease");
		String d = sc.next();
		patient.setDisease(d);

		transaction.commit();
		session.close();
	}
	
	public void updateDate() {
		SessionFactory factory = PatientUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter patient id ");
		int p = sc.nextInt();
		PatientDetail patient = session.find(PatientDetail.class, p);
		
		patient.setDate(new Date());
		
		transaction.commit();
		session.close();
		
	}
	
	public void deletePatient() {
		SessionFactory factory = PatientUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("enter patient id for delete");
		int p = sc.nextInt();
		PatientDetail patient = session.find(PatientDetail.class, p);
		
		session.remove(patient);
		
		transaction.commit();
		session.close();
	}
}
