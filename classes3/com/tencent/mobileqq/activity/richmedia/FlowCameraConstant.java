package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Calendar;

public abstract class FlowCameraConstant
{
  public static float a = 0.75F;
  public static final int a = 95;
  public static final String a = "flow_camera_height";
  public static final float b = 0.83F;
  public static final int b = 90;
  public static final String b = "flow_camera_use_surfaceview";
  public static final int c = 1000;
  public static final String c = "flow_camera_ptv_mode";
  public static int d = 2;
  public static final String d = "flow_camera_capture_mode";
  public static final int e = 1000;
  public static final String e = "flow_camera_use_filter_function";
  public static final int f = 1001;
  public static final String f = "flow_camera_show_redDot";
  public static final int g = 1002;
  public static final String g = "flow_camera_video_mode";
  public static final int h = 20;
  public static final String h = "flow_camera_show_panel";
  public static final String i = "flow_camera_show_ptv_guide";
  public static final String j = "flow_key_ptv_max_time";
  public static final String k = "flow_key_need_poke_red";
  public static final String l = "flow_key_from_guide";
  public static final String m = "ignore_dpc_duration";
  public static final String n = "video_duration";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.bp);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i1 = localCalendar.get(2) + 1;
    if (i1 < 10)
    {
      localObject = "0" + i1;
      localStringBuilder.append(localObject);
      i1 = localCalendar.get(5);
      if (i1 >= 10) {
        break label293;
      }
      localObject = "0" + i1;
      label104:
      localStringBuilder.append(localObject);
      i1 = localCalendar.get(11);
      if (i1 >= 10) {
        break label301;
      }
      localObject = "0" + i1;
      label143:
      localStringBuilder.append(localObject);
      i1 = localCalendar.get(12);
      if (i1 >= 10) {
        break label309;
      }
      localObject = "0" + i1;
      label182:
      localStringBuilder.append(localObject);
      i1 = localCalendar.get(13);
      if (i1 >= 10) {
        break label317;
      }
    }
    label293:
    label301:
    label309:
    label317:
    for (Object localObject = "0" + i1;; localObject = Integer.valueOf(i1))
    {
      localStringBuilder.append(localObject);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label325;
      }
      return localStringBuilder.toString() + ".jpg";
      localObject = Integer.valueOf(i1);
      break;
      localObject = Integer.valueOf(i1);
      break label104;
      localObject = Integer.valueOf(i1);
      break label143;
      localObject = Integer.valueOf(i1);
      break label182;
    }
    label325:
    localObject = new StringBuilder(localStringBuilder);
    int i2 = localStringBuilder.length();
    i1 = 1;
    for (;;)
    {
      if (i1 < Integer.MAX_VALUE)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(".jpg");
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(i2, ((StringBuilder)localObject).length());
      i1 += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\FlowCameraConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */