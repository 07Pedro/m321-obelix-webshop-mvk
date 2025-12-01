package ch.bbw.obelix.quarry.service;

import ch.bbw.obelix.quarry.dto.MenhirDto;
import ch.bbw.obelix.quarry.entity.MenhirEntity;
import ch.bbw.obelix.quarry.repository.MenhirRepository;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@Service
public class QuarryService {
    // Connect the DB with the service -> returns DTO's

    private final MenhirRepository menhirRepository;

    public QuarryService(MenhirRepository menhirRepository, MeterRegistry meterRegistry) {
        // check how many mehnirs available
        this.menhirRepository = menhirRepository;
        Gauge.builder("menhirs.available", menhirRepository, MenhirRepository::count)
                .description("The number of available menhirs in the quarry")
                .register(meterRegistry);
    }

    public List<MenhirDto> getAllMenhirs() {
        // get all menhirs from DB
        return menhirRepository.findAll().stream()
                .map(MenhirEntity::toDto)
                .toList();
    }

    public MenhirDto getMenhirById(UUID menhirId) {
        // get specific menhir from DB
        return menhirRepository.findById(menhirId)
                .map(MenhirEntity::toDto)
                .orElseThrow(() -> new UnknownMenhirException("unknown menhir with id " + menhirId));
    }

    public void deleteById(UUID menhirId) {
        // delete specific menhir by ID
        menhirRepository.deleteById(menhirId);
    }

    @StandardException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class UnknownMenhirException extends RuntimeException {}
}