package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GroupMsgHead
  extends JceStruct
{
  public byte cCurPkg;
  public byte cTotalPkg;
  public long dwReserved;
  public int usCmdType;
  public int usPkgSeq;
  
  public GroupMsgHead()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GroupMsgHead(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, long paramLong)
  {
    this.usCmdType = paramInt1;
    this.cTotalPkg = paramByte1;
    this.cCurPkg = paramByte2;
    this.usPkgSeq = paramInt2;
    this.dwReserved = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.usCmdType = paramJceInputStream.read(this.usCmdType, 0, true);
    this.cTotalPkg = paramJceInputStream.read(this.cTotalPkg, 1, true);
    this.cCurPkg = paramJceInputStream.read(this.cCurPkg, 2, true);
    this.usPkgSeq = paramJceInputStream.read(this.usPkgSeq, 3, true);
    this.dwReserved = paramJceInputStream.read(this.dwReserved, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.usCmdType, 0);
    paramJceOutputStream.write(this.cTotalPkg, 1);
    paramJceOutputStream.write(this.cCurPkg, 2);
    paramJceOutputStream.write(this.usPkgSeq, 3);
    paramJceOutputStream.write(this.dwReserved, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PushNotifyPack\GroupMsgHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */