package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class QueryADBannerUnit
  extends JceStruct
{
  static int cache_eAdType;
  static ArrayList cache_multibanner;
  static TimeRange cache_sShowTimeRange;
  static ArrayList cache_videobanners;
  public String btnText = "";
  public String description = "";
  public int detail_info;
  public int duration;
  public int eAdType;
  public long iAdID;
  public long iStoreID;
  public long iTraceID;
  public long iUin;
  public ArrayList multibanner;
  public String nick = "";
  public int noCloseButton;
  public int priority;
  public int reopenHours;
  public String report_info = "";
  public String roomId = "";
  public TimeRange sShowTimeRange;
  public String strJmpUrl = "";
  public String strPicMD5 = "";
  public String strPicUrl = "";
  public String strSchemeUrl = "";
  public String strStoreUrl = "";
  public String strTraceInfo = "";
  public int type;
  public ArrayList videobanners;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_eAdType = 0;
    cache_sShowTimeRange = new TimeRange();
    cache_multibanner = new ArrayList();
    Object localObject = new MultiBanner();
    cache_multibanner.add(localObject);
    cache_videobanners = new ArrayList();
    localObject = new VideoBanner();
    cache_videobanners.add(localObject);
  }
  
  public QueryADBannerUnit() {}
  
  public QueryADBannerUnit(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, TimeRange paramTimeRange, String paramString3, long paramLong3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, int paramInt7, String paramString7, String paramString8, String paramString9, long paramLong4, String paramString10, String paramString11, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.strPicUrl = paramString1;
    this.strJmpUrl = paramString2;
    this.iAdID = paramLong1;
    this.iTraceID = paramLong2;
    this.eAdType = paramInt1;
    this.sShowTimeRange = paramTimeRange;
    this.strStoreUrl = paramString3;
    this.iStoreID = paramLong3;
    this.strSchemeUrl = paramString4;
    this.detail_info = paramInt2;
    this.noCloseButton = paramInt3;
    this.reopenHours = paramInt4;
    this.priority = paramInt5;
    this.duration = paramInt6;
    this.report_info = paramString5;
    this.strPicMD5 = paramString6;
    this.type = paramInt7;
    this.description = paramString7;
    this.btnText = paramString8;
    this.strTraceInfo = paramString9;
    this.iUin = paramLong4;
    this.roomId = paramString10;
    this.nick = paramString11;
    this.multibanner = paramArrayList1;
    this.videobanners = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicUrl = paramJceInputStream.readString(0, true);
    this.strJmpUrl = paramJceInputStream.readString(1, true);
    this.iAdID = paramJceInputStream.read(this.iAdID, 2, true);
    this.iTraceID = paramJceInputStream.read(this.iTraceID, 3, true);
    this.eAdType = paramJceInputStream.read(this.eAdType, 4, true);
    this.sShowTimeRange = ((TimeRange)paramJceInputStream.read(cache_sShowTimeRange, 5, false));
    this.strStoreUrl = paramJceInputStream.readString(6, false);
    this.iStoreID = paramJceInputStream.read(this.iStoreID, 7, false);
    this.strSchemeUrl = paramJceInputStream.readString(8, false);
    this.detail_info = paramJceInputStream.read(this.detail_info, 9, false);
    this.noCloseButton = paramJceInputStream.read(this.noCloseButton, 10, false);
    this.reopenHours = paramJceInputStream.read(this.reopenHours, 11, false);
    this.priority = paramJceInputStream.read(this.priority, 12, false);
    this.duration = paramJceInputStream.read(this.duration, 13, false);
    this.report_info = paramJceInputStream.readString(14, false);
    this.strPicMD5 = paramJceInputStream.readString(15, false);
    this.type = paramJceInputStream.read(this.type, 16, false);
    this.description = paramJceInputStream.readString(17, false);
    this.btnText = paramJceInputStream.readString(18, false);
    this.strTraceInfo = paramJceInputStream.readString(19, false);
    this.iUin = paramJceInputStream.read(this.iUin, 20, false);
    this.roomId = paramJceInputStream.readString(21, false);
    this.nick = paramJceInputStream.readString(22, false);
    this.multibanner = ((ArrayList)paramJceInputStream.read(cache_multibanner, 23, false));
    this.videobanners = ((ArrayList)paramJceInputStream.read(cache_videobanners, 24, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPicUrl, 0);
    paramJceOutputStream.write(this.strJmpUrl, 1);
    paramJceOutputStream.write(this.iAdID, 2);
    paramJceOutputStream.write(this.iTraceID, 3);
    paramJceOutputStream.write(this.eAdType, 4);
    if (this.sShowTimeRange != null) {
      paramJceOutputStream.write(this.sShowTimeRange, 5);
    }
    if (this.strStoreUrl != null) {
      paramJceOutputStream.write(this.strStoreUrl, 6);
    }
    paramJceOutputStream.write(this.iStoreID, 7);
    if (this.strSchemeUrl != null) {
      paramJceOutputStream.write(this.strSchemeUrl, 8);
    }
    paramJceOutputStream.write(this.detail_info, 9);
    paramJceOutputStream.write(this.noCloseButton, 10);
    paramJceOutputStream.write(this.reopenHours, 11);
    paramJceOutputStream.write(this.priority, 12);
    paramJceOutputStream.write(this.duration, 13);
    if (this.report_info != null) {
      paramJceOutputStream.write(this.report_info, 14);
    }
    if (this.strPicMD5 != null) {
      paramJceOutputStream.write(this.strPicMD5, 15);
    }
    paramJceOutputStream.write(this.type, 16);
    if (this.description != null) {
      paramJceOutputStream.write(this.description, 17);
    }
    if (this.btnText != null) {
      paramJceOutputStream.write(this.btnText, 18);
    }
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 19);
    }
    paramJceOutputStream.write(this.iUin, 20);
    if (this.roomId != null) {
      paramJceOutputStream.write(this.roomId, 21);
    }
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 22);
    }
    if (this.multibanner != null) {
      paramJceOutputStream.write(this.multibanner, 23);
    }
    if (this.videobanners != null) {
      paramJceOutputStream.write(this.videobanners, 24);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_AD_BANNER\QueryADBannerUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */