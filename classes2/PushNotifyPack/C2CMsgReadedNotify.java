package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class C2CMsgReadedNotify
  extends JceStruct
{
  public long lBindedUin;
  public long lFlag;
  public long lLastReadTime;
  public long lPeerUin;
  public String strPhoneNum;
  
  public C2CMsgReadedNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strPhoneNum = "";
  }
  
  public C2CMsgReadedNotify(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4)
  {
    this.strPhoneNum = "";
    this.lPeerUin = paramLong1;
    this.lLastReadTime = paramLong2;
    this.lFlag = paramLong3;
    this.strPhoneNum = paramString;
    this.lBindedUin = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 0, false);
    this.lLastReadTime = paramJceInputStream.read(this.lLastReadTime, 1, false);
    this.lFlag = paramJceInputStream.read(this.lFlag, 2, false);
    this.strPhoneNum = paramJceInputStream.readString(3, false);
    this.lBindedUin = paramJceInputStream.read(this.lBindedUin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lPeerUin, 0);
    paramJceOutputStream.write(this.lLastReadTime, 1);
    paramJceOutputStream.write(this.lFlag, 2);
    if (this.strPhoneNum != null) {
      paramJceOutputStream.write(this.strPhoneNum, 3);
    }
    paramJceOutputStream.write(this.lBindedUin, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PushNotifyPack\C2CMsgReadedNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */