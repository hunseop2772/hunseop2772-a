import cv2

# 그레이 스케일로 읽어들이기
src = cv2.imread('circuit.bmp', cv2.IMREAD_GRAYSCALE)
# 마스크 얻어내는 함수
# 가로5, 세로3 의 마스크를 사용하겠다
se = cv2.getStructuringElement(cv2.MORPH_RECT, (5, 3))
dst1 = cv2.erode(src, se) # 깨진부분 축소
dst2 = cv2.dilate(src, None) # 깨진부분 확대, None 3*3

# 만약 수직선이 단선됐을 때 위 아래로 연결하고 싶은경우
# 1*5 커널을 생성하면 됨 - 마스크 사이즈라고 생각하고(1*5)로

cv2.imshow('src', src)
cv2.imshow('dst1', dst1)
cv2.imshow('dst2', dst2)
cv2.waitKey()