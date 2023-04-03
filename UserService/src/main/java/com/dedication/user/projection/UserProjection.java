package com.dedication.user.projection;

import org.springframework.stereotype.Component;

import com.dedication.common.models.CardDetails;
import com.dedication.common.models.User;
import com.dedication.common.queries.GetUserPaymentDetailsQuery;

@Component
public class UserProjection {

	public User getUserPaymentDetails(GetUserPaymentDetailsQuery userPaymentDetailsQuery) {
		
		//Ideally get this from DB
		
		CardDetails cardDetails = new CardDetails();
		cardDetails.setName("Gajanan");
		cardDetails.setValidUntilYear(2022);
		cardDetails.setValiUntilMonth(01);
		cardDetails.setCardNumber("12345678");
		cardDetails.setCvv(111);

		User user = new User();
		user.setUserId(userPaymentDetailsQuery.getUserId());
		user.setFirstName("Gajanan");
		user.setLastName("Nandavdekar");
		user.setCardDetails(cardDetails);

		return user;

	}
}
