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

INSERT INTO clients (id, is_active, name, company, email, phone, line_1, line_2, zip, state, city)
VALUES
  (1, true, 'Levon Martynikhin', 'Janyx', 'lmartynikhin0@quantcast.com', '+1 (806) 224-7095', '82587 Schurz Crossing', '14th Floor', '79415', 'Texas', 'Lubbock'),
  (2, true, 'Carmita Shyre', 'Thoughtblab', 'cshyre1@businessinsider.com', '+1 (561) 126-3791', '81157 Golf View Hill', 'Suite 23', '33436', 'Florida', 'Boynton Beach'),
  (3, true, 'Loise Hamon', 'Tagpad', 'lhamon2@stanford.edu', '+1 (816) 756-3759', '8537 Thompson Lane', '10th Floor', '64101', 'Missouri', 'Kansas City'),
  (4, false, 'Andrus Blenkinsopp', 'Gigashots', 'ablenkinsopp3@arstechnica.com', '+1 (530) 284-3590', '7 Browning Drive', '18th Floor', '95973', 'California', 'Chico'),
  (5, false, 'Gerhard Thornley', 'Voolith', 'gthornley4@moonfruit.com', '+1 (704) 300-6575', '61 Kinsman Court', 'Apt 1805', '28247', 'North Carolina', 'Charlotte'),
  (6, false, 'Louie Galfour', 'Fivechat', 'lgalfour5@networkadvertising.org', '+1 (334) 885-8032', '66 Melvin Pass', 'Room 909', '36119', 'Alabama', 'Montgomery'),
  (7, true, 'Randa Seebright', 'Vitz', 'rseebright6@reuters.com', '+1 (316) 140-5514', '2 Maple Circle', 'PO Box 74222', '67236', 'Kansas', 'Wichita'),
  (8, true, 'Gordie Gini', 'Cogilith', 'ggini7@tiny.cc', '+1 (757) 420-2328', '39590 Mallory Junction', '6th Floor', '23464', 'Virginia', 'Virginia Beach'),
  (9, false, 'Elsa Letchford', 'Dabshots', 'eletchford8@ucla.edu', '+1 (808) 280-1041', '1 Almo Plaza', 'Apt 341', '96850', 'Hawaii', 'Honolulu'),
  (10, true, 'Corney Gutteridge', 'Feedmix', 'cgutteridge9@ovh.net', '+1 (850) 950-6449', '2 Bobwhite Terrace', 'Suite 19', '32405', 'Florida', 'Panama City');

