import cv2
import sys

cap = cv2.VideoCapture(0) # 동영상 파일, 캠 을 다룰 수 있다.

if not cap.isOpened():
    print('카메라를 열 수 없습니다')
    sys.exit() # 더 이상 프로그램을 진행시키지 않기 위해 ,아에 종료

print('카메라 연결 성공!')
print('가로 사이즈 : ', int(cap.get(cv2.CAP_PROP_FRAME_WIDTH)))
print('세로 사이즈 : ', int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT)))

while True:
    ret, frame = cap.read()
    if not ret:
        break

    inversed = ~frame

    cv2.imshow('frame', frame)
    cv2.imshow('inversed', inversed)

    if cv2.waitKey(10) == 27: # ESC
        # 키를 받으려고 대기중에 있는데 27번 esc를 누르면 종료가 된다
        break