package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DelGroupResp
  extends JceStruct
{
  public byte cGroupid;
  public long dwSequence;
  public long dwToUin;
  
  public DelGroupResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DelGroupResp(long paramLong1, long paramLong2, byte paramByte)
  {
    this.dwToUin = paramLong1;
    this.dwSequence = paramLong2;
    this.cGroupid = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.dwSequence = paramJceInputStream.read(this.dwSequence, 1, true);
    this.cGroupid = paramJceInputStream.read(this.cGroupid, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.dwSequence, 1);
    paramJceOutputStream.write(this.cGroupid, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\DelGroupResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */