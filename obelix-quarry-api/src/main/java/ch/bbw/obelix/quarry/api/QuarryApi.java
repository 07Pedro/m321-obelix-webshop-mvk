package ch.bbw.obelix.quarry.api;

import ch.bbw.obelix.quarry.dto.MenhirDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;
import java.util.UUID;

@HttpExchange("/api") // Endpoint /api
public interface QuarryApi {

    @GetExchange("/menhirs")
    List<MenhirDto> getAllMenhirs(); // get all Menhirs

    @GetExchange("/menhirs/{menhirId}")
    MenhirDto getMenhirById(@PathVariable UUID menhirId); // get specific Menhir by Id

    @DeleteExchange("/quarry/{menhirId}")
    void deleteById(@PathVariable UUID menhirId); // delete specific Menhir
}
