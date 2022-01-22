package lemsolaris.model.reports;

import javax.persistence.*;

@Entity
@Table(name = "tour_report")
public class TourReport {
    private int id;
    private boolean successful;
    private int profit;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "successful", nullable = false)
    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    @Basic
    @Column(name = "profit", nullable = false)
    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourReport that = (TourReport) o;

        if (id != that.id) return false;
        if (successful != that.successful) return false;
        if (profit != that.profit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (successful ? 1 : 0);
        result = 31 * result + profit;
        return result;
    }
}
