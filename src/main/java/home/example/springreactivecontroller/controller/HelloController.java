package home.example.springreactivecontroller.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Controller
public class HelloController implements HelloApiDelegate {
	@Override
	public Mono<ResponseEntity<String>> hello(ServerWebExchange exchange) {
		return Mono.just(
				ResponseEntity.ok("World!")
		);
	}
}
