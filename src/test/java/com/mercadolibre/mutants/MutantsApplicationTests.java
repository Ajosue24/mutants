package com.mercadolibre.mutants;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MutantsApplicationTests {

    @Test
    void contextLoads() {
        String[] args = {"a", "b"};
        MutantsApplication.main(args);
    }
}

