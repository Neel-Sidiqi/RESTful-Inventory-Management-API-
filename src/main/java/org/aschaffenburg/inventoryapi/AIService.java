package org.aschaffenburg.inventoryapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
@Service
public class AIService {

    private final ProductRepository productRepository;

    public AIService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String ask(String question) {

        List<Product> products = productRepository.findAll();

        String inventoryText = formatInventory(products);

        String prompt = buildPrompt(inventoryText, question);

        return callOllama(prompt);
    }

    private String formatInventory(List<Product> products) {
        return products.stream()
                .map(p -> "- " + p.getName() + ": " + p.getQuantity() + " units")
                .collect(Collectors.joining("\n"));
    }

    private String buildPrompt(String inventory, String question) {
        return """
        You are a strict, literal inventory assistant. 
        
        Your job is to answer user questions based EXCLUSIVELY on the provided inventory data.

        RULES:
        - DO NOT invent, assume, or guess any business rules, baselines, or reorder points.
        - Answer purely based on the numbers provided. Use basic math correctly.
        - If a product is not listed in the data, state that it is missing.
        - Keep your answer factual and concise.

        INVENTORY DATA:
        %s

        USER QUESTION:
        %s

        ANSWER:
        """.formatted(inventory, question);
    }
    

    private String callOllama(String prompt) {

        String url = "http://localhost:11434/api/generate";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> request = Map.of(
                "model", "llama3",
                "prompt", prompt,
                "stream", false
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(request, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                url,
                entity,
                Map.class
        );

        return (String) response.getBody().get("response");
    }

}