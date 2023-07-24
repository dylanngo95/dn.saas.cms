package dn.sass.cms.user.job;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ImportUser {

    Logger logger = LoggerFactory.getLogger(ImportUser.class);

    public void count() {
        int number = 100000;
        for (int i = 1; i < number; i++) {
            this.processing(i);
            logger.info("Import user: " + i);
        }
    }

    private void processing(int n) {
        for (int i = 0 ; i < 5; i++) {
            Float result = (float) (n / 2);
        }
    }
}
