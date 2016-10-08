package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PullDisSeqParam
  extends JceStruct
{
  public long lDisCode;
  public long lLastSeqId;
  
  public PullDisSeqParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PullDisSeqParam(long paramLong1, long paramLong2)
  {
    this.lDisCode = paramLong1;
    this.lLastSeqId = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lDisCode = paramJceInputStream.read(this.lDisCode, 0, true);
    this.lLastSeqId = paramJceInputStream.read(this.lLastSeqId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lDisCode, 0);
    paramJceOutputStream.write(this.lLastSeqId, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\PullDisSeqParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */