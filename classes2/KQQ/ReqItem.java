package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqItem
  extends JceStruct
{
  static int cache_eServiceID;
  static byte[] cache_vecParam;
  public byte cOperType;
  public int eServiceID;
  public byte[] vecParam;
  
  public ReqItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cOperType = 1;
  }
  
  public ReqItem(byte paramByte, int paramInt, byte[] paramArrayOfByte)
  {
    this.cOperType = 1;
    this.cOperType = paramByte;
    this.eServiceID = paramInt;
    this.vecParam = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cOperType = paramJceInputStream.read(this.cOperType, 0, true);
    this.eServiceID = paramJceInputStream.read(this.eServiceID, 1, true);
    if (cache_vecParam == null)
    {
      cache_vecParam = (byte[])new byte[1];
      ((byte[])cache_vecParam)[0] = 0;
    }
    this.vecParam = ((byte[])paramJceInputStream.read(cache_vecParam, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cOperType, 0);
    paramJceOutputStream.write(this.eServiceID, 1);
    if (this.vecParam != null) {
      paramJceOutputStream.write(this.vecParam, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ReqItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */