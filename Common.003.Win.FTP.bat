

cd .\bin

rd /s/q .\org\hy\common\ftp\junit

jar cvfm hy.common.ftp.jar MANIFEST.MF META-INF org

copy hy.common.ftp.jar ..
del /q hy.common.ftp.jar
cd ..

