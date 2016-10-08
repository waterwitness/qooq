package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class PhotoFeedsData
  extends JceStruct
{
  static Album cache_album = new Album();
  static ArrayList cache_photolist;
  public Album album;
  public int appid;
  public ArrayList photolist;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_photolist = new ArrayList();
    Photo localPhoto = new Photo();
    cache_photolist.add(localPhoto);
  }
  
  public PhotoFeedsData() {}
  
  public PhotoFeedsData(int paramInt, ArrayList paramArrayList, Album paramAlbum)
  {
    this.appid = paramInt;
    this.photolist = paramArrayList;
    this.album = paramAlbum;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, false));
    this.album = ((Album)paramJceInputStream.read(cache_album, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    if (this.photolist != null) {
      paramJceOutputStream.write(this.photolist, 1);
    }
    if (this.album != null) {
      paramJceOutputStream.write(this.album, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\PhotoFeedsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */