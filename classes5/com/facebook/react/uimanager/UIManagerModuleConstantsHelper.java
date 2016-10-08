package com.facebook.react.uimanager;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextInlineImageViewManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.webview.ReactWebViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UIManagerModuleConstantsHelper
{
  private static final String CUSTOM_BUBBLING_EVENT_TYPES_KEY = "customBubblingEventTypes";
  private static final String CUSTOM_DIRECT_EVENT_TYPES_KEY = "customDirectEventTypes";
  public static List<Class<? extends ViewManager>> additionalViewManagerList = null;
  private static Map<String, Object> sMap;
  
  public static void addViewManager(Class<? extends ViewManager> paramClass)
  {
    if (additionalViewManagerList == null) {
      additionalViewManagerList = new ArrayList();
    }
    additionalViewManagerList.add(paramClass);
  }
  
  public static void addViewManager(List<Class<? extends ViewManager>> paramList)
  {
    if (additionalViewManagerList == null) {
      additionalViewManagerList = new ArrayList();
    }
    additionalViewManagerList.addAll(paramList);
  }
  
  public static Map<String, Object> createConstants(DisplayMetrics paramDisplayMetrics, List<ViewManager> paramList)
  {
    Map localMap2;
    try
    {
      paramDisplayMetrics = UIManagerModuleConstants.getConstants(paramDisplayMetrics);
      Map localMap1 = UIManagerModuleConstants.getBubblingEventTypeConstants();
      localMap2 = UIManagerModuleConstants.getDirectEventTypeConstants();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ViewManager localViewManager = (ViewManager)paramList.next();
        Object localObject = localViewManager.getExportedCustomBubblingEventTypeConstants();
        if (localObject != null) {
          recursiveMerge(localMap1, (Map)localObject);
        }
        localObject = localViewManager.getExportedCustomDirectEventTypeConstants();
        if (localObject != null) {
          recursiveMerge(localMap2, (Map)localObject);
        }
        localObject = MapBuilder.newHashMap();
        Map localMap3 = localViewManager.getExportedViewConstants();
        if (localMap3 != null) {
          ((Map)localObject).put("Constants", localMap3);
        }
        localMap3 = localViewManager.getCommandsMap();
        if (localMap3 != null) {
          ((Map)localObject).put("Commands", localMap3);
        }
        localMap3 = localViewManager.getNativeProps();
        if (!localMap3.isEmpty()) {
          ((Map)localObject).put("NativeProps", localMap3);
        }
        if (!((Map)localObject).isEmpty()) {
          paramDisplayMetrics.put(localViewManager.getName(), localObject);
        }
      }
      paramDisplayMetrics.put("customBubblingEventTypes", localMap1);
    }
    finally {}
    paramDisplayMetrics.put("customDirectEventTypes", localMap2);
    return paramDisplayMetrics;
  }
  
  /* Error */
  public static Map<String, Object> createStaticConstants(DisplayMetrics paramDisplayMetrics, List<Class<? extends ViewManager>> paramList)
  {
    // Byte code:
    //   0: getstatic 125	com/facebook/react/uimanager/UIManagerModuleConstantsHelper:sMap	Ljava/util/Map;
    //   3: ifnull +7 -> 10
    //   6: getstatic 125	com/facebook/react/uimanager/UIManagerModuleConstantsHelper:sMap	Ljava/util/Map;
    //   9: areturn
    //   10: aload_0
    //   11: invokestatic 52	com/facebook/react/uimanager/UIManagerModuleConstants:getConstants	(Landroid/util/DisplayMetrics;)Ljava/util/Map;
    //   14: astore_0
    //   15: invokestatic 56	com/facebook/react/uimanager/UIManagerModuleConstants:getBubblingEventTypeConstants	()Ljava/util/Map;
    //   18: astore_2
    //   19: invokestatic 59	com/facebook/react/uimanager/UIManagerModuleConstants:getDirectEventTypeConstants	()Ljava/util/Map;
    //   22: astore_3
    //   23: aload_1
    //   24: invokeinterface 63 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 69 1 0
    //   36: ifeq +271 -> 307
    //   39: aload_1
    //   40: invokeinterface 73 1 0
    //   45: checkcast 127	java/lang/Class
    //   48: astore 4
    //   50: aload 4
    //   52: ldc -127
    //   54: iconst_0
    //   55: anewarray 127	java/lang/Class
    //   58: invokevirtual 133	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: aconst_null
    //   62: iconst_0
    //   63: anewarray 4	java/lang/Object
    //   66: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 98	java/util/Map
    //   72: astore 5
    //   74: aload 5
    //   76: ifnull +9 -> 85
    //   79: aload_2
    //   80: aload 5
    //   82: invokestatic 82	com/facebook/react/uimanager/UIManagerModuleConstantsHelper:recursiveMerge	(Ljava/util/Map;Ljava/util/Map;)V
    //   85: aload 4
    //   87: ldc -115
    //   89: iconst_0
    //   90: anewarray 127	java/lang/Class
    //   93: invokevirtual 133	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   96: aconst_null
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: checkcast 98	java/util/Map
    //   107: astore 5
    //   109: aload 5
    //   111: ifnull +9 -> 120
    //   114: aload_3
    //   115: aload 5
    //   117: invokestatic 82	com/facebook/react/uimanager/UIManagerModuleConstantsHelper:recursiveMerge	(Ljava/util/Map;Ljava/util/Map;)V
    //   120: invokestatic 91	com/facebook/react/common/MapBuilder:newHashMap	()Ljava/util/HashMap;
    //   123: astore 5
    //   125: aload 4
    //   127: ldc -113
    //   129: iconst_0
    //   130: anewarray 127	java/lang/Class
    //   133: invokevirtual 133	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   136: aconst_null
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   144: checkcast 98	java/util/Map
    //   147: astore 6
    //   149: aload 6
    //   151: ifnull +15 -> 166
    //   154: aload 5
    //   156: ldc 96
    //   158: aload 6
    //   160: invokeinterface 102 3 0
    //   165: pop
    //   166: aload 4
    //   168: ldc -111
    //   170: iconst_0
    //   171: anewarray 127	java/lang/Class
    //   174: invokevirtual 133	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   177: aconst_null
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   185: checkcast 98	java/util/Map
    //   188: astore 6
    //   190: aload 6
    //   192: ifnull +15 -> 207
    //   195: aload 5
    //   197: ldc 107
    //   199: aload 6
    //   201: invokeinterface 102 3 0
    //   206: pop
    //   207: aload 4
    //   209: aload 4
    //   211: ldc -109
    //   213: iconst_0
    //   214: anewarray 127	java/lang/Class
    //   217: invokevirtual 133	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   220: aconst_null
    //   221: iconst_0
    //   222: anewarray 4	java/lang/Object
    //   225: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   228: checkcast 127	java/lang/Class
    //   231: invokestatic 153	com/facebook/react/uimanager/ViewManagersPropertyCache:getNativePropsForView	(Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/Map;
    //   234: astore 6
    //   236: aload 6
    //   238: invokeinterface 113 1 0
    //   243: ifne +15 -> 258
    //   246: aload 5
    //   248: ldc 115
    //   250: aload 6
    //   252: invokeinterface 102 3 0
    //   257: pop
    //   258: aload 5
    //   260: invokeinterface 113 1 0
    //   265: ifne -235 -> 30
    //   268: aload_0
    //   269: aload 4
    //   271: ldc -101
    //   273: iconst_0
    //   274: anewarray 127	java/lang/Class
    //   277: invokevirtual 133	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   280: aconst_null
    //   281: iconst_0
    //   282: anewarray 4	java/lang/Object
    //   285: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   288: checkcast 157	java/lang/String
    //   291: aload 5
    //   293: invokeinterface 102 3 0
    //   298: pop
    //   299: goto -269 -> 30
    //   302: astore 4
    //   304: goto -274 -> 30
    //   307: aload_0
    //   308: ldc 8
    //   310: aload_2
    //   311: invokeinterface 102 3 0
    //   316: pop
    //   317: aload_0
    //   318: ldc 11
    //   320: aload_3
    //   321: invokeinterface 102 3 0
    //   326: pop
    //   327: aload_0
    //   328: putstatic 125	com/facebook/react/uimanager/UIManagerModuleConstantsHelper:sMap	Ljava/util/Map;
    //   331: aload_0
    //   332: areturn
    //   333: astore 4
    //   335: goto -305 -> 30
    //   338: astore 6
    //   340: goto -82 -> 258
    //   343: astore 6
    //   345: goto -138 -> 207
    //   348: astore 6
    //   350: goto -184 -> 166
    //   353: astore 5
    //   355: goto -235 -> 120
    //   358: astore 5
    //   360: goto -275 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramDisplayMetrics	DisplayMetrics
    //   0	363	1	paramList	List<Class<? extends ViewManager>>
    //   18	293	2	localMap1	Map
    //   22	299	3	localMap2	Map
    //   48	222	4	localClass	Class
    //   302	1	4	localException1	Exception
    //   333	1	4	localException2	Exception
    //   72	220	5	localObject	Object
    //   353	1	5	localException3	Exception
    //   358	1	5	localException4	Exception
    //   147	104	6	localMap3	Map
    //   338	1	6	localException5	Exception
    //   343	1	6	localException6	Exception
    //   348	1	6	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   258	299	302	java/lang/Exception
    //   120	125	333	java/lang/Exception
    //   207	258	338	java/lang/Exception
    //   166	190	343	java/lang/Exception
    //   195	207	343	java/lang/Exception
    //   125	149	348	java/lang/Exception
    //   154	166	348	java/lang/Exception
    //   85	109	353	java/lang/Exception
    //   114	120	353	java/lang/Exception
    //   50	74	358	java/lang/Exception
    //   79	85	358	java/lang/Exception
  }
  
  public static void destroy()
  {
    sMap = null;
  }
  
  public static Map<String, Object> getStaticConstants(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = createStaticConstants(paramContext.getResources().getDisplayMetrics(), makeClasses());
      }
      finally {}
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    getStaticConstants(null);
  }
  
  private static List<Class<? extends ViewManager>> makeClasses()
  {
    List localList = Arrays.asList(new Class[] { ReactImageManager.class, ReactProgressBarViewManager.class, ReactRawTextManager.class, ReactHorizontalScrollViewManager.class, ReactScrollViewManager.class, ReactTextInputManager.class, ReactTextViewManager.class, ReactViewManager.class, ReactTextInlineImageViewManager.class, ReactVirtualTextViewManager.class, ReactWebViewManager.class });
    if ((additionalViewManagerList != null) && (additionalViewManagerList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(localList.size() + additionalViewManagerList.size());
      localArrayList.addAll(localList);
      localArrayList.addAll(additionalViewManagerList);
      return localArrayList;
    }
    return localList;
  }
  
  private static void recursiveMerge(Map paramMap1, Map paramMap2)
  {
    Iterator localIterator = paramMap2.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramMap2.get(localObject1);
      Object localObject3 = paramMap1.get(localObject1);
      if ((localObject3 != null) && ((localObject2 instanceof Map)) && ((localObject3 instanceof Map))) {
        recursiveMerge((Map)localObject3, (Map)localObject2);
      } else {
        paramMap1.put(localObject1, localObject2);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\UIManagerModuleConstantsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */