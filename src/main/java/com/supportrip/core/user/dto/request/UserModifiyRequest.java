package com.supportrip.core.user.dto.request;

import com.supportrip.core.account.dto.request.BankRequest;
import lombok.Getter;

@Getter
public class UserModifiyRequest {
    private String phoneNumber;
    private BankRequest bankAccounts;
    private String email;
    private String receiveStatus;
}