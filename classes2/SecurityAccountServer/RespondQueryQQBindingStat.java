package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespondQueryQQBindingStat
  extends JceStruct
{
  static int cache_type;
  public String MobileUniqueNo;
  public long bindingTime;
  public boolean isPhoneSwitched;
  public long isRecommend;
  public boolean isStopFindMatch;
  public long lastUsedFlag;
  public String mobileNo;
  public String nationCode;
  public long originBinder;
  public int type;
  
  public RespondQueryQQBindingStat()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nationCode = "";
    this.mobileNo = "";
    this.MobileUniqueNo = "";
    this.lastUsedFlag = 1L;
    this.type = 0;
  }
  
  public RespondQueryQQBindingStat(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    this.nationCode = "";
    this.mobileNo = "";
    this.MobileUniqueNo = "";
    this.lastUsedFlag = 1L;
    this.type = 0;
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.MobileUniqueNo = paramString3;
    this.isRecommend = paramLong1;
    this.originBinder = paramLong2;
    this.bindingTime = paramLong3;
    this.lastUsedFlag = paramLong4;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
    this.MobileUniqueNo = paramJceInputStream.readString(2, true);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 3, true);
    this.originBinder = paramJceInputStream.read(this.originBinder, 4, true);
    this.bindingTime = paramJceInputStream.read(this.bindingTime, 5, false);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 6, false);
    this.type = paramJceInputStream.read(this.type, 7, false);
  }
  
  public String toString()
  {
    return "[" + this.MobileUniqueNo + ", " + this.nationCode + ", " + this.mobileNo + ", " + this.lastUsedFlag + "]";
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
    paramJceOutputStream.write(this.MobileUniqueNo, 2);
    paramJceOutputStream.write(this.isRecommend, 3);
    paramJceOutputStream.write(this.originBinder, 4);
    paramJceOutputStream.write(this.bindingTime, 5);
    paramJceOutputStream.write(this.lastUsedFlag, 6);
    paramJceOutputStream.write(this.type, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RespondQueryQQBindingStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */