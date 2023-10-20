# 설계기

[키오스크 ,,근데 이제 디자인패턴을 곁들인,,](https://vanillacake369.notion.site/d73e0712619d44fa902560e1a83753b3?pvs=4)

# 도메인 설계

> 컴포지트 패턴 사용하여 item 인터페이스로로 menu와 product를 뭉치려고 하였습니다.

- Item < Interface > : 아이템
    - Menu : 메뉴 구현체
    - Product : 상품 구현체
        - ProductType : 상품 타입
        - Bucket : 상품 장바구니
- Order < Interface > : 주문
    - OrderImpl : 주문 구현체
    - OrderState : 주문 상태(==주문 타입)

# 디렉토리

```editorconfig
- app : 실행부 디렉토리

- common:공통 인터페이스 // 삭제, 외부에서 주입하는 패턴을 통해 갈아끼울 생각했으나 지금 컨텍스트에 맞지 않아 오버엔지니어링이라고 판단.

- item:아이템 디렉토리
- menu:메뉴에 대한 컨트롤러/서비스/엔티티/뷰
- controller
- service
- view
- product:상품에 대한 컨트롤러/서비스/엔티티/뷰
- controller
- service
- view

- order: 상품에 대한 컨트롤러/서비스/엔티티/뷰
- controller
- service
- view

- utils:각종 모듈 혹은 로직 지원
```

# 역할 설계

>
> - Main :: Application 실행
>
>
> - Application :: 컨틀롤러, 뷰, 서비스 관리
    >
    >

- 원래 여기서 입/출력 다 하려고 했는데, 입/출력이 전체 로직과 의존관계가 높은 친구라 컨트롤러에 주입하기로 결정

>
>
> - 각 도메인 별 Controller :: 컨텍스트에 따른 Service 호출
>
>
> - 각 도메인 별 Service :: 비즈니스 로직 구현
>
>
> - 각 도메인 별 View :: 화면 구성