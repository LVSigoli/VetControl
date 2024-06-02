package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private LocalDate date;
    private LocalTime hour;
    private String description;
    private Veterinarian veterinarian;
    private Pet pet;
    private AppointmentStatus status;
    private double cost;
    private Payment payment;

    public Appointment(int id, LocalDate date, LocalTime hour, String description, Veterinarian veterinarian, Pet pet, double cost, Payment payment) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.veterinarian = veterinarian;
        this.pet = pet;
        this.status = AppointmentStatus.SCHEDULED;
        this.cost = cost;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public Pet getPet() {
        return pet;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", hour=" + hour +
                ", description='" + description + '\'' +
                ", veterinarian=" + veterinarian +
                ", pet=" + pet +
                ", status=" + status +
                "payment= "+ payment+
                ", cost=" + cost +
                '}';
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }
}
