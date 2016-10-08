package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BusiReqHead
  extends JceStruct
{
  public int iSeq;
  public short shVersion;
  
  public BusiReqHead()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BusiReqHead(short paramShort, int paramInt)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\BusiReqHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */