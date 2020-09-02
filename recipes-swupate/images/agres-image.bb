DESCRIPTION = "Image with swupdate layer"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit swupdate

SRC_URI = "\
    file://update.sh \
    file://sw-description \
"

# images to build before building swupdate image
IMAGE_DEPENDS = " agr-image-swupdate.bb"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = " agr-image-swupdate.bb"

SWUPDATE_IMAGES_FSTYPES[fsl-image-qt5] = ".tar.gz"
