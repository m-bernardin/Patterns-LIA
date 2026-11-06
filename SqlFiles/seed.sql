INSERT INTO User (full_name, email, age, password, usertype) VALUES 
('Admin', 'admin@gmail.com', 32, 'admin123', 'Administrator'),
('Jhon Smith' , 'jhon@gmail.com',29,'jhon123','Participant'),
('Ali Khan' , 'ali@gmail.com',26,'ali123','Participant'),
('Anna Brown' , 'anna@gmail.com',30,'anna123','Participant'),
('Sara Wilson' , 'sara@gmail.com',35,'sara123','Participant');

INSERT INTO Conference (title, capacity, start_date,end_date,location) VALUES
('AI Conference', 30, '2026-12-10 09:00', '2026-12-10 17:00', 'Vanier'),
('Cybersecurity Workshop', 2, '2026-12-12 11:00', '2026-12-12 15:00', 'Dawson'),
('Software Engineering Conference', 25, '2026-12-15 09:00', '2026-12-15 16:00', 'Vanier'),
('Computer Science', 35, '2026-12-18 12:00', '2026-12-18 17:00', 'McGill');

INSERT INTO Subscription(user_id, conference_id, is_on_waiting_list) VALUES
(2,1, 'False'),
(3,1, 'False'),
(4,2, 'False'),
(3,2, 'False'),
(2,2,'True');
