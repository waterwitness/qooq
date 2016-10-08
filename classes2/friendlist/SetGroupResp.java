package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SetGroupResp
  extends JceStruct
{
  static byte[] cache_vecBody;
  public String ErrorString;
  public byte reqtype;
  public byte result;
  public byte[] vecBody;
  
  public SetGroupResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ErrorString = "";
  }
  
  public SetGroupResp(byte paramByte1, byte paramByte2, byte[] paramArrayOfByte, String paramString)
  {
    this.ErrorString = "";
    this.reqtype = paramByte1;
    this.result = paramByte2;
    this.vecBody = paramArrayOfByte;
    this.ErrorString = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    if (cache_vecBody == null)
    {
      cache_vecBody = (byte[])new byte[1];
      ((byte[])cache_vecBody)[0] = 0;
    }
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
    this.ErrorString = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.vecBody, 2);
    paramJceOutputStream.write(this.ErrorString, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\SetGroupResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */