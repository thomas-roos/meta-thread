require recipes-core/images/image-lcm-container-minimal.bb

SUMMARY = "Iot LCM container for prpl with matter and thread for dongle"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FSTYPES = "container tar.bz2 oci"

IMAGE_INSTALL += "\
    otbr \
    dbus  \
    iptables \
    otbr-monitor \
    avahi-daemon \
    avahi-utils \
"
#    hotplug

IMAGE_FEATURES:remove = "usp-base"

# IMAGE_INSTALL:append:develop = "\
#     strace procps gdb valgrind tcpdump binutils nano sshserver \
# "

# IMAGE_INSTALL:append:release = "\
#     ssh \
# "

# IMAGE_INSTALL:<MACHINE> += "\
#     <...> \
# " (not related to LCM from the lcm minimal image)


# Application to install

#OCI configuration
## application to run
OCI_IMAGE_ENTRYPOINT = "/sbin/init"
OCI_IMAGE_ENTRYPOINT_ARGS = ""

LCM_SYSBUS = "ubus"
