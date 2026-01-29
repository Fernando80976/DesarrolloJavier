package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class JokeService {

    private final WebClient webClient;

    public JokeService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Quote getRandomJoke() {
        return webClient.get()
                .uri("/random_joke")
                .retrieve()
                .bodyToMono(Quote.class)
                .block(); // bloqueante para modo síncrono
    }
}
