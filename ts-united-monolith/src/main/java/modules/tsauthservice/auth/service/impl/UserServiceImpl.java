package modules.tsauthservice.auth.service.impl;
import java.text.MessageFormat;
import java.util.*;
import modules.tsauthservice.auth.constant.AuthConstant;
import modules.tsauthservice.auth.constant.InfoConstant;
import modules.tsauthservice.auth.dto.AuthDto;
import modules.tsauthservice.auth.entity.UserFromtsauthservice;
import modules.tsauthservice.auth.exception.UserOperationException;
import modules.tsauthservice.auth.repository.UserRepository;
import modules.tsauthservice.auth.service.UserService;
import modules.tscommon.edu.fudan.common.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author fdse
 */
@Service("userServiceImplFromtsauthservice")
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Override
    public UserFromtsauthservice saveUser(UserFromtsauthservice user) {
        return null;
    }

    @Override
    public List<UserFromtsauthservice> getAllUser(HttpHeaders headers) {
        return ((List<UserFromtsauthservice>) (userRepository.findAll()));
    }

    /**
     * create  a user with default role of user
     *
     * @param dto
     * @return  */
    @Override
    public UserFromtsauthservice createDefaultAuthUser(AuthDto dto) {
        LOGGER.info("[createDefaultAuthUser][Register User Info][AuthDto name: {}]", dto.getUserName());
        UserFromtsauthservice user = UserFromtsauthservice.builder().userId(dto.getUserId()).username(dto.getUserName()).password(passwordEncoder.encode(dto.getPassword())).roles(new HashSet<>(Arrays.asList(AuthConstant.ROLE_USER))).build();
        try {
            checkUserCreateInfo(user);
        } catch (UserOperationException e) {
            LOGGER.error("[createDefaultAuthUser][Create default auth user][UserOperationException][message: {}]", e.getMessage());
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Response deleteByUserId(String userId, HttpHeaders headers) {
        LOGGER.info("[deleteByUserId][DELETE USER][user id: {}]", userId);
        userRepository.deleteByUserId(userId);
        return new Response(1, "DELETE USER SUCCESS", null);
    }

    /**
     * check Whether user info is empty
     *
     * @param user
     */
    private void checkUserCreateInfo(UserFromtsauthservice user) throws UserOperationException {
        LOGGER.info("[checkUserCreateInfo][Check user create info][userId: {}, userName: {}]", user.getUserId(), user.getUsername());
        List<String> infos = new ArrayList<>();
        if ((null == user.getUsername()) || "".equals(user.getUsername())) {
            infos.add(MessageFormat.format(InfoConstant.PROPERTIES_CANNOT_BE_EMPTY_1, InfoConstant.USERNAME));
        }
        int passwordMaxLength = 6;
        if (null == user.getPassword()) {
            infos.add(MessageFormat.format(InfoConstant.PROPERTIES_CANNOT_BE_EMPTY_1, InfoConstant.PASSWORD));
        } else if (user.getPassword().length() < passwordMaxLength) {
            infos.add(MessageFormat.format(InfoConstant.PASSWORD_LEAST_CHAR_1, 6));
        }
        if ((null == user.getRoles()) || user.getRoles().isEmpty()) {
            infos.add(MessageFormat.format(InfoConstant.PROPERTIES_CANNOT_BE_EMPTY_1, InfoConstant.ROLES));
        }
        if (!infos.isEmpty()) {
            LOGGER.warn(infos.toString());
            throw new UserOperationException(infos.toString());
        }
    }
}