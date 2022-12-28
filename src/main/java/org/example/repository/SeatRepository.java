package org.example.repository;

import org.example.model.Seat;
import org.example.model.SeatNumberCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interface repository untuk menghandle semua permintaan ke table seat di database
 * @author Dwi Satria Patra
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatNumberCompositeKey> {

    /**
     * Method query untuk melakukan custom query yang digunakan untuk mengupdate
     * status dari suatu seat/bangku berdasarkan composite key-nya
     * @param newStatus parameter untuk status baru dari seat
     * @param nomorBarisKursi parameter nomor baris seat/bangku
     * @param NomorKolomKursi parameter nomor kolom seat/bangku
     */
    @Query(value = "update seats set status = ?1 where seats.nomor_baris_kursi = ?2 and seats.nomor_kolom_kursi = ?3", nativeQuery = true)
    @Modifying
    void repoUpdateSeats(
            @Param("status") String newStatus,
            @Param("nomor_baris_kursi") String nomorBarisKursi,
            @Param("nomor_kolom_kursi") String NomorKolomKursi
    );

    /**
     * Method query untuk melakukan custom query yang digunakan untuk mencari semua
     * seat dengan status available/siap dipesan
     * @return list semua seat dengan status available (siap dipesan)
     */
    @Query(value = "select seats.nomor_baris_kursi, seats.nomor_kolom_kursi, seats.status, seats.studio_name, seats.schedule_id from seats where seats.status = 'available'", nativeQuery = true)
    List<Seat> repoGetAllSeatsAvailable();
}
