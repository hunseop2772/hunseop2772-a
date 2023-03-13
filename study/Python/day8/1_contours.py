import cv2
import random

src = cv2.imread('contours.bmp', cv2.IMREAD_GRAYSCALE)
contours, _ = cv2.findContours(src, cv2.RETR_CCOMP,cv2.CHAIN_APPROX_NONE)

dst = cv2.cvtColor(src, cv2.COLOR_GRAY2BGR)

# cv2.drawContours(영상, 외곽선 좌표 정보, 외곽선 인덱스, (-1을 지정하면 모든 외곽선을 그림), 색상)
# 외삭선 그리기 = drawContours
color = (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))
# color는 랜덤으로 색상, 3은 색 두께, LINE_AA 는 선모양
cv2.drawContours(dst, contours, -1, color, 3, cv2.LINE_AA)


cv2.imshow('src', src)
cv2.imshow('dst', dst)

cv2.waitKey()
