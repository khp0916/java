package Notice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NoticeImpl implements Notice{

    String name, id, pw, cont, condate ;

    public Connection connection() {
        String url = "jdbc:mysql://localhost:3306/notice";
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

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================");
        System.out.println("Enter an option : ");
        System.out.println("[1]로그인 [2]회원가입 [3]글목록보기");
        System.out.println("[4]글 등록 [5]글 수정 [6]글 삭제");
        System.out.println("[7]로그아웃 [8]회원탈퇴 [9]프로그램종료");
        System.out.println("====================");

        return sc.nextInt();
    }

//1. 로그인
//로그인 성공하면 "OOO님 반갑습니다!" 출력할 것
    @Override
    public void loginMenu() {
        String idQuery = "SELECT ID FROM user WHERE ID = ?";
        String pwQuery = "SELECT PW FROM user WHERE ID = ?";
        Scanner sc = new Scanner(System.in);
        System.out.println("ID?");
        id = sc.nextLine();
        System.out.println("PW?");
        pw = sc.nextLine();

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement_1 = conn.prepareStatement(idQuery);
                PreparedStatement preparedStatement_2 = conn.prepareStatement(pwQuery);
        ) {
            if (preparedStatement_1.equals(id)) {
                if (preparedStatement_2.equals(pw)) {
                    System.out.println("Login Success!");
                } else {
                    System.out.println("PW WRONG!");
                }
            }else {
                System.out.println("ID WRONG!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//2. 회원가입
//사용자로부터 값을 받아서 저장
    @Override
    public void signUp() {
        String query = "INSERT INTO user (ID, PW, NAME) VALUES (?, ?, ?)";
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
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);
            preparedStatement.setString(3, name);

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

    }

//7. 로그아웃
    @Override
    public void logoutMenu() {

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
}
