package com.himedia.java;

// * super
// super 는 자식 클래스에서 조상 클래스로부터 상속받는 멤버를 참조하는데 사용되는 참조 변수이다.
// 멤버 변수와 지역 변수 이름이 같을 때 this를 붙여 구별했듯이 상속받은 멤버와 자신의 멤버와 이름이 같을 때는
// super 를 붙여서 구별할 수 있다.
// 조상 클래스로부터 상속받은 멤버도 자식 클래스 자신의 멤버이므로 super 대신 this를 사용할 수 있다.
// 그래도 조상 클래스의 멤버와 자식 클래스의 멤버가 중복 정의되어 서로 구별해야하는 경우에만 super를 사용하는게 좋다.
// 조상의 멤버와 자신의 멤버를 구별하는데 사용된다느 점을 제외하고는 super와 this는 근본적으로는 같다.
// 모든 인스턴스메스에는 자신이 속한 인스턴스의 주소가 지역변수로 저장되는데, 이것이 참조변수인 this와 super의 값이 된다.
// static 메서드는 인스턴스와 관련이 없다.
// 그래서 this와 super는 static 메서드에서는 사용할 수 없고, 인스턴스에서만 사용할 수 있다.

public class I_super {
    public static void main(String[] args) {
        I_child child = new I_child();
        String location = child.getLocation();
        System.out.println(location);

        child.method();
    }
}
