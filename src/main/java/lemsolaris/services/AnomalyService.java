package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.anomaly.AnomalyStatus;
import lemsolaris.repositories.AnomalyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AnomalyService {
    private final AnomalyRepository anomalyRepository;

    @Autowired
    public AnomalyService(AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    public Collection<Anomaly> getExploredAnomalies() {
        return anomalyRepository.getAnomaliesByStatusAndHazardLevel(AnomalyStatus.Explored, "Non-dangerous");
    }

    public Collection<Anomaly> getUnexploredAnomalies() {
        return anomalyRepository.getAnomaliesByStatus(AnomalyStatus.Unexplored);
    }

    public Anomaly findAnomalyById(long id) {
        Optional<Anomaly> a = anomalyRepository.findById(id);
        if (!a.isPresent()) {
            throw new RuntimeException("Anomaly not found by id");
        }
        return a.get();
    }
}
