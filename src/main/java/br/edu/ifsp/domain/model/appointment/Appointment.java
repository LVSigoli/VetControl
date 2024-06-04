package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetStatus;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private LocalDate date;
    private LocalTime hour;
    private String description;
    private Veterinarian veterinarian;
    private Pet pet;
    private Client client;
    private AppointmentStatus status;
    private double cost;
    private Payment payment;

    public Appointment(int id, LocalDate date, LocalTime hour, String description, Veterinarian veterinarian, Pet pet, Client client, double cost, Payment payment) {
        validateEntities(veterinarian, pet, client);
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.veterinarian = veterinarian;
        this.pet = pet;
        this.client = client;
        this.status = AppointmentStatus.SCHEDULED;
        this.cost = cost;
        this.payment = payment;
    }

    private void validateEntities(Veterinarian veterinarian, Pet pet, Client client) {
        if (veterinarian.InformVeterinarinaSatus() != VeterinarianStatus.ACTIVE) {
            throw new IllegalArgumentException("Veterinarian is not active.");
        }
        if (pet.InformPetStautus() != PetStatus.ACTIVE) {
            throw new IllegalArgumentException("Pet is not active.");
        }
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

    public Client getClient() {
        return client;
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
                ", client=" + client +
                ", status=" + status +
                ", payment=" + payment +
                ", cost=" + cost +
                '}';
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        validateVeterinarian(veterinarian);
        this.veterinarian = veterinarian;
    }

    private void validateVeterinarian(Veterinarian veterinarian) {
        if (veterinarian.InformVeterinarinaSatus() != VeterinarianStatus.ACTIVE) {
            throw new IllegalArgumentException("Veterinarian is not active.");
        }
    }
}
