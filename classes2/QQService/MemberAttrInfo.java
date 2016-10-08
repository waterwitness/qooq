package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MemberAttrInfo
  extends JceStruct
{
  public String StrValue;
  public int Value;
  
  public MemberAttrInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.StrValue = "";
  }
  
  public MemberAttrInfo(int paramInt, String paramString)
  {
    this.StrValue = "";
    this.Value = paramInt;
    this.StrValue = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Value = paramJceInputStream.read(this.Value, 0, true);
    this.StrValue = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Value, 0);
    if (this.StrValue != null) {
      paramJceOutputStream.write(this.StrValue, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\MemberAttrInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */