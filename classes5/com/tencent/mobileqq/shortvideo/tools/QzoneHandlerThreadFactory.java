package com.tencent.mobileqq.shortvideo.tools;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public class QzoneHandlerThreadFactory
{
  public static final String a = "QzoneThread";
  private static Map a = new HashMap();
  public static final String b = "BackGround_HandlerThread";
  public static final String c = "LeakCheck_HandlerThread";
  public static final String d = "Normal_HandlerThread";
  public static final String e = "RealTime_HandlerThread";
  public static final String f = "Business_HandlerThread";
  public static final String g = "Music_HandlerThread";
  public static final String h = "PublishQueue_HandlerThread";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(String paramString)
  {
    if ("BackGround_HandlerThread".equalsIgnoreCase(paramString)) {}
    do
    {
      return 10;
      if ("RealTime_HandlerThread".equalsIgnoreCase(paramString)) {
        return -2;
      }
    } while ("LeakCheck_HandlerThread".equalsIgnoreCase(paramString));
    return 0;
  }
  
  public static QzoneBaseThread a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static QzoneBaseThread a(String paramString, boolean paramBoolean)
  {
    synchronized (a)
    {
      Object localObject2 = (QzoneBaseThread)a.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QzoneBaseThread)localObject2).b())
        {
          a.remove(paramString);
          localObject1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new QzoneBaseThread(paramString, a(paramString));
        if (paramBoolean) {
          ((QzoneBaseThread)localObject2).a(paramBoolean);
        }
        a.put(paramString, localObject2);
      }
      return (QzoneBaseThread)localObject2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\tools\QzoneHandlerThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */