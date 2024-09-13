package Notice;

public class Start_2 {
    /*
    [공지사항]
- 데이터베이스 설계
Notice 데이터베이스 생성
User 테이블 -> 회원정보
-KEYNUM : 회원 번호
-NAME : 회원 이름
-ID : 회원 아이디
-PW : 회원 비밀번호
Content 테이블 -> 공지사항 내용
CONNUM : 글 번호
CONT : 글 내용
CONDATE : 등록(or 마지막 수정) 날짜
설계 후 생성할 것.
구조 : Notice.java(I) NoticeImpl.java Start.java
-기능
1. 로그인
로그인 성공하면 "OOO님 반갑습니다!" 출력할 것
2. 회원가입
사용자로부터 값을 받아서 저장
3. 글목록보기
-> 회원/비회원 모두 볼 수 있다.
내용 - 등록(or 마지막 수정) 날짜
4. 글 등록
-> 로그인한 회원만 등록이 가능하다.
5. 글 수정
-> 본인이 쓴 글만 수정이 가능하다.
6. 글 삭제
-> 본인이 쓴 글만 삭제가 가능하다.
7. 로그아웃
8. 회원 탈퇴
9. 프로그램 종료
     */

    public static void main(String[] args) {
        Notice_2 notice2 = new Notice2Impl_2();
        while (true) {
            int choice = notice2.printMenu();
            switch (choice) {
                case 1:
                    notice2.loginMenu();
                    break;
                case 2:
                    notice2.signUp();
                    break;
                case 3:
                    notice2.readContentsList();
                    break;
                case 4:
                    notice2.writeContent();
                    break;
                case 5:
                    notice2.editContent();
                    break;
                case 6:
                    notice2.deleteContent();
                    break;
                case 7:
                    notice2.logoutMenu();
                    break;
                case 8:
                    notice2.deleteId();
                    break;
                case 9:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다.");
                    break;
            }
        }
    }
}
