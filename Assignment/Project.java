package Assignment;

import java.time.LocalDate;

public class Project {
    private String id;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Project(String id, LocalDate dateFrom, LocalDate dateTo) {
        setId(id);
        setDateFrom(dateFrom);
        setDateTo(dateTo);
    }


    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    private void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    private void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}
