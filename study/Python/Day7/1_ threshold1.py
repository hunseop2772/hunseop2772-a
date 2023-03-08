import cv2
import matplotlib.pyplot as plt

src = cv2.imread('cell.png', cv2.IMREAD_GRAYSCALE)

hist = cv2.calcHist([src],[0],None,[256],[0, 255])

_, dst1 = cv2.threshold(src, 100, 255, cv2.THRESH_BINARY) # 사용된 임계값, 출력영상
# 100부터 255까지 나눠주고 나머지는 따로 처리를 한다.
_, dst2 = cv2.threshold(src, 210, 255, cv2.THRESH_BINARY)
# 210부터 255까지 나눠주고 나머지는 따로 처리를 한다.
# (210~ 255는 배경이며 흰색에 가까운 부분을 제외하고 오브젝트로 처리를 한가. 그렇기 때문에 검은색 따른부분이 잡히게 된다.)
# _ 는 임계값을 넣는것을 의미하고 따로 변수를 안만든다는 의미이다.

cv2.imshow('src', src)
cv2.imshow('dst1', dst1)
cv2.imshow('dst2', dst2)

plt.plot(hist)
plt.show()
cv2.waitKey()