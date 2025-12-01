package ch.bbw.obelix.quarry.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Singular;
import lombok.With;

import java.util.List;

@Builder(toBuilder = true)
@With
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record BasketDto(
        // DTO -> Datapackage which can be sent betwen services
        @Singular
        List<BasketItem> items
) {
    public static BasketDto empty() {
        return BasketDto.builder().build();
    }

    public record BasketItem(
            String name,
            int count
    ) {
    }
}
