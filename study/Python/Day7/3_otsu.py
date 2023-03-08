import cv2

# 그레이 스케일로 읽어들이기
src = cv2.imread('rice.png', cv2.IMREAD_GRAYSCALE)

th, dst = cv2.threshold(src, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_OTSU)
# 임계값을 받는 th
print('otsu: ', th)
# 131 ~ 255 배경으로 찾고 나머지를 오브젝트로 잡고있다.

cv2.imshow('src',src)
cv2.imshow('dst',dst)

cv2.waitKey()

