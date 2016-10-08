package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MobileContactsFriendInfo
  extends JceStruct
{
  static byte[] cache_MobileNoMask;
  public byte[] MobileNoMask;
  public String QQ;
  public int accountAbi;
  public long bindingDate;
  public String contactsInfoEncrypt;
  public long isRecommend;
  public long originBinder;
  
  public MobileContactsFriendInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.QQ = "";
    this.contactsInfoEncrypt = "";
    this.accountAbi = 0;
  }
  
  public MobileContactsFriendInfo(String paramString1, long paramLong1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt)
  {
    this.QQ = "";
    this.contactsInfoEncrypt = "";
    this.accountAbi = 0;
    this.QQ = paramString1;
    this.bindingDate = paramLong1;
    this.isRecommend = paramLong2;
    this.contactsInfoEncrypt = paramString2;
    this.MobileNoMask = paramArrayOfByte;
    this.originBinder = paramLong3;
    this.accountAbi = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.QQ = paramJceInputStream.readString(0, true);
    this.bindingDate = paramJceInputStream.read(this.bindingDate, 1, false);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 2, false);
    this.contactsInfoEncrypt = paramJceInputStream.readString(3, true);
    if (cache_MobileNoMask == null)
    {
      cache_MobileNoMask = (byte[])new byte[1];
      ((byte[])cache_MobileNoMask)[0] = 0;
    }
    this.MobileNoMask = ((byte[])paramJceInputStream.read(cache_MobileNoMask, 4, true));
    this.originBinder = paramJceInputStream.read(this.originBinder, 5, false);
    this.accountAbi = paramJceInputStream.read(this.accountAbi, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.QQ, 0);
    paramJceOutputStream.write(this.bindingDate, 1);
    paramJceOutputStream.write(this.isRecommend, 2);
    paramJceOutputStream.write(this.contactsInfoEncrypt, 3);
    paramJceOutputStream.write(this.MobileNoMask, 4);
    paramJceOutputStream.write(this.originBinder, 5);
    paramJceOutputStream.write(this.accountAbi, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\MobileContactsFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */