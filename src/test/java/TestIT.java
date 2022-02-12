import java.io.File;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.lifecycle.Startable;
import org.testcontainers.utility.DockerImageName;

public class TestIT {

  private static final DockerImageName IMAGE_NAME = DockerImageName.parse("redis:5.0.3-alpine");
  private static final GenericContainer GENERIC_CONTAINER = new GenericContainer(IMAGE_NAME);
  private static final DockerComposeContainer COMPOSE_CONTAINER = new DockerComposeContainer(new File(
      "src/test/resources/docker-compose.yaml"
  ));

  static {
    Stream.of(GENERIC_CONTAINER, COMPOSE_CONTAINER).parallel().forEach(Startable::start);
  }

  @Test
  void test() {
  }

}
