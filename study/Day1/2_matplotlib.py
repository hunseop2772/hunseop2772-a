import cv2
import matplotlib.pyplot as plt

# img_gray = cv2.imread('cat.bmp') 컬러
# img_gray = cv2.imread('cat.bmp', cv2.IMREAD_COLOR) 컬러
img_gray = cv2.imread('cat.bmp', cv2.IMREAD_GRAYSCALE)
# plt.axis('off') # matplotlip을 사용 축 없에기
# plt.imshow(img_gray, cmap='gray')
# plt.show()

img_rgb = cv2.imread('cat.bmp') # 이미지 정보가 블루, 그린, 레드 순으로 읽어온다
img_rgb = cv2.cvtColor(img_rgb, cv2.COLOR_BGR2RGB) # COLOR_BGR2RGB : BGR -> RGB로 변경하는 속성
# plt.axis('off') # matplotlip을 사용 축 없에기
# plt.imshow(img_rgb)
# plt.show()

# subplot 만들기
# 컬러 + 흑백
plt.subplot(121) # 1행 2열의 첫번째
plt.axis('off')
plt.imshow(img_rgb)

plt.subplot(122) #  1행 2열 2번째
plt.axis('off')
plt.imshow(img_gray, cmap='gray')
plt.show()

