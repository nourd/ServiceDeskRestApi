-- DROP TABLE IF EXISTS tickets;
-- DROP TABLE IF EXISTS statuses;
-- DROP TABLE IF EXISTS priorities;
-- DROP TABLE IF EXISTS tickets_priorities;


CREATE TABLE servicedesk.tickets (
  id SERIAL  PRIMARY KEY,
  title VARCHAR(250) DEFAULT NULL,
  document_number VARCHAR(20) DEFAULT NULL,
  document_date DATE DEFAULT NOW(),
  email VARCHAR(250) DEFAULT NULL,
  problem_description VARCHAR(2000) DEFAULT NULL,
  status_id INT DEFAULT NULL,
  priority_id INT DEFAULT NULL
);

CREATE TABLE statuses (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(20)
);

CREATE TABLE priorities (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(20)
);
CREATE INDEX priorities_name ON priorities (name);

CREATE TABLE ticket_priorities (
  ticket_id       INTEGER NOT NULL,
  priority_id INTEGER NOT NULL
);
ALTER TABLE ticket_priorities ADD CONSTRAINT fk_ticket_priorities_tickets FOREIGN KEY (ticket_id) REFERENCES tickets (id);
ALTER TABLE ticket_priorities ADD CONSTRAINT fk_ticket_priorities_priorities FOREIGN KEY (priority_id) REFERENCES priorities (id);


