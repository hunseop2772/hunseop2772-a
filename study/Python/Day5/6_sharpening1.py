import cv2
import numpy as np

src = cv2.imread('dog.jpg')


cv2.imshow('src', src)

mask = np.asarray([[-1,-1,-1],
                   [-1,9,-1],
                   [-1,-1,-1]], dtype = np.float32)
sharpening_img = cv2.filter2D(src,-1, mask)
cv2.imshow('sharpening_img', sharpening_img)

cv2.waitKey()
