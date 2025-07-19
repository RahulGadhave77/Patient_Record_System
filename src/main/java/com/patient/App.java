package com.patient;

import java.util.Scanner;

import com.patient.repository.PatientRepo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PatientRepo p = new PatientRepo();

		System.out.println("1. add patient ");
		System.out.println("2. get all patient list ");
		System.out.println("3.update patient detail");
		System.out.println("4.delet patient detail ");

		Scanner sc = new Scanner(System.in);

		int opration = sc.nextInt();

		switch (opration) {
		case 1:
			p.addPatient();
			break;
		case 2:
			p.getAll();
			break;
		case 3:

			System.out.println("update disease or date ");
			System.out.println("1. disease");
			System.out.println("2.date");

			int op = sc.nextInt();
			switch (op) {
			case 1:
				p.updateDisease();
				break;
			case 2:
				p.updateDate();
				break;
			}
			break;

		case 4:
			p.deletePatient();
			break;
		}
	}
}
