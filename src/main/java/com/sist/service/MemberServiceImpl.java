package com.sist.service;
import com.sist.mapper.*;
import com.sist.vo.*;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
      private final MemberMapper mapper;

	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		mapper.memberInsert(vo);
	}
      
}
