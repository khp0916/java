package Notice;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/*
[공지사항]
- 데이터베이스 설계
Notice 데이터베이스 생성
User 테이블 -> 회원정보
회원 번호
회원 이름
회원 아이디
회원 비밀번호
Content 테이블 -> 공지사항 내용
글 번호
글 내용
등록(or 마지막 수정) 날짜
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

public class Start {
    public static void main(String[] args) {
        // 한글 정상화 출력 코드
        setCharacter();
        Notice notice = new NoticeImpl();

        while (true) {
            int choice = notice.printMenu();
            switch (choice) {
                case 1:
                    notice.signIn();
                    break;
                case 2:
                    notice.signUp();
                    break;
                case 3:
                    notice.getList();
                    break;
                case 4:
                    notice.newNotice();
                    break;
                case 5:
                    notice.updateNotice();
                    break;
                case 6:
                    notice.deleteNotice();
                    break;
                case 7:
                    notice.signOut();
                    break;
                case 8:
                    notice.leave();
                    break;
                case 9:
                    System.out.println("다음에 또 만나요!");
                    return;
            }
        }

    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
