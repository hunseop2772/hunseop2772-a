import sys
import numpy as np
import cv2

def drawROI(img, corners):
    cpy = img.copy() # 카피 이미지를 만든다.

    c1 = (0, 0, 255) # 점 색상
    c2 = (255, 0, 0) # 선 색상

    for pt in corners: # 4바퀴 돌리기
        # circle : 원을 만들자
        cv2.circle(cpy, tuple(pt.astype(int)), 25, c1, -1, cv2.LINE_AA)
        # 25(반지름), c1 점 색상, -1 배경을 지우고 , cv2.LINE_AA 선 타입(직선)

    # line : 라인을 만들자
    cv2.line(cpy, tuple(corners[0].astype(int)), tuple(corners[1].astype(int)), c2, 2, cv2.LINE_AA)
    cv2.line(cpy, tuple(corners[1].astype(int)), tuple(corners[2].astype(int)), c2, 2, cv2.LINE_AA)
    cv2.line(cpy, tuple(corners[2].astype(int)), tuple(corners[3].astype(int)), c2, 2, cv2.LINE_AA)
    cv2.line(cpy, tuple(corners[3].astype(int)), tuple(corners[0].astype(int)), c2, 2, cv2.LINE_AA)

    return cpy


#이벤트, 좌표들, 클릭중인지, 데이터가 있으면 넘길것이 있는지
def onMouse(event, x, y, flags, param):

    global srcQuad, dragSrc, ptOld, src # 글로벌로 설정을 하영 중복을 배제한다.

    if event == cv2.EVENT_LBUTTONDOWN:
        # LBUTTONDOWN : 왼쪽 버튼이 눌리고 있냐??
        for i in range(4):
            # 4개의 좌표가 있기 때문에 4번을 반복한다.
            if cv2.norm(srcQuad[i] - (x, y)) < 25:
                # 원의 반지름 안에 들어왔냐??
                # norm 함수 : 정규화 시키는 함수이다.
                dragSrc[i] = True
                # 반지름 안에 들어왔으면
                ptOld = (x, y)
                break

    if event == cv2.EVENT_LBUTTONUP: # 마우스 버튼이 떨어젔냐??
        for i in range(4):
            dragSrc[i] = False
            # 떨어지니깐 False : 초기화 시키기 위해 사용하는 것이다.

    if event == cv2.EVENT_MOUSEMOVE: # 마우스를 드레그 한다면??
        for i in range(4):
            if dragSrc[i]: # 드레그 중이라면 (True)
                dx = x - ptOld[0] # 0번에 해당하는 x좌표는
                dy = y - ptOld[1] # 1번이라는 y좌표

                srcQuad[i] += (dx, dy) # 더해서 해당 좌표를 만든다.

                cpy = drawROI(src, srcQuad) # 다시 그려라
                cv2.imshow('img', cpy) # 다시 화면을 보여주기
                ptOld = (x, y) # 그 값들을 다시 적용하자
                break


# 입력 이미지 불러오기
src = cv2.imread('namecard.jpg')

h, w = src.shape[:2]
dh = 500
# A4용지 크기 : 219*297cm
dw = round(dh * 297/210)

# 모서리 점들의 좌표, 드래그 상태 여부
srcQuad = np.array([[30, 30], [30, h-30], [w-30, h-30], [w-30, 30]], np.float32) # 점
dstQuad = np.array([[0, 0], [0, dh], [dw, dh], [dw, 0]], np.float32) # 짜른 이미지
dragSrc = [False, False, False, False] # 지금 현재 점이 드래그 중인지 움직이면 True로 변경

# 모서리점, 사각형 그리기(얻어내는 함수를 의미한다)
disp = drawROI(src, srcQuad) # 원본에다가 드래그할 위치를 넘겨준다.
cv2.imshow('img', disp)
cv2.setMouseCallback('img', onMouse) #  마우스 이벤트
while True:
    key = cv2.waitKey()
    if key == 13:  # ENTER 키
        break
    elif key == 27:  # ESC 키
        sys.exit()

if src is None:
    print('Image open failed!')
    sys.exit()



cv2.waitKey()
# 투시 변환
pers = cv2.getPerspectiveTransform(srcQuad, dstQuad)
dst = cv2.warpPerspective(src, pers, (dw, dh), flags=cv2.INTER_CUBIC) # 확대 시킬거기 때문에 CUBIC을 사용

cv2.imshow('dst', dst)
cv2.waitKey()


