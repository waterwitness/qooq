package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QzmallProfileDecoGetRsp
  extends JceStruct
{
  static byte[] cache_vecBuff;
  public byte[] vecBuff;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vecBuff = (byte[])new byte[1];
    ((byte[])cache_vecBuff)[0] = 0;
  }
  
  public QzmallProfileDecoGetRsp() {}
  
  public QzmallProfileDecoGetRsp(byte[] paramArrayOfByte)
  {
    this.vecBuff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecBuff = ((byte[])paramJceInputStream.read(cache_vecBuff, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecBuff != null) {
      paramJceOutputStream.write(this.vecBuff, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QMALL_COVER\QzmallProfileDecoGetRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */