package home.example.springreactivecontroller.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest({HelloApiController.class, HelloController.class})
public class HelloControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void reactiveControllerTest() {
		webTestClient.get().uri("/v1/hello")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("World!");
	}
}