package lemsolaris.services.internal;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.repositories.AnomalyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnomalyService {
    private final AnomalyRepository anomalyRepository;

    public AnomalyService(@Autowired AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    public Collection<Anomaly> getExploredAnomalies() {
        // todo
        return null;
    }

    public Collection<Anomaly> getUnexploredAnomalies() {
        // todo
        return null;
    }
}
