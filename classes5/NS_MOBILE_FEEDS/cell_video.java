package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class cell_video
  extends JceStruct
{
  static Map cache_coverurl;
  static Map cache_extendinfo;
  static int cache_video_show_type = 0;
  static int cache_video_source = 0;
  static s_videoremark cache_videoremark;
  static Map cache_videourls;
  public int actiontype;
  public String actionurl = "";
  public String clientkey = "";
  public Map coverurl;
  public Map extendinfo;
  public int filetype;
  public boolean isPanorama = true;
  public String lloc = "";
  public byte playtype;
  public int report_video_feeds_type;
  public String sloc = "";
  public String toast = "";
  public int video_show_type;
  public int video_source;
  public String videoid = "";
  public s_videoremark videoremark;
  public int videostatus;
  public long videotime;
  public byte videotype;
  public String videourl = "";
  public Map videourls;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_coverurl = new HashMap();
    Object localObject = new s_picurl();
    cache_coverurl.put(Integer.valueOf(0), localObject);
    cache_videourls = new HashMap();
    localObject = new s_videourl();
    cache_videourls.put(Integer.valueOf(0), localObject);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
    cache_videoremark = new s_videoremark();
  }
  
  public cell_video() {}
  
  public cell_video(String paramString1, String paramString2, Map paramMap1, int paramInt1, String paramString3, String paramString4, int paramInt2, byte paramByte1, long paramLong, Map paramMap2, byte paramByte2, int paramInt3, String paramString5, Map paramMap3, s_videoremark params_videoremark, int paramInt4, boolean paramBoolean, int paramInt5, String paramString6, String paramString7, int paramInt6)
  {
    this.videoid = paramString1;
    this.videourl = paramString2;
    this.coverurl = paramMap1;
    this.actiontype = paramInt1;
    this.actionurl = paramString3;
    this.clientkey = paramString4;
    this.filetype = paramInt2;
    this.videotype = paramByte1;
    this.videotime = paramLong;
    this.videourls = paramMap2;
    this.playtype = paramByte2;
    this.videostatus = paramInt3;
    this.toast = paramString5;
    this.extendinfo = paramMap3;
    this.videoremark = params_videoremark;
    this.video_show_type = paramInt4;
    this.isPanorama = paramBoolean;
    this.video_source = paramInt5;
    this.sloc = paramString6;
    this.lloc = paramString7;
    this.report_video_feeds_type = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.videoid = paramJceInputStream.readString(0, false);
    this.videourl = paramJceInputStream.readString(1, false);
    this.coverurl = ((Map)paramJceInputStream.read(cache_coverurl, 2, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.actionurl = paramJceInputStream.readString(4, false);
    this.clientkey = paramJceInputStream.readString(5, false);
    this.filetype = paramJceInputStream.read(this.filetype, 6, false);
    this.videotype = paramJceInputStream.read(this.videotype, 7, false);
    this.videotime = paramJceInputStream.read(this.videotime, 8, false);
    this.videourls = ((Map)paramJceInputStream.read(cache_videourls, 9, false));
    this.playtype = paramJceInputStream.read(this.playtype, 10, false);
    this.videostatus = paramJceInputStream.read(this.videostatus, 11, false);
    this.toast = paramJceInputStream.readString(12, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 13, false));
    this.videoremark = ((s_videoremark)paramJceInputStream.read(cache_videoremark, 14, false));
    this.video_show_type = paramJceInputStream.read(this.video_show_type, 15, false);
    this.isPanorama = paramJceInputStream.read(this.isPanorama, 16, false);
    this.video_source = paramJceInputStream.read(this.video_source, 17, false);
    this.sloc = paramJceInputStream.readString(18, false);
    this.lloc = paramJceInputStream.readString(19, false);
    this.report_video_feeds_type = paramJceInputStream.read(this.report_video_feeds_type, 20, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.videoid != null) {
      paramJceOutputStream.write(this.videoid, 0);
    }
    if (this.videourl != null) {
      paramJceOutputStream.write(this.videourl, 1);
    }
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 4);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 5);
    }
    paramJceOutputStream.write(this.filetype, 6);
    paramJceOutputStream.write(this.videotype, 7);
    paramJceOutputStream.write(this.videotime, 8);
    if (this.videourls != null) {
      paramJceOutputStream.write(this.videourls, 9);
    }
    paramJceOutputStream.write(this.playtype, 10);
    paramJceOutputStream.write(this.videostatus, 11);
    if (this.toast != null) {
      paramJceOutputStream.write(this.toast, 12);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 13);
    }
    if (this.videoremark != null) {
      paramJceOutputStream.write(this.videoremark, 14);
    }
    paramJceOutputStream.write(this.video_show_type, 15);
    paramJceOutputStream.write(this.isPanorama, 16);
    paramJceOutputStream.write(this.video_source, 17);
    if (this.sloc != null) {
      paramJceOutputStream.write(this.sloc, 18);
    }
    if (this.lloc != null) {
      paramJceOutputStream.write(this.lloc, 19);
    }
    paramJceOutputStream.write(this.report_video_feeds_type, 20);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_video.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */