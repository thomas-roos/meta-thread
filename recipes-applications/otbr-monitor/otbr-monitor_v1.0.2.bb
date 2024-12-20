SRC_URI = "git://gitlab.com/prpl-foundation/components/iot/thread/otbr-monitor.git;protocol=https;nobranch=1"
SRCREV = "v1.0.2"
S = "${WORKDIR}/git"

inherit pkgconfig config-thread config-amx

SUMMARY = "OTBR monitor, launching and restarting openthread border router"
LICENSE += "BSD-2-Clause-Patent"
LIC_FILES_CHKSUM = " \
                    file://LICENSE.BSD;md5=cd9db409406fd4c7234d852479547016 \
                    file://LICENSE.SAH;md5=87f936f5d9d60bf1e6b689253d476202 \
                    "
COMPONENT = "otbr-monitor"


DEPENDS += "libsahtrace"
DEPENDS += "libamxc"
DEPENDS += "libamxp"
DEPENDS += "libamxd"
DEPENDS += "libamxo"
DEPENDS += "libamxb"
DEPENDS += "dbus"

RDEPENDS:${PN} += "libsahtrace"
RDEPENDS:${PN} += "libamxc"
RDEPENDS:${PN} += "libamxp"
RDEPENDS:${PN} += "libamxd"
RDEPENDS:${PN} += "libamxo"
RDEPENDS:${PN} += "libevent"
RDEPENDS:${PN} += "libamxb"
RDEPENDS:${PN} += "amxrt"
RDEPENDS:${PN} += "dbus"
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

