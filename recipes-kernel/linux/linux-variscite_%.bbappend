FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://logo_linux_clut224.ppm \
		   file://agr_defconfig" 

KERNEL_DEFCONFIG_imx8mq-var-dart = "${WORKDIR}/agr_defconfig"
DEFAULT_DTB_imx8mq-var-dart = "sd-lvds"

do_configure_prepend() {
    # logo support, if you supply logo_linux_clut224.ppm in SRC_URI, then it's going to be used
    if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
        install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${S}/drivers/video/logo/logo_linux_clut224.ppm
        kernel_conf_variable LOGO y
        kernel_conf_variable LOGO_LINUX_CLUT224 y
        kernel_conf_variable LOGO_VARISCITE_CLUT224 n
    fi
}
