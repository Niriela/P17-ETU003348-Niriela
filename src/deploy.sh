#!/bin/bash

APP_NAME="ETU003348"
SRC_DIR="src/main/java/"
WEB_DIR="src/main/webapp"
BUILD_DIR="build"
TOMCAT_WEBAPPS="/home/niriela/tomcat/webapps"
SERVLET_API_JAR="lib/servlet-api.jar"
MYSQL_JAR="lib/mysql-connector-j-9.0.0.jar"

# Nettoyage du dossier build
rm -rf $BUILD_DIR
mkdir -p $BUILD_DIR/WEB-INF/classes
mkdir -p $BUILD_DIR/WEB-INF/lib

# Compilation des fichiers Java
find $SRC_DIR -name "*.java" > sources.txt
javac -cp "$SERVLET_API_JAR:$MYSQL_JAR" -d $BUILD_DIR/WEB-INF/classes @sources.txt || { echo "❌ Compilation échouée"; exit 1; }
rm sources.txt

# Copie des fichiers web
cp -r $WEB_DIR/* $BUILD_DIR/

# Copie du fichier mysql-connector dans WEB-INF/lib
cp $MYSQL_JAR $BUILD_DIR/WEB-INF/lib/

# Création du fichier WAR
cd $BUILD_DIR
jar -cvf ../$APP_NAME.war *
cd ..

# Déploiement dans Tomcat
cp $APP_NAME.war $TOMCAT_WEBAPPS/

echo "✅ Déploiement terminé ! Redémarre Tomcat si besoin."
