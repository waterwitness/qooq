import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class bl
  extends AsyncTask
{
  public bl(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  protected Uri a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 7
    //   10: aload_1
    //   11: iconst_0
    //   12: aaload
    //   13: checkcast 27	android/content/Context
    //   16: astore 9
    //   18: aload_1
    //   19: iconst_1
    //   20: aaload
    //   21: checkcast 29	android/net/Uri
    //   24: astore 10
    //   26: getstatic 35	com/tencent/mobileqq/app/AppConstants:bB	Ljava/lang/String;
    //   29: astore 8
    //   31: aload 9
    //   33: invokevirtual 39	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   36: aload 10
    //   38: iconst_1
    //   39: anewarray 41	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc 43
    //   46: aastore
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 49	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +385 -> 440
    //   58: aload_1
    //   59: invokeinterface 55 1 0
    //   64: ifeq +376 -> 440
    //   67: aload_1
    //   68: iconst_0
    //   69: invokeinterface 59 2 0
    //   74: astore 5
    //   76: aload_1
    //   77: invokeinterface 62 1 0
    //   82: aload 8
    //   84: invokestatic 67	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   87: ifne +16 -> 103
    //   90: new 69	java/io/File
    //   93: dup
    //   94: aload 8
    //   96: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 75	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: new 77	java/io/FileOutputStream
    //   106: dup
    //   107: new 69	java/io/File
    //   110: dup
    //   111: new 79	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   118: aload 8
    //   120: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 5
    //   125: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   137: astore 4
    //   139: aload 7
    //   141: astore_1
    //   142: aload_3
    //   143: astore_2
    //   144: aload 9
    //   146: invokevirtual 39	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   149: aload 10
    //   151: ldc 93
    //   153: invokevirtual 97	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   156: invokevirtual 103	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   159: astore_3
    //   160: aload_3
    //   161: astore_1
    //   162: aload_3
    //   163: astore_2
    //   164: sipush 1024
    //   167: newarray <illegal type>
    //   169: astore 6
    //   171: aload_3
    //   172: astore_1
    //   173: aload_3
    //   174: astore_2
    //   175: aload_3
    //   176: aload 6
    //   178: invokevirtual 109	java/io/InputStream:read	([B)I
    //   181: istore 11
    //   183: iload 11
    //   185: iconst_m1
    //   186: if_icmpeq +73 -> 259
    //   189: aload_3
    //   190: astore_1
    //   191: aload_3
    //   192: astore_2
    //   193: aload 4
    //   195: aload 6
    //   197: iconst_0
    //   198: iload 11
    //   200: invokevirtual 113	java/io/FileOutputStream:write	([BII)V
    //   203: goto -32 -> 171
    //   206: astore_3
    //   207: aload 4
    //   209: astore_2
    //   210: aload_3
    //   211: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 117	java/io/InputStream:close	()V
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   230: new 79	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   237: ldc 120
    //   239: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 8
    //   244: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 5
    //   249: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 124	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   258: areturn
    //   259: aload_3
    //   260: astore_1
    //   261: aload_3
    //   262: astore_2
    //   263: aload 4
    //   265: invokevirtual 127	java/io/FileOutputStream:flush	()V
    //   268: aload_3
    //   269: ifnull +7 -> 276
    //   272: aload_3
    //   273: invokevirtual 117	java/io/InputStream:close	()V
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   286: new 79	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   293: ldc 120
    //   295: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 8
    //   300: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 5
    //   305: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 124	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   314: areturn
    //   315: astore_1
    //   316: aload_1
    //   317: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   320: goto -44 -> 276
    //   323: astore_1
    //   324: aload_1
    //   325: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   328: goto -42 -> 286
    //   331: astore_1
    //   332: aload_1
    //   333: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   336: goto -114 -> 222
    //   339: astore_1
    //   340: aload_1
    //   341: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   344: goto -114 -> 230
    //   347: astore_3
    //   348: aconst_null
    //   349: astore 4
    //   351: aload_2
    //   352: astore_1
    //   353: aload_1
    //   354: ifnull +7 -> 361
    //   357: aload_1
    //   358: invokevirtual 117	java/io/InputStream:close	()V
    //   361: aload 4
    //   363: ifnull +8 -> 371
    //   366: aload 4
    //   368: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   371: new 79	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   378: ldc 120
    //   380: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload 8
    //   385: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 5
    //   390: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 124	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   399: pop
    //   400: aload_3
    //   401: athrow
    //   402: astore_1
    //   403: aload_1
    //   404: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   407: goto -46 -> 361
    //   410: astore_1
    //   411: aload_1
    //   412: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   415: goto -44 -> 371
    //   418: astore_3
    //   419: aload_2
    //   420: astore_1
    //   421: goto -68 -> 353
    //   424: astore_3
    //   425: aload_2
    //   426: astore 4
    //   428: goto -75 -> 353
    //   431: astore_3
    //   432: aconst_null
    //   433: astore_2
    //   434: aload 6
    //   436: astore_1
    //   437: goto -227 -> 210
    //   440: ldc -126
    //   442: astore 5
    //   444: goto -362 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	bl
    //   0	447	1	paramVarArgs	Object[]
    //   4	430	2	localObject1	Object
    //   6	186	3	localFileInputStream	java.io.FileInputStream
    //   206	67	3	localException1	Exception
    //   347	54	3	localObject2	Object
    //   418	1	3	localObject3	Object
    //   424	1	3	localObject4	Object
    //   431	1	3	localException2	Exception
    //   137	290	4	localObject5	Object
    //   74	369	5	str1	String
    //   1	434	6	arrayOfByte	byte[]
    //   8	132	7	localObject6	Object
    //   29	355	8	str2	String
    //   16	129	9	localContext	android.content.Context
    //   24	126	10	localUri	Uri
    //   181	18	11	i	int
    // Exception table:
    //   from	to	target	type
    //   144	160	206	java/lang/Exception
    //   164	171	206	java/lang/Exception
    //   175	183	206	java/lang/Exception
    //   193	203	206	java/lang/Exception
    //   263	268	206	java/lang/Exception
    //   272	276	315	java/io/IOException
    //   281	286	323	java/io/IOException
    //   218	222	331	java/io/IOException
    //   226	230	339	java/io/IOException
    //   82	103	347	finally
    //   103	139	347	finally
    //   357	361	402	java/io/IOException
    //   366	371	410	java/io/IOException
    //   144	160	418	finally
    //   164	171	418	finally
    //   175	183	418	finally
    //   193	203	418	finally
    //   263	268	418	finally
    //   210	214	424	finally
    //   82	103	431	java/lang/Exception
    //   103	139	431	java/lang/Exception
  }
  
  protected void a(Uri paramUri)
  {
    paramUri = paramUri.getPath();
    if (!TextUtils.isEmpty(paramUri))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramUri);
      this.a.a(localArrayList, 0);
    }
    do
    {
      do
      {
        return;
      } while (this.a.isFinishing());
      if (Build.VERSION.SDK_INT < 17) {
        break;
      }
    } while (this.a.isDestroyed());
    LiteActivity.a(this.a);
    return;
    LiteActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */