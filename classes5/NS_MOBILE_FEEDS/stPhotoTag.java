package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stPhotoTag
  extends JceStruct
{
  static int cache_direction = 0;
  static int cache_type;
  public String content = "";
  public int direction = 0;
  public String poiTagStreet = "";
  public String tag_id = "";
  public int type = 0;
  public long x_scale;
  public long y_scale;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_type = 0;
  }
  
  public stPhotoTag() {}
  
  public stPhotoTag(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, String paramString3)
  {
    this.type = paramInt1;
    this.content = paramString1;
    this.tag_id = paramString2;
    this.x_scale = paramLong1;
    this.y_scale = paramLong2;
    this.direction = paramInt2;
    this.poiTagStreet = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.content = paramJceInputStream.readString(1, true);
    this.tag_id = paramJceInputStream.readString(2, true);
    this.x_scale = paramJceInputStream.read(this.x_scale, 3, false);
    this.y_scale = paramJceInputStream.read(this.y_scale, 4, false);
    this.direction = paramJceInputStream.read(this.direction, 5, false);
    this.poiTagStreet = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.content, 1);
    paramJceOutputStream.write(this.tag_id, 2);
    paramJceOutputStream.write(this.x_scale, 3);
    paramJceOutputStream.write(this.y_scale, 4);
    paramJceOutputStream.write(this.direction, 5);
    if (this.poiTagStreet != null) {
      paramJceOutputStream.write(this.poiTagStreet, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\stPhotoTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */