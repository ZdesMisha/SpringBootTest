package ru.kharkov.tinkoff.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author m.kharkov
 * @since 22.06.18
 */
@Getter
@Setter
@Entity
public class Application {

    @Id
    @Column(name = "id")
    private Long application_id;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    @Column(name = "dt_created")
    private LocalDateTime dt_created;

    @Column(name = "product_name")
    private String product_name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
