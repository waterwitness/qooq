package com.tencent.mobileqq.olympic;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.xmlpull.v1.XmlPullParser;

public class OlympicActConfig
  implements Serializable
{
  public static final String KEY_CONFIG_VERSION = "config_version";
  public static final String SAVE_PATH = "olympic_act_cfg_";
  public static final String TAG = OlympicActConfig.class.getSimpleName();
  public static final long serialVersionUID = 3L;
  private HashMap mAllCityImageMap = new HashMap();
  private HashMap mBusiBannerMap = new HashMap();
  private ArrayList mChosenCityImageList = new ArrayList();
  private HashMap mCityBgMap = new HashMap();
  private HashMap mConfigs = new HashMap();
  private HashMap mTorchImageMap = new HashMap();
  public int version = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  private void a(AppRuntime paramAppRuntime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 74
    //   13: aastore
    //   14: invokestatic 80	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_1
    //   18: checkcast 82	com/tencent/common/app/AppInterface
    //   21: invokevirtual 84	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   24: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   27: lstore 4
    //   29: lload 4
    //   31: bipush 32
    //   33: lshl
    //   34: invokestatic 96	java/lang/System:nanoTime	()J
    //   37: lor
    //   38: invokestatic 102	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   41: invokevirtual 106	java/lang/String:hashCode	()I
    //   44: i2l
    //   45: lstore 6
    //   47: lload 6
    //   49: lstore 4
    //   51: lload 6
    //   53: lconst_0
    //   54: lcmp
    //   55: ifne +8 -> 63
    //   58: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   61: lstore 4
    //   63: new 111	java/util/Random
    //   66: dup
    //   67: lload 4
    //   69: invokespecial 114	java/util/Random:<init>	(J)V
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 59	com/tencent/mobileqq/olympic/OlympicActConfig:mAllCityImageMap	Ljava/util/HashMap;
    //   77: invokevirtual 118	java/util/HashMap:keySet	()Ljava/util/Set;
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 64	com/tencent/mobileqq/olympic/OlympicActConfig:mChosenCityImageList	Ljava/util/ArrayList;
    //   85: invokevirtual 121	java/util/ArrayList:clear	()V
    //   88: aload_2
    //   89: invokeinterface 127 1 0
    //   94: astore_2
    //   95: aload_2
    //   96: invokeinterface 133 1 0
    //   101: ifeq +116 -> 217
    //   104: aload_2
    //   105: invokeinterface 137 1 0
    //   110: checkcast 139	java/lang/Integer
    //   113: astore_3
    //   114: aload_0
    //   115: getfield 59	com/tencent/mobileqq/olympic/OlympicActConfig:mAllCityImageMap	Ljava/util/HashMap;
    //   118: aload_3
    //   119: invokevirtual 143	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 145	java/util/List
    //   125: astore_3
    //   126: aload_3
    //   127: invokeinterface 148 1 0
    //   132: ifle -37 -> 95
    //   135: aload_3
    //   136: aload_1
    //   137: aload_3
    //   138: invokeinterface 148 1 0
    //   143: invokevirtual 152	java/util/Random:nextInt	(I)I
    //   146: invokeinterface 155 2 0
    //   151: checkcast 157	com/tencent/mobileqq/olympic/OlympicActConfig$CityImage
    //   154: astore_3
    //   155: aload_0
    //   156: getfield 64	com/tencent/mobileqq/olympic/OlympicActConfig:mChosenCityImageList	Ljava/util/ArrayList;
    //   159: aload_3
    //   160: invokevirtual 161	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   167: iconst_2
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: ldc -93
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_3
    //   179: invokevirtual 166	com/tencent/mobileqq/olympic/OlympicActConfig$CityImage:toString	()Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 80	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: goto -91 -> 95
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +13 -> 211
    //   201: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   204: iconst_2
    //   205: ldc 74
    //   207: aload_1
    //   208: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: lconst_0
    //   212: lstore 4
    //   214: goto -185 -> 29
    //   217: aload_0
    //   218: monitorexit
    //   219: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	OlympicActConfig
    //   0	220	1	paramAppRuntime	AppRuntime
    //   80	25	2	localObject1	Object
    //   113	66	3	localObject2	Object
    //   27	186	4	l1	long
    //   45	7	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	17	189	finally
    //   17	29	189	finally
    //   29	47	189	finally
    //   58	63	189	finally
    //   63	95	189	finally
    //   95	186	189	finally
    //   195	211	189	finally
    //   17	29	194	java/lang/Throwable
  }
  
  public static boolean deleteFile(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        OlympicUtil.b(TAG, new Object[] { "deleteFile()" });
        if (paramQQAppInterface == null)
        {
          OlympicUtil.b(TAG, new Object[] { "deleteFile(), app is null" });
          return bool;
        }
        paramQQAppInterface = paramContext.getFileStreamPath("olympic_act_cfg_" + paramQQAppInterface.a());
        if (!paramQQAppInterface.exists()) {
          OlympicUtil.b(TAG, new Object[] { "deleteFile, config file not exist" });
        } else {
          bool = paramQQAppInterface.delete();
        }
      }
      finally {}
    }
  }
  
  public static OlympicActConfig parse(AppRuntime paramAppRuntime, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      OlympicUtil.b(TAG, new Object[] { "parse(), xmlContent is empty" });
      return null;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    OlympicActConfig localOlympicActConfig = new OlympicActConfig();
    localObject1 = "";
    localObject4 = null;
    OlympicUtil.b(TAG, new Object[] { "parse(), start parse" });
    localObject5 = localObject1;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        localObject5 = localObject1;
        i = localXmlPullParser.getEventType();
        localObject2 = null;
        paramString = "";
        localObject1 = null;
        localObject3 = null;
      }
      catch (Exception paramString)
      {
        paramAppRuntime = (AppRuntime)localObject5;
        continue;
        continue;
        continue;
        int i = -1;
        continue;
        if (i == 1) {
          continue;
        }
        localObject5 = localObject4;
        switch (i)
        {
        case 0: 
        case 4: 
        case 2: 
        default: 
          localObject5 = localObject4;
        }
        localObject4 = localObject3;
        Object localObject3 = localObject2;
        Object localObject2 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject5;
        continue;
        localObject5 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject5;
        continue;
        localObject5 = null;
        localObject4 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject5;
        continue;
      }
      localObject5 = paramString;
      i = localXmlPullParser.next();
      localObject5 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject5;
      continue;
      localObject5 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
      continue;
      localObject5 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
      continue;
      try
      {
        String str = localXmlPullParser.getName();
        OlympicUtil.b(TAG, new Object[] { "startTag=", str, ", depth=", Integer.valueOf(localXmlPullParser.getDepth()) });
        if ("Olympic".equalsIgnoreCase(str))
        {
          localObject5 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject5;
        }
        else
        {
          Object localObject6;
          if (localXmlPullParser.getDepth() == 2)
          {
            localObject6 = localObject1;
            localObject5 = localObject2;
            paramString = str;
            localObject1 = localObject3;
            localObject2 = localObject6;
            localObject3 = localObject5;
          }
          else if ("TorchImage".equalsIgnoreCase(paramString))
          {
            if ("companyId".equalsIgnoreCase(str))
            {
              localObject5 = new OlympicActConfig.TorchImage();
              ((OlympicActConfig.TorchImage)localObject5).hasBg = true;
              ((OlympicActConfig.TorchImage)localObject5).companyId = tryParseInt(localXmlPullParser.nextText());
              localObject2 = localObject3;
              localObject3 = localObject5;
              localObject5 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject5;
            }
            else if ("FileUrl".equalsIgnoreCase(str))
            {
              if (localObject2 != null)
              {
                ((OlympicActConfig.TorchImage)localObject2).url = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "TorchImage, FileUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"FileMd5".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject2 != null)
              {
                ((OlympicActConfig.TorchImage)localObject2).md5 = localXmlPullParser.nextText();
                localOlympicActConfig.mTorchImageMap.put(((OlympicActConfig.TorchImage)localObject2).companyId + "", localObject2);
                localObject5 = null;
                localObject2 = localObject1;
                localObject1 = localObject3;
                localObject3 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "TorchImage, FileMd5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
          }
          else if (("CityImage".equalsIgnoreCase(paramString)) || ("City2Image".equalsIgnoreCase(paramString)))
          {
            if ("companyId".equalsIgnoreCase(str))
            {
              localObject5 = new OlympicActConfig.CityImage();
              ((OlympicActConfig.CityImage)localObject5).companyId = tryParseInt(localXmlPullParser.nextText());
              localObject1 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject5;
            }
            else if ("PicId".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).picId = tryParseLong(localXmlPullParser.nextText());
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "CityImage, PicId 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("FileUrl".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).url = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "CityImage, FileUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("FileMd5".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).md5 = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "CityImage, FileMd5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("StarFileUrl".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).starUrl = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "CityImage, StarFileUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"StarFileMd5".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).starMd5 = localXmlPullParser.nextText();
                if ("CityImage".equalsIgnoreCase(paramString))
                {
                  i = 1;
                  if (i <= 0) {
                    continue;
                  }
                  localObject6 = (List)localOlympicActConfig.mAllCityImageMap.get(Integer.valueOf(i));
                  localObject5 = localObject6;
                  if (localObject6 == null) {
                    localObject5 = new ArrayList();
                  }
                  ((List)localObject5).add(localObject1);
                  localOlympicActConfig.mAllCityImageMap.put(Integer.valueOf(i), localObject5);
                  localObject1 = null;
                  continue;
                }
                if (!"City2Image".equalsIgnoreCase(paramString)) {
                  continue;
                }
                i = 2;
                continue;
              }
              OlympicUtil.b(TAG, new Object[] { "CityImage, StarFileMd5 错误的tag顺序!" });
              localObject5 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject5;
            }
          }
          else if ("HomePageBG".equalsIgnoreCase(paramString))
          {
            if ("Cityid".equalsIgnoreCase(str))
            {
              localObject5 = new OlympicActConfig.HomePageBg();
              ((OlympicActConfig.HomePageBg)localObject5).cityId = localXmlPullParser.nextText();
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject5;
            }
            else if ("Url".equalsIgnoreCase(str))
            {
              if (localObject3 != null)
              {
                ((OlympicActConfig.HomePageBg)localObject3).url = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "HomePageBG, Url 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"Md5".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject3 != null)
              {
                ((OlympicActConfig.HomePageBg)localObject3).md5 = localXmlPullParser.nextText();
                localOlympicActConfig.mCityBgMap.put(((OlympicActConfig.HomePageBg)localObject3).cityId, localObject3);
                localObject5 = null;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "HomePageBG, Md5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
          }
          else if ("BusiBanner".equalsIgnoreCase(paramString))
          {
            if ("BannerId".equalsIgnoreCase(str))
            {
              localObject4 = new OlympicActConfig.BusiBanner();
              ((OlympicActConfig.BusiBanner)localObject4).BannerId = localXmlPullParser.nextText();
              localObject5 = localObject4;
              if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).BannerId)) {
                continue;
              }
              localObject5 = null;
              OlympicUtil.b(TAG, new Object[] { "BannerId is empty" });
              localObject4 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject4;
              localObject4 = localObject5;
            }
            else if ("Text".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).Text = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).Text)) {
                  continue;
                }
                localObject5 = null;
                OlympicUtil.b(TAG, new Object[] { "Text is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "BusiBanner, Text 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("RemindText".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).RemindText = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).RemindText)) {
                  continue;
                }
                localObject5 = null;
                OlympicUtil.b(TAG, new Object[] { "RemindText is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "BusiBanner, RemindText 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("ImgUrl".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).ImgUrl = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).ImgUrl)) {
                  continue;
                }
                localObject5 = null;
                OlympicUtil.b(TAG, new Object[] { "ImgUrl is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "BusiBanner, ImgUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("ImgMd5".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).ImgMd5 = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).ImgMd5)) {
                  continue;
                }
                localObject5 = null;
                OlympicUtil.b(TAG, new Object[] { "ImgMd5 is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                OlympicUtil.b(TAG, new Object[] { "BusiBanner, ImgMd5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"BusiBannerJump".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).BusiBannerJump = localXmlPullParser.nextText();
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).BusiBannerJump)) {
                  continue;
                }
                localObject4 = null;
                OlympicUtil.b(TAG, new Object[] { "BusiBannerJump is empty" });
                if (localObject4 == null) {
                  continue;
                }
                localOlympicActConfig.mBusiBannerMap.put(((OlympicActConfig.BusiBanner)localObject4).BannerId, localObject4);
                continue;
              }
              OlympicUtil.b(TAG, new Object[] { "BusiBanner, BusiBannerJump 错误的tag顺序!" });
              localObject5 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject5;
            }
          }
          else
          {
            localObject5 = localXmlPullParser.nextText();
            localOlympicActConfig.mConfigs.put(paramString + "_" + str, localObject5);
            localObject5 = localObject4;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        localObject1 = paramString;
        paramString = paramAppRuntime;
        paramAppRuntime = (AppRuntime)localObject1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = TAG;
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null) {
        localObject1 = "null";
      }
      QLog.d((String)localObject2, 2, new Object[] { "parse(), prefix=", localObject1, ", exception=, ", paramString });
    }
    for (;;)
    {
      for (paramAppRuntime = null;; paramAppRuntime = localOlympicActConfig)
      {
        OlympicUtil.b(TAG, new Object[] { "parse(), end parse" });
        return paramAppRuntime;
        localOlympicActConfig.a(paramAppRuntime);
      }
      localObject2 = TAG;
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null) {
        localObject1 = "null";
      }
      QLog.d((String)localObject2, 1, new Object[] { "parse(), prefix=", localObject1, ", exception=, ", paramString.getMessage() });
    }
  }
  
  /* Error */
  public static OlympicActConfig readFromFile(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   10: iconst_1
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 444
    //   19: aastore
    //   20: invokestatic 80	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_0
    //   24: ifnonnull +26 -> 50
    //   27: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 446
    //   39: aastore
    //   40: invokestatic 80	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_2
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: aload_1
    //   51: new 183	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   58: ldc 13
    //   60: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   67: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 198	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 203	java/io/File:exists	()Z
    //   81: ifne +30 -> 111
    //   84: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: ldc_w 448
    //   96: aastore
    //   97: invokestatic 80	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_2
    //   101: astore_0
    //   102: goto -57 -> 45
    //   105: astore_0
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    //   111: ldc_w 449
    //   114: newarray <illegal type>
    //   116: astore_2
    //   117: new 451	java/io/FileInputStream
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 454	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore_1
    //   126: aload_1
    //   127: aload_2
    //   128: invokevirtual 458	java/io/FileInputStream:read	([B)I
    //   131: pop
    //   132: new 460	java/io/ObjectInputStream
    //   135: dup
    //   136: new 233	java/io/ByteArrayInputStream
    //   139: dup
    //   140: aload_2
    //   141: invokespecial 240	java/io/ByteArrayInputStream:<init>	([B)V
    //   144: invokespecial 463	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   147: astore 5
    //   149: aload 5
    //   151: astore_3
    //   152: aload_1
    //   153: astore_2
    //   154: aload 5
    //   156: invokevirtual 466	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   159: checkcast 2	com/tencent/mobileqq/olympic/OlympicActConfig
    //   162: astore 4
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 469	java/io/FileInputStream:close	()V
    //   172: aload 4
    //   174: astore_0
    //   175: aload 5
    //   177: ifnull +11 -> 188
    //   180: aload 5
    //   182: invokevirtual 470	java/io/ObjectInputStream:close	()V
    //   185: aload 4
    //   187: astore_0
    //   188: goto -143 -> 45
    //   191: astore_0
    //   192: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -23 -> 172
    //   198: aload_0
    //   199: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   202: goto -30 -> 172
    //   205: astore_1
    //   206: aload 4
    //   208: astore_0
    //   209: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq -24 -> 188
    //   215: aload_1
    //   216: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   219: aload 4
    //   221: astore_0
    //   222: goto -34 -> 188
    //   225: astore 4
    //   227: aconst_null
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_1
    //   231: aload_0
    //   232: astore_3
    //   233: aload_1
    //   234: astore_2
    //   235: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +19 -> 257
    //   241: aload_0
    //   242: astore_3
    //   243: aload_1
    //   244: astore_2
    //   245: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   248: iconst_2
    //   249: ldc_w 475
    //   252: aload 4
    //   254: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 469	java/io/FileInputStream:close	()V
    //   265: aload_0
    //   266: ifnull +116 -> 382
    //   269: aload_0
    //   270: invokevirtual 470	java/io/ObjectInputStream:close	()V
    //   273: aconst_null
    //   274: astore_0
    //   275: goto -87 -> 188
    //   278: astore_1
    //   279: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -17 -> 265
    //   285: aload_1
    //   286: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   289: goto -24 -> 265
    //   292: astore_0
    //   293: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +7 -> 303
    //   299: aload_0
    //   300: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   303: aconst_null
    //   304: astore_0
    //   305: goto -117 -> 188
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_1
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 469	java/io/FileInputStream:close	()V
    //   319: aload_3
    //   320: ifnull +7 -> 327
    //   323: aload_3
    //   324: invokevirtual 470	java/io/ObjectInputStream:close	()V
    //   327: aload_0
    //   328: athrow
    //   329: astore_1
    //   330: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq -14 -> 319
    //   336: aload_1
    //   337: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   340: goto -21 -> 319
    //   343: astore_1
    //   344: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -20 -> 327
    //   350: aload_1
    //   351: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   354: goto -27 -> 327
    //   357: astore_0
    //   358: goto -47 -> 311
    //   361: astore_0
    //   362: aload_2
    //   363: astore_1
    //   364: goto -53 -> 311
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_0
    //   371: goto -140 -> 231
    //   374: astore 4
    //   376: aload 5
    //   378: astore_0
    //   379: goto -148 -> 231
    //   382: aconst_null
    //   383: astore_0
    //   384: goto -196 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramQQAppInterface	QQAppInterface
    //   0	387	1	paramContext	Context
    //   3	360	2	localObject1	Object
    //   1	323	3	localObject2	Object
    //   162	58	4	localOlympicActConfig	OlympicActConfig
    //   225	28	4	localException1	Exception
    //   367	1	4	localException2	Exception
    //   374	1	4	localException3	Exception
    //   147	230	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   7	23	105	finally
    //   27	43	105	finally
    //   50	100	105	finally
    //   168	172	105	finally
    //   180	185	105	finally
    //   192	202	105	finally
    //   209	219	105	finally
    //   261	265	105	finally
    //   269	273	105	finally
    //   279	289	105	finally
    //   293	303	105	finally
    //   315	319	105	finally
    //   323	327	105	finally
    //   327	329	105	finally
    //   330	340	105	finally
    //   344	354	105	finally
    //   168	172	191	java/io/IOException
    //   180	185	205	java/io/IOException
    //   111	126	225	java/lang/Exception
    //   261	265	278	java/io/IOException
    //   269	273	292	java/io/IOException
    //   111	126	308	finally
    //   315	319	329	java/io/IOException
    //   323	327	343	java/io/IOException
    //   126	149	357	finally
    //   154	164	361	finally
    //   235	241	361	finally
    //   245	257	361	finally
    //   126	149	367	java/lang/Exception
    //   154	164	374	java/lang/Exception
  }
  
  public static int tryParseInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
      OlympicUtil.b(TAG, new Object[] { "tryParseInt, exception, str=", paramString });
    }
    return -1;
  }
  
  public static long tryParseLong(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      OlympicUtil.b(TAG, new Object[] { "tryParseInt, exception, str=", paramString });
    }
    return -1L;
  }
  
  public OlympicActConfig.BusiBanner getBusiBanner(int paramInt)
  {
    if (this.mBusiBannerMap == null) {
      return null;
    }
    String str2 = Integer.toString(paramInt);
    String str1 = str2;
    if (paramInt < 10) {
      str1 = "0" + str2;
    }
    if (this.mBusiBannerMap.containsKey(str1)) {
      return (OlympicActConfig.BusiBanner)this.mBusiBannerMap.get(str1);
    }
    return null;
  }
  
  public ArrayList getChosenCityImageList()
  {
    return this.mChosenCityImageList;
  }
  
  public String getConfigString(String paramString1, String paramString2)
  {
    if (this.mConfigs == null) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    return (String)this.mConfigs.get(paramString1);
  }
  
  public OlympicActConfig.HomePageBg getHomePageBg(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mCityBgMap != null))
    {
      paramString = "0" + paramString;
      if (this.mCityBgMap.containsKey(paramString)) {
        return (OlympicActConfig.HomePageBg)this.mCityBgMap.get(paramString);
      }
    }
    return null;
  }
  
  public Map getTorchImageMap()
  {
    return this.mTorchImageMap;
  }
  
  /* Error */
  public boolean save2File(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore 8
    //   6: aload_0
    //   7: monitorenter
    //   8: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 503
    //   20: aastore
    //   21: invokestatic 80	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_1
    //   25: ifnonnull +28 -> 53
    //   28: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 505
    //   40: aastore
    //   41: invokestatic 80	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: iload 8
    //   46: istore 7
    //   48: aload_0
    //   49: monitorexit
    //   50: iload 7
    //   52: ireturn
    //   53: aload_2
    //   54: new 183	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   61: ldc 13
    //   63: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   70: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 198	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   79: astore 6
    //   81: aload_2
    //   82: new 183	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   89: ldc 13
    //   91: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   98: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 507
    //   104: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokevirtual 198	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   113: astore_1
    //   114: aload 6
    //   116: invokevirtual 511	java/io/File:getParentFile	()Ljava/io/File;
    //   119: invokevirtual 514	java/io/File:mkdirs	()Z
    //   122: pop
    //   123: aload_1
    //   124: invokevirtual 517	java/io/File:createNewFile	()Z
    //   127: pop
    //   128: new 519	java/io/FileOutputStream
    //   131: dup
    //   132: aload_1
    //   133: invokespecial 520	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   136: astore 4
    //   138: new 522	java/io/ByteArrayOutputStream
    //   141: dup
    //   142: ldc_w 449
    //   145: invokespecial 525	java/io/ByteArrayOutputStream:<init>	(I)V
    //   148: astore_3
    //   149: new 527	java/io/ObjectOutputStream
    //   152: dup
    //   153: aload_3
    //   154: invokespecial 530	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   157: astore_2
    //   158: aload_2
    //   159: aload_0
    //   160: invokevirtual 534	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   163: aload_2
    //   164: invokevirtual 537	java/io/ObjectOutputStream:flush	()V
    //   167: aload_3
    //   168: aload 4
    //   170: invokevirtual 540	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   173: aload_3
    //   174: invokevirtual 541	java/io/ByteArrayOutputStream:flush	()V
    //   177: aload 4
    //   179: invokevirtual 542	java/io/FileOutputStream:flush	()V
    //   182: aload 6
    //   184: invokevirtual 203	java/io/File:exists	()Z
    //   187: ifeq +9 -> 196
    //   190: aload 6
    //   192: invokevirtual 208	java/io/File:delete	()Z
    //   195: pop
    //   196: aload_1
    //   197: aload 6
    //   199: invokevirtual 546	java/io/File:renameTo	(Ljava/io/File;)Z
    //   202: istore 7
    //   204: iload 7
    //   206: istore 8
    //   208: aload 4
    //   210: ifnull +8 -> 218
    //   213: aload 4
    //   215: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   218: aload_2
    //   219: ifnull +7 -> 226
    //   222: aload_2
    //   223: invokevirtual 548	java/io/ObjectOutputStream:close	()V
    //   226: iload 8
    //   228: istore 7
    //   230: aload_3
    //   231: ifnull -183 -> 48
    //   234: aload_3
    //   235: invokevirtual 549	java/io/ByteArrayOutputStream:close	()V
    //   238: iload 8
    //   240: istore 7
    //   242: goto -194 -> 48
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   250: iload 8
    //   252: istore 7
    //   254: goto -206 -> 48
    //   257: astore_1
    //   258: aload_0
    //   259: monitorexit
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq -48 -> 218
    //   269: aload_1
    //   270: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   273: goto -55 -> 218
    //   276: astore_1
    //   277: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -54 -> 226
    //   283: aload_1
    //   284: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   287: goto -61 -> 226
    //   290: astore_3
    //   291: aconst_null
    //   292: astore 4
    //   294: aconst_null
    //   295: astore_1
    //   296: aload 5
    //   298: astore_2
    //   299: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +14 -> 316
    //   305: getstatic 44	com/tencent/mobileqq/olympic/OlympicActConfig:TAG	Ljava/lang/String;
    //   308: iconst_2
    //   309: ldc_w 551
    //   312: aload_3
    //   313: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload 4
    //   318: ifnull +8 -> 326
    //   321: aload 4
    //   323: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   326: aload_1
    //   327: ifnull +7 -> 334
    //   330: aload_1
    //   331: invokevirtual 548	java/io/ObjectOutputStream:close	()V
    //   334: iload 8
    //   336: istore 7
    //   338: aload_2
    //   339: ifnull -291 -> 48
    //   342: aload_2
    //   343: invokevirtual 549	java/io/ByteArrayOutputStream:close	()V
    //   346: iload 8
    //   348: istore 7
    //   350: goto -302 -> 48
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   358: iload 8
    //   360: istore 7
    //   362: goto -314 -> 48
    //   365: astore_3
    //   366: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq -43 -> 326
    //   372: aload_3
    //   373: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   376: goto -50 -> 326
    //   379: astore_1
    //   380: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq -49 -> 334
    //   386: aload_1
    //   387: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   390: goto -56 -> 334
    //   393: astore_1
    //   394: aconst_null
    //   395: astore 4
    //   397: aconst_null
    //   398: astore_3
    //   399: aconst_null
    //   400: astore_2
    //   401: aload 4
    //   403: ifnull +8 -> 411
    //   406: aload 4
    //   408: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   411: aload_2
    //   412: ifnull +7 -> 419
    //   415: aload_2
    //   416: invokevirtual 548	java/io/ObjectOutputStream:close	()V
    //   419: aload_3
    //   420: ifnull +7 -> 427
    //   423: aload_3
    //   424: invokevirtual 549	java/io/ByteArrayOutputStream:close	()V
    //   427: aload_1
    //   428: athrow
    //   429: astore 4
    //   431: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq -23 -> 411
    //   437: aload 4
    //   439: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   442: goto -31 -> 411
    //   445: astore_2
    //   446: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq -30 -> 419
    //   452: aload_2
    //   453: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   456: goto -37 -> 419
    //   459: astore_2
    //   460: aload_2
    //   461: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   464: goto -37 -> 427
    //   467: astore_1
    //   468: aconst_null
    //   469: astore_3
    //   470: aconst_null
    //   471: astore_2
    //   472: goto -71 -> 401
    //   475: astore_1
    //   476: aconst_null
    //   477: astore_2
    //   478: goto -77 -> 401
    //   481: astore_1
    //   482: goto -81 -> 401
    //   485: astore_3
    //   486: aload_1
    //   487: astore 5
    //   489: aload_3
    //   490: astore_1
    //   491: aload_2
    //   492: astore_3
    //   493: aload 5
    //   495: astore_2
    //   496: goto -95 -> 401
    //   499: astore_3
    //   500: aconst_null
    //   501: astore_1
    //   502: aload 5
    //   504: astore_2
    //   505: goto -206 -> 299
    //   508: astore 5
    //   510: aconst_null
    //   511: astore_1
    //   512: aload_3
    //   513: astore_2
    //   514: aload 5
    //   516: astore_3
    //   517: goto -218 -> 299
    //   520: astore 6
    //   522: aload_3
    //   523: astore_1
    //   524: aload_2
    //   525: astore 5
    //   527: aload 6
    //   529: astore_3
    //   530: aload_1
    //   531: astore_2
    //   532: aload 5
    //   534: astore_1
    //   535: goto -236 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	OlympicActConfig
    //   0	538	1	paramQQAppInterface	QQAppInterface
    //   0	538	2	paramContext	Context
    //   148	87	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   290	23	3	localException1	Exception
    //   365	8	3	localIOException1	java.io.IOException
    //   398	72	3	localObject1	Object
    //   485	5	3	localObject2	Object
    //   492	1	3	localContext1	Context
    //   499	14	3	localException2	Exception
    //   516	14	3	localException3	Exception
    //   136	271	4	localFileOutputStream	java.io.FileOutputStream
    //   429	9	4	localIOException2	java.io.IOException
    //   1	502	5	localQQAppInterface	QQAppInterface
    //   508	7	5	localException4	Exception
    //   525	8	5	localContext2	Context
    //   79	119	6	localFile	File
    //   520	8	6	localException5	Exception
    //   46	315	7	bool1	boolean
    //   4	355	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   234	238	245	java/io/IOException
    //   8	24	257	finally
    //   28	44	257	finally
    //   53	123	257	finally
    //   213	218	257	finally
    //   222	226	257	finally
    //   234	238	257	finally
    //   246	250	257	finally
    //   263	273	257	finally
    //   277	287	257	finally
    //   321	326	257	finally
    //   330	334	257	finally
    //   342	346	257	finally
    //   354	358	257	finally
    //   366	376	257	finally
    //   380	390	257	finally
    //   406	411	257	finally
    //   415	419	257	finally
    //   423	427	257	finally
    //   427	429	257	finally
    //   431	442	257	finally
    //   446	456	257	finally
    //   460	464	257	finally
    //   213	218	262	java/io/IOException
    //   222	226	276	java/io/IOException
    //   123	138	290	java/lang/Exception
    //   342	346	353	java/io/IOException
    //   321	326	365	java/io/IOException
    //   330	334	379	java/io/IOException
    //   123	138	393	finally
    //   406	411	429	java/io/IOException
    //   415	419	445	java/io/IOException
    //   423	427	459	java/io/IOException
    //   138	149	467	finally
    //   149	158	475	finally
    //   158	196	481	finally
    //   196	204	481	finally
    //   299	316	485	finally
    //   138	149	499	java/lang/Exception
    //   149	158	508	java/lang/Exception
    //   158	196	520	java/lang/Exception
    //   196	204	520	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=").append(this.version);
    if (QLog.isColorLevel())
    {
      Iterator localIterator;
      Object localObject;
      if (this.mConfigs != null)
      {
        localIterator = this.mConfigs.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          localStringBuilder.append(", ").append((String)localObject).append((String)this.mConfigs.get(localObject));
        }
      }
      if (this.mTorchImageMap != null)
      {
        localIterator = this.mTorchImageMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          localStringBuilder.append(", ").append((String)localObject).append(this.mTorchImageMap.get(localObject));
        }
      }
      if (this.mAllCityImageMap != null)
      {
        localIterator = this.mAllCityImageMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Integer)localIterator.next();
          localStringBuilder.append(", ").append(localObject).append(this.mAllCityImageMap.get(localObject));
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicActConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */