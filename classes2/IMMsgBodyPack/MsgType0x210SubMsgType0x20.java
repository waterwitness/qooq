package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MsgType0x210SubMsgType0x20
  extends JceStruct
{
  public long dwOpType;
  public long dwType;
  public long dwUin;
  public String strRemaek;
  
  public MsgType0x210SubMsgType0x20()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strRemaek = "";
  }
  
  public MsgType0x210SubMsgType0x20(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.strRemaek = "";
    this.dwOpType = paramLong1;
    this.dwType = paramLong2;
    this.dwUin = paramLong3;
    this.strRemaek = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwOpType = paramJceInputStream.read(this.dwOpType, 0, false);
    this.dwType = paramJceInputStream.read(this.dwType, 1, false);
    this.dwUin = paramJceInputStream.read(this.dwUin, 2, false);
    this.strRemaek = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwOpType, 0);
    paramJceOutputStream.write(this.dwType, 1);
    paramJceOutputStream.write(this.dwUin, 2);
    if (this.strRemaek != null) {
      paramJceOutputStream.write(this.strRemaek, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\MsgType0x210SubMsgType0x20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */