import cv2
import sys

cap = cv2.VideoCapture('baby.mp4') # 해당 파일 경로 가저오기

if not cap.isOpened():
    print('동영상을 불러올 수 없습니다')
    sys.exit()

print('가로 사이즈 : ', int(cap.get(cv2.CAP_PROP_FRAME_WIDTH)))
print('세로 사이즈 : ', int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT)))
print('프레임 수 : ', int(cap.get(cv2.CAP_PROP_FRAME_COUNT)))

fps = cap.get(cv2.CAP_PROP_FPS)
print('FPS', fps)

while True:
    # ret : 잘 읽어왔는지 여부
    # frame : 사진
    ret, frame = cap.read()
    if not ret:
        break
    cv2.imshow('frame', frame)
    if cv2.waitKey(10) == 27:
        break

cap.release() # 기존에 올라간 메모리를 지움





