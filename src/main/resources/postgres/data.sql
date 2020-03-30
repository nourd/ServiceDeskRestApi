
INSERT INTO servicedesk.tickets (title, document_number, email) 
VALUES
  ( 'First', 'TK-1', 'a@a.ee'),
  ('Second', 'TK-2',  'b@a.ee'),
  ('Third', 'TK-3',  'c@a.ee');

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
