create table clients(

    is_active boolean NOT NULL,
    id VARCHAR(36) NOT NULL,
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