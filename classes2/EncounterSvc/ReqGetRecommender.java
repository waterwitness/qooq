package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetRecommender
  extends JceStruct
{
  static int cache_eTimingType;
  static ReqUserInfo cache_stUserInfo;
  public int eTimingType;
  public ReqUserInfo stUserInfo;
  
  public ReqGetRecommender()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.eTimingType = 0;
  }
  
  public ReqGetRecommender(ReqUserInfo paramReqUserInfo, int paramInt)
  {
    this.eTimingType = 0;
    this.stUserInfo = paramReqUserInfo;
    this.eTimingType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.eTimingType = paramJceInputStream.read(this.eTimingType, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.eTimingType, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\ReqGetRecommender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */