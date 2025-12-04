package ch.bbw.obelix.quarry.service;

import ch.bbw.obelix.quarry.entity.MenhirEntity;
import ch.bbw.obelix.quarry.repository.MenhirRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner demo(MenhirRepository repository) {
        return (args) -> {
            MenhirEntity menhir1 = new MenhirEntity();
            menhir1.setWeight(10.5);
            menhir1.setStoneType("Granite");
            menhir1.setDecorativeness(MenhirEntity.Decorativeness.SIMPLE);
            menhir1.setDescription("A classic, sturdy menhir.");

            MenhirEntity menhir2 = new MenhirEntity();
            menhir2.setWeight(8.2);
            menhir2.setStoneType("Sandstone");
            menhir2.setDecorativeness(MenhirEntity.Decorativeness.DECORATED);
            menhir2.setDescription("A beautifully decorated sandstone menhir.");

            MenhirEntity menhir3 = new MenhirEntity();
            menhir3.setWeight(15.0);
            menhir3.setStoneType("Marble");
            menhir3.setDecorativeness(MenhirEntity.Decorativeness.MASTERWORK);
            menhir3.setDescription("A true masterpiece, crafted from the finest marble.");

            repository.saveAll(List.of(menhir1, menhir2, menhir3));
        };
    }
}
