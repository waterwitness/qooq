package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcResponseDelRoamMsg
  extends JceStruct
{
  public byte cReplyCode;
  public long lUin;
  public String strResult;
  
  public SvcResponseDelRoamMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strResult = "";
  }
  
  public SvcResponseDelRoamMsg(long paramLong, byte paramByte, String paramString)
  {
    this.strResult = "";
    this.lUin = paramLong;
    this.cReplyCode = paramByte;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 1, true);
    this.strResult = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cReplyCode, 1);
    paramJceOutputStream.write(this.strResult, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcResponseDelRoamMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */