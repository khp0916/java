package com.himedia.java.practice;

import java.util.Scanner;

public class I_vending_machine {
    static final int COKE = 1800, CIDER = 1700, FANTA = 1500, WATER = 800;

    public static void printMenu(int totalMoney) {
        System.out.println("===============================자판기===============================");
        System.out.println("[1]콜라-1800원 [2]사이다-1700원 [3]환타-1500원 [4]물-800원");
        System.out.println("[5]돈 넣기 [6]반환");
        System.out.println("현재 금액 : " + totalMoney + "원");
        System.out.println("===================================================================");
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("원하는 메뉴를 선택하세요. ->");
        return sc.nextInt();
    }

    public static int getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("돈을 넣으세요 ->");
        return sc.nextInt();
    }

    public static int calcMoney(int totalMoney, int price) {
        return totalMoney - price;
    }

    public static void printException() {
        System.out.println("잔돈이 부족합니다.");
    }

    public static void main(String[] args) {
        int totalMoney = 0;

        while (true) {
            printMenu(totalMoney);
            int myChoice = getChoice();
            int result = -1; // 혹시 모를 오류를 대비해 아무 음수값 대입
            switch (myChoice) {
                case 1:
                    result = calcMoney(totalMoney,COKE);
                    if (result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("콜라가 나왔습니다.");
                    }
                    break;
                case 2:
                    result = calcMoney(totalMoney,CIDER);
                    if (result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("사이다가 나왔습니다.");
                    }
                    break;
                case 3:
                    result = calcMoney(totalMoney,FANTA);
                    if (result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("환타가 나왔습니다.");
                    }
                    break;
                case 4:
                    result = calcMoney(totalMoney,WATER);
                    if (result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("물이 나왔습니다.");
                    }
                    break;
                case 5:
                    totalMoney += getMoney();
                    break;
                case 6:
                    System.out.printf("현재 잔액은 %d 원 입니다.", totalMoney);
                    return;
                default:
                    System.out.println("잘못 누르셨습니다.");
            }
        }
    }
}
