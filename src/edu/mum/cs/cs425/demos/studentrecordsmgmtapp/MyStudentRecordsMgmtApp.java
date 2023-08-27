package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {

	public static void main(String[] args) throws Exception {
		Student s1 = new Student(110001,"Dave", LocalDate.of(1951, 11, 18));
		Student s2 = new Student(110002,"Anna", LocalDate.of(1990, 12, 7));
		Student s3 = new Student(110003,"Erica", LocalDate.of(1974, 1, 31));
		Student s4 = new Student(110004,"Carlos", LocalDate.of(2009, 8, 22));
		Student s5 = new Student(110005,"Bob", LocalDate.of(1990, 3, 5));
		
		Student[] students = new Student[] {s1, s2,s3,s4,s5};
		MyStudentRecordsMgmtApp studentRecord = new MyStudentRecordsMgmtApp();
		
		System.out.println("List of all students:");
		System.out.println("______________________________________________________________");
		studentRecord.printListOfStudents(students);
		
		List<Student> platinumStudents = studentRecord.getListOfPlatinumAlumniStudents(students);
		Collections.sort(platinumStudents, (Student o1, Student o2) -> o2.getDateOfAdmission().compareTo(o1.getDateOfAdmission()));
		System.out.println("\nList of platinum students:");
		System.out.println("______________________________________________________________");
		for(Student s : platinumStudents) {
			System.out.println(s);
		}
		System.out.println("\nPrint Hello World:");
		System.out.println("______________________________________________________________");
		printHelloWorld(new int[] {35, 34, 25, 42});
		
		System.out.println("\nPrint Second Largest:");
		System.out.println("______________________________________________________________");
		System.out.println(findSecondBiggest(new int[] {1,2,3,4,5}));
	}
	
	public void printListOfStudents(Student[] students) {		
		Arrays.sort(students, (Student s1, Student s2) -> s1.getName().compareTo(s2.getName()));
		for(Student s : students) {
			System.out.println(s);
		}		
	}
	
	public  List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
		List<Student> platinumAlumniStudent = new ArrayList<>(); 
		for(Student s : students) {			
			Period period = Period.between(s.getDateOfAdmission(), LocalDate.now());
			int noOfYears = period.getYears();
			if(noOfYears > 29) {
				platinumAlumniStudent.add(s);
			}
		}	
		return platinumAlumniStudent;
	}
	
	public static void printHelloWorld(int[] arr) {
		for(int i : arr) {
			if(i %5 == 0 && i % 7 == 0) {
				System.out.println("HelloWorld");
			}else if(i % 5 == 0) {
				System.out.println("Hello");
			}else if(i % 7 == 0) {
				System.out.println("World");
			}else 
				System.out.println();
		}
	}
	
	public static int findSecondBiggest(int[] numbers) throws Exception {
		if(numbers.length < 2) {
			throw new Exception("Array does not have second biggest number");
		}
		int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
        	throw new Exception("Array does not have second biggest number");
        } 
        return secondLargest;
	}
}
