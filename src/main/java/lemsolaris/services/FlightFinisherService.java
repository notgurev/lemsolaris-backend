package lemsolaris.services;

import lemsolaris.model.flight.Flight;
import lemsolaris.model.flight.FlightStatus;
import lemsolaris.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FlightFinisherService {
    // Services
    private final ReportService reportService;

    // Repositories
    private final FlightRepository<Flight> flightRepository;


    @Autowired
    public FlightFinisherService(ReportService reportService,
                                 FlightRepository<Flight> flightRepository) {
        this.reportService = reportService;
        this.flightRepository = flightRepository;
    }

    /**
     * Заканчивает полет, возвращает ресурсы, дает прибыль, создает отчет
     */
    @Transactional
    public void finishFlight(Flight f) {
        reportService.createReport(f);
        // todo вернуть ресурсы (почти все медпакеты, 0 топлива и еды)
        // todo получить деньги если туристический
        f.setStatus(FlightStatus.Finished);
    }
}
