SUMMARY = "UpdateApp software"
AUTHOR = "Luan Rafael"

DESCRIPTION = " \
               Application development in Qt5 \
"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

DEPENDS += "qtbase \
	    qtquickcontrols2 \
	    qtserialbus \
            qt3d \
            rpm \
	    swupdate \
	    qtlocation \
"

COMPATIBLE_MACHINE= "imx8mq-var-dart"

SRC_URI = "git:///home/agronave/agronave-pro;branch=pbi/12577"

SRCREV = "45dabe39430ac96397e24ca254cf58b1d0155751"

S = "${WORKDIR}/git"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"

do_package_qa[noexec] = "1" 

RDEPENDS_${PN}-dev = ""
RDEPENDS_${PN}-dbg = ""

do_install() {
  install -d ${D}/opt/AgronavePro/bin/
#  install -m 0644 libCanLib.so ${D}/opt/UpdateApp/bin/ 
}

FILES_${PN} += "/opt/AgronavePro/bin/"

inherit qmake5
