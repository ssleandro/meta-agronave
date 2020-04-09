SUMMARY = "Install and start a systemd service to configure can"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#here we specify the source we want to build
SRC_URI = "file://agronave_m4.bin"

#here we specify the source directory, where we can do all the building and expect sources to be placed
S = "${WORKDIR}"

#bitbake task
#created a directory /home/root for target install the script
do_install() {
	install -d ${D}/boot
	install -m 0644 ${WORKDIR}/agronave_m4.bin ${D}/boot
}

#Pack the path
FILES_${PN} += "boot"

