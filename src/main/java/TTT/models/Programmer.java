package TTT.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;


import java.math.BigDecimal;

@Entity
@Table(name = "programmers")
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prog_id")
    @SequenceGenerator(name = "prog_id", sequenceName = "prog_seq",allocationSize = 1)
    private Long id;

    @Column(name = "first_name",nullable = false,length = 50)
    private String name;
    @Column(name = "last_name")
    private String surname;
    private BigDecimal salary;
    @Column(unique = true,length = 20,name = "email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Некорректный email")
    private String email;

    @ManyToOne
    private Company company;

}
