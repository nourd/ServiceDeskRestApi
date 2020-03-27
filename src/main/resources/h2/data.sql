
INSERT INTO tickets (id, title, document_number, document_date, email) 
VALUES
  (1, 'First', 'TK-1', '2020-03-23', 'a@a.ee'),
  (2, 'Second', 'TK-2', '2020-03-23', 'b@a.ee'),
  (3, 'First', 'TK-3', '2020-03-23', 'c@a.ee');

INSERT INTO statuses (id, name) 
VALUES
  (1, 'open'),
  (2, 'progress'),
  (3, 'closed');


INSERT INTO priorities (id, name) 
VALUES
  (1, 'very low'),
  (2, 'low'),
  (3, 'medium'),
  (4, 'high'),
  (5, 'very high');

INSERT INTO ticket_priorities (ticket_id, priority_id) 
VALUES
  (1, 1),
  (2, 2),
  (3, 3);
