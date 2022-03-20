package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {


    /*
    * *중요
    * MyLogger class 가 scope 가 request 인 스프링 빈이라서 그냥 MyLogger로 DI받으면
    * 스프링이 뜰때 오류가 남 : Bean 생명주기가 request 라 사용자 HTTP 요청이 있어야 생성이 되기 때문에 오류  발생
    * 그래서 ObjectProvider<T> 통해서 주입을 받음
    *
    * ObjectPrivider<T> 를 안쓰려면 ProxyMode 방식을 사용
    * MyLogger Class 에서 아래와 같이사용하면 그냥 MyLogger 로 주입(DI)받을 수 있음!
    *  -> 스프링에서 가짜 Proxy객체로 우선 주입을 해주고, 사용시점에 실제 객체의 기능을 사용할 수 있게 처리해줌
    *
      @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)

    *
    *
    * */
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = "+id);
    }

}
