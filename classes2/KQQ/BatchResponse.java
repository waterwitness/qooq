package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BatchResponse
  extends JceStruct
{
  static byte[] cache_buffer;
  static int cache_type;
  public byte[] buffer;
  public int result;
  public int seq;
  public int type;
  
  public BatchResponse()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BatchResponse(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.type = paramInt1;
    this.seq = paramInt2;
    this.result = paramInt3;
    this.buffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.seq = paramJceInputStream.read(this.seq, 1, false);
    this.result = paramJceInputStream.read(this.result, 2, false);
    if (cache_buffer == null)
    {
      cache_buffer = (byte[])new byte[1];
      ((byte[])cache_buffer)[0] = 0;
    }
    this.buffer = ((byte[])paramJceInputStream.read(cache_buffer, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.seq, 1);
    paramJceOutputStream.write(this.result, 2);
    if (this.buffer != null) {
      paramJceOutputStream.write(this.buffer, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\BatchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */