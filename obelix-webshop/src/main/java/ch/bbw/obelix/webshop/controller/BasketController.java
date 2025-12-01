package ch.bbw.obelix.webshop.controller;

import ch.bbw.obelix.quarry.dto.BasketDto;
import ch.bbw.obelix.webshop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
public class BasketController {
    // Controller for Basket
    private final BasketService basketService;

    @PostMapping("/offer")
    // returns basket offers
    public BasketDto offer(@RequestBody BasketDto.BasketItem basketItem) {
        return basketService.offer(basketItem);
    }

    @PostMapping("/leave")
    // leaves basket
    public void leave() {
        basketService.leave();
    }

    @PostMapping("/exchange/{menhirId}")
    // exchange menhirs
    public void exchange(@PathVariable UUID menhirId) {
        basketService.exchange(menhirId);
    }
}
