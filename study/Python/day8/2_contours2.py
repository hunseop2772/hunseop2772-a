import cv2
import random
# NumPy는 행렬이나 일반적으로 대규모 다차원 배열을 쉽게 처리할 수 있도록 지원하는 파이썬의 라이브러리
import numpy as np

# milkdro.bmp를 grayscale로 읽어옴
# 자동 이진화
# 외과선을 검출
# 원본과 같은 크기의 컬러 영상(배경 검은색)을 만듬
# 위 영상에 외곽선의 갯수만큼 반복을 돌며 해당 외각을 그림(색상은 랜덤)

# 1. 그레이스케일로 만든다 - 이진화를 하기 위해서이다.
src = cv2.imread('milkdrop.bmp', cv2.IMREAD_GRAYSCALE)

# 2. 영상 이진화 (자동으로) - threshold를 사용하여 흑백으로 나눠야 검출할 수 있기 때문이다.
_, src_bin = cv2.threshold(src, 0, 255, cv2.THRESH_OTSU)

# 3. 외각선을 먼저 검출을 한다
contours, _ = cv2.findContours(src_bin, cv2.RETR_LIST, cv2.CHAIN_APPROX_NONE)

# 4. 원본과 같은 크기의 컬러 영상(배경 검은색)을 만듬
h, w = src.shape[:2]
# np.zeros() : 0으로 가득 찬 배열을 만드는것을 의미한다.
dst = np.zeros((h, w, 3), np.uint8)

# 5. 위 영상에 외곽선의 갯수만큼 반복을 돌며 해당 외각을 그림(색상은 랜덤)
for i in range(len(contours)):
    # 외각선의 색을 랜덤하게 보여주기 위해 color라는 변수를 만들었고 랜덤함수를 사용하였다.
    color = (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))
    # 외각선 그리기를 실행 -> 3번째 -1인 경우 한번에 외각선이 나온다.
    # 그렇기 때문에 for문으로 돌린 i 만큼 외각선이 나오게 하기 위해 i를 선언하여 넣어주기
    cv2.drawContours(dst, contours, i, color, 1, cv2.LINE_AA)

cv2.imshow('src', src)
cv2.imshow('src_bin', src_bin)
cv2.imshow('dst', dst)
cv2.waitKey()
