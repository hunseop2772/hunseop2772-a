import  cv2

cap = cv2.VideoCapture(0)

w = round(cap.get(cv2.CAP_PROP_FRAME_WIDTH)) # 소숫점 제거
h = round(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))
fps = cap.get(cv2.CAP_PORP_FPS)

# 동영사을 만들 때 어떤 포멧으로 할지 결정한다.
fourcc = cv2.VideoWriter_fourcc(*'DIVX')
# 동영상 만드는 객체가 만들어진다.
out = cv2.VideoWriter('out.avi', fourcc, fps, (w, h))

while True:
    ret, frame = cap.read()

    if not ret:
        break

    out.write(frame)
    cv2.imshow('frame', frame)

    if cv2.waitKey(10) == 27: # 1000 - 1초
        break

cap.release()
