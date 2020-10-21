SUMMARY = "Install and start a systemd service to start agronave application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#here we specify the source we want to build
SRC_URI = "file://startApplication.sh \
	   file://startApplication-init.service"

#here we specify the source directory, where we can do all the building and expect sources to be placed
S = "${WORKDIR}"

SYSTEMD_SERVICE_${PN} = "startApplication-init.service"

RDEPENDS_${PN} += "bash"

#created a directory /home/root for target install the script
do_install() {
	install -d ${D}/home/root
        install -m 0755 ${WORKDIR}/startApplication.sh ${D}/home/root

	install -d ${D}${systemd_unitdir}/system
	install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
	install -m 0644 ${WORKDIR}/startApplication-init.service ${D}${systemd_unitdir}/system

	ln -sf ${systemd_unitdir}/system/startApplication-init.service \
         ${D}${sysconfdir}/systemd/system/multi-user.target.wants/startApplication-init.service

}

#Pack the path
FILES_${PN} += "/home/root"

#Pack the path
FILES_${PN} += "${libexecdir}"
FILES_${PN} += "${systemd_system_unitdir}"

REQUIRED_DISTRO_FEATURES= "systemd"

