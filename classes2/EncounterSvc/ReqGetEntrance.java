package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetEntrance
  extends JceStruct
{
  static ReqUserInfo cache_stUserInfo;
  public ReqUserInfo stUserInfo;
  public int support_entrace_type;
  
  public ReqGetEntrance()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.support_entrace_type = -1;
  }
  
  public ReqGetEntrance(ReqUserInfo paramReqUserInfo, int paramInt)
  {
    this.support_entrace_type = -1;
    this.stUserInfo = paramReqUserInfo;
    this.support_entrace_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.support_entrace_type = paramJceInputStream.read(this.support_entrace_type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.support_entrace_type, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\ReqGetEntrance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */