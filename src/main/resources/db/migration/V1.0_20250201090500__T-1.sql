CREATE SEQUENCE IF NOT EXISTS public.sequence_pauta
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE pauta (
  id_pauta bigint NOT NULL,
  titulo character VARYING(255) NULL,
  descricao character VARYING(2000) NOT NULL,
  data_cadastro timestamp without time zone,
  data_alteracao timestamp without time zone,
  ativo BOOLEAN NOT NULL,
  PRIMARY KEY ("id_pauta")
);

CREATE SEQUENCE IF NOT EXISTS public.sequence_sessao_voto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE sessao_voto (
  id_sessao_voto bigint NOT NULL,
  id_pauta bigint NOT NULL,
  data_abertura timestamp without time zone,
  data_fechamento timestamp without time zone,
  data_cadastro timestamp without time zone,
  data_alteracao timestamp without time zone,
  ativo BOOLEAN NOT NULL,
  PRIMARY KEY ("id_sessao_voto"),
  CONSTRAINT "fk5c3fbc0f428c7826d8f203fae88f2153" FOREIGN KEY ("id_pauta") REFERENCES "public"."pauta" ("id_pauta")
);

CREATE SEQUENCE IF NOT EXISTS public.sequence_voto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE voto (
  id_voto bigint NOT NULL,
  id_pauta bigint NOT NULL,
  id_associado bigint NOT NULL,
  tipo_voto character VARYING(10) NULL,
  data_cadastro timestamp without time zone,
  data_alteracao timestamp without time zone,
  ativo BOOLEAN NOT NULL,
  PRIMARY KEY ("id_voto"),
  CONSTRAINT "fkc69206c55d1d734fa19c01fa44fe3b95" FOREIGN KEY ("id_pauta") REFERENCES "public"."pauta" ("id_pauta"),
  CONSTRAINT "fk2f153e580034ba286139f100fdb3dd3d" FOREIGN KEY ("id_associado") REFERENCES "public"."associado" ("id_associado")
);

CREATE INDEX idx_voto_tipo_voto ON voto (tipo_voto);
CREATE INDEX idx_sessao_voto_data_fechamento ON sessao_voto (data_fechamento);

