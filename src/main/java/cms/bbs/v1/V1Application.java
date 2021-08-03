package cms.bbs.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class V1Application {

    /* 주석 추가 */
    public static void main(String[] args) {
        SpringApplication.run(V1Application.class, args);
    }

}
