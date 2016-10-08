package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SearchInfo
  extends JceStruct
{
  static int cache_eSource;
  public byte bInContact;
  public byte bIsEnterpriseQQ;
  public byte bIsFriend;
  public int eSource;
  public long lUIN;
  public String strMobile;
  public String strNick;
  
  public SearchInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strNick = "";
    this.strMobile = "";
  }
  
  public SearchInfo(long paramLong, int paramInt, String paramString1, String paramString2, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.strNick = "";
    this.strMobile = "";
    this.lUIN = paramLong;
    this.eSource = paramInt;
    this.strNick = paramString1;
    this.strMobile = paramString2;
    this.bIsFriend = paramByte1;
    this.bInContact = paramByte2;
    this.bIsEnterpriseQQ = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.eSource = paramJceInputStream.read(this.eSource, 1, true);
    this.strNick = paramJceInputStream.readString(2, false);
    this.strMobile = paramJceInputStream.readString(3, false);
    this.bIsFriend = paramJceInputStream.read(this.bIsFriend, 4, false);
    this.bInContact = paramJceInputStream.read(this.bInContact, 5, false);
    this.bIsEnterpriseQQ = paramJceInputStream.read(this.bIsEnterpriseQQ, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.eSource, 1);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 2);
    }
    if (this.strMobile != null) {
      paramJceOutputStream.write(this.strMobile, 3);
    }
    paramJceOutputStream.write(this.bIsFriend, 4);
    paramJceOutputStream.write(this.bInContact, 5);
    paramJceOutputStream.write(this.bIsEnterpriseQQ, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\SearchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */