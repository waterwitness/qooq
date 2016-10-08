package IPwdPxyMQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespondHeader
  extends JceStruct
{
  static byte[] cache_tips;
  public int cmd;
  public long requestID;
  public int result;
  public long svrSeqNo;
  public byte[] tips;
  public String uin;
  public int ver;
  
  public RespondHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uin = "";
  }
  
  public RespondHeader(int paramInt1, int paramInt2, long paramLong1, String paramString, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.uin = "";
    this.ver = paramInt1;
    this.cmd = paramInt2;
    this.requestID = paramLong1;
    this.uin = paramString;
    this.svrSeqNo = paramLong2;
    this.result = paramInt3;
    this.tips = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ver = paramJceInputStream.read(this.ver, 0, true);
    this.cmd = paramJceInputStream.read(this.cmd, 1, true);
    this.requestID = paramJceInputStream.read(this.requestID, 2, true);
    this.uin = paramJceInputStream.readString(3, true);
    this.svrSeqNo = paramJceInputStream.read(this.svrSeqNo, 4, true);
    this.result = paramJceInputStream.read(this.result, 5, true);
    if (cache_tips == null)
    {
      cache_tips = (byte[])new byte[1];
      ((byte[])cache_tips)[0] = 0;
    }
    this.tips = ((byte[])paramJceInputStream.read(cache_tips, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.cmd, 1);
    paramJceOutputStream.write(this.requestID, 2);
    paramJceOutputStream.write(this.uin, 3);
    paramJceOutputStream.write(this.svrSeqNo, 4);
    paramJceOutputStream.write(this.result, 5);
    if (this.tips != null) {
      paramJceOutputStream.write(this.tips, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IPwdPxyMQQ\RespondHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */