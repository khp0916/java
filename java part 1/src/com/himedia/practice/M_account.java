package com.himedia.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class M_account {
    static String name;
    public static int totalMoney = 0;

    public static final int count = 5;
    public static int[] account = new int[count];

    public static final int HISTORY = 5;
    public static String[][] history = new String[HISTORY][3];

    // 계좌 생성
    public static void printCreateAccountMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[이름을 입력하세요.]");
        name = sc.nextLine();
    }

    // -> Math.random 계좌번호 생성 -> 0~9 사이의 수로 조합된 5자리로 제한, 중복 숫자 없도록, 앞자리 0 X
    public static void printCreateAccountNum() {
        for (int i = 0; i < count; i++) {
            account[i] = (int) Math.floor(Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if( account[i] == account[j] ){
                    i--;
                }
            }
        }
        System.out.println("[신규 계좌가 개설되었습니다.] [이름] : " + name + " [계좌번호]" + Arrays.toString(account));
    }

    // 메뉴 출력
    public static int printMenu() {
        // 입금
        // 출금
        // 현재 금액조회
        // 내역 조회 최근 5개만 보여지도록. 만약 5개가 꽉 찼으면 가장 오래된 내역은 하나씩 지워진다.
        // [입금] 500원 *입금일자(LocalDateTime 찾아볼것) 2021-08-27 11:33:59
        // 프로그램 종료
        Scanner sc = new Scanner(System.in);
        System.out.println("[" + name + "님 수행하실 업무를 선택하세요.]");
        System.out.println("[1]입금하기 [2]출금하기");
        System.out.println("[3]현재 금액 조회 [4]최근 5회 내역 조회");
        System.out.println("[5]프로그램 종료");

        return sc.nextInt();
    }

    // 입금
    public static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("얼마를 입금하시겠습니까? ->");

        int plus = sc.nextInt();
        totalMoney += plus;
        System.out.print( plus + "원 입금이 완료되었습니다.");

    }

    // 출금
    public static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("얼마를 출금하시겠습니까? ->");

        int minus = sc.nextInt();
        if ( minus > totalMoney){
            System.out.println("출금할 금액이 부족합니다.");
            return;
        };
        totalMoney -= minus;
        System.out.print( minus + "원 출금이 완료되었습니다.");

    }

    // 현재 금액 조회
    public static void checkMoney(){
        System.out.println("현재 계좌 잔액 : " + totalMoney + "원");
    }

    // 최근 5회 내역 조회
    public static void printRecentHistory(){

    }

    public static String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public static void main(String[] args) {
        printCreateAccountMenu();
        printCreateAccountNum();

        while (true) {
            int menuNum = printMenu();
            switch (menuNum) {
                case 1:
                    deposit();
                    break;
                case 2 :
                    withdraw();
                    break;
                case 3 :
                    checkMoney();
                    break;
                case 4 :
                    printRecentHistory();
                    break;
                case 5 :
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default :
                    System.out.println("잘못 선택하셨습니다.");
                    break;
            }

        }
    }
}