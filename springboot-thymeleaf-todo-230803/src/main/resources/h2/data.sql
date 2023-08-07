INSERT INTO `user` (`idx`, `id`, `password`, `create_date`)
VALUES (1, 'admin', '123', now()),
       (2, 'test', '123', now());


INSERT INTO `user_role` (`user_idx`, `role`, `create_date`)
VALUES (1, 'ADMIN', now()),
       (1, 'USER', now()),
       (2, 'USER', now());


INSERT INTO `todo` (`user_idx`, `content`, `done_yn`, `create_date`)
VALUES (2, '일어나기', 'Y', now()),
       (2, '양치하기', 'Y', now()),
       (2, '샤워하기', 'N', now()),
       (2, '출근하기', 'N', now()),
       (2, '퇴근하기', 'N', now());