package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetSameStateList
  extends JceStruct
{
  static BusiRespHead cache_oHead;
  static byte[] cache_vCookie;
  static ArrayList cache_vUserInfos;
  public BusiRespHead oHead;
  public byte[] vCookie;
  public ArrayList vUserInfos;
  
  public RespGetSameStateList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespGetSameStateList(BusiRespHead paramBusiRespHead, byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    this.oHead = paramBusiRespHead;
    this.vCookie = paramArrayOfByte;
    this.vUserInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oHead == null) {
      cache_oHead = new BusiRespHead();
    }
    this.oHead = ((BusiRespHead)paramJceInputStream.read(cache_oHead, 0, true));
    if (cache_vCookie == null)
    {
      cache_vCookie = (byte[])new byte[1];
      ((byte[])cache_vCookie)[0] = 0;
    }
    this.vCookie = ((byte[])paramJceInputStream.read(cache_vCookie, 1, true));
    if (cache_vUserInfos == null)
    {
      cache_vUserInfos = new ArrayList();
      UserProfile localUserProfile = new UserProfile();
      cache_vUserInfos.add(localUserProfile);
    }
    this.vUserInfos = ((ArrayList)paramJceInputStream.read(cache_vUserInfos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oHead, 0);
    paramJceOutputStream.write(this.vCookie, 1);
    if (this.vUserInfos != null) {
      paramJceOutputStream.write(this.vUserInfos, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\RespGetSameStateList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */