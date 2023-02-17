import cv2

img1 = cv2.imread('cat.bmp', cv2.IMREAD_GRAYSCALE)
print('img1의 type: ', type(img1)) # 이미지가 ndarray로 저장된다. ndarray로 저장되기 때문에 shape는 존재한다
print('img1의 shape: ', img1.shape) # (480, 640) = (세로, 가로)
print('img1의 dtype: ', img1.dtype) # uint8, 밝기 정보

img2 = cv2.imread('cat.bmp')
print('img2의 type: ', type(img2))
print('img2의 shape: ', img2.shape) # (480, 640, 3) -> (세로, 가로, 컬러)
print('img2의 dtype: ', img2.dtype)

h, w = img2.shape[:2]
print(f'img2의 사이즈 : {w} * {h}')

# 흑백과 컬러 영상을 구별하는 방법
if len(img1.shape) == 2:
    print('img1은 흑백입니다.')
elif len(img1.shape) == 3:
    print('img1은 컬러입니다.')

# 특정 밝기 정보와 특정 색정보로 영상 출력하기
# for x in range(h):
#     for y in range(w):
#         img1[x, y] = 255
#         img2[x, y] = (255, 102 , 255) # BGR

img1[:,:]= 255 # 이중 포문을 사용하는 것보다 속도가 훨씬 빠르다
img2[:,:]= (255, 102, 255)

cv2.imshow('img1', img1)
cv2.imshow('img2', img2)
cv2.waitKey()