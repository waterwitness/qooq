package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BusiRespHead
  extends JceStruct
{
  public int iReplyCode;
  public int iSeq;
  public short shVersion;
  public String strResult;
  
  public BusiRespHead()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strResult = "";
  }
  
  public BusiRespHead(short paramShort, int paramInt1, int paramInt2, String paramString)
  {
    this.strResult = "";
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.iReplyCode = paramInt2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.iReplyCode, 2);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\BusiRespHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */