package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqCommon_V2
  extends JceStruct
{
  public int iAppId;
  public int iDeviceType;
  
  public ReqCommon_V2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqCommon_V2(int paramInt1, int paramInt2)
  {
    this.iAppId = paramInt1;
    this.iDeviceType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 0, true);
    this.iDeviceType = paramJceInputStream.read(this.iDeviceType, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 0);
    paramJceOutputStream.write(this.iDeviceType, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBS_V2_PROTOCOL\ReqCommon_V2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */