#!/bin/sh

cd ./bin


rm -R ./org/hy/common/ftp/junit


jar cvfm hy.common.ftp.jar MANIFEST.MF META-INF org

cp hy.common.ftp.jar ..
rm hy.common.ftp.jar
cd ..





cd ./src
jar cvfm hy.common.ftp-sources.jar MANIFEST.MF META-INF org 
cp hy.common.ftp-sources.jar ..
rm hy.common.ftp-sources.jar
cd ..
