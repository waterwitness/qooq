package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class InnerRespHeader
  extends JceStruct
{
  public int iReplyCode;
  public int iSeq;
  public long lUIN;
  public short shVersion;
  public String strResult;
  
  public InnerRespHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strResult = "";
  }
  
  public InnerRespHeader(short paramShort, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.strResult = "";
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.lUIN = paramLong;
    this.iReplyCode = paramInt2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.lUIN = paramJceInputStream.read(this.lUIN, 2, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 3, true);
    this.strResult = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.lUIN, 2);
    paramJceOutputStream.write(this.iReplyCode, 3);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\InnerRespHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */