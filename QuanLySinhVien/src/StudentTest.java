import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        int choose;
        Scanner sc = new Scanner(System.in);


        do{
            showMenu();
            System.out.println("Choose: ");
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    int n;
                    System.out.println("Nhap so SV can them: ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        Student std = new Student();
                        std.inputInfo();

                        studentList.add(std);
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 3:
                    int minIndex = 0, maxIndex = 0;
                    float minMark, maxMark;
                    minMark = studentList.get(0).getMark();
                    maxMark = studentList.get(0).getMark();

                    for (int i = 1; i < studentList.size(); i++) {
                        if(studentList.get(i).getMark() < minMark){
                            minIndex =i;
                            minMark = studentList.get(i).getMark();
                        }
                        if(studentList.get(i).getMark() > maxMark){
                            maxIndex =i;
                            maxMark = studentList.get(i).getMark();
                        }
                    }
                    System.out.println("SV co DTB cao nhat ");
                    studentList.get(maxIndex).showInfo();

                    System.out.println("SV co DTB thap nhat ");
                    studentList.get(minIndex).showInfo();

                    break;
                case 4:
                    System.out.println("Nhap ma SV can tim: ");
                    String rollNoSearch = sc.nextLine();
                    int count = 0;

                    for(Student student:studentList){
                       if(student.getRollNo().equalsIgnoreCase(rollNoSearch)){
                            student.showInfo();
                            count ++;
                        }
                    }
                    if(count == 0){
                        System.out.println("Khong tim thay SV nao");
                    }

                    break;
                case 5:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            int cp = o1.getName().compareTo(o2.getName());
                            if(cp >= 0){
                                return 1;
                            }
                            return -1;
                        }
                    });

                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 6:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getMark() >= o2.getMark() ? -1 : 1;
                        }
                    });

                    for (int i = 0; i < studentList.size(); i++) {
                        if(studentList.get(i).checkScholarship())
                            studentList.get(i).showInfo();
                    }

                    break;
                case 7:

                    System.out.println(" Goodbye !");
                    break;
                default:
                    System.err.println("Nhap sai !");

            }

        }while (choose != 7);
    }
    static void showMenu(){
        System.out.println("1. Nhap vao N SV");
        System.out.println("2. Hien thi thong tin SV");
        System.out.println("3. Hien thi max va min theo diem trung binh");
        System.out.println("4. Tim kiem theo ma SV");
        System.out.println("5. Sap xep A->Z theo ten SV & hien thi");
        System.out.println("6. Hien thi SV dc hoc bong & sap xep diem giam dan");
        System.out.println("7. Thoat");
    }
}
