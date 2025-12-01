package ch.bbw.obelix.webshop;

import ch.bbw.obelix.quarry.dto.BasketDto;
import ch.bbw.obelix.quarry.dto.MenhirDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ObelixWebshopApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void buyMenhir() {
        List<MenhirDto> menhirs = webTestClient.get()
                .uri("/api/menhirs")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(MenhirDto.class)
                .returnResult()
                .getResponseBody();

        assertThat(menhirs).isNotNull();
        if (menhirs.isEmpty()) {
            System.err.println("WARNING: No menhirs found in the connected Quarry application. Skipping 'buy' test logic.");
            return;
        }

        var anyId = menhirs.get(0).id();

        webTestClient.post()
                .uri("/api/basket/exchange/{id}", anyId)
                .exchange()
                .expectStatus().isBadRequest();

        webTestClient.post()
                .uri("/api/basket/offer")
                .bodyValue(new BasketDto.BasketItem("boar", 2))
                .exchange()
                .expectStatus().isOk();

        webTestClient.post()
                .uri("/api/basket/exchange/{id}", anyId)
                .exchange()
                .expectStatus().isOk();

        webTestClient.post()
                .uri("/api/basket/exchange/{id}", anyId)
                .exchange()
                .expectStatus().isBadRequest();
    }
}
