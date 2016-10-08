package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ProfRecentRes
  extends JceStruct
{
  static ArrayList cache_vFriendInfo;
  public byte cMask;
  public byte cResult;
  public long uServerTime;
  public ArrayList vFriendInfo;
  public short wFriendNum;
  
  public ProfRecentRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfRecentRes(byte paramByte1, long paramLong, byte paramByte2, short paramShort, ArrayList paramArrayList)
  {
    this.cResult = paramByte1;
    this.uServerTime = paramLong;
    this.cMask = paramByte2;
    this.wFriendNum = paramShort;
    this.vFriendInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    this.uServerTime = paramJceInputStream.read(this.uServerTime, 2, true);
    this.cMask = paramJceInputStream.read(this.cMask, 3, true);
    this.wFriendNum = paramJceInputStream.read(this.wFriendNum, 4, true);
    if (cache_vFriendInfo == null)
    {
      cache_vFriendInfo = new ArrayList();
      FriendUinInfo localFriendUinInfo = new FriendUinInfo();
      cache_vFriendInfo.add(localFriendUinInfo);
    }
    this.vFriendInfo = ((ArrayList)paramJceInputStream.read(cache_vFriendInfo, 5, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 1);
    paramJceOutputStream.write(this.uServerTime, 2);
    paramJceOutputStream.write(this.cMask, 3);
    paramJceOutputStream.write(this.wFriendNum, 4);
    paramJceOutputStream.write(this.vFriendInfo, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfRecentRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */