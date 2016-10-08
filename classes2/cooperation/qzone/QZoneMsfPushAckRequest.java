package cooperation.qzone;

import PUSHAPI.PushRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import common.config.service.WupTool;

public class QZoneMsfPushAckRequest
  extends QzoneExternalRequest
{
  public static final int a = 1000000;
  public static final String a = "wns.pushrsp";
  public static final int b = 1000006;
  private static final String jdField_b_of_type_JavaLangString = "wns.pushrsp";
  private static final String c = "wns.pushrsp";
  private long a;
  private long jdField_b_of_type_Long;
  private String d;
  
  public QZoneMsfPushAckRequest(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    super.setRefer(paramString1);
    this.a = paramLong2;
    this.b = paramLong3;
    this.d = paramString2;
    this.needCompress = false;
  }
  
  public String getCmdString()
  {
    return "wns.pushrsp";
  }
  
  protected byte[] getEncodedUniParameter()
  {
    PushRsp localPushRsp = new PushRsp();
    localPushRsp.ptime = this.a;
    localPushRsp.is_bgd = 0;
    localPushRsp.sUID = "<JIEHEBAN>";
    localPushRsp.flag = this.b;
    localPushRsp.Mark = this.d;
    return WupTool.a(localPushRsp);
  }
  
  public JceStruct getReq()
  {
    return null;
  }
  
  public String uniKey()
  {
    return "wns.pushrsp";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneMsfPushAckRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */