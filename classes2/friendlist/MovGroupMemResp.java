package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MovGroupMemResp
  extends JceStruct
{
  public String ErrorString;
  public byte reqtype;
  public byte result;
  public long uin;
  
  public MovGroupMemResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ErrorString = "";
  }
  
  public MovGroupMemResp(long paramLong, byte paramByte1, byte paramByte2, String paramString)
  {
    this.ErrorString = "";
    this.uin = paramLong;
    this.reqtype = paramByte1;
    this.result = paramByte2;
    this.ErrorString = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.reqtype = paramJceInputStream.read(this.reqtype, 1, true);
    this.result = paramJceInputStream.read(this.result, 2, true);
    this.ErrorString = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.reqtype, 1);
    paramJceOutputStream.write(this.result, 2);
    paramJceOutputStream.write(this.ErrorString, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\MovGroupMemResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */