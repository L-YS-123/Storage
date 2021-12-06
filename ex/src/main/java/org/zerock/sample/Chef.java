package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data //lombok 라이브러리 어노테이션
public class Chef {
	
	@Setter(onMethod_ = @Autowired) //onMethod가 뭔지 나중에 검색
	private Chef chef;
}
