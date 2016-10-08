package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetEncounter
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static UserData cache_stUserData;
  static ReqUserInfo cache_stUserInfo;
  public int iListSize;
  public ReqHeader stHeader;
  public UserData stUserData;
  public ReqUserInfo stUserInfo;
  
  public ReqGetEncounter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iListSize = -1;
  }
  
  public ReqGetEncounter(ReqHeader paramReqHeader, ReqUserInfo paramReqUserInfo, UserData paramUserData, int paramInt)
  {
    this.iListSize = -1;
    this.stHeader = paramReqHeader;
    this.stUserInfo = paramReqUserInfo;
    this.stUserData = paramUserData;
    this.iListSize = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 1, true));
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 2, true));
    this.iListSize = paramJceInputStream.read(this.iListSize, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stUserInfo, 1);
    paramJceOutputStream.write(this.stUserData, 2);
    paramJceOutputStream.write(this.iListSize, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\ReqGetEncounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */