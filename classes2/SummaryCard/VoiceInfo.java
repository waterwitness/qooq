package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class VoiceInfo
  extends JceStruct
{
  static byte[] cache_vVoiceId;
  public byte bRead;
  public short shDuration;
  public String strUrl;
  public byte[] vVoiceId;
  
  public VoiceInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bRead = 2;
    this.strUrl = "";
  }
  
  public VoiceInfo(byte[] paramArrayOfByte, short paramShort, byte paramByte, String paramString)
  {
    this.bRead = 2;
    this.strUrl = "";
    this.vVoiceId = paramArrayOfByte;
    this.shDuration = paramShort;
    this.bRead = paramByte;
    this.strUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vVoiceId == null)
    {
      cache_vVoiceId = (byte[])new byte[1];
      ((byte[])cache_vVoiceId)[0] = 0;
    }
    this.vVoiceId = ((byte[])paramJceInputStream.read(cache_vVoiceId, 0, false));
    this.shDuration = paramJceInputStream.read(this.shDuration, 1, false);
    this.bRead = paramJceInputStream.read(this.bRead, 2, false);
    this.strUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vVoiceId != null) {
      paramJceOutputStream.write(this.vVoiceId, 0);
    }
    paramJceOutputStream.write(this.shDuration, 1);
    paramJceOutputStream.write(this.bRead, 2);
    if (this.strUrl != null) {
      paramJceOutputStream.write(this.strUrl, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\VoiceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */