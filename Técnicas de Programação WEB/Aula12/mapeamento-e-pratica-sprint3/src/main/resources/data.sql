-- Inserir dados na tabela Empresa
INSERT INTO empresa (nome, cnpj, endereco, telefone, email)
VALUES
    ('Empresa1', '12345678901', 'Endereco1', '1234567890', 'empresa1@example.com'),
    ('Empresa2', '23456789012', 'Endereco2', '2345678901', 'empresa2@example.com');

-- Inserir dados na tabela Jogo
INSERT INTO jogo (nome, genero, plataforma, data_lancamento, empresa_id)
VALUES
    ('Jogo1', 'Ação', 'PC', '2023-10-24 10:00:00', 1),
    ('Jogo2', 'Aventura', 'PS4', '2023-10-25 09:30:00', 1),
    ('Jogo3', 'Esporte', 'Xbox', '2023-10-26 14:00:00', 2);
