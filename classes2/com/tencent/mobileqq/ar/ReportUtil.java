package com.tencent.mobileqq.ar;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ReportUtil
{
  public static int a = 0;
  public static final long a = 86400000L;
  public static final String a = "ARPerformance";
  public static HashMap a;
  private static boolean a = false;
  private static int jdField_b_of_type_Int = 0;
  public static final String b = "recog_track_quality";
  private static boolean jdField_b_of_type_Boolean = false;
  private static int c = 0;
  public static final String c = "render_quality";
  public static final String d = "recog";
  public static final String e = "track";
  public static final String f = "render";
  public static final String g = "glRender";
  public static final String h = "camRender";
  public static final String i = "modelRender";
  public static String j;
  public static final String k = "|";
  public static String l;
  public static String m;
  public static String n;
  public static final String o = "param_MODEL";
  public static final String p = "param_manu";
  public static final String q = "param_OS";
  public static final String r = "param_Resolution";
  public static final String s = "param_CPU";
  public static final String t = "param_Camera";
  public static final String u = "param_totalmemory";
  public static final String v = "param_availmemory";
  public static final String w = "param_totalrom";
  public static final String x = "param_availrom";
  public static final String y = "param_totalsd";
  public static final String z = "param_availsd";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Int = 5;
    c = 1;
    j = "";
    l = "";
    m = "";
    n = "";
    jdField_a_of_type_JavaUtilHashMap.put("recogQ3", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("recogQ4", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("recogQ5", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("trackQ3", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("trackQ4", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("trackQ5", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("renderQ1", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("renderQ0", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("glRenderQ1", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("glRenderQ0", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("camRenderQ0", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("modelRenderQ1", new GapDataCollector(Integer.MAX_VALUE));
    jdField_a_of_type_JavaUtilHashMap.put("modelRenderQ0", new GapDataCollector(Integer.MAX_VALUE));
  }
  
  public static LinkedHashMap a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("param_MODEL", DeviceInfoUtil.d());
    localLinkedHashMap.put("param_manu", DeviceInfoUtil.k());
    localLinkedHashMap.put("param_OS", DeviceInfoUtil.e());
    localLinkedHashMap.put("param_Resolution", DeviceInfoUtil.l());
    localLinkedHashMap.put("param_CPU", DeviceInfoUtil.g());
    localLinkedHashMap.put("param_totalmemory", String.valueOf(DeviceInfoUtil.c()));
    localLinkedHashMap.put("param_availmemory", String.valueOf(DeviceInfoUtil.d() / 1024L) + "kB");
    long[] arrayOfLong = DeviceInfoUtil.a();
    localLinkedHashMap.put("param_totalrom", String.valueOf(arrayOfLong[0]) + "MB");
    localLinkedHashMap.put("param_availrom", String.valueOf(arrayOfLong[1]) + "MB");
    arrayOfLong = DeviceInfoUtil.b();
    localLinkedHashMap.put("param_totalsd", String.valueOf(arrayOfLong[0]) + "MB");
    localLinkedHashMap.put("param_availsd", String.valueOf(arrayOfLong[1]) + "MB");
    localLinkedHashMap.put("param_Camera", "" + DeviceInfoUtil.c());
    return localLinkedHashMap;
  }
  
  public static void a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = a().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    localHashMap.put("GL_RENDERER", j);
    localHashMap.put("GL_VENDOR", l);
    localHashMap.put("GL_VERSION", m);
    localHashMap.put("GPUExtensions", n);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("recogQ3")).a();
    localHashMap.put("rec_time_q3", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("recogQ4")).a();
    localHashMap.put("rec_time_q4", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("recogQ5")).a();
    localHashMap.put("rec_time_q5", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("trackQ3")).a();
    localHashMap.put("track_time_q3", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("trackQ4")).a();
    localHashMap.put("track_time_q4", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("trackQ5")).a();
    localHashMap.put("track_time_q5", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("renderQ1")).a();
    localHashMap.put("render_fully", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("renderQ0")).a();
    localHashMap.put("render_deficient", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("glRenderQ1")).a();
    localHashMap.put("gl_render_fully", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("glRenderQ0")).a();
    localHashMap.put("gl_render_deficient", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("camRenderQ0")).a();
    localHashMap.put("cam_render", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("modelRenderQ0")).a();
    localHashMap.put("model_render_deficient", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localObject = ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("modelRenderQ1")).a();
    localHashMap.put("model_render_fully", ((GapDataCollector.RefreshData)localObject).c + "|" + ((GapDataCollector.RefreshData)localObject).b + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Long + "|" + ((GapDataCollector.RefreshData)localObject).f + "|" + ((GapDataCollector.RefreshData)localObject).jdField_a_of_type_Int);
    localHashMap.put("recog_track_quality", jdField_b_of_type_Int + "");
    localHashMap.put("render_quality", c + "");
    localHashMap.put("rec_track_stable", jdField_a_of_type_Boolean + "");
    localHashMap.put("render_stable", jdField_b_of_type_Boolean + "");
    localHashMap.put("recognized_times", jdField_a_of_type_Int + "");
    StatisticCollector.a(BaseApplicationImpl.a()).a(null, "ARPerformance", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if ("recog_track_quality".equals(paramString))
    {
      jdField_b_of_type_Int = paramInt;
      jdField_a_of_type_Boolean = true;
    }
    while (!"render_quality".equals(paramString)) {
      return;
    }
    c = paramInt;
    jdField_b_of_type_Boolean = true;
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    paramString = paramString + "Q" + paramInt;
    paramString = (GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.a(paramLong);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j = paramString1;
    l = paramString2;
    m = paramString3;
    n = paramString4;
  }
  
  public static void b()
  {
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("recogQ3")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("recogQ4")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("recogQ5")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("trackQ3")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("trackQ4")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("trackQ5")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("renderQ1")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("renderQ0")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("glRenderQ1")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("glRenderQ0")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("camRenderQ0")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("modelRenderQ1")).a();
    ((GapDataCollector)jdField_a_of_type_JavaUtilHashMap.get("modelRenderQ0")).a();
    jdField_b_of_type_Int = 5;
    c = 1;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ReportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */