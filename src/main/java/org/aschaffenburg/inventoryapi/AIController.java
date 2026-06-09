package org.aschaffenburg.inventoryapi;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/ai")
public class AIController {
    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/query")
    public String askQuestion(@RequestBody AIRequest request) {
        return aiService.ask(request.getQuestion());
    }

}
