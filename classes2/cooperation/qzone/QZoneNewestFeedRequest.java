package cooperation.qzone;

import NS_MOBILE_AIONewestFeed.AIONewestFeedReq;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class QZoneNewestFeedRequest
  extends QzoneExternalRequest
{
  public static final String a = "getAIONewestFeed";
  public static final String b = "getAIONewestFeed";
  private static final String c = "QzoneNewService.getAIONewestFeed";
  private static final String d = "getAIONewestFeed";
  public JceStruct a;
  
  public QZoneNewestFeedRequest(long paramLong1, ArrayList paramArrayList, long paramLong2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setRefer(paramString);
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    paramString = new AIONewestFeedReq();
    paramString.uOpUin = paramLong1;
    paramString.uHostUin = paramArrayList;
    paramString.uLastTime = paramLong2;
    this.a = paramString;
  }
  
  public static AIONewestFeedRsp a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramQQAppInterface = (AIONewestFeedRsp)decode(paramArrayOfByte, "getAIONewestFeed");
      paramArrayOfByte = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAIONewestFeed";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getAIONewestFeed";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneNewestFeedRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */