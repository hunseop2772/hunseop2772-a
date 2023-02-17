import cv2

# 원본 이미지
img1 = cv2.imread('baby.jpg')
# 원본을 동일하게 가리키는 주소
# img2 = img1


img_re = cv2.resize(img1, (500,500))
# 원본과 동일한 주서의 이미지 일부
img2 = img_re[64:300, 165:450]
# 복사본의 일부
img3 = img1[64:300, 165:450].copy()
# img2.fill(0)
img3.fill(0)

cv2.imshow('img_re', img_re)
cv2.imshow('img2', img2)
cv2.imshow('img3', img3)

cv2.waitKey()