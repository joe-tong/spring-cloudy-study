package com.tpp.ms_consumer_hystrix_command.compent;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by smlz on 2019/4/12.
 */
@Slf4j
public class HystrixCommandDefination extends HystrixCommand<String> {

    private Integer userId;

    private RestTemplate restTemplate;

    @Override
    protected String run() throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order/" + userId, String.class);
        String body = responseEntity.getBody();
        log.info("查询出的order:{}", body);
        return body;
    }

    /**
     * 降级方法(回退)
     *
     * @return
     */
    @Override
    protected String getFallback() {
        log.info("触发降级方法========================>");

        return "-1";
    }

    //构造方法
    public HystrixCommandDefination(String commandGroupKey, RestTemplate restTemplate, Integer userId) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
        this.userId = userId;
    }
}
