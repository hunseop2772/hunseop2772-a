import cv2
import numpy as np

# 첫 번째 동영상이 끝나고 자동으로 동영상으로 넘어가기

cap1 = cv2.VideoCapture('tree.mp4') # 해당 파일 경로 가저오기
cap2 = cv2.VideoCapture('forest.mp4')

frame_cnt1 = round(cap1.get(cv2.CAP_PROP_FRAME_COUNT))
frame_cnt2 = round(cap2.get(cv2.CAP_PROP_FRAME_COUNT))
print(frame_cnt1)
print(frame_cnt2)



fps1 = cap1.get(cv2.CAP_PROP_FPS)
fps2 = cap2.get(cv2.CAP_PROP_FPS)
print(fps1)
print(fps2)


w = round(cap1.get(cv2.CAP_PROP_FRAME_WIDTH)) # 소숫점 제거
h = round(cap1.get(cv2.CAP_PROP_FRAME_HEIGHT))
print('w', w)
print('h', h)

fourcc = cv2.VideoWriter_fourcc(*'DIVX')
# 동영상 만드는 객체가 만들어진다.
out = cv2.VideoWriter('mix.avi', fourcc, fps1, (w, h))

delay = int(1000/fps1)
effect_frame = int(fps1 * 2) # 2초

# 첫번째 영상
for i in range(frame_cnt1 - effect_frame):
    ret1, frame1 = cap1.read()
    cv2.imshow('output', frame1)
    out.write(frame1)
    if cv2.waitKey(10) == 27:
        break

for i in range(effect_frame):
    ret1, frame1 = cap1.read() # 첫번째 영상의 나머지 2초 영상 읽기
    ret2, frame2 = cap2.read() # 두번째 영상의 처음 2초 영상 읽기|

    # int(640 / 60) * 0  = 0
    # int(640 / 60) * 1  = 10
    # int(640 / 60) * 2  = 20
    # ...

    x = int(w / effect_frame) * i
    frame = np.zeros((h, w, 3), dtype = np.uint8) # color channel / 검정색 배경영상

    frame[:, 0:x, :] = frame2[:, 0:x, :]
    frame[:, x:w, :] = frame1[:, x:w, :]
    cv2.imshow('output', frame)
    out.write(frame)
    if cv2.waitKey(10) == 27:
        break
# 두번째 영상
for i in range(effect_frame, frame_cnt2):
    ret2, frame2 = cap2.read()
    cv2.imshow('output', frame2)
    out.write(frame2)
    if cv2.waitKey(10) == 27:
     break

cap1.release()
cap2.release()
out.release()