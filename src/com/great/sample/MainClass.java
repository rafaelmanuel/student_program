package com.great.sample;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String args[]){
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		String command = "";
		String fileName , fileTitle , studentName = "";
		Utilities util = new Utilities();
		List<Student> list = null;
	
		
		try {
			System.out.println("java ClassStats");
			System.out.print("Class Stats program by ralen");
			
			while(flag){
				System.out.print("\n>");
				command = scanner.nextLine();
				
				//help
				if(command.trim().toLowerCase().equals("help")){
					util.help();
					
				//load
				}else if(command.trim().toLowerCase().split(" ")[0].equals("load") && !(fileName = command.trim().toLowerCase().split(" ")[1]).equals("")){
					util.setFileName(fileName);
					util.setAssigment();
					list =  util.getAllStudent();

					if(fileName.equals("philosophy101.txt"))
						System.out.printf("loaded class %s, section %d", util.getAssignmentName() , util.getSection());
				
				//students
				}else if(command.trim().toLowerCase().equals("students") && list != null){
					System.out.printf("\nStudent Grades for  %s, section %d \nTotal points possible: 100\n\n" , util.getAssignmentName() , util.getSection());
					System.out.println("First Name\t\tLast Name\t\tPoints\t\tGrade");
					System.out.println("----------\t\t---------\t\t------\t\t-----");
					for(Student student : list){
						int points = student.getEssay1() + student.getEssay2() + student.getTest1() + student.getTest2() + student.getFinalGrade();
						System.out.printf("%s\t\t%s\t\t   %d\t\t   %s\n" , util.setWordAllignment(student.getFirstName()),
								util.setWordAllignment(student.getLastName()) , points , util.gradeRating(points));
					}
				//assignments
				}else if(command.trim().toLowerCase().equals("assignments")){
					System.out.printf("\nAssignments for %s, section %d\n\n" , util.getAssignmentName() , util.getSection());
					System.out.println("Assignment\t\tPoints");
					System.out.println("----------\t\t------");
					System.out.printf("essay 1  \t\t  %d\n" , util.getEssay1());
					System.out.printf("test 1   \t\t  %d\n" , util.getTest1());
					System.out.printf("essay 2  \t\t  %d\n" , util.getEssay2());
					System.out.printf("test 2   \t\t  %d\n" , util.getTest2());
					System.out.printf("final    \t\t  %d\n" , util.getFinalGrade());
				
				//search
				}else if(command.trim().toLowerCase().split(" ")[0].equals("search") && !(studentName = command.trim().split(" ")[1]).equals("")){
					System.out.printf("\nStudent Grades for  %s, section %d \nTotal points possible: 100\n\n" , util.getAssignmentName() , util.getSection());
					System.out.println("First Name\t\tLast Name\t\tPoints\t\tGrade");
					System.out.println("----------\t\t---------\t\t------\t\t-----");			
					Student student = util.searchStudent(list, studentName);
					int points = student.getEssay1() + student.getEssay2() + student.getTest1() + student.getTest2() + student.getFinalGrade();
					System.out.printf("%s\t\t%s\t\t   %d\t\t   %s\n" , util.setWordAllignment(student.getFirstName()),
							util.setWordAllignment(student.getLastName()) , points , util.gradeRating(points));
					
				//grades	
				}else if(command.trim().toLowerCase().equals("grades")){
					int grade[] = new int[list.size()];
					int ctr = 0;
					for(Student student : list){
						int points = student.getEssay1() + student.getEssay2() + student.getTest1() + student.getTest2() + student.getFinalGrade();
						grade[ctr] = points;
						ctr++;
					}
				
					System.out.printf("Grade breakdown for %s, section %d\n", util.getAssignmentName() , util.getSection());
					System.out.println("\nLow: 65%\nHigh: 97%\nAve: 84%\n");
					util.studentGrade(list);
				
				//student
				}else if(command.trim().split(" ")[0].toLowerCase().equals("student") && !(studentName = command.trim().split(" ")[1]).equals("")){
					Student student = util.searchStudent(list, studentName);
					int points = student.getEssay1() + student.getEssay2() + student.getTest1() + student.getTest2() + student.getFinalGrade();
					
					System.out.printf("Grades for %s %s\n", student.getFirstName() , student.getLastName());
					System.out.println("Assignment\t\tPoints\t\tPossible");
					System.out.println("----------\t\t------\t\t--------");
					System.out.printf("essay 1   \t\t  %d\t\t   %d\n" , student.getEssay1() , util.getEssay1());
					System.out.printf("test 1   \t\t  %d\t\t   %d\n" , student.getTest1() , util.getTest1());
					System.out.printf("essay 2   \t\t  %d\t\t   %d\n" , student.getEssay2() , util.getEssay2());
					System.out.printf("test 2   \t\t  %d\t\t   %d\n" , student.getTest2() , util.getTest2());
					System.out.printf("final    \t\t  %d\t\t   %d\n\n" , student.getFinalGrade() , util.getFinalGrade());
					System.out.printf("Final Grade: %s \n", util.gradeRating(points));
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
}
