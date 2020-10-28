FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://logo_linux_clut224.ppm \
		   file://0001-Kernel_Changes.patch \
		   file://agr_defconfig" 

KERNEL_DEVICETREE = " \
        freescale/imx8mq-var-dart-wifi-hdmi.dtb \
        freescale/imx8mq-var-dart-wifi-lvds.dtb \
        freescale/imx8mq-var-dart-wifi-lvds-hdmi.dtb \
        freescale/imx8mq-var-dart-sd-hdmi.dtb \
        freescale/imx8mq-var-dart-sd-lvds.dtb \
        freescale/imx8mq-var-dart-sd-lvds-hdmi.dtb \
        freescale/imx8mq-var-dart-m4-wifi-hdmi.dtb \
        freescale/imx8mq-var-dart-m4-wifi-lvds.dtb \
        freescale/imx8mq-var-dart-m4-wifi-lvds-hdmi.dtb \
        freescale/imx8mq-var-dart-m4-sd-hdmi.dtb \
	freescale/imx8mq-var-dart-m4-sd-lvds.dtb \
        freescale/imx8mq-var-dart-m4-sd-lvds-hdmi.dtb \
"

do_configure_prepend() {
    # logo support, if you supply logo_linux_clut224.ppm in SRC_URI, then it's going to be used
    if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
        install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${S}/drivers/video/logo/logo_linux_clut224.ppm
        kernel_conf_variable LOGO y
        kernel_conf_variable LOGO_LINUX_CLUT224 y
        kernel_conf_variable LOGO_VARISCITE_CLUT224 n
    fi
}

KERNEL_DEFCONFIG_imx8mq-var-dart = "${WORKDIR}/agr_defconfig"
DEFAULT_DTB_imx8mq-var-dart = "m4-sd-lvds"

