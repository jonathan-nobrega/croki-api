CREATE TABLE meetings (
    id BIGINT NOT NULL AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    time DATETIME,
    location VARCHAR(255),

    PRIMARY KEY(id),
    CONSTRAINT fk_meetings_client_id FOREIGN KEY(client_id) REFERENCES clients(id)
);

INSERT INTO meetings (id, client_id, description, time, location)
VALUES
    (1, 10, 'Enhanced next generation application', '2023-04-22 11:27:12', '18 Upham Circle'),
    (2, 9, 'Adaptive mission-critical archive', '2022-12-18 15:14:40', '66763 Loftsgordon Drive'),
    (3, 6, 'Quality-focused high-level Graphic Interface', '2023-01-08 01:16:15', '8 Service Hill'),
    (4, 5, 'Expanded tangible matrix', '2023-01-24 23:04:04', '93903 Parkside Terrace'),
    (5, 4, 'Self-enabling transitional paradigm', '2023-10-27 05:54:55', '6658 Gina Hill'),
    (6, 4, 'Multi-lateral systematic concept', '2022-12-09 04:43:27', '711 Elgar Trail'),
    (7, 1, 'Universal multi-state leverage', '2023-09-23 10:02:34', '80520 Bunker Hill Place'),
    (8, 2, 'Realigned foreground extranet', '2023-05-25 17:36:18', '9698 Meadow Vale Drive'),
    (9, 8, 'Pre-emptive bifurcated hardware', '2023-01-13 02:35:41', '85396 Porter Road'),
    (10, 3, 'Implemented real-time customer loyalty', '2023-07-19 07:26:52', '58418 Schurz Street');

