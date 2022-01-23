package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.anomaly.AnomalyStatus;
import lemsolaris.model.anomaly.AnomalyType;
import lemsolaris.model.anomaly.HazardLevel;
import lemsolaris.repositories.AnomalyRepository;
import lemsolaris.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static lemsolaris.util.RandomUtil.randomFromArray;
import static lemsolaris.util.RandomUtil.randomIntInRange;

@Service
public class AnomalyService {
    private final AnomalyRepository anomalyRepository;

    @Autowired
    public AnomalyService(AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    public Collection<Anomaly> getSafeExploredAnomalies() {
        return anomalyRepository.getAnomaliesByStatusAndHazardLevel(AnomalyStatus.Explored, HazardLevel.Safe);
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

    private static final HazardLevel[] hazardLevels = {HazardLevel.Safe, HazardLevel.Dangerous};
    private static final AnomalyType[] anomalyTypes = {AnomalyType.NonStructural, AnomalyType.Structural};

    public Anomaly exploreAnomaly(Anomaly a) {
        a.setStatus(AnomalyStatus.Explored);
        a.setHazardLevel(randomFromArray(hazardLevels));
        a.setType(RandomUtil.randomFromArray(anomalyTypes));
        if (a.getHazardLevel() == HazardLevel.Dangerous) {
            a.setFlightRadius(randomIntInRange(50, 100));
        }
        return a;
    }
}
