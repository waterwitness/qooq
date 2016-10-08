package AvatarInfo;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DestQQHeadInfo
  extends JceStruct
  implements Cloneable
{
  public long dstUin;
  public long dwTimestamp;
  public String phoneNum;
  
  public DestQQHeadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.phoneNum = "";
  }
  
  public DestQQHeadInfo(long paramLong1, long paramLong2, String paramString)
  {
    this.phoneNum = "";
    this.dstUin = paramLong1;
    this.dwTimestamp = paramLong2;
    this.phoneNum = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.dstUin, "dstUin");
    paramStringBuilder.display(this.dwTimestamp, "dwTimestamp");
    paramStringBuilder.display(this.phoneNum, "phoneNum");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dstUin = paramJceInputStream.read(this.dstUin, 0, true);
    this.dwTimestamp = paramJceInputStream.read(this.dwTimestamp, 1, true);
    this.phoneNum = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dstUin, 0);
    paramJceOutputStream.write(this.dwTimestamp, 1);
    if (this.phoneNum != null) {
      paramJceOutputStream.write(this.phoneNum, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AvatarInfo\DestQQHeadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */