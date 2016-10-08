package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetMusicListReq
  extends JceStruct
{
  static ArrayList cache_music_id;
  public ArrayList music_id;
  
  public GetMusicListReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetMusicListReq(ArrayList paramArrayList)
  {
    this.music_id = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_music_id == null)
    {
      cache_music_id = new ArrayList();
      MusicID localMusicID = new MusicID();
      cache_music_id.add(localMusicID);
    }
    this.music_id = ((ArrayList)paramJceInputStream.read(cache_music_id, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.music_id != null) {
      paramJceOutputStream.write(this.music_id, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MUSIC\GetMusicListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */