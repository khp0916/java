package himedia.java.practice.AccountBook;

public interface AccountBook {

    int printMenu();
    void addHistory();
    void printHistory();
    void deleteHistory();
    void deleteAll();
    boolean checkDate(String date);

    String getNowDateTime();
}
