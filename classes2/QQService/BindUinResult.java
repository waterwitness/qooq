package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BindUinResult
  extends JceStruct
{
  public int iResult;
  public long lUin;
  public String strResult;
  
  public BindUinResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strResult = "";
  }
  
  public BindUinResult(long paramLong, int paramInt, String paramString)
  {
    this.strResult = "";
    this.lUin = paramLong;
    this.iResult = paramInt;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    this.strResult = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iResult, 1);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\BindUinResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */