SUMMARY = "Install and start a systemd service to configure can"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#here we specify the source we want to build
SRC_URI = "file://socketcan0-interface.service \
           file://socketcan1-interface.service"

#here we specify the source directory, where we can do all the building and expect sources to be placed
S = "${WORKDIR}"

SYSTEMD_SERVICE_${PN} = "socketcan0-interface.service socketcan1-interface.service"

#bitbake task
#created a directory /home/root for target install the script
do_install() {
	install -d ${D}${systemd_unitdir}/system
        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
	install -m 0644 ${WORKDIR}/socketcan0-interface.service ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/socketcan1-interface.service ${D}${systemd_unitdir}/system

	ln -sf ${systemd_unitdir}/system/socketcan0-interface.service \
         ${D}${sysconfdir}/systemd/system/multi-user.target.wants/socketcan0-interface.service
	ln -sf ${systemd_unitdir}/system/socketcan1-interface.service \
         ${D}${sysconfdir}/systemd/system/multi-user.target.wants/socketcan1-interface.service

}

#Pack the path
FILES_${PN} += "${libexecdir}"
FILES_${PN} += "${systemd_system_unitdir}"

REQUIRED_DISTRO_FEATURES= "systemd"
