package br.edu.ifsp.domain.model.client;

import br.edu.ifsp.domain.usecases.pet.*;

public class PetServices {
    private PetRepository petRepository;
    private ClientRepository clientRepository;

    public PetServices(PetRepository petRepository, ClientRepository clientRepository) {
        this.petRepository = petRepository;
        this.clientRepository = clientRepository;
    }

    public void addPet(int id, String name, String breed, String species, Client owner) {
        AddPetUseCase addPetUseCase = new AddPetUseCase(petRepository);
        addPetUseCase.cadastrarPet(id, name, breed, species, owner, PetStatus.ACTIVE);
    }

    public void updatePet(int id, String newName, String newBreed, String newSpecies) {
        UpdatePetUseCase updatePetUseCase = new UpdatePetUseCase(petRepository);
        updatePetUseCase.alterarPet(id, newName, newBreed, newSpecies);
    }

    public Pet findPet(int id) {
        FindPetUseCase findPetUseCase = new FindPetUseCase(petRepository);
        return findPetUseCase.visualizarPet(id);
    }

    public void deactivatePet(int id) {
        DeactivatePetUseCase deactivatePetUseCase = new DeactivatePetUseCase(petRepository);
        deactivatePetUseCase.inativarPet(id);
    }

    public void AddPetToCLient(Pet pet, CPF cpf){
     RegisterPetToClientUseCase petToCliente = new RegisterPetToClientUseCase(petRepository, clientRepository);
     petToCliente.cadastrarPet(cpf, pet);
    }
}
