DROP TABLE IF EXISTS weapon;
CREATE TABLE IF NOT EXISTS weapon
(
    id
                  SERIAL
        PRIMARY
            KEY,
    weapon_type
                  VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255) NOT NULL UNIQUE,
    owner         VARCHAR(255) DEFAULT NULL
);

INSERT INTO weapon (weapon_type, serial_number, owner)
VALUES ('AK', 'AB123456', NULL),
       ('AK', 'CD987654', NULL),
       ('AK', 'EF456789', NULL),
       ('AK', 'GH987632', NULL),
       ('SVD', 'IJ123465', NULL),
       ('SVD', 'KL789012', NULL),
       ('AK', 'MN345678', NULL),
       ('AK', 'OP901234', NULL),
       ('AK', 'QR567890', NULL),
       ('AK', 'ST234567', NULL);