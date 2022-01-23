package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.repositories.AnomalyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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

    public Anomaly findAnomalyById(long id) {
        Optional<Anomaly> a = anomalyRepository.findById(id);
        if (!a.isPresent()) {
            throw new RuntimeException("Anomaly not found by id");
        }
        return a.get();
    }
}
