package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MsgType0x210SubMsgType0x1d
  extends JceStruct
{
  public long dwID;
  public long dwOpType;
  public long dwUin;
  public String strValue;
  
  public MsgType0x210SubMsgType0x1d()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strValue = "";
  }
  
  public MsgType0x210SubMsgType0x1d(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.strValue = "";
    this.dwOpType = paramLong1;
    this.dwUin = paramLong2;
    this.dwID = paramLong3;
    this.strValue = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwOpType = paramJceInputStream.read(this.dwOpType, 0, false);
    this.dwUin = paramJceInputStream.read(this.dwUin, 1, false);
    this.dwID = paramJceInputStream.read(this.dwID, 2, false);
    this.strValue = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwOpType, 0);
    paramJceOutputStream.write(this.dwUin, 1);
    paramJceOutputStream.write(this.dwID, 2);
    if (this.strValue != null) {
      paramJceOutputStream.write(this.strValue, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\MsgType0x210SubMsgType0x1d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */