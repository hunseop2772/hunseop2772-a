import cv2 # opencv2 사용하기 위해 임포트

print('현재 opencv 버전: ', cv2.__version__)

# 이미지 불러오기 , 영상처리
img = cv2.imread('cat.bmp') #  영상 불러오기
cv2.imshow('img', img) # 영상 보여주기
cv2.waitKey() # 지워 지지 않고 해당 키를 누를 때까지 하기



