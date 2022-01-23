package lemsolaris.services.internal;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.repositories.AnomalyRepository;
import lemsolaris.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnomalyService {
    private final AnomalyRepository anomalyRepository;
    private final ReportRepository reportRepository;

    public AnomalyService(@Autowired AnomalyRepository anomalyRepository, ReportRepository reportRepository) {
        this.anomalyRepository = anomalyRepository;
        this.reportRepository = reportRepository;
    }

    public Collection<Anomaly> getExploredAnomalies() {
        return anomalyRepository.getAnomaliesByStatusOfAnomalyAndAnomalyHazardLevel("Explored", "Non-dangerous");
    }

    public AnomalyReport getReportAnomaly(int id) {
        return reportRepository.getAnomalyReportById(id);
    }
}
