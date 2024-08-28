package com.himedia.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


// 가계부
public class N_account_book {

    public static int listIdx = -1;
    public static final int LIST_MAX_LENGTH = 10;
    public static String[] list = new String[LIST_MAX_LENGTH];

    // 1월 ~ 12월 월별로 선택할 수 있도록 한다.
    public static void selectMonth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("조회를 원하는 월을 입력하세요.");
        int month = sc.nextInt();
         while ((month > 13) || (month < 1)) {
             System.out.println("--------------------------------------------------");
             System.out.println("존재하지 않는 월입니다. 조회를 원하는 월을 다시 입력하세요.");
        }
    }

    // 기능
    // 해당 물품 내용 수정
    // 해당 물품 내용 삭제
    // 해당 월의 내용 전체 삭제
    public static int printListMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("[원하는 항목을 선택하세요.]");
        System.out.println("[1]물품 내용 수정 [2]물품 내용 삭제");
        System.out.println("[3]당월 내용 전체 삭제 [4]최근 5회 내역 조회");

        return sc.nextInt();
    }

    // 해당월을 선택하였으면 자동으로 구매 목록 리스트가 나온다.
    // 내용(물품 이름, 물품 가격, 추가일자) 추가 10개 까지만... 10개를 초과할 경우 가장 앞에 내역을 지운다.
    // 날짜 형식 : 2024-08-20 08:10:30
    public static void printList() {
        System.out.println("=============== 내용조회 ===============");
        for (int i = listIdx; i < LIST_MAX_LENGTH; i++) {
            if (list[i] == null) continue;
            System.out.println(list[i]);
        }
    }
    public static String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }


    public static void main(String[] args) {
        selectMonth();

        while (true) {
            int listNum = printListMenu();
            switch (listNum) {
                case 1:

                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :
                    System.out.println("가계부를 종료합니다.");
                    return;
                default :
                    System.out.println("잘못 선택하셨습니다.");
                    break;
            }

        }
    }
}
