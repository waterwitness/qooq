package PushAdMsg;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AdMsgInfo
  extends JceStruct
{
  public String strMsgContent;
  public long uDstUin;
  public int uMsgType;
  public long uSrcUin;
  public long utime;
  
  public AdMsgInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strMsgContent = "";
  }
  
  public AdMsgInfo(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    this.strMsgContent = "";
    this.uSrcUin = paramLong1;
    this.uDstUin = paramLong2;
    this.utime = paramLong3;
    this.uMsgType = paramInt;
    this.strMsgContent = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uSrcUin = paramJceInputStream.read(this.uSrcUin, 1, true);
    this.uDstUin = paramJceInputStream.read(this.uDstUin, 2, true);
    this.utime = paramJceInputStream.read(this.utime, 3, true);
    this.uMsgType = paramJceInputStream.read(this.uMsgType, 4, true);
    this.strMsgContent = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uSrcUin, 1);
    paramJceOutputStream.write(this.uDstUin, 2);
    paramJceOutputStream.write(this.utime, 3);
    paramJceOutputStream.write(this.uMsgType, 4);
    paramJceOutputStream.write(this.strMsgContent, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PushAdMsg\AdMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */