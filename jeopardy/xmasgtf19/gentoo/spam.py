import pyautogui as pa
import time as t
 
screenWidth, screenHeight = pa.size()
currentMouseX, currentMouseY = pa.position()
 
def main():
    t.sleep(5)
    pa.moveTo(1686, 949, duration=1)
    pa.click()
    spam()
 
def spam():
    pa.write("alt-f10")
    pa.press("enter")
    t.sleep(4)
    pa.write("alt-f9")
    pa.press("enter")
    t.sleep(4)
    spam()
 
main()