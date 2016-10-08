package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.msgb_rapidemotion;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_msgb_rapidemotion
  extends JceStruct
{
  static msgb_rapidemotion cache_emotion = new msgb_rapidemotion();
  public msgb_rapidemotion emotion;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public cell_msgb_rapidemotion() {}
  
  public cell_msgb_rapidemotion(msgb_rapidemotion parammsgb_rapidemotion)
  {
    this.emotion = parammsgb_rapidemotion;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.emotion = ((msgb_rapidemotion)paramJceInputStream.read(cache_emotion, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.emotion != null) {
      paramJceOutputStream.write(this.emotion, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_msgb_rapidemotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */