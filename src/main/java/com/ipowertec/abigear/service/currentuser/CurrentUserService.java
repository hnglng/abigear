package com.ipowertec.abigear.service.currentuser;

import com.ipowertec.abigear.domain.CurrentUser;

public interface CurrentUserService {
    
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
