package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddAppointmentUseCase {
    private AppointmentRepository appointmentRepository;

    public AddAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment cadastrarConsulta(int id, LocalDate date, LocalTime hour, String description, Veterinarian veterinarian, Pet pet, double cost, Payment payment) {
        Appointment appointment = new Appointment(id, date, hour, description, veterinarian, pet, cost, payment);
        appointmentRepository.save(appointment);
        return appointment;
    }
}
