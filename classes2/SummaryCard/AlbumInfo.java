package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class AlbumInfo
  extends JceStruct
{
  static ArrayList cache_vPhotos;
  public ArrayList vPhotos;
  
  public AlbumInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AlbumInfo(ArrayList paramArrayList)
  {
    this.vPhotos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPhotos == null)
    {
      cache_vPhotos = new ArrayList();
      PhotoInfo localPhotoInfo = new PhotoInfo();
      cache_vPhotos.add(localPhotoInfo);
    }
    this.vPhotos = ((ArrayList)paramJceInputStream.read(cache_vPhotos, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vPhotos != null) {
      paramJceOutputStream.write(this.vPhotos, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\AlbumInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */