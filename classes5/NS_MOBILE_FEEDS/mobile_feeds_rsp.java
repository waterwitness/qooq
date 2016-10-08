package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_rsp
  extends JceStruct
{
  static ArrayList cache_all_feeds_data;
  static Map cache_extendinfo;
  static s_cover cache_host_cover;
  static login_uin_info cache_loginuin_info;
  static st_prefetch cache_prefetch_rsp;
  static Map cache_stMapExtendinfo;
  static interest_list cache_uin_info;
  public ArrayList all_feeds_data;
  public String attach_info = "";
  public int auto_load;
  public Map extendinfo;
  public int gamebar_video_checking_num;
  public int hasmore;
  public s_cover host_cover;
  public long host_imbitmap;
  public long iFollowNum;
  public int is_detail_report;
  public int is_realname_succ;
  public login_uin_info loginuin_info;
  public int network_report = 1;
  public long newcount;
  public int no_update;
  public st_prefetch prefetch_rsp;
  public long req_count;
  public Map stMapExtendinfo;
  public interest_list uin_info;
  public long undealFeedCount;
  public String undealFeedTime = "";
  public String user_sid = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_all_feeds_data = new ArrayList();
    single_feed localsingle_feed = new single_feed();
    cache_all_feeds_data.add(localsingle_feed);
    cache_prefetch_rsp = new st_prefetch();
    cache_host_cover = new s_cover();
    cache_uin_info = new interest_list();
    cache_loginuin_info = new login_uin_info();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(Integer.valueOf(0), "");
    cache_stMapExtendinfo = new HashMap();
    cache_stMapExtendinfo.put("", "");
  }
  
  public mobile_feeds_rsp() {}
  
  public mobile_feeds_rsp(int paramInt1, String paramString1, ArrayList paramArrayList, long paramLong1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, String paramString2, st_prefetch paramst_prefetch, int paramInt4, s_cover params_cover, interest_list paraminterest_list, int paramInt5, login_uin_info paramlogin_uin_info, Map paramMap1, int paramInt6, int paramInt7, String paramString3, Map paramMap2, long paramLong5)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString1;
    this.all_feeds_data = paramArrayList;
    this.newcount = paramLong1;
    this.auto_load = paramInt2;
    this.no_update = paramInt3;
    this.req_count = paramLong2;
    this.iFollowNum = paramLong3;
    this.host_imbitmap = paramLong4;
    this.user_sid = paramString2;
    this.prefetch_rsp = paramst_prefetch;
    this.is_realname_succ = paramInt4;
    this.host_cover = params_cover;
    this.uin_info = paraminterest_list;
    this.gamebar_video_checking_num = paramInt5;
    this.loginuin_info = paramlogin_uin_info;
    this.extendinfo = paramMap1;
    this.is_detail_report = paramInt6;
    this.network_report = paramInt7;
    this.undealFeedTime = paramString3;
    this.stMapExtendinfo = paramMap2;
    this.undealFeedCount = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 2, false));
    this.newcount = paramJceInputStream.read(this.newcount, 3, false);
    this.auto_load = paramJceInputStream.read(this.auto_load, 4, false);
    this.no_update = paramJceInputStream.read(this.no_update, 5, false);
    this.req_count = paramJceInputStream.read(this.req_count, 6, false);
    this.iFollowNum = paramJceInputStream.read(this.iFollowNum, 7, false);
    this.host_imbitmap = paramJceInputStream.read(this.host_imbitmap, 8, false);
    this.user_sid = paramJceInputStream.readString(9, false);
    this.prefetch_rsp = ((st_prefetch)paramJceInputStream.read(cache_prefetch_rsp, 10, false));
    this.is_realname_succ = paramJceInputStream.read(this.is_realname_succ, 11, false);
    this.host_cover = ((s_cover)paramJceInputStream.read(cache_host_cover, 12, false));
    this.uin_info = ((interest_list)paramJceInputStream.read(cache_uin_info, 13, false));
    this.gamebar_video_checking_num = paramJceInputStream.read(this.gamebar_video_checking_num, 14, false);
    this.loginuin_info = ((login_uin_info)paramJceInputStream.read(cache_loginuin_info, 15, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 16, false));
    this.is_detail_report = paramJceInputStream.read(this.is_detail_report, 17, false);
    this.network_report = paramJceInputStream.read(this.network_report, 18, false);
    this.undealFeedTime = paramJceInputStream.readString(19, false);
    this.stMapExtendinfo = ((Map)paramJceInputStream.read(cache_stMapExtendinfo, 20, false));
    this.undealFeedCount = paramJceInputStream.read(this.undealFeedCount, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 1);
    }
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 2);
    }
    paramJceOutputStream.write(this.newcount, 3);
    paramJceOutputStream.write(this.auto_load, 4);
    paramJceOutputStream.write(this.no_update, 5);
    paramJceOutputStream.write(this.req_count, 6);
    paramJceOutputStream.write(this.iFollowNum, 7);
    paramJceOutputStream.write(this.host_imbitmap, 8);
    if (this.user_sid != null) {
      paramJceOutputStream.write(this.user_sid, 9);
    }
    if (this.prefetch_rsp != null) {
      paramJceOutputStream.write(this.prefetch_rsp, 10);
    }
    paramJceOutputStream.write(this.is_realname_succ, 11);
    if (this.host_cover != null) {
      paramJceOutputStream.write(this.host_cover, 12);
    }
    if (this.uin_info != null) {
      paramJceOutputStream.write(this.uin_info, 13);
    }
    paramJceOutputStream.write(this.gamebar_video_checking_num, 14);
    if (this.loginuin_info != null) {
      paramJceOutputStream.write(this.loginuin_info, 15);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 16);
    }
    paramJceOutputStream.write(this.is_detail_report, 17);
    paramJceOutputStream.write(this.network_report, 18);
    if (this.undealFeedTime != null) {
      paramJceOutputStream.write(this.undealFeedTime, 19);
    }
    if (this.stMapExtendinfo != null) {
      paramJceOutputStream.write(this.stMapExtendinfo, 20);
    }
    paramJceOutputStream.write(this.undealFeedCount, 21);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\mobile_feeds_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */