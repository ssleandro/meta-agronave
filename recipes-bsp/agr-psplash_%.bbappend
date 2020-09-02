do_install_append () {
        rm -fr ${D}/${systemd_unitdir}/system/psplash*
}
