CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
);

INSERT INTO users(id, login, password) VALUES(
    1,
    'asd@asd.com',
    '$2a$10$AvSNvQy0Te/GyODXe4x4FeI93bNCGEx7PuYJN/XfXi6UGl1VeHRry'
);


