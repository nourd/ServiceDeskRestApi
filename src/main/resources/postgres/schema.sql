CREATE TYPE servicedesk.status AS ENUM ('open', 'progress', 'close');

CREATE TABLE servicedesk.tickets (
  id SERIAL  PRIMARY KEY,
  title VARCHAR(250) DEFAULT NULL,
  document_number VARCHAR(20) DEFAULT NULL,
  document_date DATE DEFAULT NOW(),
  email VARCHAR(250) DEFAULT NULL,
  problem_description VARCHAR(2000) DEFAULT NULL,
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

ALTER TABLE servicedesk.tickets 
ADD CONSTRAINT status_fk FOREIGN KEY (status_id) REFERENCES servicedesk.statuses (id);

ALTER TABLE servicedesk.tickets 
ADD CONSTRAINT priority_fk FOREIGN KEY (priority_id) REFERENCES servicedesk.priorities (id);


--CREATE CAST (CHARACTER VARYING as servicedesk.status) WITH INOUT AS IMPLICIT;

--CREATE CAST (servicedesk.status as CHARACTER VARYING) WITH INOUT AS IMPLICIT;

--CREATE TYPE servicedesk.priority AS ENUM ('very low', 'low', 'medium', 'high', 'very high');

--CREATE CAST (CHARACTER VARYING as servicedesk.priority) WITH INOUT AS IMPLICIT;

--CREATE CAST (servicedesk.priority as CHARACTER VARYING) WITH INOUT AS IMPLICIT;

CREATE SEQUENCE servicedesk.document_number_seq START 1001;
ALTER TABLE servicedesk.tickets ADD COLUMN doc_number integer  DEFAULT nextval('servicedesk.document_number_seq')
