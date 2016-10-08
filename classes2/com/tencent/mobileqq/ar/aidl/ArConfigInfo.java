package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.ar.model.ModelResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import qpo;

public class ArConfigInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new qpo();
  public static final String TAG = "ArConfigInfo";
  public long aRBegin;
  public long aREnd;
  public int actType;
  public ArrayList featureResources = new ArrayList();
  public ArrayList modelResources = new ArrayList();
  public String osId;
  public String scanIconImg;
  public String scanIconMd5;
  public String scanIconPressed;
  public String scanIconPressedMd5;
  public String scanIconText;
  public String scanLine1;
  public String scanLine2;
  public String scanLineLink;
  public String scanLinkUrl;
  public int version;
  public String versionId;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArConfigInfo() {}
  
  public ArConfigInfo(Parcel paramParcel)
  {
    this.version = paramParcel.readInt();
    this.versionId = paramParcel.readString();
    this.osId = paramParcel.readString();
    this.aRBegin = paramParcel.readLong();
    this.aREnd = paramParcel.readLong();
    this.actType = paramParcel.readInt();
    this.scanIconImg = paramParcel.readString();
    this.scanIconMd5 = paramParcel.readString();
    this.scanIconPressed = paramParcel.readString();
    this.scanIconPressedMd5 = paramParcel.readString();
    this.scanIconText = paramParcel.readString();
    this.scanLine1 = paramParcel.readString();
    this.scanLine2 = paramParcel.readString();
    this.scanLineLink = paramParcel.readString();
    this.scanLinkUrl = paramParcel.readString();
    try
    {
      Object localObject = new ArrayList();
      paramParcel.readList((List)localObject, ArResourceInfo.class.getClassLoader());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArResourceInfo localArResourceInfo = (ArResourceInfo)((Iterator)localObject).next();
        if (localArResourceInfo != null) {
          this.featureResources.add(localArResourceInfo);
        }
      }
      localObject = new ArrayList();
      paramParcel.readList((List)localObject, ModelResource.class.getClassLoader());
      paramParcel = ((ArrayList)localObject).iterator();
      while (paramParcel.hasNext())
      {
        localObject = (ModelResource)paramParcel.next();
        if (localObject != null) {
          this.modelResources.add(localObject);
        }
      }
      return;
    }
    catch (Error paramParcel)
    {
      return;
    }
    catch (Exception paramParcel) {}
  }
  
  public static void deleteConfigFile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfigInfo", 2, "deleteConfigFile,uin=" + paramString);
    }
    if (paramString == null) {}
    do
    {
      return;
      paramString = new File(BaseApplicationImpl.a.getFilesDir(), "ar_file_config" + paramString);
    } while (!paramString.exists());
    paramString.delete();
  }
  
  /* Error */
  public static ArConfigInfo loadConfigFromFile(String paramString)
  {
    // Byte code:
    //   0: new 164	java/io/File
    //   3: dup
    //   4: getstatic 170	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   7: invokevirtual 174	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   10: new 148	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   17: ldc -80
    //   19: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 179	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 182	java/io/File:exists	()Z
    //   39: ifeq +344 -> 383
    //   42: new 193	java/io/FileInputStream
    //   45: dup
    //   46: aload 5
    //   48: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: astore_1
    //   52: new 198	java/io/BufferedInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 201	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_0
    //   61: aload_1
    //   62: astore_3
    //   63: aload_0
    //   64: astore_2
    //   65: aload_1
    //   66: invokevirtual 204	java/io/FileInputStream:available	()I
    //   69: newarray <illegal type>
    //   71: astore 4
    //   73: aload_1
    //   74: astore_3
    //   75: aload_0
    //   76: astore_2
    //   77: aload_0
    //   78: aload 4
    //   80: invokevirtual 208	java/io/BufferedInputStream:read	([B)I
    //   83: pop
    //   84: aload_1
    //   85: astore_3
    //   86: aload_0
    //   87: astore_2
    //   88: invokestatic 212	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   91: astore 6
    //   93: aload_1
    //   94: astore_3
    //   95: aload_0
    //   96: astore_2
    //   97: aload 6
    //   99: aload 4
    //   101: iconst_0
    //   102: aload 4
    //   104: arraylength
    //   105: invokevirtual 216	android/os/Parcel:unmarshall	([BII)V
    //   108: aload_1
    //   109: astore_3
    //   110: aload_0
    //   111: astore_2
    //   112: aload 6
    //   114: iconst_0
    //   115: invokevirtual 220	android/os/Parcel:setDataPosition	(I)V
    //   118: aload_1
    //   119: astore_3
    //   120: aload_0
    //   121: astore_2
    //   122: getstatic 49	com/tencent/mobileqq/ar/aidl/ArConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   125: aload 6
    //   127: invokeinterface 226 2 0
    //   132: checkcast 2	com/tencent/mobileqq/ar/aidl/ArConfigInfo
    //   135: astore 4
    //   137: aload_1
    //   138: astore_3
    //   139: aload_0
    //   140: astore_2
    //   141: aload 6
    //   143: invokevirtual 229	android/os/Parcel:recycle	()V
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 232	java/io/BufferedInputStream:close	()V
    //   154: aload 4
    //   156: astore_0
    //   157: aload_1
    //   158: ifnull +10 -> 168
    //   161: aload_1
    //   162: invokevirtual 233	java/io/FileInputStream:close	()V
    //   165: aload 4
    //   167: astore_0
    //   168: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +28 -> 199
    //   174: ldc 14
    //   176: iconst_2
    //   177: new 148	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   184: ldc -21
    //   186: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: areturn
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   206: goto -52 -> 154
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   214: aload 4
    //   216: astore_0
    //   217: goto -49 -> 168
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_1
    //   224: aconst_null
    //   225: astore_0
    //   226: aload_1
    //   227: astore_3
    //   228: aload_0
    //   229: astore_2
    //   230: aload 5
    //   232: invokevirtual 185	java/io/File:delete	()Z
    //   235: pop
    //   236: aload_1
    //   237: astore_3
    //   238: aload_0
    //   239: astore_2
    //   240: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +33 -> 276
    //   246: aload_1
    //   247: astore_3
    //   248: aload_0
    //   249: astore_2
    //   250: ldc 14
    //   252: iconst_2
    //   253: new 148	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   260: ldc -13
    //   262: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 4
    //   267: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: ifnull +7 -> 284
    //   280: aload_0
    //   281: invokevirtual 232	java/io/BufferedInputStream:close	()V
    //   284: aload_1
    //   285: ifnull +93 -> 378
    //   288: aload_1
    //   289: invokevirtual 233	java/io/FileInputStream:close	()V
    //   292: aconst_null
    //   293: astore_0
    //   294: goto -126 -> 168
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   302: goto -18 -> 284
    //   305: astore_0
    //   306: aload_0
    //   307: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   310: aconst_null
    //   311: astore_0
    //   312: goto -144 -> 168
    //   315: astore_0
    //   316: aconst_null
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_2
    //   320: aload_2
    //   321: ifnull +7 -> 328
    //   324: aload_2
    //   325: invokevirtual 232	java/io/BufferedInputStream:close	()V
    //   328: aload_1
    //   329: ifnull +7 -> 336
    //   332: aload_1
    //   333: invokevirtual 233	java/io/FileInputStream:close	()V
    //   336: aload_0
    //   337: athrow
    //   338: astore_2
    //   339: aload_2
    //   340: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   343: goto -15 -> 328
    //   346: astore_1
    //   347: aload_1
    //   348: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   351: goto -15 -> 336
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_2
    //   357: goto -37 -> 320
    //   360: astore_0
    //   361: aload_3
    //   362: astore_1
    //   363: goto -43 -> 320
    //   366: astore 4
    //   368: aconst_null
    //   369: astore_0
    //   370: goto -144 -> 226
    //   373: astore 4
    //   375: goto -149 -> 226
    //   378: aconst_null
    //   379: astore_0
    //   380: goto -212 -> 168
    //   383: aconst_null
    //   384: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   51	282	1	localFileInputStream1	java.io.FileInputStream
    //   346	2	1	localIOException1	java.io.IOException
    //   362	1	1	localObject1	Object
    //   64	261	2	str	String
    //   338	2	2	localIOException2	java.io.IOException
    //   356	1	2	localObject2	Object
    //   62	300	3	localFileInputStream2	java.io.FileInputStream
    //   71	144	4	localObject3	Object
    //   220	46	4	localThrowable1	Throwable
    //   366	1	4	localThrowable2	Throwable
    //   373	1	4	localThrowable3	Throwable
    //   32	199	5	localFile	File
    //   91	51	6	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   150	154	201	java/io/IOException
    //   161	165	209	java/io/IOException
    //   42	52	220	java/lang/Throwable
    //   280	284	297	java/io/IOException
    //   288	292	305	java/io/IOException
    //   42	52	315	finally
    //   324	328	338	java/io/IOException
    //   332	336	346	java/io/IOException
    //   52	61	354	finally
    //   65	73	360	finally
    //   77	84	360	finally
    //   88	93	360	finally
    //   97	108	360	finally
    //   112	118	360	finally
    //   122	137	360	finally
    //   141	146	360	finally
    //   230	236	360	finally
    //   240	246	360	finally
    //   250	276	360	finally
    //   52	61	366	java/lang/Throwable
    //   65	73	373	java/lang/Throwable
    //   77	84	373	java/lang/Throwable
    //   88	93	373	java/lang/Throwable
    //   97	108	373	java/lang/Throwable
    //   112	118	373	java/lang/Throwable
    //   122	137	373	java/lang/Throwable
    //   141	146	373	java/lang/Throwable
  }
  
  public static ArConfigInfo parseArConfig(String paramString)
  {
    Object localObject1 = Xml.newPullParser();
    ArConfigInfo localArConfigInfo = new ArConfigInfo();
    for (;;)
    {
      try
      {
        ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = ((XmlPullParser)localObject1).getEventType();
      }
      catch (Exception localException)
      {
        localArConfigInfo = null;
        localObject1 = localArConfigInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ArConfigInfo", 2, paramString, localException);
        localObject1 = localArConfigInfo;
        return (ArConfigInfo)localObject1;
      }
      int i = ((XmlPullParser)localObject1).next();
      break label1235;
      str1 = ((XmlPullParser)localObject1).getName();
      if (str1.equalsIgnoreCase("VersionID"))
      {
        localArConfigInfo.versionId = ((XmlPullParser)localObject1).nextText();
      }
      else if (localException.equalsIgnoreCase("OSId"))
      {
        localArConfigInfo.osId = ((XmlPullParser)localObject1).nextText();
      }
      else if (localException.equalsIgnoreCase("ScanAR"))
      {
        i = ((XmlPullParser)localObject1).next();
        label148:
        if (i != 1)
        {
          if (i != 2) {
            break label463;
          }
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (!((String)localObject2).equalsIgnoreCase("Begin")) {
            break label201;
          }
          localArConfigInfo.aRBegin = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
        }
        label201:
        label463:
        while ((i != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("ScanAR"))) {
          for (;;)
          {
            i = ((XmlPullParser)localObject1).next();
            break label148;
            break;
            if (((String)localObject2).equalsIgnoreCase("End")) {
              localArConfigInfo.aREnd = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
            } else if (((String)localObject2).equalsIgnoreCase("ActType")) {
              localArConfigInfo.actType = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
            } else if (((String)localObject2).equalsIgnoreCase("ScanIconImg")) {
              localArConfigInfo.scanIconImg = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("ScanIconMd5")) {
              localArConfigInfo.scanIconMd5 = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("ScanIconPressed")) {
              localArConfigInfo.scanIconPressed = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("ScanIconPressedMd5")) {
              localArConfigInfo.scanIconPressedMd5 = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("ScanIconText")) {
              localArConfigInfo.scanIconText = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("Scan_Line1")) {
              localArConfigInfo.scanLine1 = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("Scan_Line2")) {
              localArConfigInfo.scanLine2 = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("Scan_Line3")) {
              localArConfigInfo.scanLineLink = ((XmlPullParser)localObject1).nextText();
            } else if (((String)localObject2).equalsIgnoreCase("Scan_Line3_URL")) {
              localArConfigInfo.scanLinkUrl = ((XmlPullParser)localObject1).nextText();
            }
          }
        }
      }
      else if (((String)localObject2).equalsIgnoreCase("Feature"))
      {
        localObject2 = new ArResourceInfo();
        i = ((XmlPullParser)localObject1).next();
        label513:
        if (i != 1)
        {
          if (i != 2) {
            break label889;
          }
          str2 = ((XmlPullParser)localObject1).getName();
          if (!str2.equalsIgnoreCase("Type")) {
            break label571;
          }
          ((ArResourceInfo)localObject2).jdField_c_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
        }
        label571:
        label889:
        while ((i != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("Feature"))) {
          for (;;)
          {
            i = ((XmlPullParser)localObject1).next();
            break label513;
            break;
            if (str2.equalsIgnoreCase("FileId")) {
              ((ArResourceInfo)localObject2).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("SDKVersion")) {
              ((ArResourceInfo)localObject2).b = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("PicId")) {
              ((ArResourceInfo)localObject2).jdField_c_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("FileUrl")) {
              ((ArResourceInfo)localObject2).d = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("FileMd5")) {
              ((ArResourceInfo)localObject2).e = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("FileSize")) {
              ((ArResourceInfo)localObject2).jdField_a_of_type_Long = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            } else if (str2.equalsIgnoreCase("End_Line1")) {
              ((ArResourceInfo)localObject2).j = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("End_Line2")) {
              ((ArResourceInfo)localObject2).k = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("End_Line3")) {
              ((ArResourceInfo)localObject2).l = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("End_Line3_URL")) {
              ((ArResourceInfo)localObject2).m = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("ModelConfigFile")) {
              ((ArResourceInfo)localObject2).f = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("CommonBgMusic")) {
              ((ArResourceInfo)localObject2).h = ((XmlPullParser)localObject1).nextText();
            } else if (str2.equalsIgnoreCase("FireMusic")) {
              ((ArResourceInfo)localObject2).i = ((XmlPullParser)localObject1).nextText();
            }
          }
        }
        localArConfigInfo.featureResources.add(localObject2);
      }
      else if ((((String)localObject2).equalsIgnoreCase("ModelResource")) || (((String)localObject2).equalsIgnoreCase("AndroidModelResource")))
      {
        localObject2 = new ModelResource();
        i = ((XmlPullParser)localObject1).next();
        label958:
        if (i != 1)
        {
          if (i != 2) {
            break label1151;
          }
          str2 = ((XmlPullParser)localObject1).getName();
          if (!str2.equalsIgnoreCase("Type")) {
            break label1016;
          }
          ((ModelResource)localObject2).jdField_a_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
        }
        label1016:
        label1151:
        do
        {
          do
          {
            for (;;)
            {
              i = ((XmlPullParser)localObject1).next();
              break label958;
              break;
              if (str2.equalsIgnoreCase("ModelResourceUrl"))
              {
                ((ModelResource)localObject2).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              }
              else if (str2.equalsIgnoreCase("ModelResourceMD5"))
              {
                ((ModelResource)localObject2).b = ((XmlPullParser)localObject1).nextText();
              }
              else if (str2.equalsIgnoreCase("FileSize"))
              {
                ((ModelResource)localObject2).jdField_a_of_type_Long = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
              }
              else if (str2.equalsIgnoreCase("Req"))
              {
                str2 = ((XmlPullParser)localObject1).nextText();
                if ((!TextUtils.isEmpty(str2)) && ("1".equals(str2.trim()))) {
                  ((ModelResource)localObject2).jdField_a_of_type_Boolean = true;
                } else {
                  ((ModelResource)localObject2).jdField_a_of_type_Boolean = false;
                }
              }
            }
          } while (i != 3);
          str2 = ((XmlPullParser)localObject1).getName();
        } while ((!str2.equalsIgnoreCase("ModelResource")) && (!str2.equalsIgnoreCase("AndroidModelResource")));
        localArConfigInfo.modelResources.add(localObject2);
        label1235:
        while (i == 1)
        {
          do
          {
            String str1;
            Object localObject2;
            String str2;
            localObject1 = localArConfigInfo;
          } while (!QLog.isColorLevel());
          QLog.d("ArConfigInfo", 2, "parseConfig success|config=" + localArConfigInfo);
          return localArConfigInfo;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  /* Error */
  public static boolean saveArConfigToFile(ArConfigInfo paramArConfigInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore 7
    //   5: aload_0
    //   6: ifnonnull +6 -> 12
    //   9: iload 7
    //   11: ireturn
    //   12: new 164	java/io/File
    //   15: dup
    //   16: getstatic 170	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 174	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   22: new 148	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   29: ldc -80
    //   31: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 179	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore 5
    //   46: new 164	java/io/File
    //   49: dup
    //   50: getstatic 170	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   53: invokevirtual 174	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   56: new 148	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   63: ldc -80
    //   65: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 449
    //   75: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 179	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   84: astore 6
    //   86: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +12 -> 101
    //   92: ldc 14
    //   94: iconst_2
    //   95: ldc_w 450
    //   98: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: invokestatic 212	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   104: astore 4
    //   106: aload 4
    //   108: iconst_0
    //   109: invokevirtual 220	android/os/Parcel:setDataPosition	(I)V
    //   112: aload_0
    //   113: aload 4
    //   115: iconst_0
    //   116: invokevirtual 454	com/tencent/mobileqq/ar/aidl/ArConfigInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   119: aload 4
    //   121: invokevirtual 457	android/os/Parcel:marshall	()[B
    //   124: astore_0
    //   125: aload 5
    //   127: invokevirtual 460	java/io/File:getParentFile	()Ljava/io/File;
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 182	java/io/File:exists	()Z
    //   135: ifne +8 -> 143
    //   138: aload_1
    //   139: invokevirtual 463	java/io/File:mkdir	()Z
    //   142: pop
    //   143: aload 6
    //   145: invokevirtual 182	java/io/File:exists	()Z
    //   148: ifeq +9 -> 157
    //   151: aload 6
    //   153: invokevirtual 185	java/io/File:delete	()Z
    //   156: pop
    //   157: new 465	java/io/FileOutputStream
    //   160: dup
    //   161: aload 6
    //   163: invokespecial 466	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   166: astore_2
    //   167: new 468	java/io/BufferedOutputStream
    //   170: dup
    //   171: aload_2
    //   172: invokespecial 471	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   175: astore_1
    //   176: aload_1
    //   177: aload_0
    //   178: invokevirtual 474	java/io/BufferedOutputStream:write	([B)V
    //   181: aload_1
    //   182: invokevirtual 477	java/io/BufferedOutputStream:flush	()V
    //   185: aload 6
    //   187: aload 5
    //   189: invokestatic 482	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   192: istore 8
    //   194: aload 4
    //   196: invokevirtual 229	android/os/Parcel:recycle	()V
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 483	java/io/BufferedOutputStream:close	()V
    //   207: iload 8
    //   209: istore 7
    //   211: aload_2
    //   212: ifnull -203 -> 9
    //   215: aload_2
    //   216: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   219: iload 8
    //   221: ireturn
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   227: iload 8
    //   229: ireturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   235: goto -28 -> 207
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_1
    //   241: aload_3
    //   242: astore_0
    //   243: aload_2
    //   244: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   247: aload 4
    //   249: invokevirtual 229	android/os/Parcel:recycle	()V
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 483	java/io/BufferedOutputStream:close	()V
    //   260: aload_0
    //   261: ifnull -252 -> 9
    //   264: aload_0
    //   265: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   275: iconst_0
    //   276: ireturn
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   282: goto -22 -> 260
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_1
    //   288: aconst_null
    //   289: astore_2
    //   290: aload 4
    //   292: invokevirtual 229	android/os/Parcel:recycle	()V
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 483	java/io/BufferedOutputStream:close	()V
    //   303: aload_2
    //   304: ifnull +7 -> 311
    //   307: aload_2
    //   308: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   311: aload_0
    //   312: athrow
    //   313: astore_1
    //   314: aload_1
    //   315: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   318: goto -15 -> 303
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   326: goto -15 -> 311
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_1
    //   332: goto -42 -> 290
    //   335: astore_0
    //   336: goto -46 -> 290
    //   339: astore_3
    //   340: aload_0
    //   341: astore_2
    //   342: aload_3
    //   343: astore_0
    //   344: goto -54 -> 290
    //   347: astore_3
    //   348: aconst_null
    //   349: astore_1
    //   350: aload_2
    //   351: astore_0
    //   352: aload_3
    //   353: astore_2
    //   354: goto -111 -> 243
    //   357: astore_3
    //   358: aload_2
    //   359: astore_0
    //   360: aload_3
    //   361: astore_2
    //   362: goto -119 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramArConfigInfo	ArConfigInfo
    //   0	365	1	paramString	String
    //   166	50	2	localFileOutputStream	java.io.FileOutputStream
    //   238	6	2	localIOException1	java.io.IOException
    //   289	73	2	localObject1	Object
    //   1	241	3	localObject2	Object
    //   339	4	3	localObject3	Object
    //   347	6	3	localIOException2	java.io.IOException
    //   357	4	3	localIOException3	java.io.IOException
    //   104	187	4	localParcel	Parcel
    //   44	144	5	localFile1	File
    //   84	102	6	localFile2	File
    //   3	207	7	bool1	boolean
    //   192	36	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   215	219	222	java/io/IOException
    //   203	207	230	java/io/IOException
    //   157	167	238	java/io/IOException
    //   264	268	270	java/io/IOException
    //   256	260	277	java/io/IOException
    //   157	167	285	finally
    //   299	303	313	java/io/IOException
    //   307	311	321	java/io/IOException
    //   167	176	329	finally
    //   176	194	335	finally
    //   243	247	339	finally
    //   167	176	347	java/io/IOException
    //   176	194	357	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ModelResource getModelResByMd5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.modelResources.iterator();
    while (localIterator.hasNext())
    {
      ModelResource localModelResource = (ModelResource)localIterator.next();
      if (paramString.equals(localModelResource.b)) {
        return localModelResource;
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArConfigInfo{");
    localStringBuffer.append("version='").append(this.version).append('\'');
    localStringBuffer.append(", aRBegin=").append(this.aRBegin);
    localStringBuffer.append(", aREnd=").append(this.aREnd);
    localStringBuffer.append(", actType=").append(this.actType);
    localStringBuffer.append(", scanIconImg='").append(this.scanIconImg).append('\'');
    localStringBuffer.append(", scanIconPressed='").append(this.scanIconPressed).append('\'');
    localStringBuffer.append(", scanIconText='").append(this.scanIconText).append('\'');
    localStringBuffer.append(", scanLine1='").append(this.scanLine1).append('\'');
    localStringBuffer.append(", scanLine2='").append(this.scanLine2).append('\'');
    localStringBuffer.append(", scanLineLink='").append(this.scanLineLink).append('\'');
    localStringBuffer.append(", scanLinkUrl='").append(this.scanLinkUrl).append('\'');
    localStringBuffer.append(", featureResources=").append(this.featureResources);
    localStringBuffer.append(", modelResources=").append(this.modelResources);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.versionId);
    paramParcel.writeString(this.osId);
    paramParcel.writeLong(this.aRBegin);
    paramParcel.writeLong(this.aREnd);
    paramParcel.writeInt(this.actType);
    paramParcel.writeString(this.scanIconImg);
    paramParcel.writeString(this.scanIconMd5);
    paramParcel.writeString(this.scanIconPressed);
    paramParcel.writeString(this.scanIconPressedMd5);
    paramParcel.writeString(this.scanIconText);
    paramParcel.writeString(this.scanLine1);
    paramParcel.writeString(this.scanLine2);
    paramParcel.writeString(this.scanLineLink);
    paramParcel.writeString(this.scanLinkUrl);
    paramParcel.writeList(this.featureResources);
    paramParcel.writeList(this.modelResources);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\aidl\ArConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */