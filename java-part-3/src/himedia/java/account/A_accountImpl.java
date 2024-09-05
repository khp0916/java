package himedia.java.account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A_accountImpl implements A_account {

    private String userName,userAccount;
    private int totalMoney;
    private int ACCOUNT_MAX_LENGTH = 5;
    private List<String> HISTORY;


    public A_accountImpl() {
        ACCOUNT_MAX_LENGTH = 5;
        totalMoney = 0;
        HISTORY = new ArrayList<String>();
    }

    @Override
    public void printCreateAccountMenu() {
        System.out.println("===========계좌 생성===========");
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");

        userName = sc.nextLine();
        userAccount = createAccountNum();

        System.out.println("계좌가 생성되었습니다. [이름] " + userName + ", [계좌번호] " + userAccount);
    }

    @Override
    public String createAccountNum() {
        StringBuilder sb = new StringBuilder();
        int[] accountNums = new int[ACCOUNT_MAX_LENGTH];
        int idx = 0;

        while (idx < ACCOUNT_MAX_LENGTH) {
            int tmp = (int)(Math.random() * 10);

            if ( idx == 0 && tmp == 0 ) continue;
            if ( idx > 0 && checkDuplicateNum(accountNums, tmp, idx) ) continue;

            accountNums[idx++] = tmp;
        }

        for ( int accountNum : accountNums ) {
            sb.append(accountNum);
        }

        return sb.toString();
    }

    @Override
    public boolean checkDuplicateNum(int[] accountNums, int tmp, int idx) {
        for (int i = 0; i < idx; i++) {
            if (accountNums[i] == tmp) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========== 메뉴 ==========");
        System.out.println("[계좌번호] : " + userAccount + ", [이름] : " + userName);
        System.out.println("[1]입금 [2]출금 [3]내역조회 [4]프로그램종료");
        System.out.println("현재금액 - " + totalMoney + "원");
        System.out.println("원하시는 메뉴를 선택하세요.");

        return sc.nextInt();
    }

    @Override
    public void addMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금할 금액을 입력하세요.");
        int getMoney = sc.nextInt();
        totalMoney += getMoney;
        HISTORY.add("[입금] " + getMoney + " 원, 시간 : " + getNowDateTime());
    }

    @Override
    public void subMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("출금할 금액을 입력하세요.");
        int subMoney = sc.nextInt();

        if (subMoney > totalMoney) {
            System.out.println("출금할 금액이 부족합니다.");
            return;
        }
        totalMoney -= subMoney;
        HISTORY.add("[출금] " + subMoney + " 원, 시간 : " + getNowDateTime());
    }

    @Override
    public String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    @Override
    public void printHistory() {
        System.out.println("======= 내역조회 =======");
//        Collections.reverse(HISTORY);
//        for (int i = 0; i < HISTORY.size(); i++) {
//            System.out.println((i+1) + " : " + HISTORY.get(i));
//        }
        for (int i = HISTORY.size()-1; i > 0; --i) {
            System.out.println((i) + " : " + HISTORY.get(i));
        }
    }
}