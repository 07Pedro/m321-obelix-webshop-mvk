package ch.bbw.obelix.webshop.service;

import ch.bbw.obelix.quarry.api.QuarryApi;
import ch.bbw.obelix.quarry.dto.MenhirDto;
import ch.bbw.obelix.webshop.configuration.QuarryProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;
import java.util.UUID;

@Service
public class QuarryWebclientService implements QuarryApi {

    private final QuarryApi quarryApi;

    public QuarryWebclientService(QuarryProperties quarryProperties) {
        var client = WebClient.builder().baseUrl(quarryProperties.baseUrl()).build();
        var adapter = WebClientAdapter.create(client);
        var factory = HttpServiceProxyFactory.builderFor(adapter).build();
        quarryApi = factory.createClient(QuarryApi.class);
    }

    @Override
    public List<MenhirDto> getAllMenhirs() {
        // get all menhirs from quarry
        return quarryApi.getAllMenhirs();
    }

    @Override
    public MenhirDto getMenhirById(UUID menhirId) {
        // get specific menhir from quarry by ID
        return quarryApi.getMenhirById(menhirId);
    }

    @Override
    public void deleteById(UUID menhirId) {
        // delete specific mehir by id
        quarryApi.deleteById(menhirId);
    }
}
