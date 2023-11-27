CREATE TABLE projects(

    id BIGINT NOT NULL AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    is_active BOOLEAN NOT NULL,
    title VARCHAR(100) NOT NULL,
    billing_method VARCHAR(100) NOT NULL,
    deadline datetime NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_projects_client_id FOREIGN KEY(client_id) REFERENCES clients(id)
)