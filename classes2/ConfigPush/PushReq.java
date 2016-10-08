package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PushReq
  extends JceStruct
{
  static byte[] cache_jcebuf;
  public byte[] jcebuf;
  public long lSeq;
  public int type;
  
  public PushReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PushReq(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    this.type = paramInt;
    this.jcebuf = paramArrayOfByte;
    this.lSeq = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 1, true);
    if (cache_jcebuf == null)
    {
      cache_jcebuf = (byte[])new byte[1];
      ((byte[])cache_jcebuf)[0] = 0;
    }
    this.jcebuf = ((byte[])paramJceInputStream.read(cache_jcebuf, 2, true));
    this.lSeq = paramJceInputStream.read(this.lSeq, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.jcebuf, 2);
    paramJceOutputStream.write(this.lSeq, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\PushReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */