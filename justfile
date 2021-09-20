export GRAAL_HOME := "~/.jenv/candidates/java/graalvm-21.2-java11"

# native build
native_build:
   mvn -DskipTests clean package native:build
   upx -7 -k target/demo-cli

# shell completion
shell-completion:
   mvn compile exec:exec

# run with agent
run_with_agent:
   mkdir -p target/native-image
   {{GRAAL_HOME}}/bin/java -agentlib:native-image-agent=config-output-dir=target/native-image -jar target/demo-cli.jar demo

# run test
test:
   ./target/demo-cli Jackie

# setup
setup:
   brew install upx
