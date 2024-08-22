package com.himedia.java;

//  1. 자바 언어의 특징
//  - 운영체제에 독립적이다.
//  자바 응용프로그램은 하드웨어가 아닌 JVM(Java Virtual Machine)하고만 통신한다.
//  JVM이 자바 응용프로그램으로부터 전달받은 명령을 해당 운영체제가 이해할 수 있도록 변환하여 전달한다.
//  - 객체지향 언어이다.
//  - 자동 메모리 관리 : 자바로 작성된 프로그램이 실행되면, 가비지 컬렉터가 자동적으로 메모리를 관리해주기 때문에 프로그래머는 메모리를 따로 관리하지 않아도 된다.
//  - 멀티스레드를 지원한다.
//  - 동적 로딩을 지원한다 : 자바는 동적 로딩을 지원하기 때문에 실행 시에 모든 클래스가 로딩되지 않고 필요한 시점에 클래스를 로딩하여 사용할 수 있다는 장점이 있다.

//  2. JVM(Java Virtual Machine)
// JVM은 자바를 실행하기 위한 가상 기계라고 할 수 있다.
// 자바로 작성된 애플리케이션은 모두 이 가상 컴퓨터에서만 실행되기 때문에,
// 자바 애플리케이션이 실행되기 위해서는 반드시 JVM이 필요하다.
// 요즘엔 바이트코드(컴파일된 자바코드)를 하드웨어의 기계어로 바로 변환해주는 JIT컴파일러와
// 향상된 최적화 기술이 적용되어서 속도의 격차를 많이 줄였다.
// Java 애플리케이션은 JVM하고만 상호작용을 하기 때문에 OS와 하드웨어에 독립적이라
// 다른 OS에서도 프로그램의 변경없이 실행이 가능하다.
// 단, JVM은 OS에 종속적이기 때문에 해당 OS에서 실행가능한 JVM이 필요하다.


public class A_helloworld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
