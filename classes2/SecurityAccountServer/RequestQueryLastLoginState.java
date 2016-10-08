package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestQueryLastLoginState
  extends JceStruct
{
  public String MobileUniqueNo;
  public long nextFlag;
  public long timeStamp;
  
  public RequestQueryLastLoginState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.MobileUniqueNo = "";
  }
  
  public RequestQueryLastLoginState(long paramLong1, long paramLong2, String paramString)
  {
    this.MobileUniqueNo = "";
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.MobileUniqueNo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.MobileUniqueNo = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestQueryLastLoginState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */