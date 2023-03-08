import cv2
import numpy as np

src = cv2.imread('rice.png', cv2.IMREAD_GRAYSCALE)

# 전역 이진화
_, dst1 = cv2.threshold(src, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_OTSU)

# 지역 이진화
dst2 = np.zeros(src.shape, np.uint8)
# 0으로 체운 shape 의 행렬을 만등 - 영상을 만듬

bw = src.shape[1] // 4
# 위드는 1번 자리에 있다.
bh = src.shape[0] // 4
# 높이는 0번 자리에 있다.

# 가로 세로 4등분 하기위해 이중포문을 사용
for y in range(4):
    for x in range(4):
        # : 부터 시작해서
        # 0이 나오지 않기 위해 ,threshold 입력값으로 주기 위해 입력 영상도 4등분
        src_ = src[y*bh:(y+1)*bh, x*bw:(x+1)*bw]
        # 지역 이진화도 똑같이 4등분을 해준다.
        dst_ = dst2[y*bh:(y+1)*bh, x*bw:(x+1)*bw]

        # cv2 ~ 맨 마지막에오는 dst는 출력영상을 의미한다, 대신 출력영상과 입력영상의 크기는 동일해야한다
        # 앞에 src_ 는 입력영상이다
        cv2.threshold(src_, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_OTSU, dst_)

cv2.imshow('src', src)
cv2.imshow('dst1', dst1)
cv2.imshow('dst2', dst2)

cv2.waitKey()