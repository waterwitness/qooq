package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ThemeJsPlugin$SwitchThemeTask
  extends AsyncTask
{
  public String callbackId;
  public String seriesID;
  public boolean showDlgTip;
  public long startTime;
  public JSONArray themeArray;
  public String themeId;
  public String version;
  
  public ThemeJsPlugin$SwitchThemeTask(ThemeJsPlugin paramThemeJsPlugin, String paramString, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.callbackId = paramString;
    this.showDlgTip = paramBoolean;
  }
  
  public void clearImageCache()
  {
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
  }
  
  public void delOldResDir(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString1 != null) {
      try
      {
        if ((paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
        {
          String str1 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
          File[] arrayOfFile = new File(str1).listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
            while (i < arrayOfFile.length)
            {
              String str2 = arrayOfFile[i].getName();
              if (str2.startsWith(paramString1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeJsPlugin", 2, "delete old theme res dir,themeId=" + paramString1 + ",dirName=" + str2);
                }
                FileUtils.a(str1 + File.separator + str2);
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ThemeJsPlugin", 1, "delOldResDir,themeId=" + paramString1 + ",themeResPath=" + paramString2 + ", msg:" + localException.getMessage());
      }
    }
  }
  
  /* Error */
  protected org.json.JSONObject doInBackground(Object... paramVarArgs)
  {
    // Byte code:
    //   0: new 137	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 138	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   12: getfield 144	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   15: new 94	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   22: aload_0
    //   23: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   26: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc -108
    //   31: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   38: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokevirtual 153	java/lang/String:hashCode	()I
    //   47: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: invokevirtual 165	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   53: ifeq +303 -> 356
    //   56: aload_0
    //   57: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   60: getfield 144	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   63: new 94	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   70: aload_0
    //   71: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   74: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc -108
    //   79: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   86: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokevirtual 153	java/lang/String:hashCode	()I
    //   95: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: invokevirtual 169	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: checkcast 52	java/lang/String
    //   104: astore_2
    //   105: aload_3
    //   106: ldc -86
    //   108: aload_0
    //   109: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   112: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_3
    //   117: ldc -81
    //   119: aload_0
    //   120: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   123: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: aload_3
    //   128: ldc -79
    //   130: iconst_m1
    //   131: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload_3
    //   136: ldc -74
    //   138: ldc -72
    //   140: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_0
    //   145: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   148: ifnull +15 -> 163
    //   151: aload_0
    //   152: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   155: ldc -70
    //   157: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +203 -> 363
    //   163: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +43 -> 209
    //   169: ldc 92
    //   171: iconst_2
    //   172: new 94	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   179: ldc -65
    //   181: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   188: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc -63
    //   193: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   200: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_0
    //   210: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   213: ifnonnull +28 -> 241
    //   216: aload_0
    //   217: ldc -70
    //   219: putfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   222: aload_3
    //   223: ldc -86
    //   225: aload_0
    //   226: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   229: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: ldc 92
    //   235: iconst_1
    //   236: ldc -58
    //   238: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: ldc2_w 199
    //   244: invokestatic 206	java/lang/Thread:sleep	(J)V
    //   247: aload_3
    //   248: ldc -79
    //   250: iconst_0
    //   251: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   254: pop
    //   255: aload_3
    //   256: ldc -74
    //   258: ldc -48
    //   260: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   263: pop
    //   264: iconst_m1
    //   265: istore 8
    //   267: aload_3
    //   268: ldc -46
    //   270: iload 8
    //   272: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   275: pop
    //   276: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +31 -> 310
    //   282: ldc 92
    //   284: iconst_2
    //   285: new 94	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   292: ldc -44
    //   294: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_3
    //   298: invokevirtual 213	org/json/JSONObject:toString	()Ljava/lang/String;
    //   301: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: iload 8
    //   312: bipush -36
    //   314: if_icmpeq +10 -> 324
    //   317: iload 8
    //   319: bipush -35
    //   321: if_icmpne +33 -> 354
    //   324: aload_0
    //   325: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   328: aconst_null
    //   329: iconst_1
    //   330: aload_0
    //   331: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   334: lconst_0
    //   335: aconst_null
    //   336: aconst_null
    //   337: ldc -41
    //   339: sipush 155
    //   342: aload_2
    //   343: iload 8
    //   345: aload_0
    //   346: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   349: ldc -39
    //   351: invokevirtual 221	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   354: aload_3
    //   355: areturn
    //   356: getstatic 226	com/tencent/mobileqq/theme/ThemeReporter:u	Ljava/lang/String;
    //   359: astore_2
    //   360: goto -255 -> 105
    //   363: aload_0
    //   364: getfield 228	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:seriesID	Ljava/lang/String;
    //   367: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   370: ifne +53 -> 423
    //   373: aload_0
    //   374: getfield 236	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeArray	Lorg/json/JSONArray;
    //   377: ifnull +46 -> 423
    //   380: aload_0
    //   381: getfield 236	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeArray	Lorg/json/JSONArray;
    //   384: invokevirtual 239	org/json/JSONArray:length	()I
    //   387: ifle +36 -> 423
    //   390: aload_3
    //   391: ldc -16
    //   393: aload_0
    //   394: getfield 228	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:seriesID	Ljava/lang/String;
    //   397: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   400: pop
    //   401: aload_3
    //   402: ldc -15
    //   404: aload_0
    //   405: getfield 236	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeArray	Lorg/json/JSONArray;
    //   408: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload_3
    //   413: ldc -14
    //   415: aload_0
    //   416: getfield 244	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:startTime	J
    //   419: invokevirtual 247	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   422: pop
    //   423: aload_0
    //   424: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   427: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   430: aload_0
    //   431: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   434: invokestatic 257	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   437: astore 5
    //   439: aload 5
    //   441: ifnull +52 -> 493
    //   444: aload 5
    //   446: getfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   449: ldc_w 264
    //   452: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   455: ifeq +38 -> 493
    //   458: aload_0
    //   459: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   462: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   465: aload_0
    //   466: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   469: invokestatic 268	com/tencent/mobileqq/theme/ThemeUtil:getErrorThemeId	(Landroid/content/Context;Ljava/lang/String;)I
    //   472: ldc_w 269
    //   475: idiv
    //   476: ldc_w 271
    //   479: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   482: if_icmpne +11 -> 493
    //   485: aload 5
    //   487: ldc_w 271
    //   490: putfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   497: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   500: aload_0
    //   501: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   504: aload_0
    //   505: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   508: invokestatic 278	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   511: astore 4
    //   513: aload_0
    //   514: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   517: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   520: aload_0
    //   521: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   524: aload_0
    //   525: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   528: invokestatic 281	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   531: astore 6
    //   533: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +41 -> 577
    //   539: ldc 92
    //   541: iconst_2
    //   542: new 94	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 283
    //   552: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 4
    //   557: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 285
    //   563: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload 6
    //   568: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: new 58	java/io/File
    //   580: dup
    //   581: aload 6
    //   583: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   586: astore 7
    //   588: aload 5
    //   590: ifnull +288 -> 878
    //   593: aload 5
    //   595: getfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   598: ldc_w 264
    //   601: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   604: ifeq +274 -> 878
    //   607: new 58	java/io/File
    //   610: dup
    //   611: aload 4
    //   613: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   616: astore_1
    //   617: aload_1
    //   618: invokevirtual 288	java/io/File:exists	()Z
    //   621: ifeq +664 -> 1285
    //   624: aload_1
    //   625: invokestatic 292	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   628: istore 8
    //   630: iload 8
    //   632: ifle +1469 -> 2101
    //   635: iload 8
    //   637: aload 5
    //   639: getfield 296	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   642: if_icmplt +1459 -> 2101
    //   645: ldc 92
    //   647: iconst_1
    //   648: new 94	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 298
    //   658: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   665: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: ldc_w 300
    //   671: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload_0
    //   675: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   678: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: ldc_w 302
    //   684: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 5
    //   689: getfield 296	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   692: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: ldc_w 307
    //   698: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: iload 8
    //   703: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: ldc2_w 199
    //   715: invokestatic 206	java/lang/Thread:sleep	(J)V
    //   718: aload_3
    //   719: ldc -79
    //   721: iconst_0
    //   722: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   725: pop
    //   726: aload_3
    //   727: ldc_w 309
    //   730: aload 4
    //   732: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   735: pop
    //   736: aload_3
    //   737: ldc -74
    //   739: ldc_w 311
    //   742: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   745: pop
    //   746: aload_3
    //   747: areturn
    //   748: aload_0
    //   749: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   752: ldc_w 313
    //   755: iconst_1
    //   756: aload_0
    //   757: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   760: lconst_0
    //   761: ldc_w 315
    //   764: aload_1
    //   765: ldc -41
    //   767: sipush 155
    //   770: aload_2
    //   771: sipush 135
    //   774: aload_0
    //   775: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   778: ldc -39
    //   780: invokevirtual 221	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   783: ldc 92
    //   785: iconst_1
    //   786: new 94	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 317
    //   796: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_0
    //   800: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   803: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: ldc_w 300
    //   809: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload_0
    //   813: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   816: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: ldc_w 302
    //   822: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload 5
    //   827: getfield 296	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   830: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   833: ldc_w 307
    //   836: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: iload 8
    //   841: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload_3
    //   851: ldc -79
    //   853: iconst_4
    //   854: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   857: pop
    //   858: aload_3
    //   859: ldc_w 309
    //   862: aload 4
    //   864: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   867: pop
    //   868: aload_3
    //   869: ldc -74
    //   871: ldc_w 319
    //   874: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   877: pop
    //   878: aload 5
    //   880: ifnull +842 -> 1722
    //   883: aload 7
    //   885: invokevirtual 288	java/io/File:exists	()Z
    //   888: ifeq +834 -> 1722
    //   891: aload 7
    //   893: invokevirtual 322	java/io/File:length	()J
    //   896: aload 5
    //   898: getfield 325	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   901: lcmp
    //   902: ifne +820 -> 1722
    //   905: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   908: ifeq +44 -> 952
    //   911: ldc 92
    //   913: iconst_2
    //   914: new 94	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   921: ldc_w 327
    //   924: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload 7
    //   929: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   932: ldc_w 332
    //   935: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload 5
    //   940: getfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   943: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   952: aload_0
    //   953: aload_0
    //   954: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   957: aload 4
    //   959: invokevirtual 334	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:delOldResDir	(Ljava/lang/String;Ljava/lang/String;)V
    //   962: iconst_0
    //   963: istore 11
    //   965: iconst_0
    //   966: istore 9
    //   968: iconst_0
    //   969: istore 8
    //   971: aload 6
    //   973: aload 4
    //   975: iconst_0
    //   976: invokestatic 337	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   979: new 58	java/io/File
    //   982: dup
    //   983: aload 4
    //   985: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   988: astore_1
    //   989: aload_1
    //   990: invokevirtual 288	java/io/File:exists	()Z
    //   993: ifeq +9 -> 1002
    //   996: aload_1
    //   997: invokestatic 292	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   1000: istore 8
    //   1002: iload 8
    //   1004: ifle +384 -> 1388
    //   1007: iconst_1
    //   1008: istore 10
    //   1010: iload 10
    //   1012: ifne +1107 -> 2119
    //   1015: new 58	java/io/File
    //   1018: dup
    //   1019: aload 4
    //   1021: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   1024: astore_1
    //   1025: new 58	java/io/File
    //   1028: dup
    //   1029: aload 6
    //   1031: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   1034: astore 7
    //   1036: ldc 92
    //   1038: iconst_1
    //   1039: new 94	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 339
    //   1049: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 6
    //   1054: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1063: aload 7
    //   1065: aload_1
    //   1066: iconst_0
    //   1067: invokestatic 344	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/io/File;Ljava/io/File;Z)Z
    //   1070: istore 11
    //   1072: aload_0
    //   1073: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1076: aconst_null
    //   1077: iconst_1
    //   1078: aload_0
    //   1079: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   1082: lconst_0
    //   1083: aconst_null
    //   1084: aconst_null
    //   1085: ldc -41
    //   1087: sipush 155
    //   1090: aload_2
    //   1091: sipush 136
    //   1094: aload_0
    //   1095: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   1098: ldc -39
    //   1100: invokevirtual 221	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1103: goto +1016 -> 2119
    //   1106: new 58	java/io/File
    //   1109: dup
    //   1110: aload 4
    //   1112: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   1115: astore_1
    //   1116: aload_1
    //   1117: invokevirtual 288	java/io/File:exists	()Z
    //   1120: ifeq +461 -> 1581
    //   1123: aload 5
    //   1125: ldc_w 264
    //   1128: putfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1131: aload_1
    //   1132: invokestatic 292	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   1135: istore 8
    //   1137: aload 5
    //   1139: iload 8
    //   1141: putfield 296	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   1144: aload_0
    //   1145: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1148: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   1151: aload 5
    //   1153: invokestatic 348	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1156: invokevirtual 353	java/lang/Boolean:booleanValue	()Z
    //   1159: istore 12
    //   1161: ldc 92
    //   1163: iconst_1
    //   1164: new 94	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1171: ldc_w 355
    //   1174: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: iload 12
    //   1179: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1182: ldc_w 307
    //   1185: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: iload 8
    //   1190: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1193: ldc_w 360
    //   1196: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: aload 6
    //   1201: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1210: iload 8
    //   1212: ifle +251 -> 1463
    //   1215: aload_3
    //   1216: ldc -79
    //   1218: iconst_0
    //   1219: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1222: pop
    //   1223: aload_3
    //   1224: ldc_w 309
    //   1227: aload 4
    //   1229: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1232: pop
    //   1233: aload_3
    //   1234: ldc -74
    //   1236: ldc_w 362
    //   1239: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1242: pop
    //   1243: goto +889 -> 2132
    //   1246: iload 8
    //   1248: ifgt +847 -> 2095
    //   1251: ldc 92
    //   1253: iconst_1
    //   1254: new 94	java/lang/StringBuilder
    //   1257: dup
    //   1258: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1261: ldc_w 364
    //   1264: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: aload 4
    //   1269: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1278: bipush -30
    //   1280: istore 8
    //   1282: goto +853 -> 2135
    //   1285: ldc 92
    //   1287: iconst_1
    //   1288: new 94	java/lang/StringBuilder
    //   1291: dup
    //   1292: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1295: ldc_w 366
    //   1298: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: aload 4
    //   1303: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1312: aload_0
    //   1313: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1316: ldc_w 313
    //   1319: iconst_1
    //   1320: aload_0
    //   1321: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   1324: lconst_0
    //   1325: ldc_w 315
    //   1328: ldc_w 368
    //   1331: ldc -41
    //   1333: sipush 155
    //   1336: aload_2
    //   1337: bipush 119
    //   1339: aload_0
    //   1340: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   1343: ldc -39
    //   1345: invokevirtual 221	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1348: goto -470 -> 878
    //   1351: astore_1
    //   1352: ldc 92
    //   1354: iconst_1
    //   1355: new 94	java/lang/StringBuilder
    //   1358: dup
    //   1359: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1362: ldc_w 370
    //   1365: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: aload_1
    //   1369: invokevirtual 371	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1372: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1378: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1381: bipush -36
    //   1383: istore 8
    //   1385: goto -1109 -> 276
    //   1388: iconst_0
    //   1389: istore 10
    //   1391: goto -381 -> 1010
    //   1394: astore_1
    //   1395: aload_3
    //   1396: ldc -74
    //   1398: ldc_w 373
    //   1401: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1404: pop
    //   1405: aload_3
    //   1406: ldc -79
    //   1408: iconst_2
    //   1409: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1412: pop
    //   1413: aload_3
    //   1414: ldc_w 375
    //   1417: ldc_w 377
    //   1420: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1423: pop
    //   1424: ldc 92
    //   1426: iconst_1
    //   1427: new 94	java/lang/StringBuilder
    //   1430: dup
    //   1431: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1434: ldc_w 379
    //   1437: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: aload_1
    //   1441: invokevirtual 380	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1444: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1453: iconst_0
    //   1454: istore 10
    //   1456: iload 9
    //   1458: istore 8
    //   1460: goto -450 -> 1010
    //   1463: ldc 92
    //   1465: iconst_1
    //   1466: new 94	java/lang/StringBuilder
    //   1469: dup
    //   1470: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1473: ldc_w 382
    //   1476: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: iload 10
    //   1481: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1484: ldc_w 384
    //   1487: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: iload 11
    //   1492: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1495: ldc_w 307
    //   1498: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: iload 8
    //   1503: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1506: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1509: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1512: aload_3
    //   1513: ldc -74
    //   1515: ldc_w 386
    //   1518: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1521: pop
    //   1522: aload_3
    //   1523: ldc -79
    //   1525: iconst_3
    //   1526: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1529: pop
    //   1530: aload_3
    //   1531: ldc_w 375
    //   1534: ldc_w 388
    //   1537: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1540: pop
    //   1541: goto +591 -> 2132
    //   1544: astore_1
    //   1545: ldc 92
    //   1547: iconst_1
    //   1548: new 94	java/lang/StringBuilder
    //   1551: dup
    //   1552: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1555: ldc_w 390
    //   1558: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: aload_1
    //   1562: invokevirtual 123	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1565: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1571: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1574: bipush -35
    //   1576: istore 8
    //   1578: goto -1302 -> 276
    //   1581: ldc 92
    //   1583: iconst_1
    //   1584: new 94	java/lang/StringBuilder
    //   1587: dup
    //   1588: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1591: ldc_w 392
    //   1594: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: iload 10
    //   1599: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1602: ldc_w 384
    //   1605: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: iload 11
    //   1610: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1613: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1616: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1619: aload_3
    //   1620: ldc -74
    //   1622: ldc_w 394
    //   1625: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1628: pop
    //   1629: aload_3
    //   1630: ldc -79
    //   1632: iconst_2
    //   1633: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1636: pop
    //   1637: aload_3
    //   1638: ldc_w 375
    //   1641: ldc_w 396
    //   1644: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1647: pop
    //   1648: aload 6
    //   1650: invokestatic 398	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1653: pop
    //   1654: goto +478 -> 2132
    //   1657: aload_3
    //   1658: ldc -74
    //   1660: ldc_w 400
    //   1663: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1666: pop
    //   1667: aload_3
    //   1668: ldc -79
    //   1670: iconst_2
    //   1671: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1674: pop
    //   1675: aload_3
    //   1676: ldc_w 375
    //   1679: ldc_w 402
    //   1682: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1685: pop
    //   1686: aload 6
    //   1688: invokestatic 398	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1691: pop
    //   1692: ldc 92
    //   1694: iconst_1
    //   1695: new 94	java/lang/StringBuilder
    //   1698: dup
    //   1699: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1702: ldc_w 364
    //   1705: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: aload 4
    //   1710: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1716: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1719: goto -473 -> 1246
    //   1722: aload 5
    //   1724: ifnonnull +68 -> 1792
    //   1727: aload_3
    //   1728: ldc -74
    //   1730: ldc_w 404
    //   1733: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1736: pop
    //   1737: aload_3
    //   1738: ldc_w 375
    //   1741: ldc_w 406
    //   1744: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1747: pop
    //   1748: bipush -7
    //   1750: istore 8
    //   1752: ldc 92
    //   1754: iconst_1
    //   1755: new 94	java/lang/StringBuilder
    //   1758: dup
    //   1759: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1762: ldc_w 408
    //   1765: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: aload_0
    //   1769: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   1772: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1778: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: aload_3
    //   1782: ldc -79
    //   1784: iconst_1
    //   1785: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1788: pop
    //   1789: goto -1522 -> 267
    //   1792: aload 7
    //   1794: invokevirtual 288	java/io/File:exists	()Z
    //   1797: ifne +106 -> 1903
    //   1800: aload 5
    //   1802: ifnull +44 -> 1846
    //   1805: aload 5
    //   1807: getfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1810: ldc_w 410
    //   1813: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1816: ifne +30 -> 1846
    //   1819: aload 5
    //   1821: ldc_w 410
    //   1824: putfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1827: aload 5
    //   1829: lconst_0
    //   1830: putfield 413	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1833: aload_0
    //   1834: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1837: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   1840: aload 5
    //   1842: invokestatic 348	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1845: pop
    //   1846: aload_3
    //   1847: ldc -74
    //   1849: ldc_w 415
    //   1852: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1855: pop
    //   1856: aload_3
    //   1857: ldc_w 375
    //   1860: ldc_w 417
    //   1863: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1866: pop
    //   1867: bipush -29
    //   1869: istore 8
    //   1871: ldc 92
    //   1873: iconst_1
    //   1874: new 94	java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1881: ldc_w 419
    //   1884: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: aload_0
    //   1888: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   1891: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1897: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1900: goto -119 -> 1781
    //   1903: aload 7
    //   1905: invokevirtual 322	java/io/File:length	()J
    //   1908: aload 5
    //   1910: getfield 325	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   1913: lcmp
    //   1914: ifeq +147 -> 2061
    //   1917: aload 5
    //   1919: ifnull +44 -> 1963
    //   1922: aload 5
    //   1924: getfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1927: ldc_w 421
    //   1930: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1933: ifne +30 -> 1963
    //   1936: aload 5
    //   1938: ldc_w 421
    //   1941: putfield 262	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1944: aload 5
    //   1946: lconst_0
    //   1947: putfield 413	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1950: aload_0
    //   1951: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1954: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   1957: aload 5
    //   1959: invokestatic 348	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1962: pop
    //   1963: aload_3
    //   1964: ldc -74
    //   1966: ldc_w 423
    //   1969: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1972: pop
    //   1973: aload_3
    //   1974: ldc_w 375
    //   1977: ldc_w 425
    //   1980: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1983: pop
    //   1984: bipush -28
    //   1986: istore 8
    //   1988: ldc 92
    //   1990: iconst_1
    //   1991: new 94	java/lang/StringBuilder
    //   1994: dup
    //   1995: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1998: ldc_w 427
    //   2001: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: aload_0
    //   2005: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:themeId	Ljava/lang/String;
    //   2008: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: ldc_w 429
    //   2014: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2017: aload_0
    //   2018: getfield 150	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:version	Ljava/lang/String;
    //   2021: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: ldc_w 431
    //   2027: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: aload 7
    //   2032: invokevirtual 322	java/io/File:length	()J
    //   2035: invokevirtual 434	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2038: ldc_w 436
    //   2041: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2044: aload 5
    //   2046: getfield 325	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   2049: invokevirtual 434	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2052: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2055: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2058: goto -277 -> 1781
    //   2061: aload_3
    //   2062: ldc_w 375
    //   2065: ldc_w 438
    //   2068: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2071: pop
    //   2072: ldc 92
    //   2074: iconst_1
    //   2075: ldc_w 440
    //   2078: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2081: iconst_m1
    //   2082: istore 8
    //   2084: goto -303 -> 1781
    //   2087: astore_1
    //   2088: goto -1841 -> 247
    //   2091: astore_1
    //   2092: goto -1374 -> 718
    //   2095: iconst_m1
    //   2096: istore 8
    //   2098: goto +37 -> 2135
    //   2101: ldc_w 442
    //   2104: astore_1
    //   2105: iload 8
    //   2107: bipush 100
    //   2109: if_icmple +29 -> 2138
    //   2112: ldc_w 444
    //   2115: astore_1
    //   2116: goto -1368 -> 748
    //   2119: iload 10
    //   2121: ifne -1015 -> 1106
    //   2124: iload 11
    //   2126: ifeq -469 -> 1657
    //   2129: goto -1023 -> 1106
    //   2132: goto -886 -> 1246
    //   2135: goto -1868 -> 267
    //   2138: iload 8
    //   2140: bipush 50
    //   2142: if_icmple +10 -> 2152
    //   2145: ldc_w 446
    //   2148: astore_1
    //   2149: goto -1401 -> 748
    //   2152: iload 8
    //   2154: bipush 20
    //   2156: if_icmple -1408 -> 748
    //   2159: ldc_w 448
    //   2162: astore_1
    //   2163: goto -1415 -> 748
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2166	0	this	SwitchThemeTask
    //   0	2166	1	paramVarArgs	Object[]
    //   104	1233	2	str1	String
    //   7	2055	3	localJSONObject	org.json.JSONObject
    //   511	1198	4	str2	String
    //   437	1608	5	localThemeInfo	com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
    //   531	1156	6	str3	String
    //   586	1445	7	localFile	File
    //   265	1892	8	i	int
    //   966	491	9	j	int
    //   1008	1112	10	bool1	boolean
    //   963	1162	11	bool2	boolean
    //   1159	19	12	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   105	163	1351	org/json/JSONException
    //   163	209	1351	org/json/JSONException
    //   209	241	1351	org/json/JSONException
    //   241	247	1351	org/json/JSONException
    //   247	264	1351	org/json/JSONException
    //   267	276	1351	org/json/JSONException
    //   363	423	1351	org/json/JSONException
    //   423	439	1351	org/json/JSONException
    //   444	493	1351	org/json/JSONException
    //   493	577	1351	org/json/JSONException
    //   577	588	1351	org/json/JSONException
    //   593	630	1351	org/json/JSONException
    //   635	712	1351	org/json/JSONException
    //   712	718	1351	org/json/JSONException
    //   718	746	1351	org/json/JSONException
    //   748	878	1351	org/json/JSONException
    //   883	952	1351	org/json/JSONException
    //   952	962	1351	org/json/JSONException
    //   971	989	1351	org/json/JSONException
    //   989	1002	1351	org/json/JSONException
    //   1015	1103	1351	org/json/JSONException
    //   1106	1210	1351	org/json/JSONException
    //   1215	1243	1351	org/json/JSONException
    //   1251	1278	1351	org/json/JSONException
    //   1285	1348	1351	org/json/JSONException
    //   1395	1453	1351	org/json/JSONException
    //   1463	1541	1351	org/json/JSONException
    //   1581	1654	1351	org/json/JSONException
    //   1657	1719	1351	org/json/JSONException
    //   1727	1748	1351	org/json/JSONException
    //   1752	1781	1351	org/json/JSONException
    //   1781	1789	1351	org/json/JSONException
    //   1792	1800	1351	org/json/JSONException
    //   1805	1846	1351	org/json/JSONException
    //   1846	1867	1351	org/json/JSONException
    //   1871	1900	1351	org/json/JSONException
    //   1903	1917	1351	org/json/JSONException
    //   1922	1963	1351	org/json/JSONException
    //   1963	1984	1351	org/json/JSONException
    //   1988	2058	1351	org/json/JSONException
    //   2061	2081	1351	org/json/JSONException
    //   971	989	1394	java/io/IOException
    //   989	1002	1394	java/io/IOException
    //   105	163	1544	java/lang/Exception
    //   163	209	1544	java/lang/Exception
    //   209	241	1544	java/lang/Exception
    //   247	264	1544	java/lang/Exception
    //   267	276	1544	java/lang/Exception
    //   363	423	1544	java/lang/Exception
    //   423	439	1544	java/lang/Exception
    //   444	493	1544	java/lang/Exception
    //   493	577	1544	java/lang/Exception
    //   577	588	1544	java/lang/Exception
    //   593	630	1544	java/lang/Exception
    //   635	712	1544	java/lang/Exception
    //   718	746	1544	java/lang/Exception
    //   748	878	1544	java/lang/Exception
    //   883	952	1544	java/lang/Exception
    //   952	962	1544	java/lang/Exception
    //   971	989	1544	java/lang/Exception
    //   989	1002	1544	java/lang/Exception
    //   1015	1103	1544	java/lang/Exception
    //   1106	1210	1544	java/lang/Exception
    //   1215	1243	1544	java/lang/Exception
    //   1251	1278	1544	java/lang/Exception
    //   1285	1348	1544	java/lang/Exception
    //   1395	1453	1544	java/lang/Exception
    //   1463	1541	1544	java/lang/Exception
    //   1581	1654	1544	java/lang/Exception
    //   1657	1719	1544	java/lang/Exception
    //   1727	1748	1544	java/lang/Exception
    //   1752	1781	1544	java/lang/Exception
    //   1781	1789	1544	java/lang/Exception
    //   1792	1800	1544	java/lang/Exception
    //   1805	1846	1544	java/lang/Exception
    //   1846	1867	1544	java/lang/Exception
    //   1871	1900	1544	java/lang/Exception
    //   1903	1917	1544	java/lang/Exception
    //   1922	1963	1544	java/lang/Exception
    //   1963	1984	1544	java/lang/Exception
    //   1988	2058	1544	java/lang/Exception
    //   2061	2081	1544	java/lang/Exception
    //   241	247	2087	java/lang/Exception
    //   712	718	2091	java/lang/Exception
  }
  
  /* Error */
  protected void onPostExecute(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 92
    //   8: iconst_2
    //   9: new 94	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 455
    //   19: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 213	org/json/JSONObject:toString	()Ljava/lang/String;
    //   26: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: ldc_w 311
    //   38: astore 7
    //   40: getstatic 226	com/tencent/mobileqq/theme/ThemeReporter:u	Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: astore_3
    //   46: aload_1
    //   47: ldc -79
    //   49: invokevirtual 458	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   52: istore 16
    //   54: aload_2
    //   55: astore_3
    //   56: aload_1
    //   57: ldc -74
    //   59: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 4
    //   64: aload_2
    //   65: astore_3
    //   66: aload_1
    //   67: ldc -86
    //   69: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 8
    //   74: aload_2
    //   75: astore_3
    //   76: aload_1
    //   77: ldc -81
    //   79: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 9
    //   84: aload_2
    //   85: astore_3
    //   86: aload_0
    //   87: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   90: getfield 144	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   93: new 94	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   100: aload 8
    //   102: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc -108
    //   107: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 9
    //   112: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 153	java/lang/String:hashCode	()I
    //   121: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: invokevirtual 165	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   127: ifeq +820 -> 947
    //   130: aload_2
    //   131: astore_3
    //   132: aload_0
    //   133: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   136: getfield 144	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   139: new 94	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   146: aload 8
    //   148: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc -108
    //   153: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 9
    //   158: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokevirtual 153	java/lang/String:hashCode	()I
    //   167: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokevirtual 169	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast 52	java/lang/String
    //   176: astore_2
    //   177: aload_2
    //   178: astore_3
    //   179: new 137	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 138	org/json/JSONObject:<init>	()V
    //   186: astore 10
    //   188: aload_2
    //   189: astore_3
    //   190: aload 10
    //   192: ldc_w 464
    //   195: iload 16
    //   197: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload_2
    //   202: astore_3
    //   203: aload 10
    //   205: ldc_w 466
    //   208: aload 4
    //   210: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: iconst_0
    //   215: istore 14
    //   217: iconst_0
    //   218: istore 13
    //   220: aload_2
    //   221: astore_3
    //   222: aload_1
    //   223: ldc -46
    //   225: invokevirtual 469	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   228: ifeq +1175 -> 1403
    //   231: aload_2
    //   232: astore_3
    //   233: aload_1
    //   234: ldc -46
    //   236: invokevirtual 458	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   239: istore 12
    //   241: iload 16
    //   243: ifne +835 -> 1078
    //   246: aload_2
    //   247: astore_3
    //   248: aload 8
    //   250: ldc -70
    //   252: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   255: ifeq +701 -> 956
    //   258: aconst_null
    //   259: astore 4
    //   261: aload_2
    //   262: astore_3
    //   263: aload_0
    //   264: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   267: invokevirtual 472	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:doScreenShot	()V
    //   270: aload_2
    //   271: astore_3
    //   272: invokestatic 478	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   275: aload_0
    //   276: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   279: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   282: aload 4
    //   284: invokevirtual 482	com/tencent/theme/SkinEngine:setSkinRootPath	(Landroid/content/Context;Ljava/lang/String;)Z
    //   287: istore 20
    //   289: aload_2
    //   290: astore_3
    //   291: ldc 92
    //   293: iconst_1
    //   294: new 94	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 484
    //   304: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload 20
    //   309: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iload 20
    //   320: iconst_1
    //   321: if_icmpne +668 -> 989
    //   324: aload_2
    //   325: astore_3
    //   326: aload_0
    //   327: invokevirtual 486	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:clearImageCache	()V
    //   330: aload_2
    //   331: astore_3
    //   332: aload_0
    //   333: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   336: invokestatic 490	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   339: aload 8
    //   341: aload 9
    //   343: invokestatic 494	com/tencent/mobileqq/theme/ThemeUtil:setCurrentThemeIdVersion	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   346: invokevirtual 353	java/lang/Boolean:booleanValue	()Z
    //   349: istore 20
    //   351: aload 4
    //   353: ifnonnull +617 -> 970
    //   356: iconst_0
    //   357: istore 13
    //   359: aload_2
    //   360: astore_3
    //   361: new 496	android/os/Bundle
    //   364: dup
    //   365: invokespecial 497	android/os/Bundle:<init>	()V
    //   368: astore 11
    //   370: aload_2
    //   371: astore_3
    //   372: aload 11
    //   374: ldc -86
    //   376: aload 8
    //   378: invokevirtual 500	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload_2
    //   382: astore_3
    //   383: aload 11
    //   385: ldc -81
    //   387: aload 9
    //   389: invokevirtual 500	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: iload 20
    //   394: ifne +1016 -> 1410
    //   397: iconst_1
    //   398: istore 20
    //   400: aload_2
    //   401: astore_3
    //   402: aload 11
    //   404: ldc_w 502
    //   407: iload 20
    //   409: invokevirtual 506	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   412: aload_2
    //   413: astore_3
    //   414: aload_1
    //   415: ldc -16
    //   417: invokevirtual 469	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   420: ifeq +996 -> 1416
    //   423: aload_2
    //   424: astore_3
    //   425: aload_1
    //   426: ldc -16
    //   428: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   431: astore 5
    //   433: aload_2
    //   434: astore_3
    //   435: aload_1
    //   436: ldc -15
    //   438: invokevirtual 469	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   441: ifeq +981 -> 1422
    //   444: aload_2
    //   445: astore_3
    //   446: aload_1
    //   447: ldc -15
    //   449: invokevirtual 510	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   452: astore 6
    //   454: aload_2
    //   455: astore_3
    //   456: new 94	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 512
    //   466: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: iload 13
    //   471: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: ldc_w 514
    //   477: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload 4
    //   482: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: ldc_w 516
    //   488: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 8
    //   493: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 300
    //   499: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 9
    //   504: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: ldc_w 518
    //   510: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload 5
    //   515: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc_w 520
    //   521: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: astore 4
    //   526: aload 6
    //   528: ifnull +900 -> 1428
    //   531: aload_2
    //   532: astore_3
    //   533: aload 6
    //   535: invokevirtual 239	org/json/JSONArray:length	()I
    //   538: ifle +890 -> 1428
    //   541: iconst_1
    //   542: istore 20
    //   544: aload_2
    //   545: astore_3
    //   546: ldc 92
    //   548: iconst_1
    //   549: aload 4
    //   551: iload 20
    //   553: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   556: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aload_2
    //   563: astore_3
    //   564: aload 5
    //   566: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   569: ifne +75 -> 644
    //   572: aload 6
    //   574: ifnull +70 -> 644
    //   577: aload_2
    //   578: astore_3
    //   579: aload 6
    //   581: invokevirtual 239	org/json/JSONArray:length	()I
    //   584: ifle +60 -> 644
    //   587: aload_2
    //   588: astore_3
    //   589: aload 11
    //   591: ldc -16
    //   593: aload 5
    //   595: invokevirtual 500	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload_2
    //   599: astore_3
    //   600: aload 11
    //   602: ldc -15
    //   604: aload 6
    //   606: invokevirtual 521	org/json/JSONArray:toString	()Ljava/lang/String;
    //   609: invokevirtual 500	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: aload_2
    //   613: astore_3
    //   614: aload_1
    //   615: ldc -14
    //   617: invokevirtual 469	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   620: ifeq +814 -> 1434
    //   623: aload_2
    //   624: astore_3
    //   625: aload_1
    //   626: ldc -14
    //   628: invokevirtual 525	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   631: lstore 18
    //   633: aload_2
    //   634: astore_3
    //   635: aload 11
    //   637: ldc -14
    //   639: lload 18
    //   641: invokevirtual 529	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   644: aload_2
    //   645: astore_3
    //   646: ldc_w 531
    //   649: ldc -39
    //   651: aload_0
    //   652: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   655: getfield 535	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   658: getfield 540	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   661: aload 11
    //   663: invokestatic 545	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   666: astore_1
    //   667: aload_2
    //   668: astore_3
    //   669: aload_0
    //   670: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   673: aload_1
    //   674: iconst_0
    //   675: iconst_1
    //   676: invokevirtual 549	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   679: iconst_1
    //   680: istore 15
    //   682: aload_2
    //   683: astore_3
    //   684: aload_0
    //   685: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   688: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   691: aload 8
    //   693: invokestatic 268	com/tencent/mobileqq/theme/ThemeUtil:getErrorThemeId	(Landroid/content/Context;Ljava/lang/String;)I
    //   696: istore 17
    //   698: iload 12
    //   700: istore 13
    //   702: iload 15
    //   704: istore 14
    //   706: aload 7
    //   708: astore_1
    //   709: iload 17
    //   711: ifle +685 -> 1396
    //   714: aload_2
    //   715: astore_3
    //   716: ldc 92
    //   718: iconst_1
    //   719: new 94	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   726: ldc_w 551
    //   729: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload 8
    //   734: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: ldc_w 300
    //   740: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 9
    //   745: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: ldc_w 553
    //   751: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: iload 17
    //   756: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_2
    //   766: astore_3
    //   767: ldc2_w 554
    //   770: invokestatic 206	java/lang/Thread:sleep	(J)V
    //   773: aload_2
    //   774: astore_3
    //   775: iload 17
    //   777: ldc_w 269
    //   780: idiv
    //   781: ldc_w 271
    //   784: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   787: if_icmpne +18 -> 805
    //   790: aload_2
    //   791: astore_3
    //   792: aload_0
    //   793: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   796: invokestatic 251	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   799: aload 8
    //   801: iconst_1
    //   802: invokestatic 559	com/tencent/mobileqq/theme/ThemeUtil:setErrorThemeId	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   805: aload_2
    //   806: astore_3
    //   807: new 496	android/os/Bundle
    //   810: dup
    //   811: invokespecial 497	android/os/Bundle:<init>	()V
    //   814: astore_1
    //   815: aload_2
    //   816: astore_3
    //   817: aload_1
    //   818: ldc -86
    //   820: aload 8
    //   822: invokevirtual 500	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload_2
    //   826: astore_3
    //   827: aload_1
    //   828: ldc -81
    //   830: aload 9
    //   832: invokevirtual 500	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload_2
    //   836: astore_3
    //   837: ldc_w 561
    //   840: ldc -39
    //   842: aload_0
    //   843: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   846: getfield 535	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   849: getfield 540	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   852: aload_1
    //   853: invokestatic 545	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   856: astore_1
    //   857: aload_2
    //   858: astore_3
    //   859: aload_0
    //   860: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   863: aload_1
    //   864: iconst_0
    //   865: iconst_1
    //   866: invokevirtual 549	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   869: iload 12
    //   871: istore 13
    //   873: iload 15
    //   875: istore 14
    //   877: aload 7
    //   879: astore_1
    //   880: goto +516 -> 1396
    //   883: aload_2
    //   884: astore_3
    //   885: aload_0
    //   886: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   889: aload_0
    //   890: getfield 31	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:callbackId	Ljava/lang/String;
    //   893: iconst_1
    //   894: anewarray 52	java/lang/String
    //   897: dup
    //   898: iconst_0
    //   899: aload 10
    //   901: invokevirtual 213	org/json/JSONObject:toString	()Ljava/lang/String;
    //   904: aastore
    //   905: invokevirtual 565	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   908: iload 14
    //   910: ifeq +278 -> 1188
    //   913: aload_2
    //   914: astore_3
    //   915: aload_0
    //   916: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   919: ldc_w 567
    //   922: iconst_0
    //   923: aload 8
    //   925: lconst_0
    //   926: ldc_w 569
    //   929: aload_1
    //   930: ldc -41
    //   932: sipush 155
    //   935: aload_2
    //   936: bipush 23
    //   938: aload 9
    //   940: ldc_w 410
    //   943: invokevirtual 221	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   946: return
    //   947: aload_2
    //   948: astore_3
    //   949: getstatic 226	com/tencent/mobileqq/theme/ThemeReporter:u	Ljava/lang/String;
    //   952: astore_2
    //   953: goto -776 -> 177
    //   956: aload_2
    //   957: astore_3
    //   958: aload_1
    //   959: ldc_w 309
    //   962: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   965: astore 4
    //   967: goto -706 -> 261
    //   970: aload_2
    //   971: astore_3
    //   972: new 58	java/io/File
    //   975: dup
    //   976: aload 4
    //   978: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   981: invokestatic 292	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   984: istore 13
    //   986: goto -627 -> 359
    //   989: aload_2
    //   990: astore_3
    //   991: aload 10
    //   993: ldc_w 464
    //   996: iconst_m1
    //   997: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1000: pop
    //   1001: aload_2
    //   1002: astore_3
    //   1003: aload 10
    //   1005: ldc_w 466
    //   1008: ldc_w 571
    //   1011: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1014: pop
    //   1015: aload_2
    //   1016: astore_3
    //   1017: aload_0
    //   1018: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1021: getfield 575	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1024: ifnull +30 -> 1054
    //   1027: aload_2
    //   1028: astore_3
    //   1029: aload_0
    //   1030: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1033: getfield 575	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1036: invokevirtual 580	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1039: ifeq +15 -> 1054
    //   1042: aload_2
    //   1043: astore_3
    //   1044: aload_0
    //   1045: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1048: getfield 575	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1051: invokevirtual 583	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   1054: aload_2
    //   1055: astore_3
    //   1056: aload_0
    //   1057: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1060: iconst_0
    //   1061: invokestatic 586	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1064: putfield 590	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isSwitchTheme	Ljava/lang/Boolean;
    //   1067: ldc_w 592
    //   1070: astore_1
    //   1071: bipush -24
    //   1073: istore 13
    //   1075: goto +321 -> 1396
    //   1078: aload_2
    //   1079: astore_3
    //   1080: aload_0
    //   1081: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1084: getfield 575	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1087: ifnull +30 -> 1117
    //   1090: aload_2
    //   1091: astore_3
    //   1092: aload_0
    //   1093: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1096: getfield 575	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1099: invokevirtual 580	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1102: ifeq +15 -> 1117
    //   1105: aload_2
    //   1106: astore_3
    //   1107: aload_0
    //   1108: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1111: getfield 575	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1114: invokevirtual 583	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   1117: aload_2
    //   1118: astore_3
    //   1119: aload_0
    //   1120: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1123: iconst_0
    //   1124: invokestatic 586	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1127: putfield 590	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isSwitchTheme	Ljava/lang/Boolean;
    //   1130: aload_2
    //   1131: astore_3
    //   1132: new 94	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1139: ldc_w 594
    //   1142: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: astore 4
    //   1147: aload_2
    //   1148: astore_3
    //   1149: aload_1
    //   1150: ldc_w 375
    //   1153: invokevirtual 469	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1156: ifeq +284 -> 1440
    //   1159: aload_2
    //   1160: astore_3
    //   1161: aload_1
    //   1162: ldc_w 375
    //   1165: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1168: astore_1
    //   1169: aload_2
    //   1170: astore_3
    //   1171: aload 4
    //   1173: aload_1
    //   1174: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: astore_1
    //   1181: iload 13
    //   1183: istore 14
    //   1185: goto -302 -> 883
    //   1188: aload_2
    //   1189: astore_3
    //   1190: ldc 92
    //   1192: iconst_1
    //   1193: new 94	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 596
    //   1203: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: aload 8
    //   1208: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: ldc_w 300
    //   1214: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: aload 9
    //   1219: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: ldc_w 598
    //   1225: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: iload 16
    //   1230: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1233: ldc_w 600
    //   1236: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: aload_1
    //   1240: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: ldc_w 602
    //   1246: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: aload_2
    //   1250: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1259: aload_2
    //   1260: astore_3
    //   1261: aload_0
    //   1262: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1265: ldc_w 567
    //   1268: iconst_1
    //   1269: aload 8
    //   1271: lconst_0
    //   1272: ldc_w 569
    //   1275: aload_1
    //   1276: ldc -41
    //   1278: sipush 155
    //   1281: aload_2
    //   1282: iload 12
    //   1284: aload 9
    //   1286: ldc -39
    //   1288: invokevirtual 221	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1291: return
    //   1292: astore_1
    //   1293: ldc 92
    //   1295: iconst_1
    //   1296: new 94	java/lang/StringBuilder
    //   1299: dup
    //   1300: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1303: ldc_w 370
    //   1306: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: aload_1
    //   1310: invokevirtual 371	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1313: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1319: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1322: aload_0
    //   1323: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1326: getfield 575	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1329: invokevirtual 583	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   1332: aload_0
    //   1333: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1336: iconst_0
    //   1337: invokestatic 586	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1340: putfield 590	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isSwitchTheme	Ljava/lang/Boolean;
    //   1343: aload_0
    //   1344: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1347: aload_0
    //   1348: getfield 31	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:callbackId	Ljava/lang/String;
    //   1351: aload_1
    //   1352: invokevirtual 371	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1355: invokevirtual 605	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   1358: aload_0
    //   1359: getfield 21	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   1362: ldc_w 567
    //   1365: iconst_1
    //   1366: ldc -70
    //   1368: lconst_0
    //   1369: ldc_w 569
    //   1372: ldc_w 607
    //   1375: ldc -41
    //   1377: sipush 155
    //   1380: aload_3
    //   1381: bipush -36
    //   1383: ldc_w 609
    //   1386: ldc -39
    //   1388: invokevirtual 221	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1391: return
    //   1392: astore_1
    //   1393: goto -620 -> 773
    //   1396: iload 13
    //   1398: istore 12
    //   1400: goto -517 -> 883
    //   1403: bipush -23
    //   1405: istore 12
    //   1407: goto -1166 -> 241
    //   1410: iconst_0
    //   1411: istore 20
    //   1413: goto -1013 -> 400
    //   1416: aconst_null
    //   1417: astore 5
    //   1419: goto -986 -> 433
    //   1422: aconst_null
    //   1423: astore 6
    //   1425: goto -971 -> 454
    //   1428: iconst_0
    //   1429: istore 20
    //   1431: goto -887 -> 544
    //   1434: lconst_0
    //   1435: lstore 18
    //   1437: goto -804 -> 633
    //   1440: ldc_w 611
    //   1443: astore_1
    //   1444: goto -275 -> 1169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1447	0	this	SwitchThemeTask
    //   0	1447	1	paramJSONObject	org.json.JSONObject
    //   43	1239	2	str1	String
    //   45	1336	3	str2	String
    //   62	1110	4	localObject	Object
    //   431	987	5	str3	String
    //   452	972	6	localJSONArray	JSONArray
    //   38	840	7	str4	String
    //   72	1198	8	str5	String
    //   82	1203	9	str6	String
    //   186	818	10	localJSONObject	org.json.JSONObject
    //   368	294	11	localBundle	android.os.Bundle
    //   239	1167	12	i	int
    //   218	1179	13	j	int
    //   215	969	14	k	int
    //   680	194	15	m	int
    //   52	1177	16	n	int
    //   696	85	17	i1	int
    //   631	805	18	l	long
    //   287	1143	20	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   46	54	1292	org/json/JSONException
    //   56	64	1292	org/json/JSONException
    //   66	74	1292	org/json/JSONException
    //   76	84	1292	org/json/JSONException
    //   86	130	1292	org/json/JSONException
    //   132	177	1292	org/json/JSONException
    //   179	188	1292	org/json/JSONException
    //   190	201	1292	org/json/JSONException
    //   203	214	1292	org/json/JSONException
    //   222	231	1292	org/json/JSONException
    //   233	241	1292	org/json/JSONException
    //   248	258	1292	org/json/JSONException
    //   263	270	1292	org/json/JSONException
    //   272	289	1292	org/json/JSONException
    //   291	318	1292	org/json/JSONException
    //   326	330	1292	org/json/JSONException
    //   332	351	1292	org/json/JSONException
    //   361	370	1292	org/json/JSONException
    //   372	381	1292	org/json/JSONException
    //   383	392	1292	org/json/JSONException
    //   402	412	1292	org/json/JSONException
    //   414	423	1292	org/json/JSONException
    //   425	433	1292	org/json/JSONException
    //   435	444	1292	org/json/JSONException
    //   446	454	1292	org/json/JSONException
    //   456	526	1292	org/json/JSONException
    //   533	541	1292	org/json/JSONException
    //   546	562	1292	org/json/JSONException
    //   564	572	1292	org/json/JSONException
    //   579	587	1292	org/json/JSONException
    //   589	598	1292	org/json/JSONException
    //   600	612	1292	org/json/JSONException
    //   614	623	1292	org/json/JSONException
    //   625	633	1292	org/json/JSONException
    //   635	644	1292	org/json/JSONException
    //   646	667	1292	org/json/JSONException
    //   669	679	1292	org/json/JSONException
    //   684	698	1292	org/json/JSONException
    //   716	765	1292	org/json/JSONException
    //   767	773	1292	org/json/JSONException
    //   775	790	1292	org/json/JSONException
    //   792	805	1292	org/json/JSONException
    //   807	815	1292	org/json/JSONException
    //   817	825	1292	org/json/JSONException
    //   827	835	1292	org/json/JSONException
    //   837	857	1292	org/json/JSONException
    //   859	869	1292	org/json/JSONException
    //   885	908	1292	org/json/JSONException
    //   915	946	1292	org/json/JSONException
    //   949	953	1292	org/json/JSONException
    //   958	967	1292	org/json/JSONException
    //   972	986	1292	org/json/JSONException
    //   991	1001	1292	org/json/JSONException
    //   1003	1015	1292	org/json/JSONException
    //   1017	1027	1292	org/json/JSONException
    //   1029	1042	1292	org/json/JSONException
    //   1044	1054	1292	org/json/JSONException
    //   1056	1067	1292	org/json/JSONException
    //   1080	1090	1292	org/json/JSONException
    //   1092	1105	1292	org/json/JSONException
    //   1107	1117	1292	org/json/JSONException
    //   1119	1130	1292	org/json/JSONException
    //   1132	1147	1292	org/json/JSONException
    //   1149	1159	1292	org/json/JSONException
    //   1161	1169	1292	org/json/JSONException
    //   1171	1181	1292	org/json/JSONException
    //   1190	1259	1292	org/json/JSONException
    //   1261	1291	1292	org/json/JSONException
    //   767	773	1392	java/lang/Exception
  }
  
  protected void onPreExecute()
  {
    if ((this.this$0.mRuntime.a() != null) && ((this.this$0.mRuntime.a() instanceof IphoneTitleBarActivity)))
    {
      this.this$0.isSwitchTheme = Boolean.valueOf(true);
      this.this$0.themeSwitchDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((IphoneTitleBarActivity)this.this$0.mRuntime.a()).getTitleBarHeight());
      this.this$0.themeSwitchDialog.setCancelable(false);
      this.this$0.themeSwitchDialog.b(2131368351);
      if (!this.showDlgTip) {
        this.this$0.themeSwitchDialog.c(false);
      }
      this.this$0.themeSwitchDialog.show();
    }
    for (;;)
    {
      super.onPreExecute();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "activity is not TitleBarActivity");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin$SwitchThemeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */