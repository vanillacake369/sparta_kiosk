# 설계기

[키오스크 ,,근데 이제 디자인패턴을 곁들인,,](https://vanillacake369.notion.site/d73e0712619d44fa902560e1a83753b3?pvs=4)

# 도메인 설계

- item < Interface >
    - menu
      - 
    - product
      - 
- order < Interface >

# 디렉토리

```editorconfig
- app
- :실행 객체
  - item
  - menu
  -:메뉴에 대한 컨트롤러/서비스/엔티티/뷰
  - product
  -: 메뉴에 대한 컨트롤러/서비스/엔티티/뷰
     - order
     -:메뉴에 대한 컨트롤러/서비스/엔티티/뷰
     - product_bucket
     -:메뉴에 대한 컨트롤러/서비스/엔티티/뷰
     - utils
-:각종 모듈 혹은 로직 지원
```

# 역할 설계

>
> Main :: Application 실행
>
> Application :: 컨틀롤러, 뷰, 서비스 관리
>
>   => 원래 여기서 입/출력 다 하려고 했는데, 입/출력이 전체 로직과 의존관계가 높은 친구라 컨트롤러에 주입하기로 결정
>
> 각 도메인 별 Controller :: 컨텍스트에 따른 Service 호출
>
> 각 도메인 별 Service :: 비즈니스 로직 구현
>
> 각 도메인 별 View :: 화면 구성