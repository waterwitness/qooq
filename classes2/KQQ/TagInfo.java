package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TagInfo
  extends JceStruct
{
  public byte bType;
  public long iTagId;
  public String strContent;
  
  public TagInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strContent = "";
  }
  
  public TagInfo(byte paramByte, long paramLong, String paramString)
  {
    this.strContent = "";
    this.bType = paramByte;
    this.iTagId = paramLong;
    this.strContent = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bType = paramJceInputStream.read(this.bType, 0, true);
    this.iTagId = paramJceInputStream.read(this.iTagId, 1, true);
    this.strContent = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bType, 0);
    paramJceOutputStream.write(this.iTagId, 1);
    if (this.strContent != null) {
      paramJceOutputStream.write(this.strContent, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\TagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */