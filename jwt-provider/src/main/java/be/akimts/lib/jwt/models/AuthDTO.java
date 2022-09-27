package be.akimts.lib.jwt.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AuthDTO {

    private String login;
    private List<String> roles;
    private String token;
    private LocalDateTime expiresAt;

}
