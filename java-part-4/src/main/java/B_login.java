import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class B_login {
    String name, phone;
    int age;

    public Connection connection() {
        String url = "jdbc:mysql://localhost:3306/java_basic";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conn Success!");

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("SELECT MENU");
        System.out.println("[1]SIGNUP [2]LOGIN [3]END");
        return sc.nextInt();
    }

    public void insertData() {
        String query = "INSERT INTO users (name, age, phone) VALUES (?, ?, ?)";
        Scanner sc = new Scanner(System.in);
        System.out.println("NAME?");
        name = sc.nextLine();
        System.out.println("AGE?");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("PHONE?");
        phone = sc.nextLine();

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, phone);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Insert Success!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void login() {
        // 로그인 부분 해결
//        ->userID
//        ->pw
//        Succ
//        Welcome name!
//        age : ~, phone : ~
//        Fail
//        Nothing!
        Scanner sc = new Scanner(System.in);

    }

    public static void main(String[] args) {
        B_login login = new B_login();
        while(true) {
            int loginNum = printMenu();
            switch (loginNum) {
                case 1:
                    login.insertData();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다.");
                    break;
            }
        }
    }
}
