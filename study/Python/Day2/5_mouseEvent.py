import cv2
import numpy as np

oldx = oldy = -1 # 전역변수

def on_mouse(event, x, y, flags, param):
    global oldx, oldy # 전역변수를 on_mouse 함수내에서 사용하도록 설정
    # print('evemt : ', event, 'x :', x, 'y : ', y,'flags:', flags,'param : ', param)
    # print('evemt : ', event, 'x :', x, 'y : ', y, 'flags:', flags, )
    if event == cv2.EVENT_LBUTTONDOWN:  # 마우스 왼쪽 버튼이 눌렸다면
        oldx, oldy = x, y
        print('왼쪽 버튼이 눌렸어요 : %d, %d' %(x,y))
    elif event == cv2.EVENT_LBUTTONUP: # 마우스 왼쪽 버튼을 떘다면
        print('왼쪽 버튼이 때졌어요 : %d, %d' % (x, y))
    elif event == cv2.EVENT_MOUSEMOVE: # 마우스 커서가 움직였다면
        if flags & cv2.EVENT_FLAG_LBUTTON: # 왼쪽 버튼을 누르고 있다면
            cv2.line(img, (oldx, oldy), (x,y), (255, 51, 255), 3, cv2.LINE_AA)
            cv2.imshow('img',img)
            oldx, oldy = x, y

img = np.ones((480, 640, 3), dtype=np.uint8) * 255
cv2.namedWindow('img')
cv2.setMouseCallback('img', on_mouse, img) # 마우스 이벤트 발생시 ()누구를 호출 하겠냐(호출 하는것)
cv2.imshow('img', img)
cv2.waitKey()