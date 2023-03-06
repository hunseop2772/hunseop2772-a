import cv2

src = cv2.imread('dog.jpg')

cp = (src.shape[1] / 2, src.shape[0] / 2) # 센터값(중심 좌표) 구하기

rot = cv2.getRotationMatrix2D(cp, 20, 0.5)
print(rot)
dst = cv2.warpAffine(src, rot, (0,0))
cv2.imshow('src', src)
cv2.imshow('dst', dst)
cv2.waitKey()

