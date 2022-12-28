package org.example.service;

import org.example.model.Seat;
import org.example.model.dto.SeatDto;
import org.example.model.SeatNumberCompositeKey;
import java.util.List;

/**
 * Interface service untuk menghandle semua permintaan
 * ke repository seat
 * @author Dwi Satria Patra
 */
public interface SeatService {
    Seat addSeats(Seat seats);

    void updateSeatsStatus(String newStatus, String nomorBarisKursi, String nomorKolomKursi);

    Seat getSeatById(SeatNumberCompositeKey seatNumberCompositeKey);

    List<Seat> getAllSeatsAvailable();

    void deleteSeats(SeatNumberCompositeKey idSeat);

    Seat seatsDtoMapToEntity(SeatDto seatsDto);
}
