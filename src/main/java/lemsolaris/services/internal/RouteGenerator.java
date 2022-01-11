package lemsolaris.services.internal;

import lemsolaris.repositories.AnomalyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteGenerator {
    private final AnomalyRepository anomalyRepository;

    public RouteGenerator(@Autowired AnomalyRepository ar) {
        this.anomalyRepository = ar;
    }

    void generateRoute() {

    }
}
