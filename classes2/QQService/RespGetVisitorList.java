package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetVisitorList
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList cache_vEncounterInfos;
  public long RespTime;
  public RespHead stHeader;
  public UserCntlData stUserData;
  public ArrayList vEncounterInfos;
  
  public RespGetVisitorList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespGetVisitorList(RespHead paramRespHead, long paramLong, ArrayList paramArrayList, UserCntlData paramUserCntlData)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vEncounterInfos = paramArrayList;
    this.stUserData = paramUserCntlData;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    if (cache_vEncounterInfos == null)
    {
      cache_vEncounterInfos = new ArrayList();
      UserProfile localUserProfile = new UserProfile();
      cache_vEncounterInfos.add(localUserProfile);
    }
    this.vEncounterInfos = ((ArrayList)paramJceInputStream.read(cache_vEncounterInfos, 2, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    if (this.vEncounterInfos != null) {
      paramJceOutputStream.write(this.vEncounterInfos, 2);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespGetVisitorList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */