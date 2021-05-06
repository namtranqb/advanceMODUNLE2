import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    static List<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_STUDENT = "src/student.csv";

    public static void main(String[] args) {
        int choose;
        do{
            showMenu();
            choose = Integer.parseInt(sc.nextLine());

            switch (choose){
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudentById();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    sortStudentByGPA();
                    displayStudent();
                    break;
                case 5:
                    sortStudentByName();
                    displayStudent();
                    break;
                case 6:
                    displayStudent();
                    break;
                case 7:
                    saveFile();
                    System.out.println("Start save file...");
                    break;
                case 8:
                    readFile();
                    break;
                case 9:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Error");
            }
        }while (choose != 9);
    }

    private static void readFile() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fis = new FileInputStream(FILE_STUDENT);
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);

            String line = null;

            while((line = bufferedReader.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                Student std = new Student();
                std.split(line);
                studentList.add(std);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void saveFile() {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(FILE_STUDENT,true);

            for(Student std : studentList){
                String line = std.getFileLine();

                byte[] b = line.getBytes();
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void displayStudent() {
        for(Student std :studentList){
//            std.display();
            System.out.println(std.getFileLine());
        }
    }

    private static void sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getName().compareToIgnoreCase(o2.getName());
                        // a->z
            }
        });
    }

    private static void sortStudentByGPA() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGpa() > o2.getGpa()){
                    return -1;
                }
                return 1;
            }
        });
    }

    private static void deleteStudent() {
        System.out.println("Input ID Student deleted: ");
        int id = Integer.parseInt(sc.nextLine());

        for(Student std : studentList){
            if(std.getId() == id){
                studentList.remove(std);
                break;
            }
        }
    }

    private static void editStudentById() {
        System.out.println("Input ID Student edited: ");
        int id = Integer.parseInt(sc.nextLine());

        for(Student std : studentList){
            if(std.getId() == id){
                std.input();
                break;
            }
        }
    }

    private static void addStudent() {
        Student std = new Student();
        std.input();
        studentList.add(std);
    }

    static void showMenu(){
        System.out.println("1. Add student");
        System.out.println("2. Edit student by ID");
        System.out.println("3. Delete student by ID");
        System.out.println("4. Sort student by GPA");
        System.out.println("5. Sort student by name");
        System.out.println("6. Display student information");
        System.out.println("7. Save file 'student.csv'");
        System.out.println("8. Read file 'student.csv'");
        System.out.println("9. Exit");
        System.out.println(" Choose: ");
    }
}
