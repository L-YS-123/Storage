package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data //lombok ���̺귯�� ������̼�
public class Chef {
	
	@Setter(onMethod_ = @Autowired) //onMethod�� ���� ���߿� �˻�
	private Chef chef;
}
