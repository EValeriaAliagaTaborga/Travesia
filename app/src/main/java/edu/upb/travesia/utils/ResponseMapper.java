package edu.upb.travesia.utils;

import com.google.firebase.auth.FirebaseUser;

import edu.upb.travesia.models.types.UserType;
import edu.upb.travesia.models.ui.UserLogged;

public class ResponseMapper {
    public static UserLogged mapUserToUserLooged(FirebaseUser user) {
        if (user.getEmail().equals(Constants.USER_EMAIL_GUIDE)) {
            return new UserLogged(user.getEmail(), UserType.GUIDE);
        } else {
            return new UserLogged(user.getEmail(), UserType.REGULAR_USER);
        }
    }

}
