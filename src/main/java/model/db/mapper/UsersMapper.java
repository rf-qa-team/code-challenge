package model.db.mapper;

import model.db.model.UsersModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Example: Mapper for users table.
 */
public class UsersMapper implements RowMapper<UsersModel> {

    @Override
    public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UsersModel.builder()
                .userId(rs.getString("USER_ID"))
                .mxUserId(rs.getString("MX_USER_ID"))
                .externalUserId(rs.getString("EXTERNAL_USER_ID"))
                .createdAt(rs.getString("CREATED_AT"))
                .mxUserGuid(rs.getString("mx_user_guid"))
                .status(rs.getString("status"))
                .removedBy(rs.getString("removed_by"))
                .createdBy(rs.getString("created_by"))
                .build();
    }
}
