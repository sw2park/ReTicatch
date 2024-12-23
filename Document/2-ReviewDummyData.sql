SELECT *FROM PFJOIN p ;

--1
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 1, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 1, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 1, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 1, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 1, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 1, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 1, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);
--2
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 2, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 2, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 2, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 2, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 2, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 2, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 2, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);

--3
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 3, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 3, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 3, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 3, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 3, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 3, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 3, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);

--4
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 4, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 4, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 4, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 4, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 4, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 4, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 4, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);

--5
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 5, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 5, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 5, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 5, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 5, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 5, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 5, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);

--6
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 6, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 6, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 6, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 6, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 6, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 6, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 6, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);

--7
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 7, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 7, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 7, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 7, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 7, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 7, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 7, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);

--8
INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 8, 1, '전시회의 구성이 매우 인상적이었습니다. 작품 하나하나에 담긴 깊은 이야기와 의미가 마음에 와닿았어요. 특히 조명이 정말 아름다웠습니다', '2024-12-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 8, 2, '처음 보는 작품들이 많았고, 큐레이터의 설명도 쉽게 이해할 수 있어서 좋았습니다. 가족과 함께 즐거운 시간을 보낼 수 있었어요!', '2024-12-21', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 8, 3, '시간 가는 줄 모르고 감상했습니다. 전시 테마와 작품 배치가 완벽했습니다. 예술을 사랑하는 사람이라면 꼭 추천드리고 싶어요!', '2024-11-23', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 8, 4, '전시장이 넓고 작품 수도 많아서 다 보는데 시간이 좀 걸렸지만 전혀 지루하지 않았습니다. 다시 가고 싶은 전시였습니다.', '2024-12-25', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 8, 5, '특히 아이들도 즐길 수 있는 체험형 전시가 있어서 가족끼리 가기에 정말 좋은 곳이었어요. 다음에도 새로운 전시를 기대합니다!', '2024-12-31', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 8, 6, '작품의 디테일과 전시장의 분위기가 정말 최고였어요. 특히 마지막 방의 작품이 너무 인상 깊어서 아직도 기억에 남습니다.', '2024-12-26', NULL);

INSERT INTO REVIEW r (SEQ_REVIEW_ID, SEQ_PFJOIN_ID, SEQ_USER_ID, REVIEW_CONTENT, REVIEW_DATE, RATING)
VALUES(seq_review_id.NEXTVAL, 8, 7, '설명도 잘 되어 있어서 작품 감상에 도움이 많이 되었고, 다양한 작품을 통해 새로운 영감을 얻을 수 있는 시간이었습니다.', '2024-11-28', NULL);
