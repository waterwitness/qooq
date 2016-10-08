package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SetRichSigReq
  extends JceStruct
{
  static int cache_eSourceID;
  static byte[] cache_vbSignature;
  public int eSourceID;
  public byte[] vbSignature;
  
  public SetRichSigReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SetRichSigReq(byte[] paramArrayOfByte, int paramInt)
  {
    this.vbSignature = paramArrayOfByte;
    this.eSourceID = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vbSignature == null)
    {
      cache_vbSignature = (byte[])new byte[1];
      ((byte[])cache_vbSignature)[0] = 0;
    }
    this.vbSignature = ((byte[])paramJceInputStream.read(cache_vbSignature, 1, false));
    this.eSourceID = paramJceInputStream.read(this.eSourceID, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vbSignature != null) {
      paramJceOutputStream.write(this.vbSignature, 1);
    }
    paramJceOutputStream.write(this.eSourceID, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\SetRichSigReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */