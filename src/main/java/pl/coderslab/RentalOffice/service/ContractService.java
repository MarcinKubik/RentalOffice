package pl.coderslab.RentalOffice.service;

import org.springframework.stereotype.Service;
import pl.coderslab.RentalOffice.entity.Contract;
import pl.coderslab.RentalOffice.repository.ContractRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getContracts(){
        return contractRepository.findAll();
    }

    public Optional<Contract> get(Long id){
        Optional<Contract> optionalContract = contractRepository.findById(id);
        return optionalContract;
    }

    public void add(Contract contract){
        contractRepository.save(contract);
    }

    public void delete(Long id){
        contractRepository.deleteById(id);
    }

    public void update(Contract contract){
        contractRepository.save(contract);
    }

    public Contract findLastAdded(){
        return contractRepository.findFirstByOrderByIdDesc();
    }
}
