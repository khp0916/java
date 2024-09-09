package himedia.java.practice.AccountBook_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountBookImpl_2 implements AccountBook_2 {

    private String desktopPath;
    private String folderPath;
    private Path myFolder;
    private String today;
    private Path todayFile;

    public AccountBookImpl_2() {
        this.desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        this.folderPath = desktopPath + File.separator + "가계부";
        this.myFolder = Paths.get(folderPath);
    }

    @Override
    public void createFolder() {
        try {
            if ( Files.notExists(myFolder) ) {
                Files.createDirectory(myFolder);
                System.out.println("가계부 폴더가 생성되었습니다.");
            } else {
                System.out.println("폴더가 이미 존재합니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================== 가계부 ==========================");
        System.out.println("[1]내역 추가 [2]내역 조회 [3]삭제 [4]프로그램 종료");
        System.out.println("원하시는 메뉴를 선택하세요.");
        System.out.println("===========================================================");

        return sc.nextInt();
    }

    @Override
    public void addHistory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("추가하실 항목을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("항목의 금액을 입력해주세요.");
        String price = sc.nextLine();

        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        todayFile = myFolder.resolve(today + ".txt");

        if ( Files.notExists(todayFile) ) {
            try ( FileOutputStream fos = new FileOutputStream(todayFile.toFile()) ) {
                String content = name + " : " + price + "\n";
                fos.write(content.getBytes());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try(Writer writer = new FileWriter(todayFile.toFile())) {
                String content = name + " : " + price + "\n";
                writer.write(content);
            }
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void printHistory() {

    }

    @Override
    public void deleteHistory() {

    }

    @Override
    public String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().format(formatter);
    }
}
