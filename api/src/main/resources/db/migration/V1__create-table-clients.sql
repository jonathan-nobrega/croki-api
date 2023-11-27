create table clients(

    id BIGINT NOT NULL AUTO_INCREMENT,
    is_active BOOLEAN NOT NULL,
    name VARCHAR(100) NOT NULL,
    company VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    line_1 VARCHAR(100) NOT NULL,
    line_2 VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zip VARCHAR(100) NOT NULL,

    primary key(id)
);

INSERT INTO clients(
    id, is_active, name, company, email, phone, line_1, line_2, city, state, zip
) VALUES(
    1,
    true,
    "John Due",
    "Ghost Company",
    "john@ghost.com",
    "+1 919-123-1234",
    "Address line one example",
    "Address line two example",
    "Raleigh",
    "NC",
    "25555"
);