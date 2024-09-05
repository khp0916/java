package himedia.java.practice.AccountBook;

/*
가계부 1 (collections 사용할 것)
기능
AccountBook.java[i], AccountBookImpl.java, Start.java
1. 가계부 내역 추가
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
3. 전체 삭제
- 제목을 입력한 날짜와 내역을 삭제시킨다.
4. 내역 삭제
- 내역들 중 특정 항목을 삭제시킬 수 있다.
5. 프로그램 종료
 */

public class Start {

    public static void main(String[] args) {

        AccountBook accountBook = new AccountBookImpl();

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
                    accountBook.deleteAll();
                    break;
                case 5:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다.");
                    break;
            }
        }
    }

}
