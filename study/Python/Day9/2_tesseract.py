import pytesseract
import cv2

src = cv2.imread('namecard.jpg')
dst = cv2.cvtColor(src, cv2.COLOR_BGR2RGB)

text = pytesseract.image_to_string(dst, lang="kor+eng")
print(text)