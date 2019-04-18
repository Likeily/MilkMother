package com.milkmother.app.domain;

import java.io.Serializable;

public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	private Estado estado;
}
