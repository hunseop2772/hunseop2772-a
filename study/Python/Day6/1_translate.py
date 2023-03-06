# 어파인 변환 예제

import cv2
import numpy as np

src = cv2.imread('dog.jpg')

# 어파인 행렬을 일단 만들어 보자 200(x축), 100(y축) 만큼 이동할 것이다

# [1,0,tx],[0,1,ty]
# 음수 tx값은 이미지를 왼쪽으로 이동, 양수 tx값은 이미지를 오른쪽으로 이동
# 음수 ty값은 이미지를 위으로 이동, 양수 ty값은 이미지를 아래로 이동
aff = np.array([[1,0,200],[0,1,100]], dtype=np.float32)

#이미 어파인 행렬이 있기 때문에 aff를 넣어주었다.
dst = cv2.warpAffine(src, aff, (0,0))

cv2.imshow('src', src)
cv2.imshow('dst', dst)
cv2.waitKey()