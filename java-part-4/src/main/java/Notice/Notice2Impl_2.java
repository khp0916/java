package Notice;
import java.sql.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notice2Impl_2 implements Notice_2 {

    String id, pw, name, cont, condate ;
    int keynum, connum;
    private String userName;

    public Notice2Impl_2() {
        this.userName = null;
    }

    public Connection connection() {
        String url = "jdbc:mysql://localhost:3306/notice";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================");
        if (userName == null) {
            System.out.println("LOGIN Please");
        } else {
            System.out.println("Hello " + userName + "!");
        }
        System.out.println("====================");
        System.out.println("Enter an option : ");
        System.out.println("[1]LOGIN [2]SIGNUP [3]CONTENTS LIST");
        System.out.println("[4]ADD CONTENT [5]EDIT CONTENT [6]DELETE CONTENT");
        System.out.println("[7]LOGOUT [8]DELETE ID [9]EXIT");
        System.out.println("====================");

        return sc.nextInt();
    }

//1. 로그인
//로그인 성공하면 "OOO님 반갑습니다!" 출력할 것
    @Override
    public void loginMenu() {
        String Query = "SELECT ID, PW FROM user WHERE ID = ? AND PW = ?";
        Scanner sc = new Scanner(System.in);
        System.out.println("ID?");
        id = sc.nextLine();
        System.out.println("PW?");
        pw = sc.nextLine();

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(Query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Login Success!");
                userName = resultSet.getString("ID");
            }else {
                System.out.println("Login Failed!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//2. 회원가입
//사용자로부터 값을 받아서 저장
@Override
public void signUp() {
        String query = "INSERT INTO user (keynum, ID, PW, NAME) VALUES (?, ?, ?, ?)";
        Scanner sc = new Scanner(System.in);
        System.out.println("ID?");
        id = sc.nextLine();
        System.out.println("PW?");
        pw = sc.nextLine();
        System.out.println("NAME?");
        name = sc.nextLine();

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {
            preparedStatement.setInt(1,keynum);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, pw);
            preparedStatement.setString(4, name);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Sign Up Success!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//3. 글목록보기
//-> 회원/비회원 모두 볼 수 있다.
//내용 - 등록(or 마지막 수정) 날짜
    @Override
    public void readContentsList() {
        String query = "SELECT * FROM content";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cont = resultSet.getString("CONT");
                condate = resultSet.getString("CONDATE");
                System.out.println(cont + " " + condate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//4. 글 등록
//-> 로그인한 회원만 등록이 가능하다.
    @Override
    public void writeContent() {

    }

//5. 글 수정
//-> 본인이 쓴 글만 수정이 가능하다.
    @Override
    public void editContent() {

    }

//6. 글 삭제
//-> 본인이 쓴 글만 삭제가 가능하다.
    @Override
    public void deleteContent() {
        String query = "DELETE FROM content WHERE CONNUM = ?";

        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ) {
            preparedStatement.setInt(1, connum);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Delete Success!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//7. 로그아웃
    @Override
    public void logoutMenu() {
        String Query = "SELECT ID, PW FROM user WHERE ID = ? AND PW = ?";
        Scanner sc = new Scanner(System.in);
        System.out.println("ID?");
        id = sc.nextLine();
        System.out.println("PW?");
        pw = sc.nextLine();

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(Query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Logout Success!");
                userName = null;
            }else {
                System.out.println("Logout Failed!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//8. 회원 탈퇴
    @Override
    public void deleteId() {
        String query = "DELETE FROM user WHERE id = ?";
        Scanner sc = new Scanner(System.in);
        System.out.println("DELETE ID?");
        String deleteId = sc.nextLine();

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {
            preparedStatement.setString(1, deleteId);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Delete Success!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
