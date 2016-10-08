package com.tencent.beacon.d;

import android.content.Context;
import android.os.Environment;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.f;

public final class b
{
  private final Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  private static String d()
  {
    // Byte code:
    //   0: new 22	java/io/File
    //   3: dup
    //   4: invokestatic 28	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: ldc 30
    //   9: invokespecial 33	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 35	java/io/FileInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 38	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: aload_1
    //   23: invokevirtual 42	java/io/File:length	()J
    //   26: l2i
    //   27: newarray <illegal type>
    //   29: astore_1
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 46	java/io/FileInputStream:read	([B)I
    //   35: pop
    //   36: aload_0
    //   37: invokevirtual 49	java/io/FileInputStream:close	()V
    //   40: aload_1
    //   41: iconst_3
    //   42: ldc 51
    //   44: invokestatic 57	com/tencent/beacon/a/f:b	([BILjava/lang/String;)[B
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +18 -> 67
    //   52: new 59	java/lang/String
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 62	java/lang/String:<init>	([B)V
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 49	java/io/FileInputStream:close	()V
    //   65: aload_1
    //   66: areturn
    //   67: aload_0
    //   68: invokevirtual 49	java/io/FileInputStream:close	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull -6 -> 71
    //   80: aload_0
    //   81: invokevirtual 49	java/io/FileInputStream:close	()V
    //   84: goto -13 -> 71
    //   87: astore_0
    //   88: goto -17 -> 71
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: ifnull -24 -> 71
    //   98: aload_0
    //   99: invokevirtual 49	java/io/FileInputStream:close	()V
    //   102: goto -31 -> 71
    //   105: astore_0
    //   106: goto -35 -> 71
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 49	java/io/FileInputStream:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_0
    //   123: aload_1
    //   124: areturn
    //   125: astore_0
    //   126: goto -55 -> 71
    //   129: astore_0
    //   130: goto -10 -> 120
    //   133: astore_1
    //   134: goto -22 -> 112
    //   137: astore_1
    //   138: goto -44 -> 94
    //   141: astore_1
    //   142: goto -66 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	47	0	localFileInputStream	java.io.FileInputStream
    //   73	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   75	6	0	localObject1	Object
    //   87	1	0	localIOException1	java.io.IOException
    //   91	1	0	localIOException2	java.io.IOException
    //   93	6	0	localObject2	Object
    //   105	1	0	localIOException3	java.io.IOException
    //   111	6	0	localObject3	Object
    //   122	1	0	localIOException4	java.io.IOException
    //   125	1	0	localIOException5	java.io.IOException
    //   129	1	0	localIOException6	java.io.IOException
    //   12	54	1	localObject4	Object
    //   109	15	1	str	String
    //   133	1	1	localObject5	Object
    //   137	1	1	localIOException7	java.io.IOException
    //   141	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   13	22	73	java/io/FileNotFoundException
    //   80	84	87	java/io/IOException
    //   13	22	91	java/io/IOException
    //   98	102	105	java/io/IOException
    //   13	22	109	finally
    //   61	65	122	java/io/IOException
    //   67	71	125	java/io/IOException
    //   116	120	129	java/io/IOException
    //   22	48	133	finally
    //   52	61	133	finally
    //   22	48	137	java/io/IOException
    //   52	61	137	java/io/IOException
    //   22	48	141	java/io/FileNotFoundException
    //   52	61	141	java/io/FileNotFoundException
  }
  
  public final String a()
  {
    Object localObject2 = com.tencent.beacon.a.b.b(this.a, "QIMEI_DENGTA", "");
    a.b("Load QIMEI from share preference, QIMEI is %s.", new Object[] { localObject2 });
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).trim().equals("")) {}
    }
    else
    {
      f.a(this.a);
      if (!Environment.getExternalStorageState().equals("mounted")) {
        break label157;
      }
    }
    label157:
    for (int i = 1;; i = 0)
    {
      localObject1 = localObject2;
      if (i != 0)
      {
        localObject2 = d();
        a.b("Load QIMEI from SDCard, QIMEI is %s.", new Object[] { localObject2 });
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).trim().equals(""))
          {
            a.b("Save QIMEI to shared prefs: %s.", new Object[] { localObject2 });
            com.tencent.beacon.a.b.a(this.a, "QIMEI_DENGTA", (String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      a.b("Return QIMEI %s.", new Object[] { localObject2 });
      return (String)localObject2;
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +15 -> 16
    //   4: aload_1
    //   5: invokevirtual 81	java/lang/String:trim	()Ljava/lang/String;
    //   8: ldc 66
    //   10: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 13	com/tencent/beacon/d/b:a	Landroid/content/Context;
    //   21: invokestatic 88	com/tencent/beacon/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/f;
    //   24: pop
    //   25: invokestatic 91	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   28: ldc 93
    //   30: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +108 -> 141
    //   36: iconst_1
    //   37: istore 4
    //   39: iload 4
    //   41: ifeq +75 -> 116
    //   44: new 22	java/io/File
    //   47: dup
    //   48: invokestatic 28	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   51: ldc 30
    //   53: invokespecial 33	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_3
    //   59: aload_2
    //   60: invokevirtual 108	java/io/File:getParentFile	()Ljava/io/File;
    //   63: invokevirtual 112	java/io/File:mkdirs	()Z
    //   66: pop
    //   67: aload_2
    //   68: invokevirtual 115	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: new 117	java/io/FileOutputStream
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_2
    //   81: aload_2
    //   82: aload_1
    //   83: invokevirtual 122	java/lang/String:getBytes	()[B
    //   86: iconst_3
    //   87: ldc 51
    //   89: invokestatic 124	com/tencent/beacon/a/f:a	([BILjava/lang/String;)[B
    //   92: invokevirtual 127	java/io/FileOutputStream:write	([B)V
    //   95: aload_2
    //   96: invokevirtual 130	java/io/FileOutputStream:flush	()V
    //   99: aload_2
    //   100: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   103: ldc -123
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: invokestatic 78	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 13	com/tencent/beacon/d/b:a	Landroid/content/Context;
    //   120: ldc 64
    //   122: aload_1
    //   123: invokestatic 102	com/tencent/beacon/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   126: pop
    //   127: ldc -121
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: aastore
    //   137: invokestatic 78	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: return
    //   141: iconst_0
    //   142: istore 4
    //   144: goto -105 -> 39
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_2
    //   151: ifnull -48 -> 103
    //   154: aload_2
    //   155: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   158: goto -55 -> 103
    //   161: astore_2
    //   162: goto -59 -> 103
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull -66 -> 103
    //   172: aload_2
    //   173: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   176: goto -73 -> 103
    //   179: astore_2
    //   180: goto -77 -> 103
    //   183: astore_1
    //   184: aload_3
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_2
    //   197: goto -94 -> 103
    //   200: astore_2
    //   201: goto -7 -> 194
    //   204: astore_1
    //   205: goto -19 -> 186
    //   208: astore_3
    //   209: goto -41 -> 168
    //   212: astore_3
    //   213: goto -63 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	b
    //   0	216	1	paramString	String
    //   56	44	2	localObject1	Object
    //   147	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   149	6	2	localObject2	Object
    //   161	1	2	localIOException1	java.io.IOException
    //   165	1	2	localIOException2	java.io.IOException
    //   167	6	2	localObject3	Object
    //   179	1	2	localIOException3	java.io.IOException
    //   185	6	2	localObject4	Object
    //   196	1	2	localIOException4	java.io.IOException
    //   200	1	2	localIOException5	java.io.IOException
    //   58	127	3	localObject5	Object
    //   208	1	3	localIOException6	java.io.IOException
    //   212	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   37	106	4	i	int
    // Exception table:
    //   from	to	target	type
    //   59	81	147	java/io/FileNotFoundException
    //   154	158	161	java/io/IOException
    //   59	81	165	java/io/IOException
    //   172	176	179	java/io/IOException
    //   59	81	183	finally
    //   99	103	196	java/io/IOException
    //   190	194	200	java/io/IOException
    //   81	99	204	finally
    //   81	99	208	java/io/IOException
    //   81	99	212	java/io/FileNotFoundException
  }
  
  public final boolean b()
  {
    return (f.n().equals(com.tencent.beacon.a.b.b(this.a, "GEN_QIMEI", ""))) && (com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI_TIMES") >= d.a().g());
  }
  
  public final void c()
  {
    int i = com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI_TIMES");
    if (!f.n().equals(com.tencent.beacon.a.b.b(this.a, "GEN_QIMEI", "")))
    {
      com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI", f.n());
      i = 0;
    }
    com.tencent.beacon.a.b.a(this.a, "GEN_QIMEI_TIMES", i + 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */