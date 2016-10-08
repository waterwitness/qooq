package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetVoterList
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList cache_vTodayFavoriteInfos;
  static ArrayList cache_vVoterInfos;
  public long RespTime;
  public int iMaxFriendFavoriteCount = 50;
  public int iMaxStrangerFavoriteCount = 50;
  public RespHead stHeader;
  public UserCntlData stUserData;
  public ArrayList vTodayFavoriteInfos;
  public ArrayList vVoterInfos;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_stHeader = new RespHead();
    cache_vVoterInfos = new ArrayList();
    UserProfile localUserProfile = new UserProfile();
    cache_vVoterInfos.add(localUserProfile);
    cache_stUserData = new UserCntlData();
    cache_vTodayFavoriteInfos = new ArrayList();
    localUserProfile = new UserProfile();
    cache_vTodayFavoriteInfos.add(localUserProfile);
  }
  
  public RespGetVoterList() {}
  
  public RespGetVoterList(RespHead paramRespHead, long paramLong, ArrayList paramArrayList1, UserCntlData paramUserCntlData, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vVoterInfos = paramArrayList1;
    this.stUserData = paramUserCntlData;
    this.vTodayFavoriteInfos = paramArrayList2;
    this.iMaxFriendFavoriteCount = paramInt1;
    this.iMaxStrangerFavoriteCount = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    this.vVoterInfos = ((ArrayList)paramJceInputStream.read(cache_vVoterInfos, 2, false));
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
    this.vTodayFavoriteInfos = ((ArrayList)paramJceInputStream.read(cache_vTodayFavoriteInfos, 4, false));
    this.iMaxFriendFavoriteCount = paramJceInputStream.read(this.iMaxFriendFavoriteCount, 5, false);
    this.iMaxStrangerFavoriteCount = paramJceInputStream.read(this.iMaxStrangerFavoriteCount, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    if (this.vVoterInfos != null) {
      paramJceOutputStream.write(this.vVoterInfos, 2);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 3);
    }
    if (this.vTodayFavoriteInfos != null) {
      paramJceOutputStream.write(this.vTodayFavoriteInfos, 4);
    }
    paramJceOutputStream.write(this.iMaxFriendFavoriteCount, 5);
    paramJceOutputStream.write(this.iMaxStrangerFavoriteCount, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespGetVoterList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */