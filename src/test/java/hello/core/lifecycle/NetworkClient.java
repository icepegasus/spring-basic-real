package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    //@외부 라이브러리라 스스에 손대지 못해 @PostConstruct , @PreDestroy 를 사용하지 못할경우
    //@Bean 의 옵션을 활용
    //@Bean(initMethod = "init", destroyMethod = "disconnect")


    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + ", message = " + message);
    }

    @PreDestroy
    public void disconnect() {
        System.out.println("close : " + url);
    }
}
