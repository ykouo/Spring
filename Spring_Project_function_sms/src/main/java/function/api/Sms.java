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

	// @Value : ���Ȼ� apikey / fromnumber�� �ٸ����Ͽ� �����ϱ� ����  ���
	// ���� ���Ϸ� ����� ������ ��Ʈ�ѷ����� ������ȣ�� �������� �� ��������ָ� �ȴ�.
	
	// sendMessage()���� toNumber:�޴»�� ��ȣ , randomNumber:������ȣ �� ��Ƽ� ������. 
	public void sendMessage(String toNumber, String randomNumber) {

		Message coolsms = new Message(apiKey, apiSecret);

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", toNumber);
		params.put("from", fromNumber);
		params.put("type", "SMS");
		params.put("text", "[withPP] ������ȣ " + randomNumber + " �� �Է��ϼ���.");
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
