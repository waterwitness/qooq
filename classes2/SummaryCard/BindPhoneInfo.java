package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BindPhoneInfo
  extends JceStruct
{
  public String strName;
  
  public BindPhoneInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strName = "";
  }
  
  public BindPhoneInfo(String paramString)
  {
    this.strName = "";
    this.strName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strName = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\BindPhoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */