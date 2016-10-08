package com.tencent.securitysdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ApkInfoParser
{
  private static final String a = "/";
  private static final String b = "http://schemas.android.com/apk/res/android";
  
  public ApkInfoParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iconst_0
    //   3: invokevirtual 35	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +15 -> 23
    //   11: iconst_0
    //   12: ireturn
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 38	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   18: aconst_null
    //   19: astore_1
    //   20: goto -13 -> 7
    //   23: aload_1
    //   24: invokevirtual 42	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: astore_3
    //   28: new 44	android/content/res/Resources
    //   31: dup
    //   32: aload_3
    //   33: aload_0
    //   34: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   37: invokevirtual 52	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   40: aconst_null
    //   41: invokespecial 55	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   44: astore_2
    //   45: aload_1
    //   46: aload_3
    //   47: invokestatic 58	com/tencent/securitysdk/utils/ApkInfoParser:a	(Landroid/content/Context;Landroid/content/res/AssetManager;)Landroid/content/res/XmlResourceParser;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull -41 -> 11
    //   55: aload_0
    //   56: invokeinterface 64 1 0
    //   61: istore 4
    //   63: iload 4
    //   65: iconst_1
    //   66: if_icmpeq -55 -> 11
    //   69: iload 4
    //   71: tableswitch	default:+17->88, 2:+53->124
    //   88: aload_0
    //   89: invokeinterface 67 1 0
    //   94: istore 5
    //   96: iload 5
    //   98: istore 4
    //   100: goto -37 -> 63
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   108: aconst_null
    //   109: astore_0
    //   110: goto -59 -> 51
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 69	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   118: iconst_0
    //   119: istore 4
    //   121: goto -58 -> 63
    //   124: aload_0
    //   125: invokeinterface 73 1 0
    //   130: astore_1
    //   131: aload_1
    //   132: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne -47 -> 88
    //   138: aload_1
    //   139: ldc 81
    //   141: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifeq -56 -> 88
    //   147: aload_0
    //   148: aload_2
    //   149: ldc 89
    //   151: invokestatic 92	com/tencent/securitysdk/utils/ApkInfoParser:a	(Landroid/content/res/XmlResourceParser;Landroid/content/res/Resources;Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_0
    //   155: aload_0
    //   156: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne -148 -> 11
    //   162: aload_0
    //   163: invokestatic 98	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   166: ireturn
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 69	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   172: goto -109 -> 63
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   180: goto -117 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramContext	Context
    //   0	183	1	paramString	String
    //   44	105	2	localResources	Resources
    //   27	20	3	localAssetManager	AssetManager
    //   61	59	4	i	int
    //   94	3	5	j	int
    // Exception table:
    //   from	to	target	type
    //   0	7	13	android/content/pm/PackageManager$NameNotFoundException
    //   45	51	103	java/io/IOException
    //   55	63	113	org/xmlpull/v1/XmlPullParserException
    //   88	96	167	org/xmlpull/v1/XmlPullParserException
    //   88	96	175	java/io/IOException
  }
  
  protected static XmlResourceParser a(Context paramContext, AssetManager paramAssetManager)
  {
    int j = 1;
    try
    {
      String str2 = (String)Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(paramContext, new Object[0]);
      Method localMethod = AssetManager.class.getMethod("getCookieName", new Class[] { Integer.TYPE });
      String str1 = str2;
      int i = j;
      if (str2 == null)
      {
        str1 = str2;
        i = j;
        if (paramContext.getPackageName().equals("android"))
        {
          str1 = "/system/framework/framework-res.apk";
          i = j;
        }
      }
      while (i < 20)
      {
        if (str1 != null) {
          if (str1.equals(localMethod.invoke(paramAssetManager, new Object[] { Integer.valueOf(i) })))
          {
            paramContext = paramAssetManager.openXmlResourceParser(i, "AndroidManifest.xml");
            return paramContext;
          }
        }
        i += 1;
      }
      return paramAssetManager.openXmlResourceParser("AndroidManifest.xml");
    }
    catch (Exception paramContext) {}
  }
  
  protected static String a(XmlResourceParser paramXmlResourceParser, Resources paramResources, String paramString)
  {
    return a(paramXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString), paramResources);
  }
  
  protected static String a(String paramString, Resources paramResources)
  {
    if ((paramString == null) || (!paramString.startsWith("@")) || (paramResources == null)) {
      return paramString;
    }
    try
    {
      paramResources = paramResources.getString(Integer.parseInt(paramString.substring(1)));
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      return paramString;
    }
    catch (NumberFormatException paramResources) {}
    return paramString;
  }
  
  public static List a(Context paramContext, String paramString)
  {
    int j = 0;
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramContext.getPackageResourcePath();
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject2 = ((String)localObject1).split("/");
      if (localObject2 != null)
      {
        if (i >= localObject2.length) {
          break label347;
        }
        if (!localObject2[i].contains(paramContext.getPackageName())) {
          break label175;
        }
      }
    }
    label175:
    label347:
    for (paramContext = localObject2[i];; paramContext = "")
    {
      if (!TextUtils.isEmpty(paramContext))
      {
        localObject2 = ((String)localObject1).replace(paramContext, paramString + "-1");
        if (new File((String)localObject2).exists()) {
          localArrayList.add(localObject2);
        }
        paramContext = ((String)localObject1).replace(paramContext, paramString + "-2");
        if (new File(paramContext).exists()) {
          localArrayList.add(paramContext);
        }
      }
      do
      {
        do
        {
          return localArrayList;
          i += 1;
          break;
          paramContext = ((String)localObject1).split("/");
        } while (paramContext == null);
        localObject1 = new StringBuilder();
        i = j;
        while (i < paramContext.length)
        {
          if (i != paramContext.length - 1)
          {
            ((StringBuilder)localObject1).append(paramContext[i]);
            ((StringBuilder)localObject1).append("/");
          }
          i += 1;
        }
        paramContext = ((StringBuilder)localObject1).toString();
        localObject1 = paramContext + paramString + "-1.apk";
        if (new File((String)localObject1).exists()) {
          localArrayList.add(localObject1);
        }
        paramContext = paramContext + paramString + "-2.apk";
      } while (!new File(paramContext).exists());
      localArrayList.add(paramContext);
      return localArrayList;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\securitysdk\utils\ApkInfoParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */