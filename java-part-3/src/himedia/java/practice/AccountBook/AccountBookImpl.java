package himedia.java.practice.AccountBook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountBookImpl implements AccountBook {

    private List<String> details;
    private Map<String, List<String>> HistoryMap;

    public AccountBookImpl() {
        details = new ArrayList<>();
        HistoryMap = new HashMap<>();
    }

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================== 가계부 ==========================");
        System.out.println("[1]내역 추가 [2]내역 조회 [3]전체 삭제 [4]내역 삭제 [5]프로그램 종료");
        System.out.println("원하시는 메뉴를 선택하세요.");
        System.out.println("===========================================================");

        return sc.nextInt();
    }

    @Override
    public void addHistory() {

        // 밸류 값에 넣을 항목 이름과 가격, 합계 입력받고 추가하기
        Scanner sc = new Scanner(System.in);
        System.out.println("추가하실 항목을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("항목의 금액을 입력해주세요.");
        String price = sc.nextLine();
        // 같은 날짜가 존재할때 변수
        if (!HistoryMap.containsKey(getNowDateTime())) {
            details.clear();
        }
        details.add(name + " : " + price);
        HistoryMap.put(getNowDateTime(), details);
    }

    @Override
    public void printHistory() {
        System.out.println("========================== 내역 ==========================");
        // 과거 날짜 내역 프린트하기 -> 맵의 키 값 출력
        for( String key : HistoryMap.keySet() ) {
            System.out.println("날짜 : " + key);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("내역 조회를 원하는 날짜를 입력하세요. (yyyy-mm-dd)");
        String date = sc.nextLine();
        if ( !checkDate(date) ) {
            System.out.println("해당 날짜의 내역이 존재하지 않습니다.");
        } else {
            // 존재하는 날짜의 내역 프린트하기 -> 맵의 키값을 입력받아 밸류 값 출력
            List<String> dateDetails = HistoryMap.get(date);
            for (int i = 0; i < dateDetails.size(); i++) {
                System.out.println("[" + (i+1) + "]" + dateDetails.get(i) + "원");
            }
        }
        // 합계 출력하기
        int Money = 0;
        for( int i=0; i<details.size(); i++ ) {
            String[] money = details.get(i).split(" ");
            Money += Integer.parseInt(money[2]);
        }
        System.out.println("합계 : " + Money + " 입니다.");
    }

    @Override
    public void deleteAll() {
        HistoryMap.clear();
    }

    @Override
    public void deleteHistory() {
        System.out.println("삭제할 내역이 속한 날짜를 조회합니다.");
        printHistory();
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제를 원하는 항목 번호를 입력하세요.");
        int deleteNum = Integer.parseInt(sc.nextLine());
        details.remove(deleteNum-1);
        System.out.println("해당 내역이 정상적으로 삭제되었습니다.");

    }

    @Override
    public String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().format(formatter);
    }

    @Override
    public boolean checkDate(String date) {
        return HistoryMap.containsKey(date);
    }
}
