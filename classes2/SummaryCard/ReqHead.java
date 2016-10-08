package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqHead
  extends JceStruct
{
  public int iVersion;
  
  public ReqHead()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iVersion = 1;
  }
  
  public ReqHead(int paramInt)
  {
    this.iVersion = 1;
    this.iVersion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iVersion = paramJceInputStream.read(this.iVersion, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersion, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\ReqHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */