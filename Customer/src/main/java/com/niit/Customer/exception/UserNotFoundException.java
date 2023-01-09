/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found")
public class UserNotFoundException extends Exception{
}
