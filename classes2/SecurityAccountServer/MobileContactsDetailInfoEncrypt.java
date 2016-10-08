package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MobileContactsDetailInfoEncrypt
  extends JceStruct
{
  static byte[] cache_MobileNoMask;
  public byte[] MobileNoMask;
  public String QQ;
  public int accountAbi;
  public long bindingDate;
  public String contactsInfoEncrypt;
  public long isRecommend;
  public String nickname;
  public long originBinder;
  public short rmdScore;
  
  public MobileContactsDetailInfoEncrypt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.QQ = "";
    this.nickname = "";
    this.contactsInfoEncrypt = "";
    this.accountAbi = 0;
  }
  
  public MobileContactsDetailInfoEncrypt(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, byte[] paramArrayOfByte, long paramLong3, int paramInt, short paramShort)
  {
    this.QQ = "";
    this.nickname = "";
    this.contactsInfoEncrypt = "";
    this.accountAbi = 0;
    this.QQ = paramString1;
    this.bindingDate = paramLong1;
    this.isRecommend = paramLong2;
    this.nickname = paramString2;
    this.contactsInfoEncrypt = paramString3;
    this.MobileNoMask = paramArrayOfByte;
    this.originBinder = paramLong3;
    this.accountAbi = paramInt;
    this.rmdScore = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.QQ = paramJceInputStream.readString(0, true);
    this.bindingDate = paramJceInputStream.read(this.bindingDate, 1, false);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 2, false);
    this.nickname = paramJceInputStream.readString(3, false);
    this.contactsInfoEncrypt = paramJceInputStream.readString(4, true);
    if (cache_MobileNoMask == null)
    {
      cache_MobileNoMask = (byte[])new byte[1];
      ((byte[])cache_MobileNoMask)[0] = 0;
    }
    this.MobileNoMask = ((byte[])paramJceInputStream.read(cache_MobileNoMask, 5, true));
    this.originBinder = paramJceInputStream.read(this.originBinder, 6, false);
    this.accountAbi = paramJceInputStream.read(this.accountAbi, 7, false);
    this.rmdScore = paramJceInputStream.read(this.rmdScore, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.QQ, 0);
    paramJceOutputStream.write(this.bindingDate, 1);
    paramJceOutputStream.write(this.isRecommend, 2);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 3);
    }
    paramJceOutputStream.write(this.contactsInfoEncrypt, 4);
    paramJceOutputStream.write(this.MobileNoMask, 5);
    paramJceOutputStream.write(this.originBinder, 6);
    paramJceOutputStream.write(this.accountAbi, 7);
    paramJceOutputStream.write(this.rmdScore, 8);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\MobileContactsDetailInfoEncrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */