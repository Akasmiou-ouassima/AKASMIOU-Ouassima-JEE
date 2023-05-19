package org.sid.ebankingbackend.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.repositories.AccountOperationRepository;
import org.sid.ebankingbackend.repositories.BankAccountRepository;
import org.sid.ebankingbackend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private CustomerRepository customerRepository;
    private AccountOperationRepository accountOperationRepository;
   // Logger log= LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new customer {} ",customer.getName());
       Customer savedCustomer= customerRepository.save(customer);
        return savedCustomer;
    }
    @Override
    public BankAccount saveBankAccount(double initialBalance, String Type, Long customerId) {
       Customer customer= customerRepository.findById(customerId).orElse(null);
       if(customer == null)
           throw new RuntimeException("Customer not found");
       BankAccount bankAccount;
        if(Type.equals("Current"))
            bankAccount=new CurrentAccount();
        else
            bankAccount=new SavingAccount();
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        bankAccount.setBalance(initialBalance);
        bankAccount.setCustomer(customerRepository.findById(customerId).get());

        return bankAccount;
    }

    @Override
    public List<Customer> listCustomers() {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }
    @Override
    public void debit(String accountId, double amount, String description) {

    }
    @Override
    public void credit(String accountId, double amount, String description) {

    }
    @Override
    public void transfer(String AccountIdSource, String AccountIdDestination, double amount) {

    }
}
