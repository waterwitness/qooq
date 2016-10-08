package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcResponseSendFile
  extends JceStruct
{
  public String strResult;
  public long uReplyCode;
  
  public SvcResponseSendFile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strResult = "";
  }
  
  public SvcResponseSendFile(long paramLong, String paramString)
  {
    this.strResult = "";
    this.uReplyCode = paramLong;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uReplyCode = paramJceInputStream.read(this.uReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uReplyCode, 0);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcResponseSendFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */