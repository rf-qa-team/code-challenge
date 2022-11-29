package params;

import lombok.Builder;
import lombok.Getter;

/**
 * Class that contains db params model. Used in dbClient.
 */
@Getter
@Builder
public class DbParams {
    private final String jdbc;
    private final String usr;
    private final String pass;
}
