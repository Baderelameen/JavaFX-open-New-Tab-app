package bdr.tableviewana.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task {
    private final IntegerProperty no = new SimpleIntegerProperty();
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> finishDate = new SimpleObjectProperty<>();
    private final StringProperty unit = new SimpleStringProperty();
    private final DoubleProperty quantity = new SimpleDoubleProperty();
    private final DoubleProperty unitPrice = new SimpleDoubleProperty();
    private final StringProperty comments = new SimpleStringProperty();

    public Task(int no, String id) {
        this.no.set(no);
        this.id.set(id);
        this.startDate.set(LocalDate.now());
        this.finishDate.set(LocalDate.now());
        this.unit.set("m²");
        this.quantity.set(0.0);
        this.unitPrice.set(0.0);
    }

    // Duration is calculated
    public long getDuration() {
        if (startDate.get() != null && finishDate.get() != null)
            return ChronoUnit.DAYS.between(startDate.get(), finishDate.get());
        return 0;
    }

    // Amount is calculated
    public double getAmount() {
        return quantity.get() * unitPrice.get();
    }

    // Getters and setters
    public IntegerProperty noProperty() { return no; }
    public StringProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty descriptionProperty() { return description; }
    public ObjectProperty<LocalDate> startDateProperty() { return startDate; }
    public ObjectProperty<LocalDate> finishDateProperty() { return finishDate; }
    public StringProperty unitProperty() { return unit; }
    public DoubleProperty quantityProperty() { return quantity; }
    public DoubleProperty unitPriceProperty() { return unitPrice; }
    public StringProperty commentsProperty() { return comments; }
}
