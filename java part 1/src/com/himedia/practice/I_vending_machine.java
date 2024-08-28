package com.himedia.java.practice;

import java.util.Scanner;

public class I_vending_machine {
    public static int totalMoney = 0;
    public static final int COKE = 500, CIDER = 300, FANTA = 700, WATER = 200;

    public static void printMenu(int totalMoney) {
        System.out.println("===============================자판기===============================");
        System.out.println("[1]콜라-500원 [2]사이다-300원 [3]환타-700원 [4]물-200원");
        System.out.println("[5]돈 넣기 [6]반환");
        System.out.println("현재 금액 : " + totalMoney + "원");
        System.out.println("===================================================================");
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 메뉴를 선택하세요. ->");
        return sc.nextInt();
    }

    public static int getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("돈을 넣으세요 ->");
        return sc.nextInt();
    }

    public static void productPrice(int myChoice) {
        if ( myChoice == 1 ) {
            myChoice = COKE;
        } else if ( myChoice == 2 ) {
            myChoice = CIDER;
        } else if ( myChoice == 3 ) {
            myChoice = FANTA;
        } else if ( myChoice == 4 ) {
            myChoice = WATER;
        }
    }

    public static void menuChoice(int productPrice) {
        int result = -1; // 혹시 모를 오류를 대비해 아무 음수값 대입
        result = calcMoney(totalMoney,productPrice);
        if (result < 0 ) {
            printException();
        } else {
            totalMoney = result;

        }
    }

    public static int calcMoney(int totalMoney, int price) {
        return totalMoney - price;
    }

    public static void printException() {
        System.out.println("잔돈이 부족합니다.");
    }
    public static void main(String[] args) {

        while (true) {
            printMenu(totalMoney);
            int myChoice = getChoice();
            productPrice(myChoice);
            switch (myChoice) {
                case 1:
                    menuChoice(COKE);
                    break;
                case 2:
                    menuChoice(CIDER);
                    break;
                case 3:
                    menuChoice(FANTA);
                    break;
                case 4:
                    menuChoice(WATER);
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
