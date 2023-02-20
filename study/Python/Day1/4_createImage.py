import cv2
import numpy as np
# numpy : empty

img1 = np.empty((240, 320), dtype=np.uint8)
img2 = np.zeros((240, 320, 3), dtype=np.uint8)
img3 = np.ones((240, 320), dtype=np.uint8) * 150
img4 = np.full((240, 320, 3), (255, 102, 255), dtype=np.uint8)  # 채우고 싶은 부분
#                   3채널을      이걸로 다 채워라

cv2.imshow('img1', img1)
cv2.imshow('img2', img2)
cv2.imshow('img3', img3)
cv2.imshow('img4', img4)
cv2.waitKey()
