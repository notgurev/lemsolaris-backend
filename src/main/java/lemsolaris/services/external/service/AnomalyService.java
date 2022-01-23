package lemsolaris.services.external.service;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.repositories.AnomalyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnomalyService {
    final
    AnomalyRepository anomalyRepository;

    public AnomalyService(AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    public Collection<Anomaly> getExploredAnomaly() {
        return anomalyRepository.getAnomaliesByStatusAndHazardLevel("Explored", "Non-dangerous");
    }

    public Collection<Anomaly> getUnexploredAnomaly() {
        return anomalyRepository.getAnomaliesByStatus("Unexplored");
    }
}
