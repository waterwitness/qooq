package cooperation.qzone.patch;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_REQ;
import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import android.os.Build.VERSION;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class QZonePatchRequest
  extends QzoneExternalRequest
{
  private static final String a = "mqBatchUpdate";
  public JceStruct a;
  
  public QZonePatchRequest(long paramLong, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    SQ_CLIENT_UPDATE_REQ localSQ_CLIENT_UPDATE_REQ = new SQ_CLIENT_UPDATE_REQ();
    localSQ_CLIENT_UPDATE_REQ.qua = QUA.a();
    localSQ_CLIENT_UPDATE_REQ.version = AppSetting.d();
    localSQ_CLIENT_UPDATE_REQ.apiLevel = Build.VERSION.SDK_INT;
    localSQ_CLIENT_UPDATE_REQ.triggerType = 1;
    localSQ_CLIENT_UPDATE_REQ.vPlugin = paramArrayList;
    this.a = localSQ_CLIENT_UPDATE_REQ;
  }
  
  public static SQ_CLIENT_UPDATE_RSP a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte, "mqBatchUpdate");
    if ((paramArrayOfByte instanceof SQ_CLIENT_UPDATE_RSP)) {
      return (SQ_CLIENT_UPDATE_RSP)paramArrayOfByte;
    }
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.update.mqBatchUpdate";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "mqBatchUpdate";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\patch\QZonePatchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */