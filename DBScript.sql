DROP TABLE IF EXISTS pessoa, categoria;

CREATE TABLE public.categoria 
(
	idcategoria SERIAL NOT NULL,
	descricao character varying(255),
        CONSTRAINT categoria_pkey PRIMARY KEY (idcategoria)
);


CREATE TABLE public.pessoa
(
	idpessoa SERIAL NOT NULL,
	datanasc date,
	fkcategoria integer,
	nome character varying(255),
	sexo character(1),
	CONSTRAINT fkcategoria FOREIGN KEY (fkcategoria) REFERENCES categoria(idcategoria)
);
