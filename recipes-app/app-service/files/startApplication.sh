#!/bin/bash

sleep 4

MEDIA_DIR=/run/media/sd*
AGRONAVEAPP_PATH=/opt/AgronavePro/bin/AgronaveProApp
UPDATEAPP_PATH=/opt/UpdateApp/bin/UpdateApp

check_dir=true

export QT_QPA_PLATFORM=eglfs                                      
export QT_QPA_EGLFS_ALWAYS_SET_MODE=1                             
export QT_QPA_EGLFS_INTEGRATION=eglfs_kms                         
export QT_QPA_EGLFS_KMS_ATOMIC=1                                  
export QT_QPA_EGLFS_WIDTH=1280                                    
export QT_QPA_EGLFS_HEIGHT=800                                    
export QT_QPA_EGLFS_PHYSICAL_WIDTH=216   
export QT_QPA_EGLFS_PHYSICAL_HEIGHT=136 

while true
do

	if [ -d $MEDIA_DIR ]; then
		if [ -f "$UPDATEAPP_PATH" ]; then
			if [ $check_dir == true ]; then
				$UPDATEAPP_PATH	
				check_dir=false
			else
				if [ -f "$AGRONAVEAPP_PATH" ]; then
					$AGRONAVEAPP_PATH
				fi
				check_dir=true
			fi
		fi	
	else	
		if [ -f "$AGRONAVEAPP_PATH" ]; then
			$AGRONAVEAPP_PATH 
		else
			$UPDATEAPP_PATH	
		fi
	fi

    echo 'running..'
    sleep 1
done
