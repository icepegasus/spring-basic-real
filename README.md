# spring-basic-real
김영한 스프링 핵심원리 기본편 강의내용

내 Repository 중에 # spring-basic 프로젝트는 초급편 내용임 (거기도 유용한 내용 많음)

@스프링 컨테이너와 스프링 빈
@싱글톤 컨테이너 관련 내용
@ComponentScan
@DI (의존관계 자동 주입)
@빈 생명주기 콜백(@PostConstruct (빈 생성후 초기화(init)에 사용), @PreDestroy(빈 종료 직전 close와 같은 처리에 사용))
@빈 스코프
          -singleton(기본,스프링컨테이너 생성과 종료될 시점에 맞춰 빈이 생성되고 종료됨(싱글톤방식으로))
          -prototype(객체생성,DI하고 스코프 종료됨,종료콜백 호출안됨, Bean을 요청할때마다 매번 새로운 Bean이 생성됨)
          -request: HTTP 요청 하나하나 당 새로운 Bean 객체가 생성되고 요청이 종료되면 스코프 종료(삭제), 같은 HTTP 요청 내 이면 같은 객체를 사용(엄청 편함))
          -웹스코프(request, session, application 등이 있음) 
@ObjectProvider -> 객체를 사용시점에 받아와서 DL(Dependency Lookup) 해서 사용(request scope Bean과 같이 스프링뜰때 Bean생성이 불가능한 경우 사용)
@Scope 기능에 Proxy모드도 있음
