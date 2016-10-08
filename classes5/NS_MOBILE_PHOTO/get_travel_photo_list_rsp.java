package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_travel_photo_list_rsp
  extends JceStruct
  implements Cloneable
{
  static Album cache_albuminfo;
  static Map cache_busi_param;
  static ArrayList cache_photolist;
  static stPhotoPoiAreaList cache_pos;
  static s_outshare cache_shareinfo;
  public Album albuminfo;
  public int appid;
  public String attach_info;
  public Map busi_param;
  public int hasmore;
  public ArrayList photolist;
  public stPhotoPoiAreaList pos;
  public s_outshare shareinfo;
  
  public get_travel_photo_list_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.attach_info = "";
  }
  
  public get_travel_photo_list_rsp(Album paramAlbum, ArrayList paramArrayList, String paramString, int paramInt1, stPhotoPoiAreaList paramstPhotoPoiAreaList, Map paramMap, int paramInt2, s_outshare params_outshare)
  {
    this.attach_info = "";
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.attach_info = paramString;
    this.hasmore = paramInt1;
    this.pos = paramstPhotoPoiAreaList;
    this.busi_param = paramMap;
    this.appid = paramInt2;
    this.shareinfo = params_outshare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_albuminfo == null) {
      cache_albuminfo = new Album();
    }
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, true));
    if (cache_photolist == null)
    {
      cache_photolist = new ArrayList();
      s_picdata locals_picdata = new s_picdata();
      cache_photolist.add(locals_picdata);
    }
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, true));
    this.attach_info = paramJceInputStream.readString(2, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 3, false);
    if (cache_pos == null) {
      cache_pos = new stPhotoPoiAreaList();
    }
    this.pos = ((stPhotoPoiAreaList)paramJceInputStream.read(cache_pos, 4, false));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.appid = paramJceInputStream.read(this.appid, 6, false);
    if (cache_shareinfo == null) {
      cache_shareinfo = new s_outshare();
    }
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 0);
    paramJceOutputStream.write(this.photolist, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.hasmore, 3);
    if (this.pos != null) {
      paramJceOutputStream.write(this.pos, 4);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    paramJceOutputStream.write(this.appid, 6);
    if (this.shareinfo != null) {
      paramJceOutputStream.write(this.shareinfo, 7);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\get_travel_photo_list_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */