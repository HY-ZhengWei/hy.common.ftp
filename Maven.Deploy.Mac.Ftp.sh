#!/bin/sh

mvn deploy:deploy-file -Dfile=hy.common.ftp.jar                              -DpomFile=./src/META-INF/maven/org/hy/common/ftp/pom.xml -DrepositoryId=thirdparty -Durl=http://HY-ZhengWei:1481/repository/thirdparty
mvn deploy:deploy-file -Dfile=hy.common.ftp-sources.jar -Dclassifier=sources -DpomFile=./src/META-INF/maven/org/hy/common/ftp/pom.xml -DrepositoryId=thirdparty -Durl=http://HY-ZhengWei:1481/repository/thirdparty
