SUMMARY = "UpdateApp software"
AUTHOR = "Luan Rafael"

DESCRIPTION = " \
               Application development in Qt5 \
"

inherit deploy


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://agronavePro-0.1-0.aarch64.rpm;unpack=0"

S = "${WORKDIR}"

do_install() {
  	install -d ${D}/home/root
	install -m 0755 ${WORKDIR}/agronavePro-0.1-0.aarch64.rpm ${D}/home/root
}

IMAGE_INSTALL = "agronavePro-0.1-0.aarch64.rpm"

FILES_${PN} += "/home/root"


