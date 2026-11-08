INSERT INTO User (full_name, email, age, usertype) VALUES 
('Admin', 'admin@gmail.com', 32, 'Administrator'),
('John Smith' , 'john@gmail.com',29,'Participant'),
('Ali Khan' , 'ali@gmail.com',26,'Participant'),
('Anna Brown' , 'anna@gmail.com',30,'Participant'),
('Sara Wilson' , 'sara@gmail.com',35,'Participant');

INSERT INTO Credentials(user_id, password_hash) VALUES
-- Sample for now but Password will be hashed when system implementes 
(1, 'admin123'),
(2, 'jhon23'),
(3, 'ali123'),
(4, 'anna123'),
(5, 'sara123');
 

INSERT INTO Conference (title, capacity, start_date,end_date,location) VALUES
('AI Conference', 30, '2026-12-10 09:00', '2026-12-10 17:00', 'Vanier'),
('Cybersecurity Workshop', 2, '2026-12-12 11:00', '2026-12-12 15:00', 'Dawson'),
('Software Engineering Conference', 25, '2026-12-15 09:00', '2026-12-15 16:00', 'Vanier'),
('Computer Science', 35, '2026-12-18 12:00', '2026-12-18 17:00', 'McGill');

INSERT INTO Subscription(user_id, conference_id,waitinglist_status,waitinglist_position ) VALUES
(2, 1, 'False', '2026-11-05 09:00:00'),
(3, 1, 'False', '2026-11-05 09:05:00'),
(4, 2, 'False', '2026-11-05 09:10:00'),
(3, 2, 'False', '2026-11-05 09:15:00'),
(2, 2, 'True', '2026-11-05 09:20:00');
