CREATE SEQUENCE IF NOT EXISTS public.sequence_associado
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE associado (
  id_associado bigint NOT NULL,
  nome character VARYING(255) NULL,
  email character VARYING(255) NOT NULL,
  data_cadastro timestamp without time zone,
  data_alteracao timestamp without time zone,
  ativo BOOLEAN NOT NULL,
  PRIMARY KEY ("id_associado")
)