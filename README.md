# SenacBankPOO

======================================================================================
CODIGO CRIAÇÂO DAS TABELAS NO DB
======================================================================================


CREATE TABLE PessoaFisica(
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    Nome VARCHAR(255) NOT NULL,
    Sobrenome VARCHAR(255) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    DataNascimento DATE NOT NULL,
    GeneroId INT NOT NULL,
    DataRegistro DATE NOT NULL,
    CONSTRAINT Cliente_PK PRIMARY KEY(Id),
    UNIQUE(CPF)
);

CREATE TABLE PessoaJuridica(
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    Nome VARCHAR(255) NOT NULL,
    Sobrenome VARCHAR(255) NOT NULL,
    CNPJ VARCHAR(255) NOT NULL,
    DataNascimento DATE NOT NULL,
    GeneroId INT NOT NULL,
    DataRegistro DATE NOT NULL,
    CONSTRAINT ClienteJuridica_PK PRIMARY KEY(Id),
    UNIQUE(CNPJ)
);

CREATE TABLE ContaCorrente(
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    ClienteId INT NOT NULL,
    Saldo DECIMAL NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY ("CLIENTEID") REFERENCES PessoaFisica("ID")
);

CREATE TABLE ContaPoupanca(
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    ClienteId INT NOT NULL,
    Saldo DECIMAL NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY ("CLIENTEID") REFERENCES PessoaFisica("ID")
);
