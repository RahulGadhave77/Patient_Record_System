package com.patient.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PatientUtility {

	private PatientUtility() {
	}

	private static SessionFactory factory;

	public static SessionFactory getfactory() {

		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;

	}

}
