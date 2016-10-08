package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DiscussRespHeader
  extends JceStruct
{
  public int Result;
  public String ResultDesc;
  
  public DiscussRespHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ResultDesc = "";
  }
  
  public DiscussRespHeader(int paramInt, String paramString)
  {
    this.ResultDesc = "";
    this.Result = paramInt;
    this.ResultDesc = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Result = paramJceInputStream.read(this.Result, 0, true);
    this.ResultDesc = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Result, 0);
    paramJceOutputStream.write(this.ResultDesc, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\DiscussRespHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */