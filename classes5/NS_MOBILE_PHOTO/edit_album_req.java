package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class edit_album_req
  extends JceStruct
{
  static Album cache_album;
  static Map cache_busi_param;
  public Album album;
  public Map busi_param;
  public long cancelIndividual;
  public String itemid = "";
  public String newCoverId = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_album = new Album();
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public edit_album_req() {}
  
  public edit_album_req(Album paramAlbum, Map paramMap, String paramString1, String paramString2, long paramLong)
  {
    this.album = paramAlbum;
    this.busi_param = paramMap;
    this.newCoverId = paramString1;
    this.itemid = paramString2;
    this.cancelIndividual = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.newCoverId = paramJceInputStream.readString(2, false);
    this.itemid = paramJceInputStream.readString(3, false);
    this.cancelIndividual = paramJceInputStream.read(this.cancelIndividual, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    if (this.newCoverId != null) {
      paramJceOutputStream.write(this.newCoverId, 2);
    }
    if (this.itemid != null) {
      paramJceOutputStream.write(this.itemid, 3);
    }
    paramJceOutputStream.write(this.cancelIndividual, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\edit_album_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */