-- ================================================
-- CRIACAO DO BANCO DE DADOS - Clinica API
-- SENAI - Tecnico em Desenvolvimento de Sistemas
-- ================================================

CREATE DATABASE IF NOT EXISTS clinica_api;
USE clinica_api;

-- ================================================
-- TABELA PACIENTE
-- ================================================
CREATE TABLE IF NOT EXISTS paciente (
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

-- ================================================
-- TABELA CONSULTA
-- ================================================
CREATE TABLE IF NOT EXISTS consulta (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo         VARCHAR(255) NOT NULL,
    data_consulta  DATE NOT NULL,
    status         VARCHAR(50) NOT NULL,
    paciente_id    BIGINT NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

-- ================================================
-- 5 PACIENTES DE TESTE
-- ================================================
INSERT INTO paciente (nome, email) VALUES ('Ana Silva',      'ana@email.com');
INSERT INTO paciente (nome, email) VALUES ('Bruno Costa',    'bruno@email.com');
INSERT INTO paciente (nome, email) VALUES ('Carla Souza',    'carla@email.com');
INSERT INTO paciente (nome, email) VALUES ('Diego Alves',    'diego@email.com');
INSERT INTO paciente (nome, email) VALUES ('Elena Martins',  'elena@email.com');

-- ================================================
-- 7 CONSULTAS DE TESTE
-- ================================================
INSERT INTO consulta (titulo, data_consulta, status, paciente_id)
    VALUES ('Consulta Geral',      '2026-05-10', 'AGENDADA',     1);
INSERT INTO consulta (titulo, data_consulta, status, paciente_id)
    VALUES ('Retorno Cardiaco',    '2026-05-12', 'AGENDADA',     2);
INSERT INTO consulta (titulo, data_consulta, status, paciente_id)
    VALUES ('Exame de Sangue',     '2026-05-13', 'EM_ANDAMENTO', 3);
INSERT INTO consulta (titulo, data_consulta, status, paciente_id)
    VALUES ('Check-up Anual',      '2026-05-14', 'AGENDADA',     4);
INSERT INTO consulta (titulo, data_consulta, status, paciente_id)
    VALUES ('Consulta Pediatra',   '2026-05-15', 'CONCLUIDA',    5);
INSERT INTO consulta (titulo, data_consulta, status, paciente_id)
    VALUES ('Dermatologia',        '2026-05-16', 'AGENDADA',     1);
INSERT INTO consulta (titulo, data_consulta, status, paciente_id)
    VALUES ('Ortopedia',           '2026-05-17', 'CANCELADA',    2);