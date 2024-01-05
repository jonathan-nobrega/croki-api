CREATE TABLE projects(

    id BIGINT NOT NULL AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    is_active BOOLEAN NOT NULL,
    title VARCHAR(100) NOT NULL,
    billing_method VARCHAR(100) NOT NULL,
    deadline DATETIME NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_projects_client_id FOREIGN KEY(client_id) REFERENCES clients(id)
);

INSERT INTO projects (id, client_id, is_active, title, billing_method, deadline)
VALUES
  (1, 8, false, 'Organic attitude-oriented benchmark', 'BASED_ON_PROJECT_HOURS', '2024-01-03 03:55:26'),
  (2, 1, false, 'Balanced regional support', 'FIXED_COST_FOR_PROJECT', '2024-01-03 03:55:26'),
  (3, 3, true, 'Phased maximized artificial intelligence', 'FIXED_COST_FOR_PROJECT', '2024-01-03 03:55:26'),
  (4, 7, false, 'Front-line impactful definition', 'BASED_ON_PROJECT_HOURS', '2024-01-03 03:55:26'),
  (5, 4, true, 'Streamlined maximized superstructure', 'FIXED_COST_FOR_PROJECT', '2024-01-03 03:55:26'),
  (6, 5, false, 'Multi-lateral asymmetric migration', 'BASED_ON_PROJECT_HOURS', '2024-01-03 03:55:26'),
  (7, 7, false, 'Mandatory web-enabled help-desk', 'BASED_ON_PROJECT_HOURS', '2024-01-03 03:55:26'),
  (8, 3, true, 'Synergistic 5th generation help-desk', 'FIXED_COST_FOR_PROJECT', '2024-01-03 03:55:26'),
  (9, 2, true, 'Customer-focused even-keeled moderator', 'BASED_ON_PROJECT_HOURS', '2024-01-03 03:55:26'),
  (10, 1, false, 'Focused multi-tasking installation', 'FIXED_COST_FOR_PROJECT', '2024-01-03 03:55:26');


