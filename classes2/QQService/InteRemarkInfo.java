package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class InteRemarkInfo
  extends JceStruct
{
  public long Source;
  public String StrValue;
  
  public InteRemarkInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.StrValue = "";
  }
  
  public InteRemarkInfo(String paramString, long paramLong)
  {
    this.StrValue = "";
    this.StrValue = paramString;
    this.Source = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.StrValue = paramJceInputStream.readString(0, true);
    this.Source = paramJceInputStream.read(this.Source, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.StrValue, 0);
    paramJceOutputStream.write(this.Source, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\InteRemarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */