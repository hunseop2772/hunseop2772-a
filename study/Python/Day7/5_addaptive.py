import cv2

# 그레이 스케일로 읽어들이기
src = cv2.imread('sudoku.jpg', cv2.IMREAD_GRAYSCALE)

# 함수만들기
def on_trackbar(pos):
    bsize = pos
    if bsize < 3:
        bsize = 3
    if bsize % 2 == 0:
        bsize += 1
    dst = cv2.adaptiveThreshold(src, 255,cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY, bsize, 1)
    cv2.imshow('dst',dst)

cv2.imshow('src',src)
cv2.namedWindow('dst')
cv2.createTrackbar('Block size', 'dst', 0 , 200, on_trackbar)
cv2.setTrackbarPos('Block size', 'dst', 10)
cv2.waitKey()


