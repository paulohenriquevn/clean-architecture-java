CREATE TABLE public.entidade
(
    id integer NOT NULL
);

ALTER TABLE public.entidade OWNER to postgres;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE public.entidade TO postgres;


COMMENT ON TABLE public.entidade IS 'Entidade';
