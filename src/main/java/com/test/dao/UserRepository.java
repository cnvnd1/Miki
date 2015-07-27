package com.test.dao;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.exception.LoginWrongPasswdException;
import com.exception.PostWriteException;
import com.exception.UserLoginException;
import com.test.entity.user.UserDTO;
import com.test.entity.user.UserPostWriteDTO;

@Component("userRepository")
public class UserRepository extends RepositoyAdaptor{
	private static final int USERID_NOTFOUND = 0;	
	private static final int SUCCESS = 1;	
	private static final int USERID_LOGINSUCCESS = 1;
	private static final int POSTWRITE_FAILED = 1;
	private static final String INPUTTYPE_LOGIN ="login";
	private static final String INPUTTYPE_SIGNUP ="signup";
	Log log = LogFactory.getLog(UserRepository.class);
	
	@Autowired
	@Qualifier("sessionTemplete2")
	SqlSessionTemplate template;
	
	public int userInsert(UserDTO dto) throws UserLoginException{
	
		if(INPUTTYPE_LOGIN.equals(dto.getSubmit())){
			int loginCheck = template.selectOne("user.login",dto);
			if(USERID_LOGINSUCCESS == loginCheck){
			}else{
				throw new LoginWrongPasswdException("비번이 틀립니다"); 
			}
		}else if(INPUTTYPE_SIGNUP.equals(dto.getSubmit())){
			int loginCheck = template.selectOne("user.findUser",dto);
			if(USERID_NOTFOUND == loginCheck){
				 template.insert("user.insert", dto);
			}else{
				throw new LoginWrongPasswdException("아이디가 중복 됩니다"); 
			}	
		}
		return SUCCESS;
	}
	@Override
	public void userPostWrite(UserPostWriteDTO dto) throws UserLoginException {
		
		int result = template.insert("user.postWrite", dto);
		
		if(POSTWRITE_FAILED ==  result ){
			throw new PostWriteException("포스트 입력 실패");
		}
	}

	@Override
	public List<UserPostWriteDTO> userPostSelect() {
	
		return	template.selectList("user.postSelect",new RowBounds(0, 10));
	}
}
