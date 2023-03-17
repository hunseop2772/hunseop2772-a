import cv2

img = cv2.imread('hat.png')
cpy = img.copy()

gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
_, thr = cv2.threshold(gray, 127, 255, cv2.THRESH_BINARY)

contour, _ = cv2.findContours(thr, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

print(contour)

cnt = contour[1]

cv2.drawContours(img, [cnt], -1, (255, 0, 0), 2)
check = cv2.isContourConvex(cnt)

if not check:
    hull = cv2.convexHull(cnt)
    cv2.drawContours(cpy, [hull], -1, (0,255,0), 2)
    cv2.imshow('hull',cpy)
cv2.imshow('contour', img)
cv2.waitKey()