
create table _user (
       id         bigserial    not null primary key,
       birth_date date         not null,
       email      varchar(255) not null unique,
       name       varchar(255) not null,
       password   varchar(100) not null,
       phone      varchar(11)  not null,
       role       varchar(255) not null,
       url_photo  varchar(255),
       created_at timestamp not null,
       updated_at timestamp not null,
       deleted_at timestamp

);
alter table _user owner to username;
-- Inserir um usuário
INSERT INTO _user (birth_date, email, name, password, phone, role, created_at, updated_at)
VALUES ('1990-01-01', 'johndoe@example.com', 'Usuário', '$2a$10$En0EnM/pb.X3RtjkffBV3.80L7Ojkdh9x7mNThNXSBLhmv.UTid/i', '1234567890', 'CUSTOMER_CREATE,CUSTOMER_UPDATE,CUSTOMER_READ,CUSTOMER_DELETE', NOW(), NOW());

create table address (
             id           bigserial not null primary key,
             user_id      BIGINT          not null,
             is_primary   boolean default false,
             postal_code  varchar(8)     not null,
             number       int            not null,
             street       varchar(80)     not null,
             complement   varchar(100),
             neighborhood varchar(100)    not null,
             city         varchar(100)    not null,
             state        varchar(2)      not null,
             created_at   timestamp not null,
             updated_at   timestamp not null,
             deleted_at   timestamp,
             FOREIGN KEY (user_id) REFERENCES _user (id)
);
alter table address owner to username;
-- Inserir um endereço relacionado ao usuário
INSERT INTO address (user_id, is_primary, postal_code, number, street, complement, neighborhood, city, state,  created_at, updated_at)
VALUES (1, true, '01234567', 23, 'Rua Principal', 'Apto 123', 'Bairro Central', 'Cidade', 'DF', NOW(), NOW());

create table token (
    id         bigserial not null primary key,
    expired    boolean   not null,
    revoked    boolean   not null,
    jwt varchar(100000),
    token_type varchar(255),
    user_id    bigint references _user
);
alter table token owner to username;
create unique index uk_token_jwt on token (jwt);

create table store (
       id             bigserial      not null primary key,
       bio            varchar(1000),
       cnpj           varchar(14),
       cpf            varchar(11),
       delivery_price double precision   not null,
       name           varchar(255)       not null,
       phone          varchar(11)        not null,
       url_photo      varchar(255)
);
alter table store owner to username;