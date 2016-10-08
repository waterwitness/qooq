package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestPushStatus
  extends JceStruct
{
  public byte cDataLine;
  public byte cPrintable;
  public byte cStatus;
  public byte cViewPcFile;
  public long iPCVersion;
  public long lUin;
  
  public RequestPushStatus()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RequestPushStatus(long paramLong1, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong2)
  {
    this.lUin = paramLong1;
    this.cStatus = paramByte1;
    this.cDataLine = paramByte2;
    this.cPrintable = paramByte3;
    this.cViewPcFile = paramByte4;
    this.iPCVersion = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.cDataLine = paramJceInputStream.read(this.cDataLine, 2, false);
    this.cPrintable = paramJceInputStream.read(this.cPrintable, 3, false);
    this.cViewPcFile = paramJceInputStream.read(this.cViewPcFile, 4, false);
    this.iPCVersion = paramJceInputStream.read(this.iPCVersion, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.cDataLine, 2);
    paramJceOutputStream.write(this.cPrintable, 3);
    paramJceOutputStream.write(this.cViewPcFile, 4);
    paramJceOutputStream.write(this.iPCVersion, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\RequestPushStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */