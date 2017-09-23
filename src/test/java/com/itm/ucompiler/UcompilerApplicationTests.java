package com.itm.ucompiler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itm.ucompiler.auxdata.YesNot;
import com.itm.ucompiler.model.ParentEntity;
import com.itm.ucompiler.util.Encryption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UcompilerApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		System.out.println(Encryption.encryptMD5("1234"));
	}
}
