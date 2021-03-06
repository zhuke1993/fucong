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
        // 命名空间

        String nameSpace = "http://WebXml.com.cn/";
        // 调用的方法名称
        String methodName = "getMobileCodeInfo";
        // EndPoint
        String endPoint = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";
        // SOAP Action
        String soapAction = "http://WebXml.com.cn/getMobileCodeInfo";

        // 指定WebService的命名空间和调用的方法名
        SoapObject rpc = new SoapObject(nameSpace, methodName);

        // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
        rpc.addProperty("mobileCode", phoneSec);
        rpc.addProperty("userId", "");

        // 生成调用WebService方法的SOAP请求信息,并指定SOAP的版本
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER10);

        envelope.bodyOut = rpc;
        // 设置是否调用的是dotNet开发的WebService
        envelope.dotNet = true;
        // 等价于envelope.bodyOut = rpc;
        envelope.setOutputSoapObject(rpc);


        HttpTransportSE transport = new HttpTransportSE(endPoint);


        try {
            // 调用WebService
            transport.call(null, envelope);
            System.out.println("--------"+envelope.getResponse());
            if(envelope.getResponse()!=null){

                // 获取返回的数据
                SoapObject object = (SoapObject) envelope.bodyIn;

                // 获取返回的结果
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
