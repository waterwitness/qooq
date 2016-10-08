package cooperation.qzone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import common.config.service.QzoneConfig;

public class QZoneHelper$QZoneCoverConstants
{
  public static final int a = 1;
  public static final String a = "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&uin={uin}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}&router=list&cate_id={cateid}&hostUin={hostUin}&_proxy=1";
  public static final int b = 2;
  public static final String b = "cover_uin";
  public static final int c = 3;
  public static final String c = "set_source";
  public static final int d = 4;
  public static final String d = "current_cover";
  public static final int e = 5;
  public static final String e = "photowall_mode";
  public static final int f = 6;
  public static final String f = "photowall_updated";
  public static final int g = 7;
  public static final String g = "key_from";
  public static final int h = 8;
  public static final String h = "direct_select_photo";
  public static final int i = 9;
  public static final String i = "jigsaw_open";
  public static final int j = 0;
  public static final String j = "cover_setjigsaw";
  public static final int k = 1;
  public static final String k = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
  public static final int l = 1;
  public static final String l = "action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end";
  public static final int m = 1;
  public static final String m = "showWidgetSet";
  public static final int n = 2;
  public static final String n = "action.com.qzone.cover.set_cover_success";
  public static final int o = 3;
  public static final String o = "preload_cover_url";
  public static final int p = 4;
  public static final String p = "preload_cover_uin";
  public static final int q = 5;
  public static final String q = "HigeResolutionCover";
  public static final int r = 6;
  public static final String r = "LowResolutionCover";
  public static final int s = 7;
  private static final String s = "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&uin={uin}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}&hostUin={hostUin}&_proxy=1";
  public static final int t = 8;
  private static final String t = "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&uin={uin}&hostUin={hostUin}&isPhotoWall={isPhotoWall}&customCoverUrl={customCoverUrl}&from={from}&page=1&qua={qua}&_bid=372&clicktime={clicktime}&router=photoWall";
  public static final int u = 9;
  private static final String u = "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&from={from}&page={page}&qua={qua}&_bid=372&&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1";
  
  public QZoneHelper$QZoneCoverConstants()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return QzoneConfig.a().a("H5Url", "CoverStore", "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&uin={uin}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}&hostUin={hostUin}&_proxy=1").replace("{uin}", paramString3).replace("{hostUin}", paramString4).replace("{qua}", QUA.a()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString1).replace("{page}", paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.a().a("H5Url", "CoverList", "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&uin={uin}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}&router=list&cate_id={cateid}&hostUin={hostUin}&_proxy=1").replace("{uin}", paramString3).replace("{hostUin}", paramString5).replace("{qua}", QUA.a()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString1).replace("{page}", paramString2).replace("{cateid}", paramString4);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString1 = QzoneConfig.a().a("H5Url", "PhotoWallUrl", "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&uin={uin}&hostUin={hostUin}&isPhotoWall={isPhotoWall}&customCoverUrl={customCoverUrl}&from={from}&page=1&qua={qua}&_bid=372&clicktime={clicktime}&router=photoWall").replace("{uin}", paramString1).replace("{hostUin}", paramString2).replace("{qua}", QUA.a());
    paramString2 = new StringBuilder().append("");
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0) {
      return paramString1.replace("{isPhotoWall}", i1).replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString3);
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.a().a("H5Url", "CoverPreview", "http://h5.qzone.qq.com/bgstore/index?_wv=2098179&from={from}&page={page}&qua={qua}&_bid=372&&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1").replace("{qua}", QUA.a()).replace("{pb}", "").replace("{from}", paramString1).replace("{page}", paramString2).replace("{coverid}", paramString3).replace("{uin}", paramString4).replace("{hostUin}", paramString5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneHelper$QZoneCoverConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */