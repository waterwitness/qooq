package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetCooperateCms
  extends JceStruct
{
  public int cmsType;
  public long preTime;
  
  public ReqGetCooperateCms()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqGetCooperateCms(int paramInt, long paramLong)
  {
    this.cmsType = paramInt;
    this.preTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmsType = paramJceInputStream.read(this.cmsType, 0, true);
    this.preTime = paramJceInputStream.read(this.preTime, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmsType, 0);
    paramJceOutputStream.write(this.preTime, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\acs\ReqGetCooperateCms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */