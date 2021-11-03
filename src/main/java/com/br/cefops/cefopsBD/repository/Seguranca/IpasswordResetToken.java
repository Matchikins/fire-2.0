package com.br.cefops.cefopsBD.repository.Seguranca;

import java.util.Optional;

import com.br.cefops.cefopsBD.domain.seguranca.User;
import com.br.cefops.cefopsBD.domain.Financias.PasswordResetToken;


public interface IpasswordResetToken {

	User getUser(String verificationToken);
	
	void createVerificationTokenForUser(User user, String token);

	PasswordResetToken getVerificationToken(String VerificationToken);

	PasswordResetToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);
    
    PasswordResetToken getPasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);

}
