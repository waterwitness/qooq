package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class modify_travel_photo_scence
  extends JceStruct
{
  static int cache_opetype = 0;
  static stPhotoPoiArea cache_poi = new stPhotoPoiArea();
  public int opetype;
  public stPhotoPoiArea poi;
  public long poi_area_start_time;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public modify_travel_photo_scence() {}
  
  public modify_travel_photo_scence(int paramInt, stPhotoPoiArea paramstPhotoPoiArea, long paramLong)
  {
    this.opetype = paramInt;
    this.poi = paramstPhotoPoiArea;
    this.poi_area_start_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opetype = paramJceInputStream.read(this.opetype, 0, true);
    this.poi = ((stPhotoPoiArea)paramJceInputStream.read(cache_poi, 1, true));
    this.poi_area_start_time = paramJceInputStream.read(this.poi_area_start_time, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.opetype, 0);
    paramJceOutputStream.write(this.poi, 1);
    paramJceOutputStream.write(this.poi_area_start_time, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\modify_travel_photo_scence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */