package model.db.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Example: Users table mx-integration db model.
 */
@Getter
@Setter
@Builder
public class UsersModel {
    private String userId;
    private String externalUserId;
    private String mxUserId;
    private String status;
    private String mxUserGuid;
    private String createdAt;
    private String removedBy;
    private String createdBy;
    private Boolean emptyResult;
}
