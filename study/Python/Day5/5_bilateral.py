import cv2

src = cv2.imread('dog.jpg')
dst = cv2.bilateralFilter(src, -1, 10, 5)

cv2.imshow('src',src)
cv2.imshow('dst',dst)
cv2.waitKey()