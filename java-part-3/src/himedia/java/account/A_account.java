package himedia.java.account;

public interface A_account {

    void printCreateAccountMenu();
    String createAccountNum();
    boolean checkDuplicateNum(int[] accountNums, int tmp, int idx);
    int printMenu();
    void addMoney();
    void subMoney();
    String getNowDateTime();
    void printHistory();
}
