package lemsolaris.services;

import lemsolaris.model.flight.Flight;
import lemsolaris.model.flight.FlightResource;
import lemsolaris.model.other.ResourceType;
import lemsolaris.model.other.StockResource;
import lemsolaris.repositories.FlightResourceRepository;
import lemsolaris.repositories.StockResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResourceService {

    // TODO NOT FINISHED

    // Repositories
    private final StockResourceRepository stock;
    private final FlightResourceRepository flightResources;

    @Autowired
    public ResourceService(StockResourceRepository stock, FlightResourceRepository flightResources) {
        this.stock = stock;
        this.flightResources = flightResources;
    }

    @Transactional
    public void addToFlight(ResourceType type, Flight flight, int quantity) {
        StockResource resource = stock.getByType(type);
        flightResources.save(new FlightResource(resource.getId(), flight.getId(), quantity));
    }

    @Transactional
    public void returnFromFlight(Flight flight) {
        flightResources.deleteAllByFlightId(flight.getId());
    }

    @Transactional
    public void returnPartFromFlight(Flight flight) {

    }
}
