@echo off
set DIR="%~dp0"
set JAVA_EXEC="%DIR:"=%\java"



pushd %DIR% & %JAVA_EXEC% %CDS_JVM_OPTS% -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -Djdk.gtk.version=2 -Dfile.encoding=utf-8 --add-exports=javafx.controls/com.sun.javafx.scene.control.behavior=com.jfoenix --add-exports=javafx.base/com.sun.javafx.binding=com.jfoenix --add-exports=javafx.base/com.sun.javafx.event=com.jfoenix --add-exports=javafx.graphics/com.sun.javafx.stage=com.jfoenix --add-exports=javafx.graphics/com.sun.javafx.scene=com.jfoenix --add-exports=javafx.graphics/com.sun.javafx.geom=com.jfoenix --add-exports=javafx.graphics/com.sun.javafx.scene.text=com.jfoenix --add-exports=javafx.controls/com.sun.javafx.scene.control.inputmap=com.jfoenix --add-exports=javafx.graphics/com.sun.javafx.scene.traversal=com.jfoenix --add-exports=javafx.controls/com.sun.javafx.scene.control=com.jfoenix --add-exports=javafx.graphics/com.sun.javafx.util=com.jfoenix --add-exports=javafx.graphics/com.sun.javafx.util=com.jfoenix --add-opens=java.base/java.lang.reflect=com.jfoenix -p "%~dp0/../app" -m app.main/cc.cc1234.Application  %* & popd
