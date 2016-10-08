package com.tencent.ttpic.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BenchUtil
{
  private static final int COUNT = 16;
  private static final String PREFIX = "[time]";
  private static final String TAG = BenchUtil.class.getSimpleName();
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, List<Long>> totalTimeMap = new HashMap();
  
  public static long benchEnd(String paramString)
  {
    long l1;
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {
      l1 = 0L;
    }
    Object localObject;
    long l2;
    do
    {
      return l1;
      List localList = (List)totalTimeMap.get(paramString);
      localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        totalTimeMap.put(paramString, localObject);
      }
      l2 = System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue();
      ((List)localObject).add(Long.valueOf(l2));
      l1 = l2;
    } while (((List)localObject).size() < 16);
    ((List)localObject).clear();
    return l2;
  }
  
  public static void benchEnd(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {}
    Object localObject;
    do
    {
      return;
      List localList = (List)totalTimeMap.get(paramString);
      localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        totalTimeMap.put(paramString, localObject);
      }
      ((List)localObject).add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
    } while (((List)localObject).size() < 16);
    Log.d(TAG, "[time]" + paramString + ": " + getTotalTime((List)localObject) / (((List)localObject).size() / paramInt) + "ms");
    ((List)localObject).clear();
  }
  
  public static void benchEndReverse(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {}
    Object localObject;
    do
    {
      return;
      List localList = (List)totalTimeMap.get(paramString);
      localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        totalTimeMap.put(paramString, localObject);
      }
      ((List)localObject).add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
    } while (((List)localObject).size() < 16);
    Log.d(TAG, "[time]" + paramString + ": " + ((List)localObject).size() * paramInt / getTotalTime((List)localObject) + "fps");
    ((List)localObject).clear();
  }
  
  public static void benchStart(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  private static long getTotalTime(List<Long> paramList)
  {
    long l2;
    if (VideoUtil.isEmpty(paramList))
    {
      l2 = 0L;
      return l2;
    }
    long l1 = 0L;
    paramList = paramList.iterator();
    for (;;)
    {
      l2 = l1;
      if (!paramList.hasNext()) {
        break;
      }
      l1 += ((Long)paramList.next()).longValue();
    }
  }
  
  public static void init()
  {
    startTimeMap.clear();
    totalTimeMap.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\BenchUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */