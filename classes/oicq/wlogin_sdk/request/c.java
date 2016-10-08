package oicq.wlogin_sdk.request;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class c
{
  private static final Object f = new Object();
  private static final Object g = new Object();
  private static b h = null;
  private static b i = null;
  Context a;
  WloginLastLoginInfo b = new WloginLastLoginInfo();
  TreeMap<Long, WloginAllSigInfo> c = new TreeMap();
  TreeMap<String, UinInfo> d = new TreeMap();
  public int e;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.d = a(this.a, "name_file");
    if (this.d == null) {
      this.d = new TreeMap();
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_1
    //   6: ldc 60
    //   8: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +251 -> 262
    //   14: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   17: ifnonnull +17 -> 34
    //   20: new 68	oicq/wlogin_sdk/request/b
    //   23: dup
    //   24: aload_0
    //   25: aload_1
    //   26: aconst_null
    //   27: iconst_1
    //   28: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   31: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   34: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   37: invokevirtual 75	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   45: invokestatic 84	oicq/wlogin_sdk/request/c:c	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: new 86	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   56: ldc 89
    //   58: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 95
    //   67: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 97
    //   76: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload_1
    //   87: iconst_1
    //   88: anewarray 62	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: ldc 105
    //   95: aastore
    //   96: ldc 107
    //   98: aconst_null
    //   99: aconst_null
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 117 1 0
    //   112: ifne +57 -> 169
    //   115: aload_0
    //   116: new 86	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   123: ldc 119
    //   125: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 121
    //   134: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 123
    //   143: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: iconst_2
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: iconst_0
    //   156: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: iconst_1
    //   163: newarray <illegal type>
    //   165: aastore
    //   166: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: new 86	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   177: ldc -122
    //   179: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc -120
    //   188: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc -118
    //   197: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_2
    //   210: aastore
    //   211: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_3
    //   215: ifnull +18 -> 233
    //   218: aload_3
    //   219: invokeinterface 142 1 0
    //   224: ifne +9 -> 233
    //   227: aload_3
    //   228: invokeinterface 145 1 0
    //   233: aload_0
    //   234: ifnull +22 -> 256
    //   237: iconst_1
    //   238: aload_0
    //   239: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   242: if_icmpne +14 -> 256
    //   245: ldc -106
    //   247: ldc -104
    //   249: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   256: iconst_0
    //   257: istore 5
    //   259: iload 5
    //   261: ireturn
    //   262: getstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   265: ifnonnull +17 -> 282
    //   268: new 68	oicq/wlogin_sdk/request/b
    //   271: dup
    //   272: aload_0
    //   273: aload_1
    //   274: aconst_null
    //   275: iconst_1
    //   276: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   279: putstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   282: getstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   285: invokevirtual 75	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   288: astore_0
    //   289: goto -248 -> 41
    //   292: astore 4
    //   294: aconst_null
    //   295: astore_0
    //   296: aload_3
    //   297: astore_2
    //   298: aload 4
    //   300: astore_3
    //   301: aload_1
    //   302: ldc 60
    //   304: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: ifeq +79 -> 386
    //   310: aconst_null
    //   311: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   314: aload_3
    //   315: ldc -104
    //   317: invokestatic 163	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   320: ldc -91
    //   322: ldc -104
    //   324: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: sipush 64514
    //   330: istore 6
    //   332: aload_0
    //   333: ifnull +18 -> 351
    //   336: aload_0
    //   337: invokeinterface 142 1 0
    //   342: ifne +9 -> 351
    //   345: aload_0
    //   346: invokeinterface 145 1 0
    //   351: iload 6
    //   353: istore 5
    //   355: aload_2
    //   356: ifnull -97 -> 259
    //   359: iload 6
    //   361: istore 5
    //   363: iconst_1
    //   364: aload_2
    //   365: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   368: if_icmpne -109 -> 259
    //   371: ldc -106
    //   373: ldc -104
    //   375: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: aload_2
    //   379: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   382: sipush 64514
    //   385: ireturn
    //   386: aconst_null
    //   387: putstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   390: goto -76 -> 314
    //   393: astore_3
    //   394: aload_2
    //   395: astore_1
    //   396: aload_0
    //   397: astore_2
    //   398: aload_3
    //   399: astore_0
    //   400: aload_2
    //   401: ifnull +18 -> 419
    //   404: aload_2
    //   405: invokeinterface 142 1 0
    //   410: ifne +9 -> 419
    //   413: aload_2
    //   414: invokeinterface 145 1 0
    //   419: aload_1
    //   420: ifnull +22 -> 442
    //   423: iconst_1
    //   424: aload_1
    //   425: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   428: if_icmpne +14 -> 442
    //   431: ldc -106
    //   433: ldc -104
    //   435: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_1
    //   439: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   442: aload_0
    //   443: athrow
    //   444: astore_0
    //   445: aconst_null
    //   446: astore_1
    //   447: aload 4
    //   449: astore_2
    //   450: goto -50 -> 400
    //   453: astore_2
    //   454: aload_0
    //   455: astore_1
    //   456: aload_2
    //   457: astore_0
    //   458: aload 4
    //   460: astore_2
    //   461: goto -61 -> 400
    //   464: astore 4
    //   466: aload_3
    //   467: astore_2
    //   468: aload_0
    //   469: astore_1
    //   470: aload 4
    //   472: astore_0
    //   473: goto -73 -> 400
    //   476: astore_3
    //   477: aconst_null
    //   478: astore 4
    //   480: aload_0
    //   481: astore_2
    //   482: aload 4
    //   484: astore_0
    //   485: goto -184 -> 301
    //   488: astore 4
    //   490: aload_0
    //   491: astore_2
    //   492: aload 4
    //   494: astore_0
    //   495: aload_3
    //   496: astore 4
    //   498: aload_0
    //   499: astore_3
    //   500: aload 4
    //   502: astore_0
    //   503: goto -202 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramContext	Context
    //   0	506	1	paramString	String
    //   0	506	2	paramArrayOfByte	byte[]
    //   4	311	3	localObject1	Object
    //   393	74	3	localObject2	Object
    //   476	20	3	localException1	Exception
    //   499	1	3	localContext	Context
    //   1	1	4	localObject3	Object
    //   292	167	4	localException2	Exception
    //   464	7	4	localObject4	Object
    //   478	5	4	localObject5	Object
    //   488	5	4	localException3	Exception
    //   496	5	4	localObject6	Object
    //   257	105	5	j	int
    //   330	30	6	k	int
    // Exception table:
    //   from	to	target	type
    //   5	34	292	java/lang/Exception
    //   34	41	292	java/lang/Exception
    //   262	282	292	java/lang/Exception
    //   282	289	292	java/lang/Exception
    //   301	314	393	finally
    //   314	327	393	finally
    //   386	390	393	finally
    //   5	34	444	finally
    //   34	41	444	finally
    //   262	282	444	finally
    //   282	289	444	finally
    //   41	106	453	finally
    //   106	169	464	finally
    //   169	214	464	finally
    //   41	106	476	java/lang/Exception
    //   106	169	488	java/lang/Exception
    //   169	214	488	java/lang/Exception
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int j = paramInt;
    if (j < paramArrayOfByte1.length - paramArrayOfByte2.length - paramInt)
    {
      k = 0;
      label16:
      if (k >= paramArrayOfByte2.length) {
        break label64;
      }
      if (paramArrayOfByte1[(j + k)] == paramArrayOfByte2[k]) {}
    }
    label64:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        return j;
        k += 1;
        break label16;
      }
      j += 1;
      break;
      return -1;
    }
  }
  
  public static TreeMap a(Context paramContext, String paramString)
  {
    util.LOGI("loadTKTreeMap sigfile " + paramString, "");
    Object localObject1 = b(paramContext, paramString);
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (localObject1 != null)
    {
      util.LOGI("loadTKTreeMap len:" + localObject1.length + " at " + t.l(), "");
      try
      {
        localObject3 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, t.z);
        if (localObject3 != null)
        {
          localObject1 = new ByteArrayInputStream((byte[])localObject3);
          localObject4 = new ObjectInputStream((InputStream)localObject1);
          localObject3 = (TreeMap)((ObjectInputStream)localObject4).readObject();
          ((ObjectInputStream)localObject4).close();
          ((ByteArrayInputStream)localObject1).close();
          if (localObject3 != null)
          {
            util.LOGI("loadTKTreeMap tree size: " + ((TreeMap)localObject3).size(), "");
            if ("tk_file".equals(paramString))
            {
              localObject4 = ((TreeMap)localObject3).keySet().iterator();
              for (;;)
              {
                localObject1 = localObject3;
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject1 = ((Iterator)localObject4).next();
                localObject5 = (WloginAllSigInfo)((TreeMap)localObject3).get(localObject1);
                util.LOGI(localObject1 + " allsig: " + ((WloginAllSigInfo)localObject5)._tk_map, "" + localObject1);
              }
              localObject2 = c(paramContext, paramString);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "");
      }
    }
    for (;;)
    {
      return (TreeMap)localObject2;
      localObject4 = ((TreeMap)localObject3).keySet().iterator();
      for (;;)
      {
        localObject2 = localObject3;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject4).next();
        localObject5 = (UinInfo)((TreeMap)localObject3).get(localObject2);
        if (localObject5 != null) {
          util.LOGI(localObject2 + " is uin: " + ((UinInfo)localObject5)._uin, "");
        }
      }
      util.LOGI("tree is null", "");
      return null;
      localObject4 = new SecretKeySpec(t.z, "DESede");
      localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject4);
      Object localObject2 = new ByteArrayInputStream((byte[])localObject2);
      localObject3 = new ObjectInputStream(new CipherInputStream((InputStream)localObject2, (Cipher)localObject3));
      localObject4 = (TreeMap)((ObjectInputStream)localObject3).readObject();
      if (localObject4 != null)
      {
        ((ObjectInputStream)localObject3).close();
        ((ByteArrayInputStream)localObject2).close();
        return (TreeMap)localObject4;
        util.LOGI("dbdata is null", "");
      }
    }
  }
  
  /* Error */
  public static byte[] b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: invokestatic 293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6: astore 4
    //   8: aload_1
    //   9: ldc 60
    //   11: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +202 -> 216
    //   17: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   20: ifnonnull +17 -> 37
    //   23: new 68	oicq/wlogin_sdk/request/b
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: aconst_null
    //   30: iconst_1
    //   31: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   34: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   37: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   40: invokevirtual 296	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   48: invokestatic 84	oicq/wlogin_sdk/request/c:c	(Ljava/lang/String;)V
    //   51: new 86	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 298
    //   61: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   68: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: ldc -104
    //   76: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: new 86	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 300
    //   90: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 302
    //   100: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aconst_null
    //   107: invokevirtual 306	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore_2
    //   111: aload 4
    //   113: astore_3
    //   114: aload_2
    //   115: invokeinterface 309 1 0
    //   120: ifeq +21 -> 141
    //   123: aload 4
    //   125: astore_3
    //   126: aload_2
    //   127: iconst_0
    //   128: invokeinterface 313 2 0
    //   133: ifle +8 -> 141
    //   136: iconst_1
    //   137: invokestatic 293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   140: astore_3
    //   141: aload_2
    //   142: ifnull +18 -> 160
    //   145: aload_2
    //   146: invokeinterface 142 1 0
    //   151: ifne +9 -> 160
    //   154: aload_2
    //   155: invokeinterface 145 1 0
    //   160: aload_3
    //   161: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   164: istore 6
    //   166: iload 6
    //   168: ifne +78 -> 246
    //   171: aload_2
    //   172: ifnull +18 -> 190
    //   175: aload_2
    //   176: invokeinterface 142 1 0
    //   181: ifne +9 -> 190
    //   184: aload_2
    //   185: invokeinterface 145 1 0
    //   190: aload_0
    //   191: ifnull +23 -> 214
    //   194: iconst_1
    //   195: aload_0
    //   196: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   199: if_icmpne +15 -> 214
    //   202: ldc_w 318
    //   205: ldc -104
    //   207: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_0
    //   211: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   214: aconst_null
    //   215: areturn
    //   216: getstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   219: ifnonnull +17 -> 236
    //   222: new 68	oicq/wlogin_sdk/request/b
    //   225: dup
    //   226: aload_0
    //   227: aload_1
    //   228: aconst_null
    //   229: iconst_1
    //   230: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   233: putstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   236: getstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   239: invokevirtual 296	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   242: astore_0
    //   243: goto -199 -> 44
    //   246: aload_0
    //   247: aload_1
    //   248: iconst_1
    //   249: anewarray 62	java/lang/String
    //   252: dup
    //   253: iconst_0
    //   254: aload_1
    //   255: aastore
    //   256: ldc 107
    //   258: aconst_null
    //   259: aconst_null
    //   260: aconst_null
    //   261: aconst_null
    //   262: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   265: astore_3
    //   266: aload_3
    //   267: ifnonnull +48 -> 315
    //   270: aload_3
    //   271: ifnull +18 -> 289
    //   274: aload_3
    //   275: invokeinterface 142 1 0
    //   280: ifne +9 -> 289
    //   283: aload_3
    //   284: invokeinterface 145 1 0
    //   289: aload_0
    //   290: ifnull +23 -> 313
    //   293: iconst_1
    //   294: aload_0
    //   295: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   298: if_icmpne +15 -> 313
    //   301: ldc_w 318
    //   304: ldc -104
    //   306: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_0
    //   310: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   313: aconst_null
    //   314: areturn
    //   315: aload_3
    //   316: invokeinterface 321 1 0
    //   321: ifeq +62 -> 383
    //   324: aload_3
    //   325: iconst_0
    //   326: invokeinterface 325 2 0
    //   331: astore_2
    //   332: aload_3
    //   333: invokeinterface 145 1 0
    //   338: aload_3
    //   339: ifnull +18 -> 357
    //   342: aload_3
    //   343: invokeinterface 142 1 0
    //   348: ifne +9 -> 357
    //   351: aload_3
    //   352: invokeinterface 145 1 0
    //   357: aload_0
    //   358: ifnull +23 -> 381
    //   361: iconst_1
    //   362: aload_0
    //   363: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   366: if_icmpne +15 -> 381
    //   369: ldc_w 318
    //   372: ldc -104
    //   374: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   381: aload_2
    //   382: areturn
    //   383: aload_3
    //   384: invokeinterface 145 1 0
    //   389: aload_3
    //   390: ifnull +18 -> 408
    //   393: aload_3
    //   394: invokeinterface 142 1 0
    //   399: ifne +9 -> 408
    //   402: aload_3
    //   403: invokeinterface 145 1 0
    //   408: aload_0
    //   409: ifnull +23 -> 432
    //   412: iconst_1
    //   413: aload_0
    //   414: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   417: if_icmpne +15 -> 432
    //   420: ldc_w 318
    //   423: ldc -104
    //   425: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: aload_0
    //   429: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   432: aconst_null
    //   433: areturn
    //   434: astore_3
    //   435: aconst_null
    //   436: astore_0
    //   437: aconst_null
    //   438: astore_2
    //   439: aload_1
    //   440: ldc 60
    //   442: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   445: ifeq +58 -> 503
    //   448: aconst_null
    //   449: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   452: aload_3
    //   453: ldc -104
    //   455: invokestatic 163	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   458: aload_0
    //   459: ifnull +18 -> 477
    //   462: aload_0
    //   463: invokeinterface 142 1 0
    //   468: ifne +9 -> 477
    //   471: aload_0
    //   472: invokeinterface 145 1 0
    //   477: aload_2
    //   478: ifnull +23 -> 501
    //   481: iconst_1
    //   482: aload_2
    //   483: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   486: if_icmpne +15 -> 501
    //   489: ldc_w 318
    //   492: ldc -104
    //   494: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload_2
    //   498: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   501: aconst_null
    //   502: areturn
    //   503: aconst_null
    //   504: putstatic 34	oicq/wlogin_sdk/request/c:i	Loicq/wlogin_sdk/request/b;
    //   507: goto -55 -> 452
    //   510: astore_3
    //   511: aload_0
    //   512: astore_1
    //   513: aload_3
    //   514: astore_0
    //   515: aload_1
    //   516: ifnull +18 -> 534
    //   519: aload_1
    //   520: invokeinterface 142 1 0
    //   525: ifne +9 -> 534
    //   528: aload_1
    //   529: invokeinterface 145 1 0
    //   534: aload_2
    //   535: ifnull +23 -> 558
    //   538: iconst_1
    //   539: aload_2
    //   540: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   543: if_icmpne +15 -> 558
    //   546: ldc_w 318
    //   549: ldc -104
    //   551: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload_2
    //   555: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   558: aload_0
    //   559: athrow
    //   560: astore_0
    //   561: aconst_null
    //   562: astore_2
    //   563: aload_3
    //   564: astore_1
    //   565: goto -50 -> 515
    //   568: astore_1
    //   569: aload_0
    //   570: astore_2
    //   571: aload_1
    //   572: astore_0
    //   573: aload_3
    //   574: astore_1
    //   575: goto -60 -> 515
    //   578: astore_3
    //   579: aload_2
    //   580: astore_1
    //   581: aload_0
    //   582: astore_2
    //   583: aload_3
    //   584: astore_0
    //   585: goto -70 -> 515
    //   588: astore 4
    //   590: aload_3
    //   591: astore_1
    //   592: aload_0
    //   593: astore_2
    //   594: aload 4
    //   596: astore_0
    //   597: goto -82 -> 515
    //   600: astore_3
    //   601: aload_0
    //   602: astore_2
    //   603: aconst_null
    //   604: astore_0
    //   605: goto -166 -> 439
    //   608: astore_3
    //   609: aload_0
    //   610: astore 4
    //   612: aload_2
    //   613: astore_0
    //   614: aload 4
    //   616: astore_2
    //   617: goto -178 -> 439
    //   620: astore 5
    //   622: aload_3
    //   623: astore_2
    //   624: aload_0
    //   625: astore 4
    //   627: aload 5
    //   629: astore_3
    //   630: aload_2
    //   631: astore_0
    //   632: aload 4
    //   634: astore_2
    //   635: goto -196 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramContext	Context
    //   0	638	1	paramString	String
    //   110	525	2	localObject1	Object
    //   1	402	3	localObject2	Object
    //   434	19	3	localException1	Exception
    //   510	64	3	localObject3	Object
    //   578	13	3	localObject4	Object
    //   600	1	3	localException2	Exception
    //   608	15	3	localException3	Exception
    //   629	1	3	localObject5	Object
    //   6	118	4	localBoolean	Boolean
    //   588	7	4	localObject6	Object
    //   610	23	4	localContext	Context
    //   620	8	5	localException4	Exception
    //   164	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	37	434	java/lang/Exception
    //   37	44	434	java/lang/Exception
    //   216	236	434	java/lang/Exception
    //   236	243	434	java/lang/Exception
    //   439	452	510	finally
    //   452	458	510	finally
    //   503	507	510	finally
    //   8	37	560	finally
    //   37	44	560	finally
    //   216	236	560	finally
    //   236	243	560	finally
    //   44	111	568	finally
    //   114	123	578	finally
    //   126	141	578	finally
    //   145	160	578	finally
    //   160	166	578	finally
    //   246	266	578	finally
    //   315	338	588	finally
    //   383	389	588	finally
    //   44	111	600	java/lang/Exception
    //   114	123	608	java/lang/Exception
    //   126	141	608	java/lang/Exception
    //   145	160	608	java/lang/Exception
    //   160	166	608	java/lang/Exception
    //   246	266	608	java/lang/Exception
    //   315	338	620	java/lang/Exception
    //   383	389	620	java/lang/Exception
  }
  
  private static TreeMap c(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.z, "DESede");
      Object localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject3));
      if ((localThrowable2 instanceof FileNotFoundException)) {
        break label118;
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        localObject3 = (TreeMap)((ObjectInputStream)localObject1).readObject();
        paramString = (String)localObject1;
        paramContext = (Context)localObject3;
        if (paramContext != null) {
          break label1327;
        }
        return paramContext;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject5;
          continue;
          int j = 0;
          continue;
          j = 0;
          continue;
          j = 0;
          continue;
          j = 0;
        }
      }
      localThrowable2 = localThrowable2;
      localObject1 = null;
    }
    try
    {
      byte[] arrayOfByte1 = new byte['Ā'];
      localObject5 = paramContext.openFileInput(paramString);
      for (;;)
      {
        j = ((FileInputStream)localObject5).read(arrayOfByte1, 0, arrayOfByte1.length);
        if (j <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string(arrayOfByte1, j));
      }
      try
      {
        localObject4 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
        localObject5 = Cipher.getInstance("DESede");
        ((Cipher)localObject5).init(2, (Key)localObject4);
        localObject4 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject5));
      }
      catch (Throwable localThrowable3) {}
    }
    catch (Exception localException2) {}
    for (;;)
    {
      try
      {
        label118:
        Object localObject4;
        localObject1 = (TreeMap)((ObjectInputStream)localObject4).readObject();
        paramString = (String)localObject4;
        paramContext = (Context)localObject1;
      }
      catch (Throwable localThrowable1)
      {
        byte[] arrayOfByte2;
        byte[] arrayOfByte3;
        Object localObject2 = arrayOfByte2;
        continue;
      }
      ((FileInputStream)localObject5).close();
    }
    for (;;)
    {
      int n;
      label276:
      label314:
      try
      {
        arrayOfByte2 = new byte['Ā'];
        int m = arrayOfByte2.length;
        paramString = paramContext.openFileInput(paramString);
        localObject5 = paramContext.openFileOutput("tmp_tk_file", 0);
        n = paramString.read(arrayOfByte2, 40, m - 40);
        if (n <= 0) {
          break label1292;
        }
        j = 40 + n;
        if (j >= arrayOfByte2.length) {
          break label1352;
        }
        arrayOfByte2[j] = 0;
        j += 1;
        continue;
        if (j < 0) {
          break label1358;
        }
        arrayOfByte3 = new String("WloginAllSigInfo").getBytes();
        j = a(arrayOfByte2, j, arrayOfByte3);
        if (j >= 0) {
          break;
        }
      }
      catch (Exception paramString) {}
      if (j < 0) {
        break label1364;
      }
      arrayOfByte3 = new String("WloginSigInfo").getBytes();
      j = a(arrayOfByte2, j, arrayOfByte3);
      if (j >= 0) {
        break label681;
      }
      break label1364;
      label352:
      if (j < 0) {
        break label1370;
      }
      arrayOfByte3 = new String("WloginSimpleInfo").getBytes();
      j = a(arrayOfByte2, j, arrayOfByte3);
      if (j >= 0) {
        break label874;
      }
      break label1370;
      label390:
      if (j >= 0)
      {
        arrayOfByte3 = new String("UinInfo").getBytes();
        j = a(arrayOfByte2, j, arrayOfByte3);
        if (j >= 0) {
          break label1083;
        }
      }
      ((FileOutputStream)localObject5).write(arrayOfByte2, 40, n);
      if (n > 40) {
        System.arraycopy(arrayOfByte2, n, arrayOfByte2, 0, 40);
      }
    }
    for (;;)
    {
      paramString = (String)localObject1;
      localObject1 = null;
      paramContext.deleteFile("tmp_tk_file");
      paramContext = (Context)localObject1;
      break;
      int k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != -127) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != 64) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != 1) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != 111) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != -111) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != -44) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != 26) {
        break label276;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != -101) {
        break label276;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label276;
      label681:
      k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != 0) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != 0) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != 0) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != 0) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != 0) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != 0) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != 0) {
        break label314;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != 0) {
        break label314;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label314;
      label874:
      k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != 57) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != -69) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != -84) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != 110) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != -46) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != 98) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != -31) {
        break label352;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != -113) {
        break label352;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label352;
      label1083:
      k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != -118) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != -23) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != Byte.MIN_VALUE) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != -19) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != -26) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != 99) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != 41) {
        break label390;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != 14) {
        break label390;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label390;
      label1292:
      paramString.close();
      ((FileOutputStream)localObject5).close();
      paramString = new ObjectInputStream(paramContext.openFileInput("tmp_tk_file"));
      for (;;)
      {
        try
        {
          localObject1 = (TreeMap)paramString.readObject();
        }
        catch (Exception localException1)
        {
          label1327:
          String str = paramString;
        }
        try
        {
          paramString.close();
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
  }
  
  private static void c(String paramString)
  {
    long l = new File(paramString).lastModified();
    util.LOGI("file " + paramString + " last update stample " + l, "");
  }
  
  /* Error */
  public int a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: new 86	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 404
    //   18: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 86	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   35: ldc -104
    //   37: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   54: ifnull +115 -> 169
    //   57: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   60: astore 5
    //   62: aload 5
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   69: ldc 60
    //   71: invokestatic 55	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   74: astore 6
    //   76: iload 9
    //   78: istore 8
    //   80: aload 6
    //   82: ifnull +84 -> 166
    //   85: aload 6
    //   87: lload_1
    //   88: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   91: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: checkcast 240	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   97: astore 7
    //   99: aload 7
    //   101: ifnonnull +14 -> 115
    //   104: iconst_m1
    //   105: istore 8
    //   107: aload 5
    //   109: monitorexit
    //   110: aload_0
    //   111: monitorexit
    //   112: iload 8
    //   114: ireturn
    //   115: ldc_w 411
    //   118: new 86	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   125: ldc -104
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: lload_1
    //   131: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 7
    //   142: lload_3
    //   143: iconst_0
    //   144: newarray <illegal type>
    //   146: invokevirtual 415	oicq/wlogin_sdk/request/WloginAllSigInfo:put_da2	(J[B)I
    //   149: pop
    //   150: aload_0
    //   151: aload 6
    //   153: ldc 60
    //   155: invokevirtual 418	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   158: istore 8
    //   160: aload_0
    //   161: aload 6
    //   163: putfield 46	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   166: aload 5
    //   168: monitorexit
    //   169: new 86	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 420
    //   179: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 8
    //   184: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: new 86	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   197: ldc -104
    //   199: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: lload_1
    //   203: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: goto -102 -> 110
    //   215: astore 5
    //   217: aload_0
    //   218: monitorexit
    //   219: aload 5
    //   221: athrow
    //   222: astore 6
    //   224: aload 5
    //   226: monitorexit
    //   227: aload 6
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	c
    //   0	230	1	paramLong1	long
    //   0	230	3	paramLong2	long
    //   215	10	5	localObject2	Object
    //   74	88	6	localTreeMap	TreeMap
    //   222	6	6	localObject3	Object
    //   97	44	7	localWloginAllSigInfo	WloginAllSigInfo
    //   1	182	8	j	int
    //   4	73	9	k	int
    // Exception table:
    //   from	to	target	type
    //   8	50	215	finally
    //   50	65	215	finally
    //   169	212	215	finally
    //   227	230	215	finally
    //   65	76	222	finally
    //   85	99	222	finally
    //   107	110	222	finally
    //   115	166	222	finally
    //   166	169	222	finally
    //   224	227	222	finally
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
      int j;
      if (localWloginAllSigInfo == null) {
        j = -1;
      }
      for (;;)
      {
        return j;
        j = localWloginAllSigInfo.put_siginfo(paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
        if (this.a != null) {
          synchronized (f)
          {
            paramArrayOfByte2 = a(this.a, "tk_file");
            paramArrayOfByte1 = paramArrayOfByte2;
            if (paramArrayOfByte2 == null) {
              paramArrayOfByte1 = new TreeMap();
            }
            paramArrayOfByte1.put(Long.valueOf(paramLong1), localWloginAllSigInfo.get_clone());
            a(paramArrayOfByte1, "tk_file");
          }
        }
      }
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, byte[] arg5)
  {
    label210:
    label218:
    for (;;)
    {
      try
      {
        Object localObject3 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
        if (localObject3 == null)
        {
          j = -1;
          return j;
        }
        Object localObject1 = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(Long.valueOf(paramLong2));
        if ((localObject1 == null) || (((WloginSigInfo)localObject1)._randseed == null)) {
          break label210;
        }
        localObject1 = (byte[])((WloginSigInfo)localObject1)._randseed.clone();
        int j = ((WloginAllSigInfo)localObject3).put_randseed(paramLong2, ???);
        if (this.a != null)
        {
          synchronized (f)
          {
            TreeMap localTreeMap = a(this.a, "tk_file");
            if (localTreeMap != null)
            {
              localTreeMap.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject3).get_clone());
              j = a(localTreeMap, "tk_file");
              if (j == 0) {
                break label218;
              }
              localObject3 = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(Long.valueOf(paramLong2));
              if (localObject3 == null) {
                break label218;
              }
              ((WloginSigInfo)localObject3)._randseed = ((byte[])((byte[])localObject1).clone());
              break label218;
            }
          }
          continue;
        }
      }
      finally {}
      continue;
      byte[] arrayOfByte = new byte[0];
    }
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[][] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, byte[] paramArrayOfByte17, byte[] paramArrayOfByte18, byte[][] paramArrayOfByte19, long[] paramArrayOfLong, int paramInt)
  {
    label821:
    label828:
    label861:
    label868:
    for (;;)
    {
      try
      {
        util.LOGI("start put_siginfo", "" + paramLong1);
        int j = 0;
        if (this.a != null) {}
        synchronized (f)
        {
          util.LOGI("put_siginfo load file", "" + paramLong1);
          TreeMap localTreeMap = a(this.a, "tk_file");
          if (localTreeMap != null) {
            break label868;
          }
          localTreeMap = new TreeMap();
          localObject2 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label861;
          }
          localObject2 = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label861;
          }
          localObject5 = new WloginAllSigInfo();
          util.LOGI("mainSigMap 0x" + Integer.toHexString(this.e), "" + paramLong1);
          ((WloginAllSigInfo)localObject5).mainSigMap = this.e;
          localObject7 = new byte[0];
          localObject6 = new byte[0];
          byte[] arrayOfByte = new byte[0];
          localObject3 = new byte[0];
          localObject4 = new byte[0];
          Object localObject9 = (WloginSigInfo)((WloginAllSigInfo)localObject5)._tk_map.get(Long.valueOf(paramLong2));
          if (localObject9 == null) {
            break label828;
          }
          localObject2 = localObject6;
          localObject1 = localObject7;
          if (((WloginSigInfo)localObject9)._en_A1 != null)
          {
            localObject1 = (byte[])((WloginSigInfo)localObject9)._en_A1.clone();
            if (((WloginSigInfo)localObject9)._noPicSig == null) {
              break label821;
            }
            localObject2 = (byte[])((WloginSigInfo)localObject9)._noPicSig.clone();
          }
          if (((WloginSigInfo)localObject9)._G != null) {
            arrayOfByte = (byte[])((WloginSigInfo)localObject9)._G.clone();
          }
          if (((WloginSigInfo)localObject9)._dpwd != null) {
            localObject3 = (byte[])((WloginSigInfo)localObject9)._dpwd.clone();
          }
          if (((WloginSigInfo)localObject9)._randseed != null)
          {
            localObject4 = (byte[])((WloginSigInfo)localObject9)._randseed.clone();
            localObject8 = ((WloginSigInfo)localObject9)._psKey;
            localObject9 = ((WloginSigInfo)localObject9)._pt4Token;
            localObject6 = localObject4;
            localObject7 = localObject3;
            localObject4 = localObject1;
            localObject3 = localObject2;
            localObject2 = localObject7;
            localObject1 = localObject6;
            localObject7 = localObject8;
            localObject6 = localObject9;
            if ((paramArrayOfByte19[6] != null) && (paramArrayOfByte19[6].length > 2))
            {
              localObject8 = new HashMap();
              localObject9 = new HashMap();
              HashMap localHashMap1 = new HashMap();
              HashMap localHashMap2 = new HashMap();
              Ticket.parsePsBuf((byte[])localObject7, paramLong5, (Map)localObject8, (Map)localObject9);
              Ticket.parsePsBuf((byte[])localObject6, paramLong5, localHashMap1, localHashMap2);
              Ticket.parseSvrPs(paramArrayOfByte19[6], paramLong5, (Map)localObject8, (Map)localObject9, localHashMap1, localHashMap2);
              paramArrayOfByte19[6] = Ticket.packPsBuf((Map)localObject8, paramLong5, (Map)localObject9);
              paramArrayOfByte19[12] = Ticket.packPsBuf(localHashMap1, paramLong5, localHashMap2);
            }
            ((WloginAllSigInfo)localObject5).put_simpleinfo(paramLong1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6);
            ((WloginAllSigInfo)localObject5).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfByte15, paramArrayOfByte16, paramArrayOfByte17, paramArrayOfByte18, paramArrayOfByte19, paramArrayOfLong, paramInt);
            ((WloginAllSigInfo)localObject5).put_siginfo(paramLong2, paramArrayOfByte1, paramLong5);
            localTreeMap.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject5).get_clone());
            util.LOGI("put_siginfo save file", "" + paramLong1);
            j = a(localTreeMap, "tk_file");
            if (j != 0)
            {
              paramArrayOfByte1 = (WloginSigInfo)((WloginAllSigInfo)localObject5)._tk_map.get(Long.valueOf(paramLong2));
              if (paramArrayOfByte1 != null)
              {
                paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject4).clone());
                paramArrayOfByte1._noPicSig = ((byte[])((byte[])localObject3).clone());
                paramArrayOfByte1._G = ((byte[])arrayOfByte.clone());
                paramArrayOfByte1._dpwd = ((byte[])((byte[])localObject2).clone());
                paramArrayOfByte1._randseed = ((byte[])((byte[])localObject1).clone());
              }
            }
            this.c.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject5).get_clone());
            util.LOGI("put_siginfo end", "" + paramLong1);
            return j;
          }
        }
        continue;
      }
      finally {}
      Object localObject2 = localObject6;
      continue;
      Object localObject8 = new byte[0];
      Object localObject1 = localObject4;
      localObject2 = localObject3;
      Object localObject3 = localObject6;
      Object localObject4 = localObject7;
      Object localObject7 = new byte[0];
      Object localObject6 = localObject8;
      continue;
      Object localObject5 = localObject1;
    }
  }
  
  public int a(TreeMap paramTreeMap, String paramString)
  {
    int j = 0;
    try
    {
      if (("tk_file".equals(paramString)) || ("name_file".equals(paramString))) {
        j = b(paramTreeMap, paramString);
      }
      return j;
    }
    finally {}
  }
  
  /* Error */
  public String a(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   6: invokevirtual 220	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   9: invokeinterface 226 1 0
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 231 1 0
    //   21: ifeq +53 -> 74
    //   24: aload_3
    //   25: invokeinterface 234 1 0
    //   30: checkcast 62	java/lang/String
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   38: aload_2
    //   39: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 256	oicq/wlogin_sdk/request/UinInfo
    //   45: astore 4
    //   47: aload 4
    //   49: ifnull -34 -> 15
    //   52: aload 4
    //   54: getfield 262	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   57: aload_1
    //   58: invokevirtual 516	java/lang/Long:equals	(Ljava/lang/Object;)Z
    //   61: istore 5
    //   63: iload 5
    //   65: ifeq -50 -> 15
    //   68: aload_2
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: areturn
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -6 -> 70
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	c
    //   0	84	1	paramLong	Long
    //   33	36	2	str	String
    //   14	11	3	localIterator	Iterator
    //   45	8	4	localUinInfo	UinInfo
    //   61	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	79	finally
    //   15	47	79	finally
    //   52	63	79	finally
  }
  
  public List<WloginLoginInfo> a(boolean paramBoolean)
  {
    label308:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (this.a == null) {
          break label308;
        }
        TreeMap localTreeMap = a(this.a, "tk_file");
        if (localTreeMap == null) {
          return localArrayList;
        }
        Iterator localIterator1 = localTreeMap.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break label308;
        }
        Long localLong1 = (Long)localIterator1.next();
        Object localObject3 = (WloginAllSigInfo)this.c.get(localLong1);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = (WloginAllSigInfo)localTreeMap.get(localLong1);
          if (localObject1 == null) {
            continue;
          }
          this.c.put(localLong1, localObject1);
        }
        Iterator localIterator2 = ((WloginAllSigInfo)localObject1)._tk_map.keySet().iterator();
        if (localIterator2.hasNext())
        {
          Long localLong2 = (Long)localIterator2.next();
          WloginSigInfo localWloginSigInfo = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(localLong2);
          if (localWloginSigInfo == null) {
            continue;
          }
          String str = a(localLong1);
          localObject3 = str;
          if (str == null) {
            localObject3 = String.valueOf(localLong1);
          }
          if (((WloginAllSigInfo)localObject1)._useInfo._img_url == null) {
            ((WloginAllSigInfo)localObject1)._useInfo._img_url = new byte[0];
          }
          long l1 = localLong1.longValue();
          long l2 = localLong2.longValue();
          str = new String(((WloginAllSigInfo)localObject1)._useInfo._img_url);
          long l3 = localWloginSigInfo._create_time;
          if (paramBoolean)
          {
            j = WloginLoginInfo.TYPE_LOACL;
            localArrayList.add(new WloginLoginInfo((String)localObject3, l1, l2, str, l3, j, localWloginSigInfo._login_bitmap));
          }
        }
        else
        {
          continue;
        }
        int j = WloginLoginInfo.TYPE_REMOTE;
      }
      finally {}
    }
  }
  
  /* Error */
  public UinInfo a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: ifeq +76 -> 79
    //   6: aload_0
    //   7: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   10: aload_1
    //   11: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 256	oicq/wlogin_sdk/request/UinInfo
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +60 -> 79
    //   22: new 86	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 566
    //   32: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 568
    //   42: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: getfield 262	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   49: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 570
    //   55: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 573	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   62: invokevirtual 576	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc -104
    //   70: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: aload_0
    //   80: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   83: ifnonnull +8 -> 91
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: aload_0
    //   92: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   95: ldc 52
    //   97: invokestatic 55	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   100: astore_3
    //   101: aload_3
    //   102: ifnonnull +8 -> 110
    //   105: aconst_null
    //   106: astore_1
    //   107: goto -32 -> 75
    //   110: aload_3
    //   111: aload_1
    //   112: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 256	oicq/wlogin_sdk/request/UinInfo
    //   118: astore_3
    //   119: aload_3
    //   120: ifnonnull +8 -> 128
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -50 -> 75
    //   128: aload_0
    //   129: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 433	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: new 86	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 578
    //   148: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 568
    //   158: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_3
    //   162: getfield 262	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   165: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: ldc_w 570
    //   171: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_3
    //   175: invokevirtual 573	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   178: invokevirtual 576	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: ldc -104
    //   186: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_3
    //   190: astore_1
    //   191: goto -116 -> 75
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	c
    //   0	199	1	paramString	String
    //   0	199	2	paramBoolean	boolean
    //   17	173	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	194	finally
    //   22	73	194	finally
    //   79	86	194	finally
    //   91	101	194	finally
    //   110	119	194	finally
    //   128	189	194	finally
  }
  
  /* Error */
  public WloginAllSigInfo a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 581
    //   5: new 86	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   12: ldc -104
    //   14: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload_1
    //   18: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 46	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   31: lload_1
    //   32: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 240	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +15 -> 58
    //   46: ldc_w 583
    //   49: ldc -104
    //   51: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_3
    //   57: areturn
    //   58: aload_0
    //   59: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   62: ifnonnull +8 -> 70
    //   65: aconst_null
    //   66: astore_3
    //   67: goto -13 -> 54
    //   70: aload_0
    //   71: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   74: ldc 60
    //   76: invokestatic 55	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnonnull +8 -> 89
    //   84: aconst_null
    //   85: astore_3
    //   86: goto -32 -> 54
    //   89: aload_3
    //   90: lload_1
    //   91: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 240	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   100: astore_3
    //   101: aload_3
    //   102: ifnonnull +8 -> 110
    //   105: aconst_null
    //   106: astore_3
    //   107: goto -53 -> 54
    //   110: ldc_w 585
    //   113: ldc -104
    //   115: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: getfield 46	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   122: lload_1
    //   123: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aload_3
    //   127: invokevirtual 433	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: goto -77 -> 54
    //   134: astore_3
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_3
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	c
    //   0	139	1	paramLong	long
    //   41	86	3	localObject1	Object
    //   134	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	134	finally
    //   46	54	134	finally
    //   58	65	134	finally
    //   70	80	134	finally
    //   89	101	134	finally
    //   110	131	134	finally
  }
  
  public void a()
  {
    try
    {
      util.LOGI("refresh_all_siginfo ...", "");
      this.c = a(this.a, "tk_file");
      if (this.c == null) {
        this.c = new TreeMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    for (;;)
    {
      TreeMap localTreeMap;
      try
      {
        util.LOGI("clear_sig uin=" + paramLong1, "");
        ??? = (WloginAllSigInfo)this.c.get(paramLong1);
        if (??? != null)
        {
          ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
          util.LOGI("uin " + paramLong1 + " appid " + paramLong2 + " sig has been cleared");
        }
        if (this.a != null) {}
        synchronized (f)
        {
          localTreeMap = a(this.a, "tk_file");
          if (localTreeMap == null) {
            return;
          }
          paramLong1 = (WloginAllSigInfo)localTreeMap.get(paramLong1);
          if (paramLong1 != null) {}
        }
        paramLong1._tk_map.remove(paramLong2);
      }
      finally {}
      a(localTreeMap, "tk_file");
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 593	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   15: ifnull +52 -> 67
    //   18: getstatic 30	oicq/wlogin_sdk/request/c:g	Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   30: ldc 52
    //   32: invokestatic 55	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: ifnonnull +11 -> 50
    //   42: new 43	java/util/TreeMap
    //   45: dup
    //   46: invokespecial 44	java/util/TreeMap:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: aload_1
    //   52: invokevirtual 593	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload_0
    //   57: aload_2
    //   58: ldc 52
    //   60: invokevirtual 418	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   63: pop
    //   64: aload 4
    //   66: monitorexit
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload 4
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	c
    //   0	81	1	paramString	String
    //   37	21	2	localTreeMap1	TreeMap
    //   35	4	3	localTreeMap2	TreeMap
    // Exception table:
    //   from	to	target	type
    //   26	36	70	finally
    //   42	50	70	finally
    //   50	67	70	finally
    //   71	74	70	finally
    //   2	26	76	finally
    //   74	76	76	finally
  }
  
  /* Error */
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 602
    //   12: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 604
    //   22: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: new 86	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   39: ldc -104
    //   41: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_2
    //   45: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 522	oicq/wlogin_sdk/request/c:a	(Ljava/lang/Long;)Ljava/lang/String;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +13 -> 76
    //   66: aload_0
    //   67: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   70: aload 5
    //   72: invokevirtual 593	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: new 256	oicq/wlogin_sdk/request/UinInfo
    //   79: dup
    //   80: aload_2
    //   81: iload_3
    //   82: invokespecial 607	oicq/wlogin_sdk/request/UinInfo:<init>	(Ljava/lang/Long;Z)V
    //   85: astore 7
    //   87: aload_0
    //   88: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   91: aload_1
    //   92: aload 7
    //   94: invokevirtual 433	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_0
    //   99: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   102: ifnull +69 -> 171
    //   105: getstatic 30	oicq/wlogin_sdk/request/c:g	Ljava/lang/Object;
    //   108: astore 6
    //   110: aload 6
    //   112: monitorenter
    //   113: aload_0
    //   114: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   117: ldc 52
    //   119: invokestatic 55	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   122: astore 4
    //   124: aload 4
    //   126: astore_2
    //   127: aload 4
    //   129: ifnonnull +11 -> 140
    //   132: new 43	java/util/TreeMap
    //   135: dup
    //   136: invokespecial 44	java/util/TreeMap:<init>	()V
    //   139: astore_2
    //   140: aload 5
    //   142: ifnull +10 -> 152
    //   145: aload_2
    //   146: aload 5
    //   148: invokevirtual 593	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: aload_2
    //   153: aload_1
    //   154: aload 7
    //   156: invokevirtual 433	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: aload_0
    //   161: aload_2
    //   162: ldc 52
    //   164: invokevirtual 418	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   167: pop
    //   168: aload 6
    //   170: monitorexit
    //   171: aload_0
    //   172: monitorexit
    //   173: return
    //   174: astore_1
    //   175: aload 6
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	c
    //   0	185	1	paramString	String
    //   0	185	2	paramLong	Long
    //   0	185	3	paramBoolean	boolean
    //   122	6	4	localTreeMap	TreeMap
    //   59	88	5	str	String
    //   85	70	7	localUinInfo	UinInfo
    // Exception table:
    //   from	to	target	type
    //   113	124	174	finally
    //   132	140	174	finally
    //   145	152	174	finally
    //   152	171	174	finally
    //   175	178	174	finally
    //   2	61	180	finally
    //   66	76	180	finally
    //   76	113	180	finally
    //   178	180	180	finally
  }
  
  public int b(TreeMap paramTreeMap, String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramTreeMap);
      localObjectOutputStream.flush();
      paramTreeMap = localByteArrayOutputStream.toByteArray();
      paramTreeMap = cryptor.encrypt(paramTreeMap, 0, paramTreeMap.length, t.z);
      j = a(this.a, paramString, paramTreeMap);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return j;
    }
    catch (Throwable paramTreeMap)
    {
      for (;;)
      {
        util.LOGI("saveTKTreeMap failed " + paramTreeMap.getStackTrace().toString(), "");
        util.printThrowable(paramTreeMap, "");
        int j = 64514;
      }
    }
    finally {}
  }
  
  /* Error */
  public WloginSimpleInfo b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 642
    //   5: new 86	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 644
    //   15: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 647	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: lload_1
    //   30: invokevirtual 649	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull +9 -> 44
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: aload_3
    //   45: getfield 529	oicq/wlogin_sdk/request/WloginAllSigInfo:_useInfo	Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   48: invokevirtual 652	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:get_clone	()Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   51: astore_3
    //   52: goto -12 -> 40
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	c
    //   0	60	1	paramLong	long
    //   33	19	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	55	finally
    //   44	52	55	finally
  }
  
  /* Error */
  public void b(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 655
    //   12: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 86	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   29: ldc -104
    //   31: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 46	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 240	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   58: astore 5
    //   60: aload 5
    //   62: ifnonnull +6 -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload 5
    //   70: getfield 248	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   73: lload_3
    //   74: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 436	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   83: astore 6
    //   85: aload 6
    //   87: ifnull -22 -> 65
    //   90: aload 6
    //   92: iconst_0
    //   93: newarray <illegal type>
    //   95: putfield 481	oicq/wlogin_sdk/sharemem/WloginSigInfo:_pt4Token	[B
    //   98: aload 6
    //   100: iconst_0
    //   101: newarray <illegal type>
    //   103: putfield 478	oicq/wlogin_sdk/sharemem/WloginSigInfo:_psKey	[B
    //   106: aload 6
    //   108: aconst_null
    //   109: putfield 659	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheTickets	Ljava/util/List;
    //   112: aload 6
    //   114: lconst_0
    //   115: putfield 662	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheUpdateStamp	J
    //   118: aload 5
    //   120: getfield 248	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   123: lload_1
    //   124: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aload 6
    //   129: invokevirtual 433	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_0
    //   134: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   137: ifnull -72 -> 65
    //   140: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   143: astore 6
    //   145: aload 6
    //   147: monitorenter
    //   148: aload_0
    //   149: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   152: ldc 60
    //   154: invokestatic 55	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   157: astore 7
    //   159: aload 7
    //   161: ifnull +30 -> 191
    //   164: aload 7
    //   166: lload_1
    //   167: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   170: aload 5
    //   172: invokevirtual 433	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload_0
    //   177: aload 7
    //   179: ldc 60
    //   181: invokevirtual 418	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   184: pop
    //   185: aload_0
    //   186: aload 7
    //   188: putfield 46	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   191: aload 6
    //   193: monitorexit
    //   194: goto -129 -> 65
    //   197: astore 5
    //   199: aload 6
    //   201: monitorexit
    //   202: aload 5
    //   204: athrow
    //   205: astore 5
    //   207: aload_0
    //   208: monitorexit
    //   209: aload 5
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	c
    //   0	212	1	paramLong1	long
    //   0	212	3	paramLong2	long
    //   58	113	5	localWloginAllSigInfo	WloginAllSigInfo
    //   197	6	5	localObject1	Object
    //   205	5	5	localObject2	Object
    //   157	30	7	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   148	159	197	finally
    //   164	191	197	finally
    //   191	194	197	finally
    //   199	202	197	finally
    //   2	60	205	finally
    //   68	85	205	finally
    //   90	148	205	finally
    //   202	205	205	finally
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 593	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 86	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 664
    //   21: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: ldc -104
    //   33: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   40: ifnull +25 -> 65
    //   43: getstatic 30	oicq/wlogin_sdk/request/c:g	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 50	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   53: ldc 52
    //   55: invokestatic 55	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnonnull +8 -> 68
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_3
    //   69: aload_1
    //   70: invokevirtual 593	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: aload_0
    //   75: aload_3
    //   76: ldc 52
    //   78: invokevirtual 418	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   81: pop
    //   82: aload_2
    //   83: monitorexit
    //   84: goto -19 -> 65
    //   87: astore_1
    //   88: aload_2
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	c
    //   0	97	1	paramString	String
    //   58	18	3	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   49	59	87	finally
    //   63	65	87	finally
    //   68	84	87	finally
    //   88	90	87	finally
    //   2	49	92	finally
    //   90	92	92	finally
  }
  
  /* Error */
  public WloginSigInfo c(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 667
    //   12: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 86	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   29: lload_1
    //   30: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc -104
    //   35: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: lload_1
    //   46: invokevirtual 649	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnonnull +11 -> 64
    //   56: aconst_null
    //   57: astore 5
    //   59: aload_0
    //   60: monitorexit
    //   61: aload 5
    //   63: areturn
    //   64: new 86	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 669
    //   74: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 5
    //   79: getfield 248	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   82: invokevirtual 216	java/util/TreeMap:size	()I
    //   85: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc_w 671
    //   91: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 5
    //   96: getfield 248	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   99: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: new 86	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   112: lload_1
    //   113: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: ldc -104
    //   118: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 5
    //   129: getfield 248	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   132: lload_3
    //   133: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   136: invokevirtual 238	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 436	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   142: astore 5
    //   144: aload 5
    //   146: ifnonnull +9 -> 155
    //   149: aconst_null
    //   150: astore 5
    //   152: goto -93 -> 59
    //   155: new 86	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 673
    //   165: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: lload_3
    //   169: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: ldc_w 671
    //   175: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 5
    //   180: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: new 86	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   193: lload_1
    //   194: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: ldc -104
    //   199: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: goto -149 -> 59
    //   211: astore 5
    //   213: aload_0
    //   214: monitorexit
    //   215: aload 5
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	c
    //   0	218	1	paramLong1	long
    //   0	218	3	paramLong2	long
    //   49	130	5	localObject1	Object
    //   211	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	51	211	finally
    //   64	144	211	finally
    //   155	208	211	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */