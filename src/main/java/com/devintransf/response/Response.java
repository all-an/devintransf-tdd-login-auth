package com.devintransf.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> { //classe generica Response
	
	private T data;
	private List<String> errors;
	
	
	
}
