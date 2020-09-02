# Copyright (C) 2015 Freescale Semiconductor
# Copyright 2017-2019 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-fsl/images/imx-image-multimedia.bb
#require recipes-fsl/images/imx-image-core.bb

ML_PKGS ?= ""
ML_PKGS_mx8 = "packagegroup-imx-ml"

IMAGE_INSTALL += " \
    packagegroup-qt5-imx \
    ${ML_PKGS} \
"

