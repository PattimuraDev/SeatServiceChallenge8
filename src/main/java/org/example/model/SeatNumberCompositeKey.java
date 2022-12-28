package org.example.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Kelas untuk memodelkan table/entity composite key dari seat
 * @author Dwi Satria Patra
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatNumberCompositeKey implements Serializable {
    @Schema(example = "23")
    private String nomorBarisKursi;
    @Schema(example = "E")
    private String nomorKolomKursi;
}
