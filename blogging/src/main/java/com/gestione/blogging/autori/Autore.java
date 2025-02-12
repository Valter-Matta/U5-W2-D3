package com.gestione.blogging.autori;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "autori")
public class Autore {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;



}