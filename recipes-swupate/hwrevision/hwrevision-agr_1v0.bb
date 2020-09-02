SUMMARY = "Install hwrevision file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#here we specify the source we want to build
SRC_URI = "file://hwrevision"

S = "${WORKDIR}"

#created a directory /home/root for target install the script
do_install() {
        install -d ${D}${sysconfdir}
        install -m 0644 ${WORKDIR}/hwrevision ${D}${sysconfdir}
}

FILES_${PN} = "/etc"
