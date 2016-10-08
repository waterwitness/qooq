package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcRequestSetRoamMsgAllUser
  extends JceStruct
{
  public byte cValue;
  public byte cVerifyType;
  public long lUin;
  public short shType;
  
  public SvcRequestSetRoamMsgAllUser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRequestSetRoamMsgAllUser(long paramLong, byte paramByte1, short paramShort, byte paramByte2)
  {
    this.lUin = paramLong;
    this.cVerifyType = paramByte1;
    this.shType = paramShort;
    this.cValue = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    this.shType = paramJceInputStream.read(this.shType, 2, true);
    this.cValue = paramJceInputStream.read(this.cValue, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.shType, 2);
    paramJceOutputStream.write(this.cValue, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcRequestSetRoamMsgAllUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */