package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PushResp
  extends JceStruct
{
  static byte[] cache_jcebuf;
  public byte[] jcebuf;
  public long lSeq;
  public int type;
  
  public PushResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PushResp(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    this.type = paramInt;
    this.lSeq = paramLong;
    this.jcebuf = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.lSeq = paramJceInputStream.read(this.lSeq, 2, true);
    if (cache_jcebuf == null)
    {
      cache_jcebuf = (byte[])new byte[1];
      ((byte[])cache_jcebuf)[0] = 0;
    }
    this.jcebuf = ((byte[])paramJceInputStream.read(cache_jcebuf, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.lSeq, 2);
    if (this.jcebuf != null) {
      paramJceOutputStream.write(this.jcebuf, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\PushResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */