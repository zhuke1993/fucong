import org.testng.annotations.Test;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by ZHUKE on 2015/10/24.
 */
public class OthersTest {
    @Test
    public void testcuicui(){
        getRemoteInfo("18883283704");
    }

    public void getRemoteInfo(String phoneSec) {
        // �����ռ�

        String nameSpace = "http://WebXml.com.cn/";
        // ���õķ�������
        String methodName = "getMobileCodeInfo";
        // EndPoint
        String endPoint = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";
        // SOAP Action
        String soapAction = "http://WebXml.com.cn/getMobileCodeInfo";

        // ָ��WebService�������ռ�͵��õķ�����
        SoapObject rpc = new SoapObject(nameSpace, methodName);

        // ���������WebService�ӿ���Ҫ�������������mobileCode��userId
        rpc.addProperty("mobileCode", phoneSec);
        rpc.addProperty("userId", "");

        // ���ɵ���WebService������SOAP������Ϣ,��ָ��SOAP�İ汾
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER10);

        envelope.bodyOut = rpc;
        // �����Ƿ���õ���dotNet������WebService
        envelope.dotNet = true;
        // �ȼ���envelope.bodyOut = rpc;
        envelope.setOutputSoapObject(rpc);


        HttpTransportSE transport = new HttpTransportSE(endPoint);


        try {
            // ����WebService
            transport.call(null, envelope);
            System.out.println("--------"+envelope.getResponse());
            if(envelope.getResponse()!=null){

                // ��ȡ���ص�����
                SoapObject object = (SoapObject) envelope.bodyIn;

                // ��ȡ���صĽ��
                String result = object.getProperty(0).toString();

                System.out.println(result);
            }else{
                System.out.println("---------->>>>>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("------cuicui");
        }


    }
}
