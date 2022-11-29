package util.dbcl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import params.DbParams;

/**
 * Db client: spring.jdbc.
 */
public final class DbClient {
    private DbClient() {
    }

    public static NamedParameterJdbcTemplate namedParameterJdbcTemplate(DbParams dbParams) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(dbParams.getJdbc());
        dataSource.setUsername(dbParams.getUsr());
        dataSource.setPassword(dbParams.getPass());
        return new NamedParameterJdbcTemplate(dataSource);

    }

}
