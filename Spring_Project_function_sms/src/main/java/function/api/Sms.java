package function.api;

import java.util.HashMap;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class Sms {
	/**
	 * @class ExampleSend
	 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API
	 *        PHP
	 */
	@Value("${coolsms.devYk.apikey}")
	private String apiKey;

	@Value("${coolsms.devYk.apisecret}")
	private String apiSecret;

	@Value("${coolsms.devHee.fromnumber}")
	private String fromNumber;

	// @Value : 보안상 apikey / fromnumber는 다른파일에 보관하기 위해  사용
	// 서비스 파일로 만들어 놓은후 컨트롤러에서 인증번호를 보내야할 때 실행시켜주면 된다.
	
	// sendMessage()에서 toNumber:받는사람 번호 , randomNumber:인증번호 를 담아서 보낸다. 
	public void sendMessage(String toNumber, String randomNumber) {

		Message coolsms = new Message(apiKey, apiSecret);

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", toNumber);
		params.put("from", fromNumber);
		params.put("type", "SMS");
		params.put("text", "[withPP] 인증번호 " + randomNumber + " 를 입력하세요.");
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}
