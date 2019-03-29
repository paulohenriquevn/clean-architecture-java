ambiente=${1:-dev}

rm -r */target/
SPRING_PROFILES_ACTIVE=${ambiente} mvn spring-boot:run -pl web
