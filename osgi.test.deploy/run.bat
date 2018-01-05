@echo off

set CMD=java.exe
set CURRENT_DIR=%cd%
set CMD_OPT1=-Declipse.ignoreApp=true
set CMD_OPT2=-Dosgi.noShutDown=true
set CMD_OPT3=-Dconfig.dir=D:/Software/eclipse/osgi.test.deploy
set CMD_OPT116=-jar equinox.jar
set CMD_OPT117=-clean
set CMD_OPT118=-console

set CMD_OPTS=%CMD_OPT1% %CMD_OPT2% %CMD_OPT3% %CMD_OPT116% %CMD_OPT117% %CMD_OPT118%

@echo on
%CMD% %CMD_OPTS%