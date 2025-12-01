package ch.bbw.obelix.quarry.controller;


import ch.bbw.obelix.quarry.api.QuarryApi;
import ch.bbw.obelix.quarry.dto.MenhirDto;
import ch.bbw.obelix.quarry.service.QuarryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class QuarryController implements QuarryApi {

    // controller for Quarry
    private final QuarryService quarryService;

    @Override
    public List<MenhirDto> getAllMenhirs() {
        return quarryService.getAllMenhirs(); // controllerfunction to get all menhirs
    }

    @Override
    public MenhirDto getMenhirById(UUID menhirId) {
        return quarryService.getMenhirById(menhirId); // controllerfunction to get specific Menhir
    }

    @Override
    public void deleteById(UUID menhirId) {
        quarryService.deleteById(menhirId); // controllerfunction to delete specific menhir
    }

}
