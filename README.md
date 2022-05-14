# Private_Project

## 회원 도메인 설계

- 회원 도메인 요구사항
  - 회원을 가입하고 조회할 수 있다.
  - 회원은 일반과 VIP 두 가지 등급이 있다.
  - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)

#### 회원 도메인 협력 관계
![1  회원 도메인 설계](https://user-images.githubusercontent.com/65766105/162138762-a857d406-2f1d-4d03-825f-98f9c5b3e567.JPG)

#### 회원 클래스 다이어그램
![2  회원 클래스 다이어그램](https://user-images.githubusercontent.com/65766105/162138784-c35189f4-63b3-4e90-8ab5-c2d9a37dceb8.JPG)

#### 회원 객체 다이어그램
![3  회원 객체 다이어그램](https://user-images.githubusercontent.com/65766105/162138771-dfd31cdd-4f1e-42b6-82f4-ca9db6afb93a.JPG)

### 회원 도메인 설계의 문제점
#### OCP, DIP 원칙을 지키지 못함, 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있음.



## 주문과 할인 도메인 설계

- 주문과 할인 정책
  - 회원은 상품을 주문할 수 있다.
  - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수있다.)
  - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)

#### 주문 도메인 협력, 역할, 책임
![4  주문 도메인 협력, 역할, 책임](https://user-images.githubusercontent.com/65766105/162140830-979aff0d-d465-489d-b52c-acad7818f030.JPG)

1. 주문 생성: 클라이언트는 주문 서비스에 주문 생성을 요청한다.
2. 회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을조회한다.
3. 할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
4. 주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.

#### 주문 도메인 클래스 다이어그램
![5  주문 도메인 클래스 다이어그램](https://user-images.githubusercontent.com/65766105/162141053-b75b53cc-4521-4053-96a4-15b60caff789.JPG)

### 새로운 할인 정책 개발
#### OCP, DIP 원칙을 지켰으면 새로운 할인 정책 개발을 바꿔 껴주기만 하면 끝이난다.
![6  새로운 할인 정책 개발](https://user-images.githubusercontent.com/65766105/162141721-5679057b-f795-4858-a7fb-d427ead95f42.JPG)

### AppConfig 등장
#### 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스를 만들자.
![7  Appconfig 다이어그램](https://user-images.githubusercontent.com/65766105/162142483-e1233082-2f08-4333-8f08-2b02c541b39f.JPG)



### 중간정리
- AppConfig를 통해서 관심사를 확실하게 분리함.
- AppConfig는 공연 기획자임.
- AppConfig는 구체 클래스를 선택한다. 배역에 맞는 담당 배우를 선택함. 애플리케이션이 어떻게 동작해야 할지 전체 구성을 책임짐.
- 이제 각 배우들은 담당 기능을 실행하는 책임만 지면 됨.
- OrderServiceImpl 은 기능을 실행하는 책임만 지면 됨.

#### 새로운 할인 정책(변경 전)
![8  새로운 구조와 할인 정책 적용(변경 전)](https://user-images.githubusercontent.com/65766105/162143473-45bdcfc6-1593-4809-a414-89d821f3e0c8.JPG)

#### 새로운 할인 정책(변경 후)
![9  새로운 구조와 할인 정책 적용(변경 후)](https://user-images.githubusercontent.com/65766105/162143498-af71154a-5c20-4d3e-9269-048571de869c.JPG)

#### FixDiscountPolicy RateDiscountPolicy 로 변경해도 구성 영역만 영향을 받고, 사용 영역은 전혀 영향을 받지 않음.



## 전체 흐름 정리
- 새로운 할인 정책 개발
- 새로운 할인 정책 적용과 문제점
- 관심사의 분리
- AppConfig 리팩터링
- 새로운 구조와 할인 정책 적용


### "스프링 핵심 원리 이해2 - 객체지향 원리 적용" 까지 회고록
https://taeyun1215.notion.site/2-7463dcb8ea7f4f3082dc8e0673cdca12

여기서부터 이어서 쓰기










