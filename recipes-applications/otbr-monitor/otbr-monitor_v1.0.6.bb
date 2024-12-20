

SRC_URI = "git://gitlab.com/prpl-foundation/components/iot/otbr-monitor.git;protocol=https;nobranch=1"
SRCREV = "v1.0.6"

S = "${WORKDIR}/git"

inherit pkgconfig config-thread

SUMMARY = "This service has reponsibilities to start and monitor otbr-agent process"
LICENSE += "BSD-2-Clause-Patent & SAH"
LIC_FILES_CHKSUM += "file://LICENSE;md5=cd9db409406fd4c7234d852479547016"

COMPONENT = "otbr-monitor"
VERSION_PREFIX = ""



export CONFIG_SAH_SERVICES_OTBR

CONFIG_SAH_SERVICES_OTBR ??= "y"

SAH_CONFIG += " \
                CONFIG_SAH_SERVICES_OTBR \
                "

DEPENDS += "libsahtrace"
DEPENDS += "libamxc"
DEPENDS += "libamxp"
DEPENDS += "libamxd"
DEPENDS += "libamxo"
DEPENDS += "libamxb"

RDEPENDS:${PN} += "libsahtrace"
RDEPENDS:${PN} += "libamxc"
RDEPENDS:${PN} += "libamxp"
RDEPENDS:${PN} += "libamxd"
RDEPENDS:${PN} += "libamxo"
RDEPENDS:${PN} += "libamxb"
RDEPENDS:${PN} += "amxrt"
RDEPENDS:${PN} += "mod-sahtrace"

inherit update-rc.d
INITSCRIPT_NAME = "${COMPONENT}"

INITSCRIPT_PARAMS = "start 99 2 3 4 5 . stop 88 0 1 6 ."

EXTRA_OEMAKE += "DEST=${D} \
                 PREFIX=${prefix} \
                 LIBDIR=${libdir} \
                 BINDIR=${bindir} \
                 INCLUDEDIR=${includedir} \
                 "

FILES:${PN} += "/usr/lib/amx/${COMPONENT}/${COMPONENT}.so"
FILES:${PN} += "/etc/amx/${COMPONENT}/*.odl"
FILES:${PN} += "/usr/bin/${COMPONENT}"
FILES:${PN} += "${INITDIR}/${COMPONENT}"
FILES:${PN} += "${LIBDIR}/debuginfo/D10${COMPONENT}"
