package com.devintransf.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {
	
	private Long id;
	
	@CPF(message="Cpf inválido")
	private String cpf;
	
	@Email(message="Email inválido")
	private String email;
	
	@Length(min=3, max=50, message="O Nome deve conter entre 3 e 50 caracteres")
	private String name;
	
	@NotNull
	@Length(min=3, message="A senha deve conter no minimo 6 caracteres")
	private String password;
	
	

}
