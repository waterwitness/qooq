package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_audio
  extends JceStruct
{
  public String audiokey;
  public int audiotime;
  public String errormessge;
  public int isplay;
  
  public s_audio()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.audiokey = "";
    this.errormessge = "";
  }
  
  public s_audio(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.audiokey = "";
    this.errormessge = "";
    this.audiokey = paramString1;
    this.audiotime = paramInt1;
    this.errormessge = paramString2;
    this.isplay = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.audiokey = paramJceInputStream.readString(0, false);
    this.audiotime = paramJceInputStream.read(this.audiotime, 1, false);
    this.errormessge = paramJceInputStream.readString(2, false);
    this.isplay = paramJceInputStream.read(this.isplay, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.audiokey != null) {
      paramJceOutputStream.write(this.audiokey, 0);
    }
    paramJceOutputStream.write(this.audiotime, 1);
    if (this.errormessge != null) {
      paramJceOutputStream.write(this.errormessge, 2);
    }
    paramJceOutputStream.write(this.isplay, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_audio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */