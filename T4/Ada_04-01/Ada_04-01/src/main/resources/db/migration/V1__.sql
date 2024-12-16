CREATE SEQUENCE IF NOT EXISTS clientes_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS pedidos_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS talleres_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE cliente_taller_fk
(
    cliente_id INTEGER NOT NULL,
    taller_id  INTEGER NOT NULL
);

CREATE TABLE clientes
(
    id           INTEGER NOT NULL,
    nombre       VARCHAR(255),
    id_direccion INTEGER,
    CONSTRAINT pk_clientes PRIMARY KEY (id)
);

CREATE TABLE direcciones
(
    id        INTEGER NOT NULL,
    direccion VARCHAR(255),
    CONSTRAINT pk_direcciones PRIMARY KEY (id)
);

CREATE TABLE pedidos
(
    codigo      INTEGER NOT NULL,
    descripcion VARCHAR(255),
    taller_id   INTEGER,
    cliente_id  INTEGER,
    CONSTRAINT pk_pedidos PRIMARY KEY (codigo)
);

CREATE TABLE talleres
(
    id           INTEGER NOT NULL,
    id_direccion INTEGER,
    CONSTRAINT pk_talleres PRIMARY KEY (id)
);

ALTER TABLE clientes
    ADD CONSTRAINT uc_clientes_id_direccion UNIQUE (id_direccion);

ALTER TABLE talleres
    ADD CONSTRAINT uc_talleres_id_direccion UNIQUE (id_direccion);

ALTER TABLE clientes
    ADD CONSTRAINT FK_CLIENTES_ON_ID_DIRECCION FOREIGN KEY (id_direccion) REFERENCES direcciones (id);

ALTER TABLE pedidos
    ADD CONSTRAINT FK_PEDIDOS_ON_CLIENTE FOREIGN KEY (cliente_id) REFERENCES clientes (id);

ALTER TABLE pedidos
    ADD CONSTRAINT FK_PEDIDOS_ON_TALLER FOREIGN KEY (taller_id) REFERENCES talleres (id);

ALTER TABLE talleres
    ADD CONSTRAINT FK_TALLERES_ON_ID_DIRECCION FOREIGN KEY (id_direccion) REFERENCES direcciones (id);

ALTER TABLE cliente_taller_fk
    ADD CONSTRAINT fk_clitalfk_on_cliente FOREIGN KEY (cliente_id) REFERENCES clientes (id);

ALTER TABLE cliente_taller_fk
    ADD CONSTRAINT fk_clitalfk_on_taller FOREIGN KEY (taller_id) REFERENCES talleres (id);