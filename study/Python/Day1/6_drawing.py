import cv2
import numpy as np

img = np.full((500, 500, 3), 255, np.uint8)

# 선 만들기
cv2.line(img, (50,50), (200,50), (0, 0, 255), 5)
cv2.rectangle(img, (50, 200, 150 , 100), (0, 255, 0), -1)
cv2.circle(img, (300,  100),50, (255, 255, 0), -1)

str = 'HEllo OpenCV'
cv2.putText(img, str, (50,35), cv2.FONT_HERSHEY_DUPLEX, 0.8, (0,0,255))


cv2.imshow('img', img)
cv2.waitKey()

