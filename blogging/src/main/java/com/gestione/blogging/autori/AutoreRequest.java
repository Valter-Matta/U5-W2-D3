package com.gestione.blogging.autori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoreRequest {
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;


}
