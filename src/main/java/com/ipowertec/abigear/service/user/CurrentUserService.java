package com.ipowertec.abigear.service.user;

import com.ipowertec.abigear.domain.user.CurrentUser;

public interface CurrentUserService {
    
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
