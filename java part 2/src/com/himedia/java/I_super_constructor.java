package com.himedia.java;

// * super() : 조상 클래스의 생성자
// this()와 마찬가지로 super() 역시 생성자이다.
// this()는 같은 클래스의 다른 생성자를 호출하는 데 사용되지만,
// super()는 조상 클래스의 생성자를 호출하는데 사용된다.

// 자식 클래스의 인스턴스를 생성하면, 자식의 멤버와 부모의 멤버가 모두 합쳐진 하나의 인스턴스가 된다.
// 그래서 자식 클래스의 인스턴스가 부모 클래스의 멤버들을 사용할 수 있는 것이다.
// 자식 클래스의 생성자에서 조상 클래스가 호출되어야한다.

// 생성자의 첫 줄에서 조상클래스의 생성자를 호출해야하는 이유는
// 자식 클래스의 멤버가 조상 클래스의 멤버를 사용할 수도 있으므로
// 조상의 멤버들이 먼저 초기화되어 있어야 하기 때문이다.

// 이와 같은 조상 클래스 생성자의 호출은 클래스의 상속관계를 거슬러 올라가면서 계속 반복된다.
// 마지막으로 모든 클래스의 최고 조상인 Object 클래스의 생성자인 Object()까지 가서야 끝이 난다.
// 그래서 Object클래스를 제외한 모든 클래스의 생성자는 첫 줄에 반드시 자신의 다른 생성자 또는
// 조상의 생성자를 호출해야 한다.
// 그렇지 않으면 생성자는 첫 줄에 super()를 자동적으로 추가할 것이다.

// Object클래스를 제외한 모든 클래스의 생성자 첫 줄에 생성자, this() 또는 super()를 호출해야 한다.
// 그렇지 않으면 컴파일러가 super()를 생성자의 첫 줄에 삽입한다.

public class I_super_constructor {

    I_point3d point3d = new I_point3d();

}
