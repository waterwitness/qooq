package cooperation.qzone.util;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class PerfTracer
{
  public static final String A = "FriendFeed_initFakeUI";
  public static final String B = "FriendFeed_initUI";
  public static final String C = "FriendFeed_initHeader";
  public static final String D = "FriendFeed_initHeader_Cover";
  public static final String E = "FriendFeed_initData";
  public static final String F = "FriendFeed_onResume";
  public static final String G = "FriendFeed_onCreate2WindowFocus";
  public static final String H = "FriendFeed_delayShow";
  public static final String I = "FriendFeed_photoGuidebannerShow";
  public static final String J = "QunFeed_onCreate";
  public static final String K = "QunFeed_parseIntent";
  public static final String L = "QunFeed_initUI";
  public static final String M = "QunFeed_initData";
  public static final String N = "QunFeed_onResume";
  public static final String O = "Detail_onCreate";
  public static final String P = "Detail_init";
  public static final String Q = "Detail_initEmoView";
  public static final String R = "Detail_onResume";
  public static final String S = "Detail_render";
  public static final String T = "UploadPhoto_onCreate";
  public static final String U = "UploadPhoto_state_init";
  public static final String V = "UploadPhoto_initUI";
  public static final String W = "UploadPhoto_initData";
  public static final String X = "UploadPhoto_initEmoView";
  public static final String Y = "UploadPhoto_onResume";
  public static final String Z = "PublishMood_onCreate";
  public static final int a = 1;
  public static final String a = "click_time";
  public static final ConcurrentHashMap a = new ConcurrentHashMap(new HashMap(8));
  public static final boolean a = false;
  public static final String aA = "PhotoWall_initData";
  public static final String aB = "PhotoWall_onResume";
  public static final String aC = "MoodList_onCreate";
  public static final String aD = "MoodList_initUI";
  public static final String aE = "MoodList_initData";
  public static final String aF = "MyFeed_onCreate";
  public static final String aG = "MyFeed_initUI";
  public static final String aH = "MyFeed_initData";
  public static final String aI = "MyFeed_onResume";
  public static final String aJ = "Video_component_pre_launch";
  public static final String aK = "Video_component_onCreate";
  private static final String aL = "Perf.Qzone";
  public static final String aa = "PublishMood_state_init";
  public static final String ab = "PublishMood_initUI";
  public static final String ac = "PublishMood_initData";
  public static final String ad = "PublishMood_onResume";
  public static final String ae = "QunAlbum_onCreate";
  public static final String af = "QunAlbum_state_init";
  public static final String ag = "QunAlbum_parseIntent";
  public static final String ah = "QunAlbum_initUI";
  public static final String ai = "QunAlbum_initData";
  public static final String aj = "QunAlbum_onResume";
  public static final String ak = "UserHome_onCreate";
  public static final String al = "UserHome_parseIntent";
  public static final String am = "UserHome_initUI";
  public static final String an = "UserHome_initHeader";
  public static final String ao = "UserHome_initData";
  public static final String ap = "UserHome_onResume";
  public static final String aq = "UserHome_Header_Resume";
  public static final String ar = "UserHome_PerformanceReport_Resume";
  public static final String as = "React_onCreate";
  public static final String at = "QzoneAlbum_onCreate";
  public static final String au = "QzoneAlbum_parseIntent";
  public static final String av = "QzoneAlbum_initUI";
  public static final String aw = "QzoneAlbum_initData";
  public static final String ax = "QzoneAlbum_onResume";
  public static final String ay = "PhotoWall_onCreate";
  public static final String az = "PhotoWall_initUI";
  public static final int b = 2;
  public static final String b = "startup_sceneid";
  public static final int c = 3;
  public static final String c = "click2LoadCompleted";
  public static final int d = 4;
  public static final String d = "click2LoadActivityCreate";
  public static final int e = 5;
  public static final String e = "App_onCreate";
  public static final int f = 6;
  public static final String f = "Runtime_load_runtime";
  public static final String g = "Runtime_onCreate";
  public static final String h = "Runtime_super_onCreate";
  public static final String i = "Runtime_first_init";
  public static final String j = "Runtime_Business_onLogin";
  public static final String k = "Runtime_Video_Init";
  public static final String l = "Preload_contentView";
  public static final String m = "Preload_headView";
  public static final String n = "Preload_New_FriendFeed";
  public static final String o = "Preload_Feed_View";
  public static final String p = "Preload_Nick_Name";
  public static final String q = "Preload_Cover";
  public static final String r = "Preload_Avatar";
  public static final String s = "Preload_FriendFeedData";
  public static final String t = "Preload_QunFeedData";
  public static final String u = "Preload_UserHomeLayout";
  public static final String v = "Preload_Load_UserHome_Class";
  public static final String w = "Prload_advFeedView";
  public static final String x = "BaseFeed_super_onCreate";
  public static final String y = "FriendFeed_onCreate";
  public static final String z = "FriendFeed_parseIntent";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l1;
    do
    {
      return;
      l1 = paramIntent.getLongExtra("click_time", 0L);
    } while (l1 <= 0L);
    boolean bool = paramIntent.getBooleanExtra("QZoneExtra.Plugin.isloading", false);
    int i1 = paramIntent.getIntExtra("startup_sceneid", -1);
    TimeCostTrace.a("qzone_launch").a(l1, i1, bool);
    TimeCostTrace.a("qzone_launch").a("click2LoadActivityCreate", l1);
    TimeCostTrace.a("qzone_launch").a("click2LoadCompleted", l1);
    b("click2LoadActivityCreate");
  }
  
  public static void a(PerfTracer.PerfTimeReport paramPerfTimeReport)
  {
    b("click2LoadCompleted");
    TimeCostTrace localTimeCostTrace = TimeCostTrace.a("qzone_launch");
    if (localTimeCostTrace == null) {
      return;
    }
    if ((localTimeCostTrace.a() > 0L) && (paramPerfTimeReport != null))
    {
      paramPerfTimeReport.a(localTimeCostTrace);
      return;
    }
    localTimeCostTrace.b();
  }
  
  public static void a(String paramString)
  {
    a(null, paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    System.currentTimeMillis();
    TimeCostTrace.a("qzone_launch").b(paramString1);
    TimeCostTrace.a("qzone_launch").a(paramString2);
  }
  
  public static void b(String paramString)
  {
    a(paramString, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qzone\util\PerfTracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */