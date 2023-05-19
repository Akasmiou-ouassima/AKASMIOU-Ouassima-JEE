package org.sid.ebankingbackend;

import jakarta.transaction.Transactional;
import org.sid.ebankingbackend.entities.*;
import org.sid.ebankingbackend.enums.AccountStatus;
import org.sid.ebankingbackend.enums.OperationType;
import org.sid.ebankingbackend.repositories.AccountOperationRepository;
import org.sid.ebankingbackend.repositories.BankAccountRepository;
import org.sid.ebankingbackend.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner CommandLineRunner(BankAccountRepository bankAccountRepository) {
        return args -> {
            BankAccount bankAccount1 = bankAccountRepository.findById("4f0a5499-79c1-42cb-bd14-0738ce0f3fa7").orElse(null);
            if (bankAccount1 != null) {
                System.out.println("***********************************");
                System.out.println(bankAccount1.getId());
                System.out.println(bankAccount1.getBalance());
                System.out.println(bankAccount1.getStatus());
                System.out.println(bankAccount1.getCreatedAt());
                System.out.println(bankAccount1.getCustomer().getName());
                System.out.println(bankAccount1.getClass().getName());
                if (bankAccount1 instanceof CurrentAccount) {
                    System.out.println("Over Draft " + ((CurrentAccount) bankAccount1).getOverDraft());
                } else if (bankAccount1 instanceof SavingAccount) {
                    System.out.println("Rate " + ((SavingAccount) bankAccount1).getInterestRate());
                }
                bankAccount1.getAccountOperations().forEach(accountOperation -> {
                    System.out.println("------------------------------");
                    System.out.println(accountOperation.getId());
                    System.out.println(accountOperation.getAmount());
                    System.out.println(accountOperation.getOperationDate());
                    System.out.println(accountOperation.getType());
                });
            }
        };
    }

    //@Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository, AccountOperationRepository accountOperationRepository) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 9000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 9000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);
            });
            bankAccountRepository.findAll().forEach(bankAccount -> {
                for (int i = 0; i < 5; i++) {
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setAmount(Math.random() * 12000);
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setBankAccount(bankAccount);
                    accountOperation.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperationRepository.save(accountOperation);
                }

            });

        };
    }
}
