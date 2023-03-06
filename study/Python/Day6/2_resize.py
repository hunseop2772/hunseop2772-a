import cv2

src = cv2.imread('rose.bmp')
dst1 = cv2.resize(src, (0, 0), fx=4, fy=4,interpolation=cv2.INTER_NEAREST)
dst2 = cv2.resize(src, (1920, 1280))
dst3 = cv2.resize(src, (1920, 1280), interpolation=cv2.INTER_CUBIC)

cv2.imshow('src', src)
cv2.imshow('dst1', dst1[500:900, 400:800]) # 처리량은 빠르지만 질이 좋지 않다
cv2.imshow('dst2', dst2[500:900, 400:800]) # 기본값 : INTER_LINEAR
cv2.imshow('dst3', dst3[500:900, 400:800])
# 큐빅 : 사람눈에 큰 차이는 없지만 계산은 복잡하고 더 좋은 퀄리티를 보장한다.
cv2.waitKey()