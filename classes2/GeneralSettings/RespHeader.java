package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespHeader
  extends JceStruct
{
  public int Result;
  public String ResultDesc;
  
  public RespHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ResultDesc = "";
  }
  
  public RespHeader(int paramInt, String paramString)
  {
    this.ResultDesc = "";
    this.Result = paramInt;
    this.ResultDesc = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Result = paramJceInputStream.read(this.Result, 0, true);
    this.ResultDesc = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Result, 0);
    if (this.ResultDesc != null) {
      paramJceOutputStream.write(this.ResultDesc, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GeneralSettings\RespHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */