package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_cover
  extends JceStruct
{
  public String cover_id;
  public String cover_music_h5url;
  public int cover_ts;
  public int cover_type;
  
  public cell_cover()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cover_id = "";
    this.cover_music_h5url = "";
  }
  
  public cell_cover(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.cover_id = "";
    this.cover_music_h5url = "";
    this.cover_id = paramString1;
    this.cover_ts = paramInt1;
    this.cover_type = paramInt2;
    this.cover_music_h5url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cover_id = paramJceInputStream.readString(0, false);
    this.cover_ts = paramJceInputStream.read(this.cover_ts, 1, false);
    this.cover_type = paramJceInputStream.read(this.cover_type, 2, false);
    this.cover_music_h5url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cover_id != null) {
      paramJceOutputStream.write(this.cover_id, 0);
    }
    paramJceOutputStream.write(this.cover_ts, 1);
    paramJceOutputStream.write(this.cover_type, 2);
    if (this.cover_music_h5url != null) {
      paramJceOutputStream.write(this.cover_music_h5url, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_cover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */