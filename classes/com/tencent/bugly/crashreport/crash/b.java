package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.j;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static int b = 0;
  protected e a;
  private Context c;
  private n d;
  private com.tencent.bugly.crashreport.common.strategy.a e;
  private com.tencent.bugly.proguard.a f;
  
  public b(int paramInt, Context paramContext, s params, n paramn, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.proguard.a parama1, e parame)
  {
    b = paramInt;
    this.c = paramContext;
    this.d = paramn;
    this.e = parama;
    this.f = parama1;
    this.a = parame;
  }
  
  private static CrashDetailBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      paramCursor = null;
    }
    for (;;)
    {
      return paramCursor;
      try
      {
        Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        if (localObject == null) {
          return null;
        }
        long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localObject = (CrashDetailBean)com.tencent.bugly.proguard.a.a((byte[])localObject, CrashDetailBean.CREATOR);
        paramCursor = (Cursor)localObject;
        if (localObject != null)
        {
          ((CrashDetailBean)localObject).a = l;
          return (CrashDetailBean)localObject;
        }
      }
      catch (Throwable paramCursor)
      {
        if (!v.a(paramCursor)) {
          paramCursor.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramList = paramCrashDetailBean;
      return paramList;
    }
    Object localObject1 = null;
    Object localObject2 = new ArrayList(10);
    Object localObject3 = paramList.iterator();
    a locala;
    while (((Iterator)localObject3).hasNext())
    {
      locala = (a)((Iterator)localObject3).next();
      if (locala.e) {
        ((List)localObject2).add(locala);
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject3 = b((List)localObject2);
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        Collections.sort((List)localObject3);
        int i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject2 = (CrashDetailBean)((List)localObject3).get(i);
          if (i == 0)
          {
            localObject1 = localObject2;
            label156:
            i += 1;
          }
          else
          {
            if (((CrashDetailBean)localObject2).s == null) {
              break label518;
            }
            localObject2 = ((CrashDetailBean)localObject2).s.split("\n");
            if (localObject2 == null) {
              break label518;
            }
            int k = localObject2.length;
            int j = 0;
            while (j < k)
            {
              locala = localObject2[j];
              if (!((CrashDetailBean)localObject1).s.contains(locala))
              {
                ((CrashDetailBean)localObject1).t += 1;
                ((CrashDetailBean)localObject1).s = (((CrashDetailBean)localObject1).s + locala + "\n");
              }
              j += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        paramCrashDetailBean.j = true;
        paramCrashDetailBean.t = 0;
        paramCrashDetailBean.s = "";
        localObject1 = paramCrashDetailBean;
      }
      for (;;)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (a)paramList.next();
          if ((!((a)localObject2).e) && (!((a)localObject2).d) && (!((CrashDetailBean)localObject1).s.contains(((a)localObject2).b)))
          {
            ((CrashDetailBean)localObject1).t += 1;
            ((CrashDetailBean)localObject1).s = (((CrashDetailBean)localObject1).s + ((a)localObject2).b + "\n");
          }
        }
        paramList = (List<a>)localObject1;
        if (((CrashDetailBean)localObject1).r == paramCrashDetailBean.r) {
          break;
        }
        paramList = (List<a>)localObject1;
        if (((CrashDetailBean)localObject1).s.contains(paramCrashDetailBean.r)) {
          break;
        }
        ((CrashDetailBean)localObject1).t += 1;
        ((CrashDetailBean)localObject1).s = (((CrashDetailBean)localObject1).s + paramCrashDetailBean.r + "\n");
        return (CrashDetailBean)localObject1;
      }
      label518:
      break label156;
      localObject1 = null;
    }
  }
  
  /* Error */
  private static ag a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +15 -> 20
    //   8: ldc -76
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 183	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: aconst_null
    //   19: areturn
    //   20: ldc -71
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_2
    //   29: aastore
    //   30: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: new 189	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: new 189	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 198	android/content/Context:getCacheDir	()Ljava/io/File;
    //   51: aload_0
    //   52: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore_3
    //   56: aload_2
    //   57: aload_3
    //   58: sipush 5000
    //   61: invokestatic 204	com/tencent/bugly/proguard/a:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   64: ifne +15 -> 79
    //   67: ldc -50
    //   69: iconst_0
    //   70: anewarray 4	java/lang/Object
    //   73: invokestatic 183	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   76: pop
    //   77: aconst_null
    //   78: areturn
    //   79: new 208	java/io/ByteArrayOutputStream
    //   82: dup
    //   83: invokespecial 209	java/io/ByteArrayOutputStream:<init>	()V
    //   86: astore_2
    //   87: new 211	java/io/FileInputStream
    //   90: dup
    //   91: aload_3
    //   92: invokespecial 214	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: aload_1
    //   97: astore_0
    //   98: sipush 1000
    //   101: newarray <illegal type>
    //   103: astore 4
    //   105: aload_1
    //   106: astore_0
    //   107: aload_1
    //   108: aload 4
    //   110: invokevirtual 218	java/io/FileInputStream:read	([B)I
    //   113: istore 5
    //   115: iload 5
    //   117: ifle +71 -> 188
    //   120: aload_1
    //   121: astore_0
    //   122: aload_2
    //   123: aload 4
    //   125: iconst_0
    //   126: iload 5
    //   128: invokevirtual 222	java/io/ByteArrayOutputStream:write	([BII)V
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 225	java/io/ByteArrayOutputStream:flush	()V
    //   137: goto -32 -> 105
    //   140: astore_2
    //   141: aload_1
    //   142: astore_0
    //   143: aload_2
    //   144: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   147: ifne +9 -> 156
    //   150: aload_1
    //   151: astore_0
    //   152: aload_2
    //   153: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 228	java/io/FileInputStream:close	()V
    //   164: aload_3
    //   165: invokevirtual 231	java/io/File:exists	()Z
    //   168: ifeq -150 -> 18
    //   171: ldc -23
    //   173: iconst_0
    //   174: anewarray 4	java/lang/Object
    //   177: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   180: pop
    //   181: aload_3
    //   182: invokevirtual 236	java/io/File:delete	()Z
    //   185: pop
    //   186: aconst_null
    //   187: areturn
    //   188: aload_1
    //   189: astore_0
    //   190: aload_2
    //   191: invokevirtual 240	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   194: astore_2
    //   195: aload_1
    //   196: astore_0
    //   197: ldc -14
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_2
    //   206: arraylength
    //   207: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: aastore
    //   211: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: aload_1
    //   216: astore_0
    //   217: new 250	com/tencent/bugly/proguard/ag
    //   220: dup
    //   221: iconst_2
    //   222: aload_3
    //   223: invokevirtual 253	java/io/File:getName	()Ljava/lang/String;
    //   226: aload_2
    //   227: invokespecial 256	com/tencent/bugly/proguard/ag:<init>	(BLjava/lang/String;[B)V
    //   230: astore_2
    //   231: aload_1
    //   232: invokevirtual 228	java/io/FileInputStream:close	()V
    //   235: aload_3
    //   236: invokevirtual 231	java/io/File:exists	()Z
    //   239: ifeq +18 -> 257
    //   242: ldc -23
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: aload_3
    //   253: invokevirtual 236	java/io/File:delete	()Z
    //   256: pop
    //   257: aload_2
    //   258: areturn
    //   259: astore_0
    //   260: aload_0
    //   261: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   264: ifne -29 -> 235
    //   267: aload_0
    //   268: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   271: goto -36 -> 235
    //   274: astore_0
    //   275: aload_0
    //   276: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   279: ifne -115 -> 164
    //   282: aload_0
    //   283: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   286: goto -122 -> 164
    //   289: astore_1
    //   290: aconst_null
    //   291: astore_0
    //   292: aload_0
    //   293: ifnull +7 -> 300
    //   296: aload_0
    //   297: invokevirtual 228	java/io/FileInputStream:close	()V
    //   300: aload_3
    //   301: invokevirtual 231	java/io/File:exists	()Z
    //   304: ifeq +18 -> 322
    //   307: ldc -23
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   316: pop
    //   317: aload_3
    //   318: invokevirtual 236	java/io/File:delete	()Z
    //   321: pop
    //   322: aload_1
    //   323: athrow
    //   324: astore_0
    //   325: aload_0
    //   326: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   329: ifne -29 -> 300
    //   332: aload_0
    //   333: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   336: goto -36 -> 300
    //   339: astore_1
    //   340: goto -48 -> 292
    //   343: astore_2
    //   344: aconst_null
    //   345: astore_1
    //   346: goto -205 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramString1	String
    //   0	349	1	paramContext	Context
    //   0	349	2	paramString2	String
    //   55	263	3	localFile	java.io.File
    //   103	21	4	arrayOfByte	byte[]
    //   113	14	5	i	int
    // Exception table:
    //   from	to	target	type
    //   98	105	140	java/lang/Throwable
    //   107	115	140	java/lang/Throwable
    //   122	131	140	java/lang/Throwable
    //   133	137	140	java/lang/Throwable
    //   190	195	140	java/lang/Throwable
    //   197	215	140	java/lang/Throwable
    //   217	231	140	java/lang/Throwable
    //   231	235	259	java/io/IOException
    //   160	164	274	java/io/IOException
    //   87	96	289	finally
    //   296	300	324	java/io/IOException
    //   98	105	339	finally
    //   107	115	339	finally
    //   122	131	339	finally
    //   133	137	339	finally
    //   143	150	339	finally
    //   152	156	339	finally
    //   190	195	339	finally
    //   197	215	339	finally
    //   217	231	339	finally
    //   87	96	343	java/lang/Throwable
  }
  
  private static ah a(Context paramContext, CrashDetailBean paramCrashDetailBean, com.tencent.bugly.crashreport.common.info.a parama)
  {
    boolean bool2 = true;
    if ((paramContext == null) || (paramCrashDetailBean == null) || (parama == null))
    {
      v.d("enExp args == null", new Object[0]);
      return null;
    }
    ah localah = new ah();
    Object localObject1;
    Map.Entry localEntry;
    ae localae;
    switch (paramCrashDetailBean.b)
    {
    default: 
      v.e("crash type error! %d", new Object[] { Integer.valueOf(paramCrashDetailBean.b) });
      localah.b = paramCrashDetailBean.r;
      localah.c = paramCrashDetailBean.n;
      localah.d = paramCrashDetailBean.o;
      localah.e = paramCrashDetailBean.p;
      localah.g = paramCrashDetailBean.q;
      localah.h = paramCrashDetailBean.y;
      localah.i = paramCrashDetailBean.c;
      localah.j = null;
      localah.l = paramCrashDetailBean.m;
      localah.m = paramCrashDetailBean.e;
      localah.f = paramCrashDetailBean.A;
      localah.t = com.tencent.bugly.crashreport.common.info.a.a().g();
      localah.n = null;
      if ((paramCrashDetailBean.i != null) && (paramCrashDetailBean.i.size() > 0))
      {
        localah.o = new ArrayList();
        localObject1 = paramCrashDetailBean.i.entrySet().iterator();
      }
      break;
    case 3: 
    case 7: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 6: 
    case 5: 
      while (((Iterator)localObject1).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        localae = new ae();
        localae.a = ((PlugInBean)localEntry.getValue()).a;
        localae.c = ((PlugInBean)localEntry.getValue()).c;
        localae.d = ((PlugInBean)localEntry.getValue()).b;
        localae.b = parama.p();
        localah.o.add(localae);
        continue;
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "203";; localObject1 = "103")
        {
          localah.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "208";; localObject1 = "108")
        {
          localah.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "200";; localObject1 = "100")
        {
          localah.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "201";; localObject1 = "101")
        {
          localah.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "202";; localObject1 = "102")
        {
          localah.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "204";; localObject1 = "104")
        {
          localah.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "206";; localObject1 = "106")
        {
          localah.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "207";; localObject1 = "107")
        {
          localah.a = ((String)localObject1);
          break;
        }
      }
    }
    if ((paramCrashDetailBean.h != null) && (paramCrashDetailBean.h.size() > 0))
    {
      localah.p = new ArrayList();
      localObject1 = paramCrashDetailBean.h.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        localae = new ae();
        localae.a = ((PlugInBean)localEntry.getValue()).a;
        localae.c = ((PlugInBean)localEntry.getValue()).c;
        localae.d = ((PlugInBean)localEntry.getValue()).b;
        localah.p.add(localae);
      }
    }
    if (paramCrashDetailBean.j)
    {
      localah.k = paramCrashDetailBean.t;
      if ((paramCrashDetailBean.s != null) && (paramCrashDetailBean.s.length() > 0)) {
        if (localah.q == null) {
          localah.q = new ArrayList();
        }
      }
    }
    label2822:
    Object localObject3;
    long l;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    try
    {
      localah.q.add(new ag((byte)1, "alltimes.txt", paramCrashDetailBean.s.getBytes("utf-8")));
      int j = localah.k;
      if (localah.q != null)
      {
        i = localah.q.size();
        v.c("crashcount:%d sz:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        if (paramCrashDetailBean.w != null) {
          if (localah.q == null) {
            localah.q = new ArrayList();
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException4)
    {
      try
      {
        localah.q.add(new ag((byte)1, "log.txt", paramCrashDetailBean.w.getBytes("utf-8")));
        if ((paramCrashDetailBean.T != null) || (paramCrashDetailBean.T.length() > 0)) {
          if (localah.q == null) {
            localah.q = new ArrayList();
          }
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException4)
      {
        try
        {
          localObject1 = new ag((byte)1, "crashInfos.txt", paramCrashDetailBean.T.getBytes("utf-8"));
          if (localObject1 != null)
          {
            v.c("attach crash infos", new Object[0]);
            localah.q.add(localObject1);
          }
          if (paramCrashDetailBean.U != null)
          {
            if (localah.q == null) {
              localah.q = new ArrayList();
            }
            localObject1 = a("backupRecord.zip", paramContext, paramCrashDetailBean.U);
            if (localObject1 != null)
            {
              v.c("attach backup record", new Object[0]);
              localah.q.add(localObject1);
            }
          }
          if ((paramCrashDetailBean.x != null) && (paramCrashDetailBean.x.length > 0))
          {
            localObject1 = new ag((byte)2, "buglylog.zip", paramCrashDetailBean.x);
            v.c("attach user log", new Object[0]);
            if (localah.q == null) {
              localah.q = new ArrayList();
            }
            localah.q.add(localObject1);
          }
          if (paramCrashDetailBean.b == 3)
          {
            if (localah.q == null) {
              localah.q = new ArrayList();
            }
            if ((paramCrashDetailBean.N == null) || (!paramCrashDetailBean.N.containsKey("BUGLY_CR_01"))) {}
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException4)
        {
          try
          {
            localah.q.add(new ag((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.N.get("BUGLY_CR_01")).getBytes("utf-8")));
            v.c("attach anr message", new Object[0]);
            paramCrashDetailBean.N.remove("BUGLY_CR_01");
            if (paramCrashDetailBean.v != null)
            {
              localObject1 = a("trace.zip", paramContext, paramCrashDetailBean.v);
              if (localObject1 != null)
              {
                v.c("attach traces", new Object[0]);
                localah.q.add(localObject1);
              }
            }
            if (paramCrashDetailBean.b == 1)
            {
              if (localah.q == null) {
                localah.q = new ArrayList();
              }
              if (paramCrashDetailBean.v != null)
              {
                paramContext = a("tomb.zip", paramContext, paramCrashDetailBean.v);
                if (paramContext != null)
                {
                  v.c("attach tombs", new Object[0]);
                  localah.q.add(paramContext);
                }
              }
            }
            if ((paramCrashDetailBean.S != null) && (paramCrashDetailBean.S.length > 0))
            {
              if (localah.q == null) {
                localah.q = new ArrayList();
              }
              localah.q.add(new ag((byte)1, "userExtraByteData", paramCrashDetailBean.S));
              v.c("attach extraData", new Object[0]);
            }
            localah.r = new HashMap();
            localah.r.put("A9", paramCrashDetailBean.B);
            localah.r.put("A11", paramCrashDetailBean.C);
            localah.r.put("A10", paramCrashDetailBean.D);
            localah.r.put("A23", paramCrashDetailBean.f);
            localah.r.put("A7", parama.g);
            localah.r.put("A6", parama.q());
            localah.r.put("A5", parama.p());
            localah.r.put("A22", parama.f());
            localah.r.put("A2", paramCrashDetailBean.F);
            localah.r.put("A1", paramCrashDetailBean.E);
            localah.r.put("A24", parama.i);
            localah.r.put("A17", paramCrashDetailBean.G);
            localah.r.put("A3", parama.i());
            localah.r.put("A16", parama.k());
            localah.r.put("A25", parama.l());
            localah.r.put("A14", parama.j());
            localah.r.put("A15", parama.u());
            localah.r.put("A13", parama.v());
            localah.r.put("A34", paramCrashDetailBean.z);
            if (parama.y != null) {
              localah.r.put("productIdentify", parama.y);
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException4)
          {
            try
            {
              for (;;)
              {
                localah.r.put("A26", URLEncoder.encode(paramCrashDetailBean.H, "utf-8"));
                if (paramCrashDetailBean.b == 1)
                {
                  localah.r.put("A27", paramCrashDetailBean.J);
                  localah.r.put("A28", paramCrashDetailBean.I);
                  localah.r.put("A29", paramCrashDetailBean.k);
                }
                localah.r.put("A30", paramCrashDetailBean.K);
                localah.r.put("A18", paramCrashDetailBean.L);
                paramContext = localah.r;
                localObject1 = new StringBuilder();
                if (paramCrashDetailBean.M) {
                  break;
                }
                bool1 = true;
                paramContext.put("A36", bool1);
                localah.r.put("F02", parama.s);
                localah.r.put("F03", parama.t);
                localah.r.put("F04", parama.c());
                localah.r.put("F05", parama.u);
                localah.r.put("F06", parama.r);
                localah.r.put("F08", parama.w);
                localah.r.put("F09", parama.x);
                localah.r.put("F10", parama.v);
                if (paramCrashDetailBean.O >= 0) {
                  localah.r.put("C01", paramCrashDetailBean.O);
                }
                if (paramCrashDetailBean.P >= 0) {
                  localah.r.put("C02", paramCrashDetailBean.P);
                }
                if ((paramCrashDetailBean.Q == null) || (paramCrashDetailBean.Q.size() <= 0)) {
                  break label2822;
                }
                paramContext = paramCrashDetailBean.Q.entrySet().iterator();
                while (paramContext.hasNext())
                {
                  localObject1 = (Map.Entry)paramContext.next();
                  localah.r.put("C03_" + (String)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
                }
                localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                localUnsupportedEncodingException1.printStackTrace();
                localah.q = null;
                continue;
                int i = 0;
                continue;
                localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                localUnsupportedEncodingException2.printStackTrace();
                localah.q = null;
                continue;
                localUnsupportedEncodingException3 = localUnsupportedEncodingException3;
                localUnsupportedEncodingException3.printStackTrace();
                Object localObject2 = null;
              }
              localUnsupportedEncodingException4 = localUnsupportedEncodingException4;
              localUnsupportedEncodingException4.printStackTrace();
              localah.q = null;
            }
            catch (UnsupportedEncodingException paramContext)
            {
              for (;;)
              {
                paramContext.printStackTrace();
                continue;
                bool1 = false;
              }
              if ((paramCrashDetailBean.R != null) && (paramCrashDetailBean.R.size() > 0))
              {
                paramContext = paramCrashDetailBean.R.entrySet().iterator();
                while (paramContext.hasNext())
                {
                  localObject3 = (Map.Entry)paramContext.next();
                  localah.r.put("C04_" + (String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
                }
              }
              localah.s = null;
              if ((paramCrashDetailBean.N != null) && (paramCrashDetailBean.N.size() > 0))
              {
                localah.s = paramCrashDetailBean.N;
                v.a("setted message size %d", new Object[] { Integer.valueOf(localah.s.size()) });
              }
              paramContext = paramCrashDetailBean.n;
              localObject3 = paramCrashDetailBean.c;
              parama = parama.c();
              l = (paramCrashDetailBean.r - paramCrashDetailBean.L) / 1000L;
              bool3 = paramCrashDetailBean.k;
              bool4 = paramCrashDetailBean.M;
              bool5 = paramCrashDetailBean.j;
              if (paramCrashDetailBean.b != 1) {}
            }
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      v.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", new Object[] { paramContext, localObject3, parama, Long.valueOf(l), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Integer.valueOf(paramCrashDetailBean.t), paramCrashDetailBean.s, Boolean.valueOf(paramCrashDetailBean.d), Integer.valueOf(localah.r.size()) });
      return localah;
    }
  }
  
  private static ai a(Context paramContext, List<CrashDetailBean> paramList, com.tencent.bugly.crashreport.common.info.a parama)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() == 0) || (parama == null))
    {
      v.d("enEXPPkg args == null!", new Object[0]);
      return null;
    }
    parama.r();
    ai localai = new ai();
    localai.a = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CrashDetailBean localCrashDetailBean = (CrashDetailBean)paramList.next();
      localai.a.add(a(paramContext, localCrashDetailBean, parama));
    }
    return localai;
  }
  
  private static List<a> a(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    long l = com.tencent.bugly.proguard.a.e();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if ((locala.d) && (locala.b < l - 86400000L)) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Thread paramThread, String paramString4, CrashDetailBean paramCrashDetailBean)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.a();
    if (locala == null) {
      return;
    }
    v.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
    v.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
    v.e("# PKG NAME: %s", new Object[] { locala.c });
    v.e("# APP VER: %s", new Object[] { locala.l });
    v.e("# LAUNCH TIME: %s", new Object[] { com.tencent.bugly.proguard.a.a(new Date(com.tencent.bugly.crashreport.common.info.a.a().a)) });
    v.e("# CRASH TYPE: %s", new Object[] { paramString1 });
    v.e("# CRASH TIME: %s", new Object[] { paramString2 });
    v.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
    if (paramThread != null) {
      v.e("# CRASH THREAD: %s", new Object[] { paramThread.getName() });
    }
    if (paramCrashDetailBean != null)
    {
      v.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
      paramString2 = locala.h;
      if (locala.v().booleanValue())
      {
        paramString1 = "ROOTED";
        v.e("# CRASH DEVICE: %s %s", new Object[] { paramString2, paramString1 });
        v.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.B), Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D) });
        v.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.E), Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G) });
        paramString1 = paramCrashDetailBean.J;
        if ((paramString1 == null) || (paramString1.trim().length() <= 0)) {
          break label439;
        }
        i = 0;
        label343:
        if (i != 0) {
          break label445;
        }
        v.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.J, paramCrashDetailBean.I });
      }
    }
    else
    {
      label375:
      if ((paramString4 == null) || (paramString4.trim().length() <= 0)) {
        break label517;
      }
    }
    label439:
    label445:
    label517:
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        v.e("# CRASH STACK: ", new Object[0]);
        v.e(paramString4, new Object[0]);
      }
      v.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
      return;
      paramString1 = "UNROOT";
      break;
      i = 1;
      break label343;
      if (paramCrashDetailBean.b != 3) {
        break label375;
      }
      if (paramCrashDetailBean.N == null) {}
      for (paramString1 = "null";; paramString1 = (String)paramCrashDetailBean.N.get("BUGLY_CR_01"))
      {
        v.e("# EXCEPTION ANR MESSAGE:\n %s", new Object[] { paramString1 });
        break;
      }
    }
  }
  
  public static void a(boolean paramBoolean, List<CrashDetailBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      v.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
      Iterator localIterator = paramList.iterator();
      CrashDetailBean localCrashDetailBean;
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        v.c("pre uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(localCrashDetailBean.l), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
        localCrashDetailBean.l += 1;
        localCrashDetailBean.d = paramBoolean;
        v.c("set uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(localCrashDetailBean.l), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
      }
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        c.a().a(localCrashDetailBean);
      }
      v.c("update state size %d", new Object[] { Integer.valueOf(paramList.size()) });
    }
    if (!paramBoolean) {
      v.b("[crash] upload fail.", new Object[0]);
    }
  }
  
  private static a b(Cursor paramCursor)
  {
    boolean bool2 = true;
    if (paramCursor == null) {}
    for (;;)
    {
      return null;
      try
      {
        a locala = new a();
        locala.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        locala.b = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        locala.c = paramCursor.getString(paramCursor.getColumnIndex("_s1"));
        if (paramCursor.getInt(paramCursor.getColumnIndex("_up")) == 1)
        {
          bool1 = true;
          locala.d = bool1;
          if (paramCursor.getInt(paramCursor.getColumnIndex("_me")) != 1) {
            break label150;
          }
        }
        label150:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          locala.e = bool1;
          locala.f = paramCursor.getInt(paramCursor.getColumnIndex("_uc"));
          return locala;
          bool1 = false;
          break;
        }
        if (v.a(paramCursor)) {}
      }
      catch (Throwable paramCursor) {}
    }
    paramCursor.printStackTrace();
    return null;
  }
  
  /* Error */
  private List<a> b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 89	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 337	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: invokestatic 842	com/tencent/bugly/proguard/n:a	()Lcom/tencent/bugly/proguard/n;
    //   13: ldc_w 844
    //   16: bipush 6
    //   18: anewarray 136	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 54
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc_w 817
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: ldc_w 819
    //   37: aastore
    //   38: dup
    //   39: iconst_3
    //   40: ldc_w 826
    //   43: aastore
    //   44: dup
    //   45: iconst_4
    //   46: ldc_w 832
    //   49: aastore
    //   50: dup
    //   51: iconst_5
    //   52: ldc_w 834
    //   55: aastore
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: iconst_1
    //   60: invokevirtual 847	com/tencent/bugly/proguard/n:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/m;Z)Landroid/database/Cursor;
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_1
    //   67: ifnonnull +24 -> 91
    //   70: aload_1
    //   71: ifnull +18 -> 89
    //   74: aload_1
    //   75: invokeinterface 850 1 0
    //   80: ifne +9 -> 89
    //   83: aload_1
    //   84: invokeinterface 851 1 0
    //   89: aconst_null
    //   90: areturn
    //   91: new 142	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   98: astore_2
    //   99: aload_1
    //   100: invokeinterface 854 1 0
    //   105: ifeq +139 -> 244
    //   108: aload_1
    //   109: invokestatic 856	com/tencent/bugly/crashreport/crash/b:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/a;
    //   112: astore 4
    //   114: aload 4
    //   116: ifnull +48 -> 164
    //   119: aload_3
    //   120: aload 4
    //   122: invokeinterface 115 2 0
    //   127: pop
    //   128: goto -29 -> 99
    //   131: astore_2
    //   132: aload_2
    //   133: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   136: ifne +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   143: aload_1
    //   144: ifnull +18 -> 162
    //   147: aload_1
    //   148: invokeinterface 850 1 0
    //   153: ifne +9 -> 162
    //   156: aload_1
    //   157: invokeinterface 851 1 0
    //   162: aload_3
    //   163: areturn
    //   164: aload_1
    //   165: aload_1
    //   166: ldc 54
    //   168: invokeinterface 48 2 0
    //   173: invokeinterface 58 2 0
    //   178: lstore 5
    //   180: aload_2
    //   181: ldc_w 858
    //   184: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc_w 860
    //   190: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: lload 5
    //   195: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: goto -100 -> 99
    //   202: astore 4
    //   204: ldc_w 862
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 183	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -116 -> 99
    //   218: astore_3
    //   219: aload_1
    //   220: astore_2
    //   221: aload_3
    //   222: astore_1
    //   223: aload_2
    //   224: ifnull +18 -> 242
    //   227: aload_2
    //   228: invokeinterface 850 1 0
    //   233: ifne +9 -> 242
    //   236: aload_2
    //   237: invokeinterface 851 1 0
    //   242: aload_1
    //   243: athrow
    //   244: aload_2
    //   245: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 411	java/lang/String:length	()I
    //   253: ifle +45 -> 298
    //   256: aload_2
    //   257: iconst_4
    //   258: invokevirtual 865	java/lang/String:substring	(I)Ljava/lang/String;
    //   261: astore_2
    //   262: ldc_w 867
    //   265: iconst_2
    //   266: anewarray 4	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: ldc_w 844
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: invokestatic 842	com/tencent/bugly/proguard/n:a	()Lcom/tencent/bugly/proguard/n;
    //   280: ldc_w 844
    //   283: aload_2
    //   284: aconst_null
    //   285: aconst_null
    //   286: iconst_1
    //   287: invokevirtual 870	com/tencent/bugly/proguard/n:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/m;Z)I
    //   290: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: aastore
    //   294: invokestatic 183	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   297: pop
    //   298: aload_1
    //   299: ifnull +18 -> 317
    //   302: aload_1
    //   303: invokeinterface 850 1 0
    //   308: ifne +9 -> 317
    //   311: aload_1
    //   312: invokeinterface 851 1 0
    //   317: aload_3
    //   318: areturn
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_2
    //   322: goto -99 -> 223
    //   325: astore_3
    //   326: aload_1
    //   327: astore_2
    //   328: aload_3
    //   329: astore_1
    //   330: goto -107 -> 223
    //   333: astore_2
    //   334: goto -202 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	b
    //   1	311	1	localObject1	Object
    //   319	8	1	localObject2	Object
    //   329	1	1	localObject3	Object
    //   63	36	2	localObject4	Object
    //   131	50	2	localThrowable1	Throwable
    //   220	108	2	localObject5	Object
    //   333	1	2	localThrowable2	Throwable
    //   9	154	3	localArrayList	ArrayList
    //   218	100	3	localList	List<a>
    //   325	4	3	localObject6	Object
    //   112	9	4	locala	a
    //   202	1	4	localThrowable3	Throwable
    //   178	16	5	l	long
    // Exception table:
    //   from	to	target	type
    //   91	99	131	java/lang/Throwable
    //   99	114	131	java/lang/Throwable
    //   119	128	131	java/lang/Throwable
    //   204	215	131	java/lang/Throwable
    //   244	298	131	java/lang/Throwable
    //   164	199	202	java/lang/Throwable
    //   91	99	218	finally
    //   99	114	218	finally
    //   119	128	218	finally
    //   164	199	218	finally
    //   204	215	218	finally
    //   244	298	218	finally
    //   10	64	319	finally
    //   132	143	325	finally
    //   10	64	333	java/lang/Throwable
  }
  
  /* Error */
  private List<CrashDetailBean> b(List<a> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 87 1 0
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 142	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: aload_1
    //   24: invokeinterface 96 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 102 1 0
    //   36: ifeq +37 -> 73
    //   39: aload_1
    //   40: invokeinterface 106 1 0
    //   45: checkcast 108	com/tencent/bugly/crashreport/crash/a
    //   48: astore_2
    //   49: aload_3
    //   50: ldc_w 858
    //   53: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 860
    //   59: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_2
    //   63: getfield 815	com/tencent/bugly/crashreport/crash/a:a	J
    //   66: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: goto -40 -> 30
    //   73: aload_3
    //   74: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_2
    //   79: astore_1
    //   80: aload_2
    //   81: invokevirtual 411	java/lang/String:length	()I
    //   84: ifle +9 -> 93
    //   87: aload_2
    //   88: iconst_4
    //   89: invokevirtual 865	java/lang/String:substring	(I)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_3
    //   94: iconst_0
    //   95: invokevirtual 874	java/lang/StringBuilder:setLength	(I)V
    //   98: invokestatic 842	com/tencent/bugly/proguard/n:a	()Lcom/tencent/bugly/proguard/n;
    //   101: ldc_w 844
    //   104: aconst_null
    //   105: aload_1
    //   106: aconst_null
    //   107: aconst_null
    //   108: iconst_1
    //   109: invokevirtual 847	com/tencent/bugly/proguard/n:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/m;Z)Landroid/database/Cursor;
    //   112: astore_1
    //   113: aload_1
    //   114: ifnonnull +24 -> 138
    //   117: aload_1
    //   118: ifnull +18 -> 136
    //   121: aload_1
    //   122: invokeinterface 850 1 0
    //   127: ifne +9 -> 136
    //   130: aload_1
    //   131: invokeinterface 851 1 0
    //   136: aconst_null
    //   137: areturn
    //   138: new 89	java/util/ArrayList
    //   141: dup
    //   142: invokespecial 337	java/util/ArrayList:<init>	()V
    //   145: astore_2
    //   146: aload_1
    //   147: invokeinterface 854 1 0
    //   152: ifeq +139 -> 291
    //   155: aload_1
    //   156: invokestatic 876	com/tencent/bugly/crashreport/crash/b:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull +48 -> 211
    //   166: aload_2
    //   167: aload 4
    //   169: invokeinterface 115 2 0
    //   174: pop
    //   175: goto -29 -> 146
    //   178: astore_2
    //   179: aload_2
    //   180: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   183: ifne +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   190: aload_1
    //   191: ifnull +18 -> 209
    //   194: aload_1
    //   195: invokeinterface 850 1 0
    //   200: ifne +9 -> 209
    //   203: aload_1
    //   204: invokeinterface 851 1 0
    //   209: aconst_null
    //   210: areturn
    //   211: aload_1
    //   212: aload_1
    //   213: ldc 54
    //   215: invokeinterface 48 2 0
    //   220: invokeinterface 58 2 0
    //   225: lstore 5
    //   227: aload_3
    //   228: ldc_w 858
    //   231: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 860
    //   237: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: lload 5
    //   242: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: goto -100 -> 146
    //   249: astore 4
    //   251: ldc_w 862
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 183	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   261: pop
    //   262: goto -116 -> 146
    //   265: astore_3
    //   266: aload_1
    //   267: astore_2
    //   268: aload_3
    //   269: astore_1
    //   270: aload_2
    //   271: ifnull +18 -> 289
    //   274: aload_2
    //   275: invokeinterface 850 1 0
    //   280: ifne +9 -> 289
    //   283: aload_2
    //   284: invokeinterface 851 1 0
    //   289: aload_1
    //   290: athrow
    //   291: aload_3
    //   292: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore_3
    //   296: aload_3
    //   297: invokevirtual 411	java/lang/String:length	()I
    //   300: ifle +45 -> 345
    //   303: aload_3
    //   304: iconst_4
    //   305: invokevirtual 865	java/lang/String:substring	(I)Ljava/lang/String;
    //   308: astore_3
    //   309: ldc_w 867
    //   312: iconst_2
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: ldc_w 844
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: invokestatic 842	com/tencent/bugly/proguard/n:a	()Lcom/tencent/bugly/proguard/n;
    //   327: ldc_w 844
    //   330: aload_3
    //   331: aconst_null
    //   332: aconst_null
    //   333: iconst_1
    //   334: invokevirtual 870	com/tencent/bugly/proguard/n:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/m;Z)I
    //   337: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: invokestatic 183	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   344: pop
    //   345: aload_1
    //   346: ifnull +18 -> 364
    //   349: aload_1
    //   350: invokeinterface 850 1 0
    //   355: ifne +9 -> 364
    //   358: aload_1
    //   359: invokeinterface 851 1 0
    //   364: aload_2
    //   365: areturn
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_2
    //   369: goto -99 -> 270
    //   372: astore_3
    //   373: aload_1
    //   374: astore_2
    //   375: aload_3
    //   376: astore_1
    //   377: goto -107 -> 270
    //   380: astore_2
    //   381: aconst_null
    //   382: astore_1
    //   383: goto -204 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	b
    //   0	386	1	paramList	List<a>
    //   48	119	2	localObject1	Object
    //   178	9	2	localThrowable1	Throwable
    //   267	108	2	localList	List<a>
    //   380	1	2	localThrowable2	Throwable
    //   22	206	3	localStringBuilder	StringBuilder
    //   265	27	3	localObject2	Object
    //   295	36	3	str	String
    //   372	4	3	localObject3	Object
    //   159	9	4	localCrashDetailBean	CrashDetailBean
    //   249	1	4	localThrowable3	Throwable
    //   225	16	5	l	long
    // Exception table:
    //   from	to	target	type
    //   138	146	178	java/lang/Throwable
    //   146	161	178	java/lang/Throwable
    //   166	175	178	java/lang/Throwable
    //   251	262	178	java/lang/Throwable
    //   291	345	178	java/lang/Throwable
    //   211	246	249	java/lang/Throwable
    //   138	146	265	finally
    //   146	161	265	finally
    //   166	175	265	finally
    //   211	246	265	finally
    //   251	262	265	finally
    //   291	345	265	finally
    //   98	113	366	finally
    //   179	190	372	finally
    //   98	113	380	java/lang/Throwable
  }
  
  private static void c(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (a)paramList.next();
        localStringBuilder.append(" or _id").append(" = ").append(((a)localObject).a);
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<a>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        v.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(n.a().a("t_cr", paramList, null, null, true)) });
        return;
      }
      catch (Throwable paramList) {}
    } while (v.a(paramList));
    paramList.printStackTrace();
  }
  
  private static ContentValues d(CrashDetailBean paramCrashDetailBean)
  {
    int j = 1;
    if (paramCrashDetailBean == null) {}
    for (;;)
    {
      return null;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramCrashDetailBean.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramCrashDetailBean.a));
        }
        localContentValues.put("_tm", Long.valueOf(paramCrashDetailBean.r));
        localContentValues.put("_s1", paramCrashDetailBean.u);
        if (paramCrashDetailBean.d)
        {
          i = 1;
          localContentValues.put("_up", Integer.valueOf(i));
          if (!paramCrashDetailBean.j) {
            break label154;
          }
        }
        label154:
        for (int i = j;; i = 0)
        {
          localContentValues.put("_me", Integer.valueOf(i));
          localContentValues.put("_uc", Integer.valueOf(paramCrashDetailBean.l));
          Parcel localParcel = Parcel.obtain();
          paramCrashDetailBean.writeToParcel(localParcel, 0);
          paramCrashDetailBean = localParcel.marshall();
          localParcel.recycle();
          localContentValues.put("_dt", paramCrashDetailBean);
          return localContentValues;
          i = 0;
          break;
        }
        if (v.a(paramCrashDetailBean)) {}
      }
      catch (Throwable paramCrashDetailBean) {}
    }
    paramCrashDetailBean.printStackTrace();
    return null;
  }
  
  private static void d(List<CrashDetailBean> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() == 0) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        paramList = paramList.iterator();
        Object localObject;
        while (paramList.hasNext())
        {
          localObject = (CrashDetailBean)paramList.next();
          localStringBuilder.append(" or _id").append(" = ").append(((CrashDetailBean)localObject).a);
        }
        return;
      }
      catch (Throwable paramList)
      {
        if (!v.a(paramList))
        {
          paramList.printStackTrace();
          return;
          localObject = localStringBuilder.toString();
          paramList = (List<CrashDetailBean>)localObject;
          if (((String)localObject).length() > 0) {
            paramList = ((String)localObject).substring(4);
          }
          localStringBuilder.setLength(0);
          v.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(n.a().a("t_cr", paramList, null, null, true)) });
        }
      }
    }
  }
  
  /* Error */
  private boolean e(CrashDetailBean paramCrashDetailBean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc_w 920
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   16: pop
    //   17: invokestatic 324	com/tencent/bugly/crashreport/common/info/a:a	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 922	com/tencent/bugly/crashreport/common/info/a:d	()Ljava/lang/String;
    //   25: astore_3
    //   26: aload_2
    //   27: getfield 736	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   30: astore 6
    //   32: aload_1
    //   33: getfield 581	com/tencent/bugly/crashreport/crash/CrashDetailBean:z	Ljava/lang/String;
    //   36: astore 7
    //   38: getstatic 928	java/util/Locale:US	Ljava/util/Locale;
    //   41: astore 8
    //   43: aload_2
    //   44: invokevirtual 932	java/lang/Object:getClass	()Ljava/lang/Class;
    //   47: pop
    //   48: aload 8
    //   50: ldc_w 934
    //   53: bipush 9
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_3
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload 6
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: ldc_w 936
    //   72: aastore
    //   73: dup
    //   74: iconst_3
    //   75: aload 7
    //   77: aastore
    //   78: dup
    //   79: iconst_4
    //   80: new 740	java/util/Date
    //   83: dup
    //   84: aload_1
    //   85: getfield 173	com/tencent/bugly/crashreport/crash/CrashDetailBean:r	J
    //   88: invokespecial 744	java/util/Date:<init>	(J)V
    //   91: invokestatic 747	com/tencent/bugly/proguard/a:a	(Ljava/util/Date;)Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_5
    //   97: aload_1
    //   98: getfield 274	com/tencent/bugly/crashreport/crash/CrashDetailBean:n	Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: bipush 6
    //   105: aload_1
    //   106: getfield 279	com/tencent/bugly/crashreport/crash/CrashDetailBean:o	Ljava/lang/String;
    //   109: aastore
    //   110: dup
    //   111: bipush 7
    //   113: aload_1
    //   114: getfield 289	com/tencent/bugly/crashreport/crash/CrashDetailBean:q	Ljava/lang/String;
    //   117: aastore
    //   118: dup
    //   119: bipush 8
    //   121: aload_1
    //   122: getfield 300	com/tencent/bugly/crashreport/crash/CrashDetailBean:c	Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 940	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore 6
    //   131: getstatic 941	com/tencent/bugly/crashreport/crash/c:i	Ljava/lang/String;
    //   134: ifnonnull +117 -> 251
    //   137: invokestatic 946	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   140: ldc_w 948
    //   143: invokevirtual 951	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +352 -> 498
    //   149: invokestatic 954	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   152: invokevirtual 957	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: astore_1
    //   156: new 142	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 959
    //   170: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_0
    //   174: getfield 29	com/tencent/bugly/crashreport/crash/b:c	Landroid/content/Context;
    //   177: invokevirtual 962	android/content/Context:getPackageName	()Ljava/lang/String;
    //   180: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_1
    //   187: new 142	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   194: aload_1
    //   195: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 964
    //   201: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_1
    //   208: aload_0
    //   209: getfield 29	com/tencent/bugly/crashreport/crash/b:c	Landroid/content/Context;
    //   212: astore_2
    //   213: getstatic 966	com/tencent/bugly/crashreport/crash/c:j	I
    //   216: istore 9
    //   218: ldc_w 968
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_1
    //   228: aastore
    //   229: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   232: pop
    //   233: aload 6
    //   235: ifnull +268 -> 503
    //   238: aload 6
    //   240: invokevirtual 776	java/lang/String:trim	()Ljava/lang/String;
    //   243: invokevirtual 411	java/lang/String:length	()I
    //   246: ifgt +38 -> 284
    //   249: iconst_1
    //   250: ireturn
    //   251: new 189	java/io/File
    //   254: dup
    //   255: getstatic 941	com/tencent/bugly/crashreport/crash/c:i	Ljava/lang/String;
    //   258: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: astore_2
    //   262: aload_2
    //   263: astore_1
    //   264: aload_2
    //   265: invokevirtual 971	java/io/File:isFile	()Z
    //   268: ifne +8 -> 276
    //   271: aload_2
    //   272: invokevirtual 974	java/io/File:getParentFile	()Ljava/io/File;
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 957	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   280: astore_1
    //   281: goto -94 -> 187
    //   284: new 189	java/io/File
    //   287: dup
    //   288: aload_1
    //   289: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual 231	java/io/File:exists	()Z
    //   297: ifne +23 -> 320
    //   300: aload_1
    //   301: invokevirtual 974	java/io/File:getParentFile	()Ljava/io/File;
    //   304: ifnull +11 -> 315
    //   307: aload_1
    //   308: invokevirtual 974	java/io/File:getParentFile	()Ljava/io/File;
    //   311: invokevirtual 977	java/io/File:mkdirs	()Z
    //   314: pop
    //   315: aload_1
    //   316: invokevirtual 980	java/io/File:createNewFile	()Z
    //   319: pop
    //   320: aload 4
    //   322: astore_3
    //   323: aload 5
    //   325: astore_2
    //   326: aload_1
    //   327: invokevirtual 982	java/io/File:length	()J
    //   330: iload 9
    //   332: i2l
    //   333: lcmp
    //   334: iflt +92 -> 426
    //   337: aload 4
    //   339: astore_3
    //   340: aload 5
    //   342: astore_2
    //   343: new 984	java/io/FileOutputStream
    //   346: dup
    //   347: aload_1
    //   348: iconst_0
    //   349: invokespecial 987	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   352: astore_1
    //   353: aload_1
    //   354: astore_3
    //   355: aload_1
    //   356: astore_2
    //   357: aload_1
    //   358: aload 6
    //   360: ldc_w 989
    //   363: invokevirtual 421	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   366: invokevirtual 992	java/io/FileOutputStream:write	([B)V
    //   369: aload_1
    //   370: astore_3
    //   371: aload_1
    //   372: astore_2
    //   373: aload_1
    //   374: invokevirtual 993	java/io/FileOutputStream:flush	()V
    //   377: aload_1
    //   378: invokevirtual 994	java/io/FileOutputStream:close	()V
    //   381: ldc_w 996
    //   384: iconst_0
    //   385: anewarray 4	java/lang/Object
    //   388: invokestatic 187	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   391: pop
    //   392: iconst_1
    //   393: ireturn
    //   394: astore_1
    //   395: ldc_w 998
    //   398: iconst_1
    //   399: anewarray 4	java/lang/Object
    //   402: dup
    //   403: iconst_0
    //   404: aload_1
    //   405: invokevirtual 999	java/lang/Throwable:toString	()Ljava/lang/String;
    //   408: aastore
    //   409: invokestatic 183	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   412: pop
    //   413: aload_1
    //   414: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   417: ifne +7 -> 424
    //   420: aload_1
    //   421: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   424: iconst_0
    //   425: ireturn
    //   426: aload 4
    //   428: astore_3
    //   429: aload 5
    //   431: astore_2
    //   432: new 984	java/io/FileOutputStream
    //   435: dup
    //   436: aload_1
    //   437: iconst_1
    //   438: invokespecial 987	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   441: astore_1
    //   442: goto -89 -> 353
    //   445: astore_1
    //   446: aload_3
    //   447: astore_2
    //   448: aload_1
    //   449: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   452: ifne +9 -> 461
    //   455: aload_3
    //   456: astore_2
    //   457: aload_1
    //   458: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   461: aload_3
    //   462: ifnull -81 -> 381
    //   465: aload_3
    //   466: invokevirtual 994	java/io/FileOutputStream:close	()V
    //   469: goto -88 -> 381
    //   472: astore_1
    //   473: aload_1
    //   474: invokestatic 77	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   477: ifne -96 -> 381
    //   480: aload_1
    //   481: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   484: goto -103 -> 381
    //   487: astore_1
    //   488: aload_2
    //   489: ifnull +7 -> 496
    //   492: aload_2
    //   493: invokevirtual 994	java/io/FileOutputStream:close	()V
    //   496: aload_1
    //   497: athrow
    //   498: aconst_null
    //   499: astore_1
    //   500: goto -313 -> 187
    //   503: iconst_1
    //   504: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	b
    //   0	505	1	paramCrashDetailBean	CrashDetailBean
    //   20	473	2	localObject1	Object
    //   25	441	3	localObject2	Object
    //   4	423	4	localObject3	Object
    //   1	429	5	localObject4	Object
    //   30	329	6	str1	String
    //   36	40	7	str2	String
    //   41	8	8	localLocale	java.util.Locale
    //   216	115	9	i	int
    // Exception table:
    //   from	to	target	type
    //   6	187	394	java/lang/Throwable
    //   187	233	394	java/lang/Throwable
    //   238	249	394	java/lang/Throwable
    //   251	262	394	java/lang/Throwable
    //   264	276	394	java/lang/Throwable
    //   276	281	394	java/lang/Throwable
    //   284	293	394	java/lang/Throwable
    //   381	392	394	java/lang/Throwable
    //   473	484	394	java/lang/Throwable
    //   326	337	445	java/lang/Throwable
    //   343	353	445	java/lang/Throwable
    //   357	369	445	java/lang/Throwable
    //   373	377	445	java/lang/Throwable
    //   432	442	445	java/lang/Throwable
    //   293	315	472	java/lang/Throwable
    //   315	320	472	java/lang/Throwable
    //   377	381	472	java/lang/Throwable
    //   465	469	472	java/lang/Throwable
    //   492	496	472	java/lang/Throwable
    //   496	498	472	java/lang/Throwable
    //   326	337	487	finally
    //   343	353	487	finally
    //   357	369	487	finally
    //   373	377	487	finally
    //   432	442	487	finally
    //   448	455	487	finally
    //   457	461	487	finally
  }
  
  public final List<CrashDetailBean> a()
  {
    Object localObject1 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    if (localObject1 == null) {
      v.d("have not synced remote!", new Object[0]);
    }
    long l1;
    long l2;
    do
    {
      return null;
      if (!((StrategyBean)localObject1).g)
      {
        v.d("Crashreport remote closed, please check your APPID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
        v.b("[init] WARNING! Crashreport closed by server, please check your APPID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
        return null;
      }
      l1 = System.currentTimeMillis();
      l2 = com.tencent.bugly.proguard.a.e();
      localList = b();
    } while ((localList == null) || (localList.size() <= 0));
    localObject1 = new ArrayList();
    Object localObject2 = localList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a)((Iterator)localObject2).next();
      if (((a)localObject3).b < l2 - c.f)
      {
        ((Iterator)localObject2).remove();
        ((List)localObject1).add(localObject3);
      }
      else if (((a)localObject3).d)
      {
        if (((a)localObject3).b >= l1 - 86400000L)
        {
          ((Iterator)localObject2).remove();
        }
        else if (!((a)localObject3).e)
        {
          ((Iterator)localObject2).remove();
          ((List)localObject1).add(localObject3);
        }
      }
      else if ((((a)localObject3).f >= 3L) && (((a)localObject3).b < l1 - 86400000L))
      {
        ((Iterator)localObject2).remove();
        ((List)localObject1).add(localObject3);
      }
    }
    if (((List)localObject1).size() > 0) {
      c((List)localObject1);
    }
    localObject1 = new ArrayList();
    List localList = b(localList);
    if ((localList != null) && (localList.size() > 0))
    {
      localObject2 = com.tencent.bugly.crashreport.common.info.a.a().l;
      localObject3 = localList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        CrashDetailBean localCrashDetailBean = (CrashDetailBean)((Iterator)localObject3).next();
        if (!((String)localObject2).equals(localCrashDetailBean.f))
        {
          ((Iterator)localObject3).remove();
          ((List)localObject1).add(localCrashDetailBean);
        }
      }
    }
    if (((List)localObject1).size() > 0) {
      d((List)localObject1);
    }
    return localList;
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean)
  {
    v.a("try to upload right now", new Object[0]);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramCrashDetailBean);
    if (paramCrashDetailBean.b == 7)
    {
      a(localArrayList, 3000L, paramBoolean, true);
      if (paramCrashDetailBean.b != 1) {
        break label96;
      }
    }
    label96:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.a != null) {
        this.a.b(paramBoolean);
      }
      return;
      a(localArrayList, 3000L, paramBoolean, false);
      break;
    }
  }
  
  public final void a(final List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e.c().g) {
      v.d("remote report is disable!", new Object[0]);
    }
    do
    {
      v.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
      do
      {
        return;
      } while ((paramList == null) || (paramList.size() == 0));
      try
      {
        localObject = a(this.c, paramList, com.tencent.bugly.crashreport.common.info.a.a());
        if (localObject != null) {
          break;
        }
        v.d("create eupPkg fail!", new Object[0]);
        return;
      }
      catch (Throwable paramList)
      {
        v.e("req cr error %s", new Object[] { paramList.toString() });
      }
    } while (v.b(paramList));
    paramList.printStackTrace();
    return;
    Object localObject = com.tencent.bugly.proguard.a.a((j)localObject);
    if (localObject == null)
    {
      v.d("send encode fail!", new Object[0]);
      return;
    }
    localObject = com.tencent.bugly.proguard.a.a(this.c, 630, (byte[])localObject);
    if (localObject == null)
    {
      v.d("request package is null.", new Object[0]);
      return;
    }
    paramList = new r()
    {
      public final void a(int paramAnonymousInt) {}
      
      public final void a(int paramAnonymousInt, ak paramAnonymousak, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        paramAnonymousak = b.this;
        b.a(paramAnonymousBoolean, paramList);
      }
    };
    if (!paramBoolean1)
    {
      if (!paramBoolean2)
      {
        s.a().a(b, (aj)localObject, null, paramList, false);
        return;
      }
      s.a().a(b, (aj)localObject, null, paramList, true);
      return;
    }
    if (!paramBoolean2) {
      s.a().a(b, (aj)localObject, null, paramList, true, paramLong, false);
    }
    for (;;)
    {
      v.a("wake up!", new Object[0]);
      return;
      s.a().a(b, (aj)localObject, null, paramList, true, paramLong, true);
    }
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean)
  {
    return a(paramCrashDetailBean, -123456789);
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean, int paramInt)
  {
    if (paramCrashDetailBean.b == 1) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    for (boolean bool = true;; bool = false)
    {
      localObject1 = paramCrashDetailBean.n;
      localObject2 = paramCrashDetailBean.p;
      localObject3 = paramCrashDetailBean.q;
      long l = paramCrashDetailBean.r;
      localObject4 = paramCrashDetailBean.m;
      String str1 = paramCrashDetailBean.e;
      String str2 = paramCrashDetailBean.c;
      if ((this.a == null) || (this.a.a(bool, (String)localObject1, (String)localObject2, (String)localObject3, paramInt, l, (String)localObject4, str1, str2))) {
        break;
      }
      return true;
    }
    if (paramCrashDetailBean.b != 2)
    {
      localObject1 = new p();
      ((p)localObject1).b = 1;
      ((p)localObject1).c = paramCrashDetailBean.z;
      ((p)localObject1).d = paramCrashDetailBean.A;
      ((p)localObject1).e = paramCrashDetailBean.r;
      localObject2 = this.d;
      n.b(1);
      this.d.a((p)localObject1);
      v.b("[crash] a crash occur, handling...", new Object[0]);
    }
    for (;;)
    {
      localObject3 = b();
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label413;
      }
      localObject1 = localObject2;
      if (((List)localObject3).size() <= 0) {
        break label413;
      }
      localObject1 = new ArrayList(10);
      localObject2 = new ArrayList(10);
      ((List)localObject1).addAll(a((List)localObject3));
      ((List)localObject3).removeAll((Collection)localObject1);
      if ((com.tencent.bugly.b.b) || (!c.c)) {
        break label413;
      }
      paramInt = 0;
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (a)((Iterator)localObject3).next();
        if (paramCrashDetailBean.u.equals(((a)localObject4).c))
        {
          if (((a)localObject4).e) {
            paramInt = 1;
          }
          ((List)localObject2).add(localObject4);
        }
      }
      v.b("[crash] a caught exception occur, handling...", new Object[0]);
    }
    if ((paramInt != 0) || (((List)localObject2).size() + 1 >= 5))
    {
      v.a("same crash occur too much do merged!", new Object[0]);
      paramCrashDetailBean = a((List)localObject2, paramCrashDetailBean);
      paramCrashDetailBean.a = -1L;
      c(paramCrashDetailBean);
      ((List)localObject1).addAll((Collection)localObject2);
      c((List)localObject1);
      v.b("[crash] save crash success. this device crash many times, won't upload crashes immediately", new Object[0]);
      return true;
    }
    label413:
    c(paramCrashDetailBean);
    c((List)localObject1);
    v.b("[crash] save crash success", new Object[0]);
    return false;
  }
  
  public final byte[] a(List<CrashDetailBean> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return null;
      try
      {
        localObject = a(this.c, paramList, com.tencent.bugly.crashreport.common.info.a.a());
        if (localObject != null) {
          break;
        }
        v.d("create eupPkg fail!", new Object[0]);
        return null;
      }
      catch (Throwable paramList) {}
    } while (v.a(paramList));
    paramList.printStackTrace();
    return null;
    Object localObject = com.tencent.bugly.proguard.a.a((j)localObject);
    if (localObject == null)
    {
      v.d("send encode fail!", new Object[0]);
      return null;
    }
    localObject = com.tencent.bugly.proguard.a.a(this.c, 630, (byte[])localObject).a();
    a(true, paramList);
    return (byte[])localObject;
  }
  
  public final void b(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      break label4;
    }
    label4:
    while ((this.f == null) && (this.a == null)) {
      return;
    }
    for (;;)
    {
      String str2;
      String str3;
      String str4;
      long l;
      String str1;
      Object localObject;
      Map.Entry localEntry;
      int i;
      try
      {
        v.a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
        switch (paramCrashDetailBean.b)
        {
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
          if (paramCrashDetailBean.b != 1) {
            break label512;
          }
          bool = true;
          str2 = paramCrashDetailBean.n;
          str3 = paramCrashDetailBean.p;
          str4 = paramCrashDetailBean.q;
          l = paramCrashDetailBean.r;
          if (this.a == null) {
            break label518;
          }
          this.a.a(bool);
          str1 = this.a.b(bool, str2, str3, str4, -1234567890, l);
          if (str1 == null) {
            break label740;
          }
          localObject = new HashMap(1);
          ((Map)localObject).put("userData", str1);
          if ((localObject == null) || (((Map)localObject).size() <= 0)) {
            break label580;
          }
          paramCrashDetailBean.N = new LinkedHashMap(((Map)localObject).size());
          Iterator localIterator = ((Map)localObject).entrySet().iterator();
          if (!localIterator.hasNext()) {
            break label580;
          }
          localEntry = (Map.Entry)localIterator.next();
          localObject = (String)localEntry.getKey();
          if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
            break label746;
          }
          i = 0;
          if (i != 0) {
            continue;
          }
          str1 = (String)localEntry.getKey();
          localObject = str1;
          if (str1.length() > 100)
          {
            localObject = str1.substring(0, 100);
            v.d("setted key length is over limit %d substring to %s", new Object[] { Integer.valueOf(100), localObject });
          }
          str1 = (String)localEntry.getValue();
          if ((str1 == null) || (str1.trim().length() <= 0)) {
            break label752;
          }
          i = 0;
          if ((i != 0) || (((String)localEntry.getValue()).length() <= 30000)) {
            break label553;
          }
          str1 = ((String)localEntry.getValue()).substring(((String)localEntry.getValue()).length() - 30000);
          v.d("setted %s value length is over limit %d substring", new Object[] { localObject, Integer.valueOf(30000) });
          paramCrashDetailBean.N.put(localObject, str1);
          v.a("add setted key %s value size:%d", new Object[] { localObject, Integer.valueOf(str1.length()) });
          continue;
          if (v.a(paramCrashDetailBean)) {
            break label4;
          }
        }
      }
      catch (Throwable paramCrashDetailBean)
      {
        v.d("crash handle callback somthing wrong! %s", new Object[] { paramCrashDetailBean.getClass().getName() });
      }
      paramCrashDetailBean.printStackTrace();
      return;
      label512:
      boolean bool = false;
      continue;
      label518:
      if (this.f != null)
      {
        localObject = this.f;
        str1 = paramCrashDetailBean.n;
        str1 = paramCrashDetailBean.o;
        str1 = paramCrashDetailBean.q;
        localObject = ((com.tencent.bugly.proguard.a)localObject).b();
        continue;
        label553:
        str1 = (String)localEntry.getValue();
        continue;
        label580:
        v.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
        localObject = null;
        if (this.a != null) {
          localObject = this.a.a(bool, str2, str3, str4, -1234567890, l);
        }
        for (;;)
        {
          paramCrashDetailBean.S = ((byte[])localObject);
          if (paramCrashDetailBean.S == null) {
            break;
          }
          if (paramCrashDetailBean.S.length > 30000) {
            v.d("extra bytes size %d is over limit %d will drop over part", new Object[] { Integer.valueOf(paramCrashDetailBean.S.length), Integer.valueOf(30000) });
          }
          v.a("add extra bytes %d ", new Object[] { Integer.valueOf(paramCrashDetailBean.S.length) });
          return;
          if (this.f != null)
          {
            localObject = this.f;
            str1 = paramCrashDetailBean.n;
            str1 = paramCrashDetailBean.o;
            str1 = paramCrashDetailBean.q;
            localObject = ((com.tencent.bugly.proguard.a)localObject).c();
          }
        }
      }
      else
      {
        localObject = null;
        continue;
        label740:
        localObject = null;
        continue;
        return;
        label746:
        i = 1;
        continue;
        label752:
        i = 1;
      }
    }
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {}
    do
    {
      return;
      ContentValues localContentValues = d(paramCrashDetailBean);
      if (localContentValues != null)
      {
        long l = n.a().a("t_cr", localContentValues, null, true);
        if (l >= 0L)
        {
          v.c("insert %s success!", new Object[] { "t_cr" });
          paramCrashDetailBean.a = l;
        }
      }
    } while (!c.h);
    e(paramCrashDetailBean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */