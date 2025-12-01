package ch.bbw.obelix.quarry.entity;

import ch.bbw.obelix.quarry.dto.DecorativenessDto;
import ch.bbw.obelix.quarry.dto.MenhirDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * A standing stone proudly created in Obelix's quarry.
 */
@Entity
@Table(name = "menhirs")
@Setter
@Getter
@NoArgsConstructor
public class MenhirEntity {

    // Entity for Menhir
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private Double weight; // in tons

	@Column(nullable = false)
	private String stoneType;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Decorativeness decorativeness;

	@Column
	private String description;

	public MenhirDto toDto() {
		return new MenhirDto(getId(), getWeight(), getStoneType(), getDecorativeness().toDto(), getDescription());
        // get DTO
	}

	public enum Decorativeness {
		PLAIN, SIMPLE, DECORATED, ORNATE, MASTERWORK;

		public DecorativenessDto toDto() {
			return DecorativenessDto.valueOf(name());
		}
	}
}
