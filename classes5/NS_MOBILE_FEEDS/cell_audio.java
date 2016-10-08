package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_audio
  extends JceStruct
{
  static ArrayList cache_audio;
  public ArrayList audio;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_audio = new ArrayList();
    s_audio locals_audio = new s_audio();
    cache_audio.add(locals_audio);
  }
  
  public cell_audio() {}
  
  public cell_audio(ArrayList paramArrayList)
  {
    this.audio = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.audio = ((ArrayList)paramJceInputStream.read(cache_audio, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.audio != null) {
      paramJceOutputStream.write(this.audio, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_audio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */