INSERT INTO `user`(idx, id, password)
VALUES(1, 'asdf', '123'),
    (2, 'sample', '123');

INSERT INTO post(idx, title, content, user_idx)
VALUES(1, '첫번째', '안녕하세요', 1),
    (2, '두번째', '반갑습니다', 1),
    (3, '세번째 ', '뉴비입니다', 2);
