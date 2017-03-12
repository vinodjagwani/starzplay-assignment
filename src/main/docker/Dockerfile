FROM jolokia/alpine-jre-8
VOLUME /tmp

EXPOSE 8080

ENV SERVICE_NAME starzplay-assignment
ENV SERVICE_8082_TAGS http

ENV _JAVA_OPTIONS  "\
    -Xms128m -Xmx386m  \
    -XX:MaxMetaspaceSize=496m  \
    -Xmn128m  \
    -XX:SurvivorRatio=8  \
    -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled  \
    -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70  \
    -XX:+ScavengeBeforeFullGC -XX:+CMSScavengeBeforeRemark  \
    -XX:+PrintGCDateStamps -verbose:gc -XX:+PrintGCDetails -Xloggc:"/var/log/gc.log"  \
    -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M  \
    -Dsun.net.inetaddr.ttl=5  \
    -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/log/heapdump_`date`.hprof  \
    -Djava.rmi.server.hostname=127.0.0.1  \
    -Dcom.sun.management.jmxremote.port=9009   \
    -Dcom.sun.management.jmxremote.authenticate=false   \
    -Dcom.sun.management.jmxremote.ssl=false  \
    "

COPY maven /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sync-agent-0.1.0.jar"]

