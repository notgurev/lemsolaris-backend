package lemsolaris.services.reports.interfaces;

public interface IReportsGenerator {
    void create_report_of_anomaly(int anomaly_id);
    void create_report_of_tour(int tour_id);
}
