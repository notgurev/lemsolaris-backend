package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.repositories.AnomalyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnomalyService {
    private final AnomalyRepository anomalyRepository;

    public AnomalyService(AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    public Collection<Anomaly> getExploredAnomalies() {
        return anomalyRepository.getAnomaliesByStatusAndHazardLevel("Explored", "Non-dangerous");
    }

    public Collection<Anomaly> getUnexploredAnomalies() {
        return anomalyRepository.getAnomaliesByStatus("Unexplored");
    }
}
