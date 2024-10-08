package himedia.java.practice.AccountBook_2;

/*
가계부 2 (File I/O 사용할 것)
기능
AccountBook.java[i], AccountBookImpl.java, Start.java
1. 가계부 내역 추가
-> 오늘 날짜의 파일(.txt)이 없으면 자동으로 생성한다.
-> 있으면 기존 내역에 해당 내용을 추가한다.
-> 추가 형식 :
공책 : 1000원
연필 : 300원
합계 : 1300원
2. 내역 조회
-> 과거 날짜 제목들 리스트가 나온다.
2024-09-04
2024-09-03
2024-09-02
2024-09-01
-> 제목을 입력하면 (2024-09-04) 해당 날짜의 내역들이 나온다.
3. 삭제
-> 제목을 입력한 파일을 삭제시킨다.
4. 프로그램 종료
 */

import himedia.java.practice.AccountBook.AccountBook;
import himedia.java.practice.AccountBook.AccountBookImpl;

public class Start_2 {
    public static void main(String[] args) {

        AccountBook_2 accountBook = new AccountBookImpl_2();
        accountBook.createFolder();

        while (true) {
            int choice = accountBook.printMenu();
            switch (choice) {
                case 1:
                    accountBook.addHistory();
                    break;
                case 2:
                    accountBook.printHistory();
                    break;
                case 3:
                    accountBook.deleteHistory();
                    break;
                case 4:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다.");
                    break;
            }
        }
    }
}
