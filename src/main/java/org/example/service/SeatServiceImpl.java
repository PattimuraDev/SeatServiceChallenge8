package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Seat;
import org.example.model.dto.SeatDto;
import org.example.model.SeatNumberCompositeKey;
import org.example.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Kelas implementasi seat service yang menghandle semua permintaan
 * ke repository seat
 * @author Dwi Satria Patra
 */
@Service
@Transactional
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;
    // mapper untuk keperluan mapping objek
    ObjectMapper mapper = new ObjectMapper();

    /**
     * Method untuk menambah seats
     *
     * @param seat object seats yang ingin ditambahkan
     * @return object seats yang berhasil ditambahkan
     */
    @Override
    public Seat addSeats(Seat seat) {
        return seatRepository.save(seat);
    }

    /**
     * Method untuk mengupdate status kursi, apakah sudah dipesan atau belum
     *
     * @param newStatus       parameter untuk mengubah status seats
     * @param nomorBarisKursi parameter nomor baris dari kursi/seats
     * @param nomorKolomKursi parameter nomor kolom dari kursi/seats
     */
    @Override
    public void updateSeatsStatus(String newStatus, String nomorBarisKursi, String nomorKolomKursi) {
        seatRepository.repoUpdateSeats(newStatus, nomorBarisKursi, nomorKolomKursi);
    }

    /**
     * Method untuk mengambil data seat berdasarkan id
     *
     * @param seatNumberCompositeKey parameter untuk composite key dari seat yang dicari
     * @return hasil pencarian seat
     */
    @Override
    public Seat getSeatById(SeatNumberCompositeKey seatNumberCompositeKey) {
        if (seatRepository.findById(seatNumberCompositeKey).isPresent()) {
            return seatRepository.findById(seatNumberCompositeKey).get();
        } else {
            return null;
        }
    }

    /**
     * Method untuk mengambil semua seats dengan status tersedia/belum dipesan (available)
     *
     * @return list seats dengan status tersedia
     */
    @Override
    public List<Seat> getAllSeatsAvailable() {
        return seatRepository.repoGetAllSeatsAvailable();
    }

    /**
     * Method yang digunakan untuk menghapus seat berdasarkan id-nya (dalam bentuk composite key)
     *
     * @param idSeat parameter untuk id daro seat yang dimaksud (dalam bentuk composite key)
     */
    @Override
    public void deleteSeats(SeatNumberCompositeKey idSeat) {
        seatRepository.deleteById(idSeat);
    }

    /**
     * Method yang digunakan untuk memetakan objek SeatsDto menjadi Seats
     *
     * @param seatDto parameter untuk objek SeatsDto
     * @return hasil pemetaan menjadi objek Seats
     */
    @Override
    public Seat seatsDtoMapToEntity(SeatDto seatDto) {
        return mapper.convertValue(seatDto, Seat.class);
    }

}
