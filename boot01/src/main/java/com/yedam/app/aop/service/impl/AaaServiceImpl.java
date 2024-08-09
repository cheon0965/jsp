package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService {

	private AaaMapper aMapper;
	@Autowired
	AaaServiceImpl(AaaMapper aMapper){
		this.aMapper = aMapper;
	}
	
	@Override
	@Transactional()
	public void insert() {
		aMapper.aaaInsert("111");
		aMapper.aaaInsert("aaa");
	}
	
}
