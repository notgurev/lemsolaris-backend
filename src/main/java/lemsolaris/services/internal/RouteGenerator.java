package lemsolaris.services.internal;

import lemsolaris.repositories.AnomalyRepository;
import lemsolaris.services.internal.interfaces.IRouteGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteGenerator implements IRouteGenerator {
    private final AnomalyRepository anomalyRepository;

    public RouteGenerator(@Autowired AnomalyRepository ar) {
        this.anomalyRepository = ar;
    }

    public void generateRoute() {

    }
}
