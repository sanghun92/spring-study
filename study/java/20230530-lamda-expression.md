#### [ 람다 표현식 ]

람다 표현식은 간단히 말해 메소드를 하나의 식으로 표현한 것이다.  
즉, 식별자 없이 실행할 수 있는 함수 표현식을 의미하며, 익명 함수라고도 부른다.

메소드를 이렇게 람다 표현식으로 표현하면 클래스를 만들고 객체를 생성하지 않아도 메소드를 사용 할 수 있다.  
또한, 람다 표현식은 메소드의 매개 변수로 전달 될 수도 있고, 메소드의 결괏값으로 반환될 수도 있다.

이러한 람다 표현식은 **_기존의 불필요한 코드를 줄여주고, 작성 된 코드의 가독성을 높이는데 목적이 있다._**

-----------------------

#### [ 람다 표현식 사용시 유의할점 ]
1. 매개 변수의 타입을 추론할 수 있는 경우에는 타입을 생략할 수 있다.
2. 매개변수가 하나인 경우에는 괄호( () )를 생략할 수 있다.
3. 함수의 몸체가 하나인 명령문만으로 이루어진 경우에는 중괄호( {} )를 생략할 수 있다.
4. 함수의 몸체가 하나의 return문으로만 이루어진 경우에는 중괄호( {} )를 생략할 수 없다.
5. return문 대신 표현식을 사용 할 수 있으며, 이떄 반환값은 표현식의 결괏값이 된다.
