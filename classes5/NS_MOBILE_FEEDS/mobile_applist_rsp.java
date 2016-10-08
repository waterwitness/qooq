package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class mobile_applist_rsp
  extends JceStruct
{
  static ArrayList cache_all_applist_data;
  static single_feed cache_share_album = new single_feed();
  public ArrayList all_applist_data;
  public String attach_info = "";
  public int auto_load;
  public int hasmore;
  public int lossy_service;
  public int remain_count;
  public single_feed share_album;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_all_applist_data = new ArrayList();
    single_feed localsingle_feed = new single_feed();
    cache_all_applist_data.add(localsingle_feed);
  }
  
  public mobile_applist_rsp() {}
  
  public mobile_applist_rsp(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, single_feed paramsingle_feed, int paramInt4)
  {
    this.all_applist_data = paramArrayList;
    this.hasmore = paramInt1;
    this.remain_count = paramInt2;
    this.attach_info = paramString;
    this.auto_load = paramInt3;
    this.share_album = paramsingle_feed;
    this.lossy_service = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_applist_data = ((ArrayList)paramJceInputStream.read(cache_all_applist_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.remain_count = paramJceInputStream.read(this.remain_count, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.auto_load = paramJceInputStream.read(this.auto_load, 4, false);
    this.share_album = ((single_feed)paramJceInputStream.read(cache_share_album, 5, false));
    this.lossy_service = paramJceInputStream.read(this.lossy_service, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_applist_data != null) {
      paramJceOutputStream.write(this.all_applist_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    paramJceOutputStream.write(this.remain_count, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.auto_load, 4);
    if (this.share_album != null) {
      paramJceOutputStream.write(this.share_album, 5);
    }
    paramJceOutputStream.write(this.lossy_service, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\mobile_applist_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */