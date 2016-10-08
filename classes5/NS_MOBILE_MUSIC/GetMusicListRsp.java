package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetMusicListRsp
  extends JceStruct
{
  static ArrayList cache_music_list;
  public ArrayList music_list;
  
  public GetMusicListRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetMusicListRsp(ArrayList paramArrayList)
  {
    this.music_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_music_list == null)
    {
      cache_music_list = new ArrayList();
      MusicInfo localMusicInfo = new MusicInfo();
      cache_music_list.add(localMusicInfo);
    }
    this.music_list = ((ArrayList)paramJceInputStream.read(cache_music_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.music_list != null) {
      paramJceOutputStream.write(this.music_list, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MUSIC\GetMusicListRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */