package org.sid.ebankingbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.enums.AccountStatus;
import java.util.Date;
import java.util.List;
@Entity
//@Inheritance(strategy = InheritanceType.SiNGLE_TABLE) plus pratique
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) dans ce cas on commente @DiscriminatorColumn
// @Inheritance(strategy = InheritanceType.JOINED) dans ce cas on commente @DiscriminatorColumn
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",  length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.EAGER)
    private List<AccountOperation> accountOperations;
}
