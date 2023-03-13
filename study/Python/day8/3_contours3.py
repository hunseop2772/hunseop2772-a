import cv2
import math # 파이를 사용하기 위해

def setLabel(img, pts, label):
    (x, y, w, h) = cv2.boundingRect(pts)
    pt1 = (x,y) # x, y 축
    pt2 = (x + w, y + h) # 해당 끝과 끝의 좌표
    cv2.rectangle(img, pt1, pt2, (0, 0, 255), 1) # 이미지, 1/3 분면 꼭지, 색, 선 굵기
    cv2.putText(img, label, pt1,  cv2.FONT_HERSHEY_PLAIN, 1, (0, 0, 255))

src = cv2.imread('polygon.bmp')

gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)

# THRESH_BINARY_INV : 흰색 검은색이 있으면 그 색을 반대로 바꿔주는 기능을 가지고 있다.
_, src_bin = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY_INV | cv2.THRESH_OTSU)

# 외과선을 검출
contours, _ = cv2.findContours(src_bin, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)

for pts in contours:
    if cv2.contourArea(pts) < 400:
        continue

    approx = cv2.approxPolyDP(pts, cv2.arcLength(pts, True) * 0.02, True)

    # 꼭지점의 수
    vtc = len(approx)

    if vtc == 3:
        setLabel(src, pts, 'TRI')
        # 삼각형
    elif vtc == 4:
        setLabel(src, pts, 'RECT')
        # 사각형
    else:
        length = cv2.arcLength(pts, True)
        area = cv2.contourArea(pts)
        ratio = 4. * math.pi * area / (length * length)
        # 원 또는 알 수 없는 각형

        if ratio > 0.85 :
            setLabel(src, pts, 'CIR')
        else:
            setLabel(src, pts, 'NONAME')

cv2.imshow('src', src)
cv2.waitKey()


