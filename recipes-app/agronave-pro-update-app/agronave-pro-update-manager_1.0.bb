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
            rpm \
	    swupdate \
"

COMPATIBLE_MACHINE= "imx8mq-var-dart"

SRC_URI = "git:///home/agronave/agronave-pro-update-manager;branch=dev"

SRCREV = "57a8fbf4427671bc536ab8b115ebc109a6d22ca6"

S = "${WORKDIR}/git"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"

do_package_qa[noexec] = "1" 

RDEPENDS_${PN}-dev = ""
RDEPENDS_${PN}-dbg = ""

do_install() {
  install -d ${D}/opt/UpdateApp/bin/
  install -m 0644 libCanLib.so ${D}/opt/UpdateApp/bin/ 
}

FILES_${PN} += "/opt/UpdateApp/bin/"

inherit qmake5
