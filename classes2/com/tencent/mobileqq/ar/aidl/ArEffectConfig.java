package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qpp;

public class ArEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new qpp();
  public static final String a = "ArConfig_ArEffectConfig";
  public int a;
  public ArrayList a;
  public int b;
  public ArrayList b;
  public int c;
  public ArrayList c;
  public int d;
  public ArrayList d;
  public int e;
  public ArrayList e;
  public int f = 30;
  public int g = 30;
  public int h = 30;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArEffectConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 80;
    this.jdField_c_of_type_Int = 80;
    this.jdField_d_of_type_Int = 80;
    this.jdField_e_of_type_Int = 30;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ArEffectConfig(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 80;
    this.jdField_c_of_type_Int = 80;
    this.jdField_d_of_type_Int = 80;
    this.jdField_e_of_type_Int = 30;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_b_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_c_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_d_of_type_JavaUtilArrayList, String.class.getClassLoader());
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    paramParcel.readList(this.jdField_e_of_type_JavaUtilArrayList, ArDefaultSetting.class.getClassLoader());
  }
  
  /* Error */
  public static ArEffectConfig a()
  {
    // Byte code:
    //   0: new 95	java/io/File
    //   3: dup
    //   4: getstatic 100	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   7: invokevirtual 104	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   10: ldc 106
    //   12: invokespecial 109	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: invokevirtual 113	java/io/File:exists	()Z
    //   22: ifeq +344 -> 366
    //   25: new 115	java/io/FileInputStream
    //   28: dup
    //   29: aload 5
    //   31: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_1
    //   35: new 120	java/io/BufferedInputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 123	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: aload_1
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: aload_1
    //   49: invokevirtual 126	java/io/FileInputStream:available	()I
    //   52: newarray <illegal type>
    //   54: astore 4
    //   56: aload_1
    //   57: astore_3
    //   58: aload_0
    //   59: astore_2
    //   60: aload_0
    //   61: aload 4
    //   63: invokevirtual 130	java/io/BufferedInputStream:read	([B)I
    //   66: pop
    //   67: aload_1
    //   68: astore_3
    //   69: aload_0
    //   70: astore_2
    //   71: invokestatic 134	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   74: astore 6
    //   76: aload_1
    //   77: astore_3
    //   78: aload_0
    //   79: astore_2
    //   80: aload 6
    //   82: aload 4
    //   84: iconst_0
    //   85: aload 4
    //   87: arraylength
    //   88: invokevirtual 138	android/os/Parcel:unmarshall	([BII)V
    //   91: aload_1
    //   92: astore_3
    //   93: aload_0
    //   94: astore_2
    //   95: aload 6
    //   97: iconst_0
    //   98: invokevirtual 142	android/os/Parcel:setDataPosition	(I)V
    //   101: aload_1
    //   102: astore_3
    //   103: aload_0
    //   104: astore_2
    //   105: getstatic 36	com/tencent/mobileqq/ar/aidl/ArEffectConfig:CREATOR	Landroid/os/Parcelable$Creator;
    //   108: aload 6
    //   110: invokeinterface 148 2 0
    //   115: checkcast 2	com/tencent/mobileqq/ar/aidl/ArEffectConfig
    //   118: astore 4
    //   120: aload_1
    //   121: astore_3
    //   122: aload_0
    //   123: astore_2
    //   124: aload 6
    //   126: invokevirtual 151	android/os/Parcel:recycle	()V
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 154	java/io/BufferedInputStream:close	()V
    //   137: aload 4
    //   139: astore_0
    //   140: aload_1
    //   141: ifnull +10 -> 151
    //   144: aload_1
    //   145: invokevirtual 155	java/io/FileInputStream:close	()V
    //   148: aload 4
    //   150: astore_0
    //   151: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +28 -> 182
    //   157: ldc 12
    //   159: iconst_2
    //   160: new 162	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   167: ldc -91
    //   169: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_0
    //   183: areturn
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   189: goto -52 -> 137
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   197: aload 4
    //   199: astore_0
    //   200: goto -49 -> 151
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_1
    //   207: aconst_null
    //   208: astore_0
    //   209: aload_1
    //   210: astore_3
    //   211: aload_0
    //   212: astore_2
    //   213: aload 5
    //   215: invokevirtual 185	java/io/File:delete	()Z
    //   218: pop
    //   219: aload_1
    //   220: astore_3
    //   221: aload_0
    //   222: astore_2
    //   223: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +33 -> 259
    //   229: aload_1
    //   230: astore_3
    //   231: aload_0
    //   232: astore_2
    //   233: ldc 12
    //   235: iconst_2
    //   236: new 162	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   243: ldc -69
    //   245: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 4
    //   250: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_0
    //   260: ifnull +7 -> 267
    //   263: aload_0
    //   264: invokevirtual 154	java/io/BufferedInputStream:close	()V
    //   267: aload_1
    //   268: ifnull +93 -> 361
    //   271: aload_1
    //   272: invokevirtual 155	java/io/FileInputStream:close	()V
    //   275: aconst_null
    //   276: astore_0
    //   277: goto -126 -> 151
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   285: goto -18 -> 267
    //   288: astore_0
    //   289: aload_0
    //   290: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   293: aconst_null
    //   294: astore_0
    //   295: goto -144 -> 151
    //   298: astore_0
    //   299: aconst_null
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_2
    //   303: aload_2
    //   304: ifnull +7 -> 311
    //   307: aload_2
    //   308: invokevirtual 154	java/io/BufferedInputStream:close	()V
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 155	java/io/FileInputStream:close	()V
    //   319: aload_0
    //   320: athrow
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   326: goto -15 -> 311
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   334: goto -15 -> 319
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_2
    //   340: goto -37 -> 303
    //   343: astore_0
    //   344: aload_3
    //   345: astore_1
    //   346: goto -43 -> 303
    //   349: astore 4
    //   351: aconst_null
    //   352: astore_0
    //   353: goto -144 -> 209
    //   356: astore 4
    //   358: goto -149 -> 209
    //   361: aconst_null
    //   362: astore_0
    //   363: goto -212 -> 151
    //   366: aconst_null
    //   367: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	140	0	localObject1	Object
    //   184	2	0	localIOException1	java.io.IOException
    //   192	2	0	localIOException2	java.io.IOException
    //   199	78	0	localObject2	Object
    //   280	2	0	localIOException3	java.io.IOException
    //   288	2	0	localIOException4	java.io.IOException
    //   294	1	0	localObject3	Object
    //   298	22	0	localObject4	Object
    //   337	1	0	localObject5	Object
    //   343	1	0	localObject6	Object
    //   352	11	0	localObject7	Object
    //   34	282	1	localFileInputStream1	java.io.FileInputStream
    //   329	2	1	localIOException5	java.io.IOException
    //   345	1	1	localObject8	Object
    //   47	261	2	localObject9	Object
    //   321	2	2	localIOException6	java.io.IOException
    //   339	1	2	localObject10	Object
    //   45	300	3	localFileInputStream2	java.io.FileInputStream
    //   54	144	4	localObject11	Object
    //   203	46	4	localThrowable1	Throwable
    //   349	1	4	localThrowable2	Throwable
    //   356	1	4	localThrowable3	Throwable
    //   15	199	5	localFile	File
    //   74	51	6	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   133	137	184	java/io/IOException
    //   144	148	192	java/io/IOException
    //   25	35	203	java/lang/Throwable
    //   263	267	280	java/io/IOException
    //   271	275	288	java/io/IOException
    //   25	35	298	finally
    //   307	311	321	java/io/IOException
    //   315	319	329	java/io/IOException
    //   35	44	337	finally
    //   48	56	343	finally
    //   60	67	343	finally
    //   71	76	343	finally
    //   80	91	343	finally
    //   95	101	343	finally
    //   105	120	343	finally
    //   124	129	343	finally
    //   213	219	343	finally
    //   223	229	343	finally
    //   233	259	343	finally
    //   35	44	349	java/lang/Throwable
    //   48	56	356	java/lang/Throwable
    //   60	67	356	java/lang/Throwable
    //   71	76	356	java/lang/Throwable
    //   80	91	356	java/lang/Throwable
    //   95	101	356	java/lang/Throwable
    //   105	120	356	java/lang/Throwable
    //   124	129	356	java/lang/Throwable
  }
  
  public static ArEffectConfig a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    ArEffectConfig localArEffectConfig = new ArEffectConfig();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next().toString();
          if ("levelTop".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = paramString.getJSONObject((String)localObject1);
            if (((JSONObject)localObject1).has("model"))
            {
              localObject2 = ((JSONObject)localObject1).getJSONArray("model");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localArEffectConfig.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(i));
                i += 1;
                continue;
              }
            }
            if (!((JSONObject)localObject1).has("GPU")) {
              continue;
            }
            localObject1 = ((JSONObject)localObject1).getJSONArray("GPU");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localArEffectConfig.jdField_b_of_type_JavaUtilArrayList.add(((JSONArray)localObject1).getString(i));
              i += 1;
              continue;
            }
            continue;
          }
          if ("blacklist".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = paramString.getJSONObject((String)localObject1);
            if (((JSONObject)localObject1).has("model"))
            {
              localObject2 = ((JSONObject)localObject1).getJSONArray("model");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localArEffectConfig.jdField_c_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(i));
                i += 1;
                continue;
              }
            }
            if (!((JSONObject)localObject1).has("GPU")) {
              continue;
            }
            localObject1 = ((JSONObject)localObject1).getJSONArray("GPU");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localArEffectConfig.jdField_d_of_type_JavaUtilArrayList.add(((JSONArray)localObject1).getString(i));
              i += 1;
              continue;
            }
            continue;
          }
          if (!"bestModel".equalsIgnoreCase((String)localObject1)) {
            break label351;
          }
          localArEffectConfig.jdField_b_of_type_Int = paramString.optInt((String)localObject1);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = localArEffectConfig;
      }
      QLog.d("ArConfig_ArEffectConfig", 2, "parseArEffectConfig|effect= " + localArEffectConfig);
      return localArEffectConfig;
      label351:
      if ("removeShadow".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.jdField_c_of_type_Int = paramString.optInt((String)localObject1);
      }
      else if ("boneAnimation".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.jdField_d_of_type_Int = paramString.optInt((String)localObject1);
      }
      else if ("quality2".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.jdField_e_of_type_Int = paramString.optInt((String)localObject1);
      }
      else if ("quality3".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.f = paramString.optInt((String)localObject1);
      }
      else if ("quality4".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.g = paramString.optInt((String)localObject1);
      }
      else if ("quality5".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.h = paramString.optInt((String)localObject1);
      }
      else if ("defaultSetting".equalsIgnoreCase((String)localObject1))
      {
        localObject1 = paramString.getJSONArray((String)localObject1);
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new ArDefaultSetting();
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          String str1 = localJSONObject.optString("model");
          String str2 = localJSONObject.optString("GPU");
          if (!TextUtils.isEmpty(str1)) {
            ((ArDefaultSetting)localObject2).a = str1;
          }
          for (((ArDefaultSetting)localObject2).jdField_c_of_type_Int = 0;; ((ArDefaultSetting)localObject2).jdField_c_of_type_Int = 1)
          {
            ((ArDefaultSetting)localObject2).jdField_e_of_type_Int = localJSONObject.optInt("quality");
            ((ArDefaultSetting)localObject2).jdField_d_of_type_Int = localJSONObject.optInt("modelType");
            localArEffectConfig.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
            break;
            if (TextUtils.isEmpty(str2)) {
              break;
            }
            ((ArDefaultSetting)localObject2).a = str2;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArEffectConfig", 2, "deleteEffectConfigFile");
    }
    File localFile = new File(BaseApplicationImpl.a.getFilesDir(), "ar_effect_config");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  /* Error */
  public static boolean a(ArEffectConfig paramArEffectConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: iconst_0
    //   3: istore 6
    //   5: aload_0
    //   6: ifnonnull +6 -> 12
    //   9: iload 6
    //   11: ireturn
    //   12: new 95	java/io/File
    //   15: dup
    //   16: getstatic 100	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 104	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   22: ldc 106
    //   24: invokespecial 109	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore_3
    //   28: new 95	java/io/File
    //   31: dup
    //   32: getstatic 100	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   35: invokevirtual 104	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   38: ldc_w 299
    //   41: invokespecial 109	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore 5
    //   46: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +12 -> 61
    //   52: ldc 12
    //   54: iconst_2
    //   55: ldc_w 301
    //   58: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: invokestatic 134	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   64: astore 4
    //   66: aload 4
    //   68: iconst_0
    //   69: invokevirtual 142	android/os/Parcel:setDataPosition	(I)V
    //   72: aload_0
    //   73: aload 4
    //   75: iconst_0
    //   76: invokevirtual 305	com/tencent/mobileqq/ar/aidl/ArEffectConfig:writeToParcel	(Landroid/os/Parcel;I)V
    //   79: aload 4
    //   81: invokevirtual 309	android/os/Parcel:marshall	()[B
    //   84: astore_0
    //   85: aload_3
    //   86: invokevirtual 312	java/io/File:getParentFile	()Ljava/io/File;
    //   89: astore_2
    //   90: aload_2
    //   91: invokevirtual 113	java/io/File:exists	()Z
    //   94: ifne +8 -> 102
    //   97: aload_2
    //   98: invokevirtual 315	java/io/File:mkdir	()Z
    //   101: pop
    //   102: aload 5
    //   104: invokevirtual 113	java/io/File:exists	()Z
    //   107: ifeq +9 -> 116
    //   110: aload 5
    //   112: invokevirtual 185	java/io/File:delete	()Z
    //   115: pop
    //   116: new 317	java/io/FileOutputStream
    //   119: dup
    //   120: aload 5
    //   122: invokespecial 318	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   125: astore_2
    //   126: new 320	java/io/BufferedOutputStream
    //   129: dup
    //   130: aload_2
    //   131: invokespecial 323	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   134: astore_1
    //   135: aload_1
    //   136: aload_0
    //   137: invokevirtual 327	java/io/BufferedOutputStream:write	([B)V
    //   140: aload_1
    //   141: invokevirtual 330	java/io/BufferedOutputStream:flush	()V
    //   144: aload 5
    //   146: aload_3
    //   147: invokestatic 335	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   150: istore 7
    //   152: aload 4
    //   154: invokevirtual 151	android/os/Parcel:recycle	()V
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 336	java/io/BufferedOutputStream:close	()V
    //   165: iload 7
    //   167: istore 6
    //   169: aload_2
    //   170: ifnull -161 -> 9
    //   173: aload_2
    //   174: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   177: iload 7
    //   179: ireturn
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   185: iload 7
    //   187: ireturn
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   193: goto -28 -> 165
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_3
    //   199: aload_1
    //   200: astore_0
    //   201: aload_3
    //   202: astore_1
    //   203: aload_2
    //   204: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   207: aload 4
    //   209: invokevirtual 151	android/os/Parcel:recycle	()V
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 336	java/io/BufferedOutputStream:close	()V
    //   220: aload_0
    //   221: ifnull -212 -> 9
    //   224: aload_0
    //   225: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   235: iconst_0
    //   236: ireturn
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   242: goto -22 -> 220
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_2
    //   250: aload 4
    //   252: invokevirtual 151	android/os/Parcel:recycle	()V
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 336	java/io/BufferedOutputStream:close	()V
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   271: aload_0
    //   272: athrow
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   278: goto -15 -> 263
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   286: goto -15 -> 271
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_1
    //   292: goto -42 -> 250
    //   295: astore_0
    //   296: goto -46 -> 250
    //   299: astore_3
    //   300: aload_0
    //   301: astore_2
    //   302: aload_3
    //   303: astore_0
    //   304: goto -54 -> 250
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_1
    //   310: aload_2
    //   311: astore_0
    //   312: aload_3
    //   313: astore_2
    //   314: goto -111 -> 203
    //   317: astore_3
    //   318: aload_2
    //   319: astore_0
    //   320: aload_3
    //   321: astore_2
    //   322: goto -119 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramArEffectConfig	ArEffectConfig
    //   1	216	1	localObject1	Object
    //   237	2	1	localIOException1	java.io.IOException
    //   247	13	1	localObject2	Object
    //   273	2	1	localIOException2	java.io.IOException
    //   281	2	1	localIOException3	java.io.IOException
    //   291	19	1	localObject3	Object
    //   89	85	2	localObject4	Object
    //   196	8	2	localIOException4	java.io.IOException
    //   249	73	2	localObject5	Object
    //   27	175	3	localFile1	File
    //   299	4	3	localObject6	Object
    //   307	6	3	localIOException5	java.io.IOException
    //   317	4	3	localIOException6	java.io.IOException
    //   64	187	4	localParcel	Parcel
    //   44	101	5	localFile2	File
    //   3	165	6	bool1	boolean
    //   150	36	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   173	177	180	java/io/IOException
    //   161	165	188	java/io/IOException
    //   116	126	196	java/io/IOException
    //   224	228	230	java/io/IOException
    //   216	220	237	java/io/IOException
    //   116	126	245	finally
    //   259	263	273	java/io/IOException
    //   267	271	281	java/io/IOException
    //   126	135	289	finally
    //   135	152	295	finally
    //   203	207	299	finally
    //   126	135	307	java/io/IOException
    //   135	152	317	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArEffectConfig{");
    localStringBuffer.append("version=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", toplevelModel=").append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuffer.append(", toplevelGPU=").append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuffer.append(", blacklistModel=").append(this.jdField_c_of_type_JavaUtilArrayList);
    localStringBuffer.append(", blacklistGPU=").append(this.jdField_d_of_type_JavaUtilArrayList);
    localStringBuffer.append(", topModelStandard=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", removeShadowLevel=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", adjustBone=").append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", traceQuality2=").append(this.jdField_e_of_type_Int);
    localStringBuffer.append(", traceQuality3=").append(this.f);
    localStringBuffer.append(", traceQuality4=").append(this.g);
    localStringBuffer.append(", traceQuality5=").append(this.h);
    localStringBuffer.append(", defaultSettings=").append(this.jdField_e_of_type_JavaUtilArrayList);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_c_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_d_of_type_JavaUtilArrayList);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeList(this.jdField_e_of_type_JavaUtilArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\aidl\ArEffectConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */