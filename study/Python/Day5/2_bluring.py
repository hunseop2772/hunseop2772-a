import cv2

src = cv2.imread('rose.bmp', cv2.IMREAD_GRAYSCALE)
dst = cv2.blur(src, (3,3)) # (3,3) 내각 원하는 3*# 행렬 마스크

cv2.imshow('src', src)
cv2.imshow('dst', dst)
cv2.waitKey()
