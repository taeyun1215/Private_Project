# Private_Project

### 회원 도메인 설계

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
