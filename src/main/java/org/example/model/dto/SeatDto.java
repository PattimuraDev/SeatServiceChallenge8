package org.example.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.example.model.SeatNumberCompositeKey;

/**
 * Kelas pemodelan DTO (data transfer object) dari seat
 * @author Dwi Satria Patra
 */
@Data
public class SeatDto {
    private SeatNumberCompositeKey seatNumberCompositeKey;
    @Schema(example = "Studio A")
    private String studioName;
    @Schema(example = "available")
    private String status;
    @Schema(example = "1")
    private Long scheduleID;
}
