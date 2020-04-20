SET targetname=new-three.apk
SET outputname=three.apk
SET packagename=com.hellocmu.picoctf

adb uninstall %packagename%
del ..\%targetname%
del dist\%outputname%
java -jar "C:/Users/Alma Karasik/Downloads/apktool.jar" b

zipalign -v 4 dist\%outputname% ..\%targetname%
echo mik147mik147| apksigner sign --ks "%HOMEPATH%\Downloads\keystore.keystore" --ks-key-alias signkey ..\%targetname%

adb install ..\%targetname%
