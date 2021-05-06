import java.util.Scanner;

public class Student {

    static int count = 0;
    private int stt = 0,id = 0, age;
    private String name,address;
    private float gpa;

    public Student() {
        stt = id = ++count;

    }

    public Student(String name,int age, String address, float gpa) {
        stt = id = ++count;
        this.age = age;
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Input name:");
        name = sc.nextLine();

        System.out.println("Input age: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("Input address: ");
        address = sc.nextLine();

        System.out.println("Input GPA: ");
        gpa = Float.parseFloat(sc.nextLine());
    }

    public String getFileLine(){
        return id +","+ name +","+ age +","+ address +","+ gpa +"\n";
    }
//
//    public void display(){
//        System.out.println(this);
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "stt=" + stt +
//                ", id=" + id +
//                ", age=" + age +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", gpa=" + gpa +
//                '}';
//    }

    public void split(String line){
        String[] params = line.split(",");
        try{
            id = Integer.parseInt(params[0]);
            name = params[1];
            age = Integer.parseInt(params[2]);
            address = params[3];
            gpa = Float.parseFloat(params[4]);
            getFileLine();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {

        }


    }
}
