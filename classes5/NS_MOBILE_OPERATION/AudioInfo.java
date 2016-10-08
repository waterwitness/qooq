package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AudioInfo
  extends JceStruct
{
  public String playkey;
  public int time;
  
  public AudioInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.playkey = "";
  }
  
  public AudioInfo(String paramString, int paramInt)
  {
    this.playkey = "";
    this.playkey = paramString;
    this.time = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.playkey = paramJceInputStream.readString(0, false);
    this.time = paramJceInputStream.read(this.time, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.playkey != null) {
      paramJceOutputStream.write(this.playkey, 0);
    }
    paramJceOutputStream.write(this.time, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\AudioInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */