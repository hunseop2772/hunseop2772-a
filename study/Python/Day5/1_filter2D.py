import cv2
import matplotlib.pyplot as plt
import numpy as np

src = cv2.imread('rose.bmp')
dst = cv2.cvtColor(src, cv2.COLOR_BGR2RGB)
plt.figure(figsize=(10,5))
for i, k in enumerate([3, 6, 10]):
    # 3바퀴 i는 인덱스 k에는 3 , 6 ,9가 들어간다.
    kernel = np.ones((k, k)) / k ** 2 # 제곱을 나눠준다, 마스크만들기
    filtering = cv2.filter2D(dst, -1, kernel)
    plt.subplot(1 , 3, i+1)
    plt.imshow(filtering)
    plt.title('kernel size : {}'.format(k))
    plt.axis('off')

plt.show()


