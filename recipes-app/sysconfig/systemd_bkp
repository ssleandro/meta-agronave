DESCRIPTION = "Customization of systemD services."

do_install_append() {
    rm ${D}${sysconfdir}/systemd/system/getty.target.wants/getty@tty1.service
}

#PACKAGECONFIG_remove = "timesyncd"

FILES_${PN} += "${sysconfdir}/systemd/system"

REQUIRED_DISTRO_FEATURES= "systemd"
