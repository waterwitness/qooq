package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetFavoriteList
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList cache_vFavoriteInfos;
  static byte[] cache_vNotice;
  public long RespTime;
  public RespHead stHeader;
  public UserCntlData stUserData;
  public ArrayList vFavoriteInfos;
  public byte[] vNotice;
  
  public RespGetFavoriteList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespGetFavoriteList(RespHead paramRespHead, long paramLong, ArrayList paramArrayList, UserCntlData paramUserCntlData, byte[] paramArrayOfByte)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vFavoriteInfos = paramArrayList;
    this.stUserData = paramUserCntlData;
    this.vNotice = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    if (cache_vFavoriteInfos == null)
    {
      cache_vFavoriteInfos = new ArrayList();
      UserProfile localUserProfile = new UserProfile();
      cache_vFavoriteInfos.add(localUserProfile);
    }
    this.vFavoriteInfos = ((ArrayList)paramJceInputStream.read(cache_vFavoriteInfos, 2, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
    if (cache_vNotice == null)
    {
      cache_vNotice = (byte[])new byte[1];
      ((byte[])cache_vNotice)[0] = 0;
    }
    this.vNotice = ((byte[])paramJceInputStream.read(cache_vNotice, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    if (this.vFavoriteInfos != null) {
      paramJceOutputStream.write(this.vFavoriteInfos, 2);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 3);
    }
    if (this.vNotice != null) {
      paramJceOutputStream.write(this.vNotice, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespGetFavoriteList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */