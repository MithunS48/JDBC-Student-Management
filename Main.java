import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();
       while (true) {

            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            System.out.println("done with the project");

            switch (choice) {

                case 1:

                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age : ");
                    int age = sc.nextInt();

                    Student s = new Student(id, name, age);

                    dao.addStudent(s);

                    break;

                case 2:

                    dao.viewStudent();;

                    break;

                case 3:

                    System.out.print("Enter ID : ");
                    id = sc.nextInt();

                    dao.searchById(id);

                    break;

                case 4:

                    System.out.print("Enter ID : ");
                    id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name : ");
                    name = sc.nextLine();

                    System.out.print("Enter New Age : ");
                    age = sc.nextInt();

                    s = new Student(id, name, age);

                    dao.updateStudent(s);

                    break;

                case 5:

                    System.out.print("Enter ID : ");
                    id = sc.nextInt();

                    dao.deleteStudent(id);

                    break;

                case 6:

                    System.out.println("Thank You!");

                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice");
            }

        }

    }
}