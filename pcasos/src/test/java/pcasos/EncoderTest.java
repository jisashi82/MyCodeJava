package pcasos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderTest {
	
	public static void main(String[] args) {
		
		String t="1234567";
		BCryptPasswordEncoder pass= new BCryptPasswordEncoder();
		String result= pass.encode(t);
		System.out.println(result);
	}

}
