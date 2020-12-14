java -XX:+UnlockDiagnosticVMOptions -XX:+StressLCM -XX:+StressGCM -XX:-RestrictContended -jar target/jcstress.jar -t ".*VolatileFieldConstructor.*" -v -f 100
