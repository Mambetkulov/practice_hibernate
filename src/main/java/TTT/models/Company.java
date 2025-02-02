package TTT.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@ToString
@Builder
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "com_id")
    @SequenceGenerator(name = "com_id",sequenceName = "comsec",allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    private LocalDate birthday;

    @OneToMany(mappedBy = "company")
    private List<Programmer> staff ;

    public Company(String name, String address) {
        this.name = name;
        this.address = address;

    }

    @PrePersist @PreUpdate
    public void prePersist() {
        birthday = LocalDate.now();
    }
}
