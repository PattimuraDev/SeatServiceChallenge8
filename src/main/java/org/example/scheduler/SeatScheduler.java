package org.example.scheduler;

import org.example.model.Seat;
import org.example.service.SeatServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class SeatScheduler extends QuartzJobBean {

    @Autowired
    SeatServiceImpl seatService;

    private static final Logger LOG = LoggerFactory.getLogger(SeatScheduler.class);


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOG.info("\nscheduler is running : ");
        List<Seat> listSeats = seatService.getAllSeatsAvailable();
        for(Seat s : listSeats){
            LOG.info(
                    "Seat dengan nomor {} tersedia",
                    (s.getSeatNumberCompositeKey().getNomorBarisKursi() + s.getSeatNumberCompositeKey().getNomorKolomKursi())
            );
        }
    }
}
