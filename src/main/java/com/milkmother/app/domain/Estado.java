package com.milkmother.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	private List<Cidade> cidades = new ArrayList<Cidade>();
}
