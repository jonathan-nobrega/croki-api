CREATE TABLE invoices(

    id BIGINT NOT NULL AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    invoice_number INTEGER NOT NULL,
    description VARCHAR(250),
    amount DOUBLE NOT NULL,
    due_date DATETIME NOT NULL,
    status VARCHAR(100) DEFAULT 'DRAFT' NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_invoices_client_id FOREIGN KEY(client_id) REFERENCES clients(id),
    CONSTRAINT fk_invoices_project_id FOREIGN KEY(project_id) REFERENCES projects(id)
);

INSERT INTO invoices (id, client_id, project_id, invoice_number, description, amount, due_date, status)
VALUES
    (1, 4, 4, 17, 'Stand-alone 4th generation instruction set', 416.91, '2024-08-09 01:00', 'PAID'),
    (2, 5, 2, 9, 'Face to face bandwidth-monitored time-frame', 333.69, '2024-01-14 01:00', 'DRAFT'),
    (3, 7, 6, 11, 'Expanded multi-tasking synergy', 323.74, '2023-09-27 01:00', 'DRAFT'),
    (4, 3, 8, 20, 'Operative client-driven hierarchy', 279.21, '2023-02-19 01:00', 'PENDING'),
    (5, 2, 5, 14, 'Profound global matrices', 344.03, '2023-11-04 01:00', 'PENDING'),
    (6, 7, 6, 11, 'Synchronised grid-enabled throughput', 327.25, '2023-07-04 01:00', 'PAID'),
    (7, 3, 3, 19, 'Organic eco-centric function', 380.96, '2024-02-28 01:00', 'PENDING'),
    (8, 9, 2, 16, 'Robust asymmetric installation', 364.57, '2024-12-10 01:00', 'PAID'),
    (9, 8, 9, 10, 'Managed full-range standardization', 180.94, '2023-04-24 01:00', 'PAID'),
    (10, 7, 1, 3, 'Digitized actuating forecast', 127.29, '2023-02-16 01:00', 'PAID'),
    (11, 7, 7, 13, 'Synchronised dedicated protocol', 434.31, '2024-08-22 01:00', 'PAID'),
    (12, 3, 2, 11, 'Cross-platform cohesive protocol', 122.5, '2023-08-20 01:00', 'PAID'),
    (13, 5, 3, 13, 'Enterprise-wide zero tolerance hub', 260.31, '2023-09-08 01:00', 'DRAFT'),
    (14, 6, 4, 13, 'Function-based multi-tasking adapter', 360.75, '2024-05-09 01:00', 'DRAFT'),
    (15, 9, 2, 13, 'Quality-focused 24 hour orchestration', 31.11, '2024-09-20 01:00', 'DRAFT'),
    (16, 1, 3, 15, 'Persevering non-volatile strategy', 199.0, '2022-11-26 01:00', 'DRAFT'),
    (17, 2, 6, 2, 'Reactive human-resource task-force', 54.16, '2023-07-22 01:00', 'PENDING'),
    (18, 6, 5, 10, 'Object-based encompassing internet solution', 289.1, '2023-09-28 01:00', 'DRAFT'),
    (19, 2, 9, 8, 'Reduced exuding local area network', 67.64, '2024-02-08 01:00', 'DRAFT'),
    (20, 2, 5, 3, 'Fully-configurable regional adapter', 286.02, '2023-04-16 01:00', 'PENDING');



