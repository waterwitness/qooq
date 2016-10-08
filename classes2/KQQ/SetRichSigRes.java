package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SetRichSigRes
  extends JceStruct
{
  public byte cResult;
  public long dwTime;
  
  public SetRichSigRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cResult = -1;
  }
  
  public SetRichSigRes(byte paramByte, long paramLong)
  {
    this.cResult = -1;
    this.cResult = paramByte;
    this.dwTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    this.dwTime = paramJceInputStream.read(this.dwTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 1);
    paramJceOutputStream.write(this.dwTime, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\SetRichSigRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */