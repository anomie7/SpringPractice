package com.SpringBoard.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of={"id", "password"})
public class UserVO {
	@NotBlank(message="id는 필수 입력 값입니다.") @Size(min=7, message="아이디는 7자 이상입니다.")
	private String id;
	@NotBlank(message="pw는 필수 입력 값입니다.") @Size(min=5, message="패스워드는 5자 이상입니다.")
	private String password;
	@Email
	private String email;
	private String tel;
}
