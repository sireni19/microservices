DROP TABLE IF EXISTS soldier;
CREATE TABLE IF NOT EXISTS soldier (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255) NOT NULL,
    weapon_number VARCHAR(255) DEFAULT 'not assigned'
    );