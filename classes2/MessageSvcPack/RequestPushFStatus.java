package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestPushFStatus
  extends JceStruct
{
  public byte cStatus;
  public long lUin;
  public int uClientType;
  
  public RequestPushFStatus()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uClientType = 99;
  }
  
  public RequestPushFStatus(long paramLong, byte paramByte, int paramInt)
  {
    this.uClientType = 99;
    this.lUin = paramLong;
    this.cStatus = paramByte;
    this.uClientType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.uClientType = paramJceInputStream.read(this.uClientType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.uClientType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\RequestPushFStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */