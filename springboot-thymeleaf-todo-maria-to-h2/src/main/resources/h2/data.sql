INSERT INTO `user`
(create_date, delete_date, idx, update_date, id, password)
VALUES
('2023-08-17 16:16:27.000', NULL, 1, NULL, 'admin', '123'),
('2023-08-17 16:16:27.000', NULL, 2, NULL, 'test', '123');

INSERT INTO user_role
(idx, create_date, user_idx, `role`)
VALUES
(1, '2023-08-17 16:16:27.000', 1, 'ADMIN'),
(2, '2023-08-17 16:16:27.000', 1, 'USER'),
(3, '2023-08-17 16:16:27.000', 2, 'USER');

INSERT INTO todo
(create_date, delete_date, idx, update_date, user_idx, content, done_yn)
VALUES
('2023-08-17 16:16:27.000', NULL, 1, NULL, 2, '일어나기', 'Y'),
('2023-08-17 16:16:27.000', NULL, 2, NULL, 2, '양치하기', 'Y'),
('2023-08-17 16:16:27.000', NULL, 3, NULL, 2, '샤워하기', 'N'),
('2023-08-17 16:16:27.000', NULL, 4, NULL, 2, '출근하기', 'N'),
('2023-08-17 16:16:27.000', NULL, 5, NULL, 2, '퇴근하기', 'N');
