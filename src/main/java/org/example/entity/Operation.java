package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.number.AbstractNumber;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private AbstractNumber num1;
    @OneToOne(cascade = CascadeType.ALL)
    private AbstractNumber num2;
    private String operationSign;
    @OneToOne(cascade = CascadeType.ALL)
    private AbstractNumber result;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    private Date date;

    public Operation(long id, AbstractNumber num1, AbstractNumber num2, String operationSign, AbstractNumber result, User user) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.operationSign = operationSign;
        this.result = result;
        this.user = user;
    }
}
