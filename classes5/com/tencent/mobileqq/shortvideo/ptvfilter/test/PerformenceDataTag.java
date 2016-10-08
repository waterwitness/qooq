package com.tencent.mobileqq.shortvideo.ptvfilter.test;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class PerformenceDataTag
{
  public static final int a = 1;
  public static final String a = "sv_filter_face_track";
  public static final int b = 2;
  public static final String b = "sv_filter_face_detect";
  public static final int c = 3;
  public static final String c = "sv_filter_draw_frame";
  public static final String d = "sv_filter_total_draw";
  public static final String e = "sv_filter_total_process_frame";
  public static final String f = "sv_filter_track_ratio";
  public static final String g = "sv_filter_mp4_fps";
  private static final String h = "sv_filter_egl_crash_exp";
  
  public PerformenceDataTag()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("crashKind", "" + paramInt);
    StatisticCollector.a(VideoEnvironment.a()).a(null, "sv_filter_egl_crash_exp", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("time", "" + paramLong);
    StatisticCollector.a(VideoEnvironment.a()).a(null, paramString, true, paramLong, 0L, localHashMap, "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ptvfilter\test\PerformenceDataTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */