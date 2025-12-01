package ch.bbw.obelix.webshop.controller;

import ch.bbw.obelix.quarry.dto.MenhirDto;
import ch.bbw.obelix.webshop.service.QuarryWebclientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/menhirs")
@RequiredArgsConstructor
public class MenhirController {

    private final QuarryWebclientService quarryWebclientService;

    @GetMapping
    // get all menhirs
    public List<MenhirDto> getAllMenhirs() {
        return quarryWebclientService.getAllMenhirs();
    }

    @GetMapping("/{menhirId}")
    // get specific menhir by id
    public MenhirDto getMenhirById(@PathVariable UUID menhirId) {
        return quarryWebclientService.getMenhirById(menhirId);
    }
}
