import cv2

# 그레이 스케일로 읽어들이기
src = cv2.imread('cell.png', cv2.IMREAD_GRAYSCALE)

# 함수만들기
def on_threshold(pos):
    _, dst = cv2.threshold(src, pos, 255, cv2.THRESH_BINARY)
    cv2.imshow('dst',dst)


cv2.imshow('src',src)

# 창에데한 이름을 지정하기
cv2.namedWindow('dst')
# createTrackbar('트랙바이름', '창이름', '최소값', '최대값', '이벤트핸들러)
cv2.createTrackbar('Threshold', 'dst', 0 , 255, on_threshold)
# setTrackbarPos('트랙바이름', '창이름', 시작포지션값)
cv2.setTrackbarPos('Threshold', 'dst', 100)
cv2.waitKey()

