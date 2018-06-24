package ru.kharkov.tinkoff.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static ru.kharkov.tinkoff.utils.DateUtils.SIMPLE_DATE_FORMATTER;

/**
 * @author m.kharkov
 * @since 22.06.18
 */
@Getter
@Setter
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "dt_created")
    private LocalDateTime dtCreated;

    @Column(name = "product_name")
    private String productName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public String getDtCreatedPretty() {
        return (dtCreated == null) ? null : SIMPLE_DATE_FORMATTER.format(dtCreated);
    }
}
