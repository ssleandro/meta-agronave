# Copyright (C) 2017 Variscite Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Variscite Image to validate i.MX machines. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

DISTRO_FEATURES_append = "wayland opengl eglfs"

#require ${BSPDIR}/sources/meta-fsl-bsp-release/imx/meta-sdk/dynamic-layers/qt5-layer/recipes-fsl/images/fsl-image-qt5.bb

inherit core-image
inherit populate_sdk_qt5
inherit extrausers

#EXTRA_USERS_PARAMS += "usermod -P agronave root;"
IMAGE_FEATURES += "debug-tweaks"
### WARNING: This image is NOT suitable for production use and is intended
###          to provide a way for users to reproduce the image used during
###          the validation process of i.MX BSP releases.

PACKAGECONFIG ??= "qtdeclarative qtquick"

IMAGE_FEATURES += " \
    tools-profile \
    package-management \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
"

PREFERRED_PROVIDER_u-boot-fw-utils = "libubootenv"

IMAGE_INSTALL_append = " \
    tcf-agent \
    openssh-sftp-server \
    qtbase \
    qtbase-plugins \
    qtbase-tools \
    qtsvg \
    qtsvg-plugins \
    qtsensors \
    qtimageformats-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtscript \
    qt3d \
    qtquickcontrols \
    qtquickcontrols2 \
    qt3d-qmlplugins \
    qt3d-tools \
    qtgraphicaleffects-qmlplugins \
    qtconnectivity-qmlplugins \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    qtserialbus \
    qtserialport \
    qtquickcontrols-qmlplugins \
    qtgraphicaleffects \
    qtlocation \
    qtserialbus \
    qtquickcontrols2-qmlplugins \
    qttools-plugins \
    qtxmlpatterns \
    qtvirtualkeyboard \
    qtvirtualkeyboard-plugins \
    qtvirtualkeyboard-qmlplugins \
    qtwayland \
    agr-can \
    swupdate \
    swupdate-www \
    hwrevision-agr \
    weston \
    udev-extraconf \
    dietsplash \
    liberation-fonts \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-common \
    i2c-tools \
    evtest \
    libevdev\
"

ERPC_COMPS ?= ""
ERPC_COMPS_append_mx7ulp = "packagegroup-imx-erpc"

TOOLCHAIN_HOST_TASK_append = " nativesdk-qttools-tools nativesdk-qt3d-tools nativesdk-qt3d "

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    ${ERPC_COMPS} \
"

IMAGE_INSTALL_remove = " \
    pulseaudio \
    qt5-demo-extrafiles \
    packagegroup-qt5-demos \
    packagegroup-qt5-webengine \
    packagegroup-fsl-pulseaudio \
    packagegroup-fsl-tools-audio \
    packagegroup-core-x11-sato \
    packagegroup-fsl-gstreamer1.0 \
   "

IMAGE_FEATURE_remove = "splash"

IMAGE_FSTYPES ?= "tar.gz sdcard.gz"
