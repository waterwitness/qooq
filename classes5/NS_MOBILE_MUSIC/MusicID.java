package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MusicID
  extends JceStruct
{
  public long song_id;
  public int type;
  
  public MusicID()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MusicID(long paramLong, int paramInt)
  {
    this.song_id = paramLong;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.song_id = paramJceInputStream.read(this.song_id, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.song_id, 0);
    paramJceOutputStream.write(this.type, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MUSIC\MusicID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */