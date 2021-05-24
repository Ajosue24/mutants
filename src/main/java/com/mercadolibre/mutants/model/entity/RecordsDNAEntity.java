package com.mercadolibre.mutants.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "records_dna")
public class RecordsDNAEntity implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(unique=true,nullable = false)
    private String dna;

    @Column(nullable = false)
    private boolean isMutant;

    public RecordsDNAEntity(String dna, boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }
}
