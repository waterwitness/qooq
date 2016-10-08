package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.j;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private Context a;
  private long b;
  private int c;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {}
    do
    {
      return null;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramUserInfoBean.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramUserInfoBean.a));
        }
        localContentValues.put("_tm", Long.valueOf(paramUserInfoBean.e));
        localContentValues.put("_ut", Long.valueOf(paramUserInfoBean.f));
        localContentValues.put("_tp", Integer.valueOf(paramUserInfoBean.b));
        localContentValues.put("_pc", paramUserInfoBean.c);
        Parcel localParcel = Parcel.obtain();
        paramUserInfoBean.writeToParcel(localParcel, 0);
        paramUserInfoBean = localParcel.marshall();
        localParcel.recycle();
        localContentValues.put("_dt", paramUserInfoBean);
        return localContentValues;
      }
      catch (Throwable paramUserInfoBean) {}
    } while (v.a(paramUserInfoBean));
    paramUserInfoBean.printStackTrace();
    return null;
  }
  
  private static UserInfoBean a(Cursor paramCursor)
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
        localObject = (UserInfoBean)com.tencent.bugly.proguard.a.a((byte[])localObject, UserInfoBean.CREATOR);
        paramCursor = (Cursor)localObject;
        if (localObject != null)
        {
          ((UserInfoBean)localObject).a = l;
          return (UserInfoBean)localObject;
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
  
  private static void a(List<UserInfoBean> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (UserInfoBean)paramList.next();
        localStringBuilder.append(" or _id").append(" = ").append(((UserInfoBean)localObject).a);
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<UserInfoBean>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        v.c("deleted %s data %d", new Object[] { "t_ui", Integer.valueOf(n.a().a("t_ui", paramList, null, null, true)) });
        return;
      }
      catch (Throwable paramList) {}
    } while (v.a(paramList));
    paramList.printStackTrace();
  }
  
  /* Error */
  public final List<UserInfoBean> a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +55 -> 59
    //   7: aload_1
    //   8: invokevirtual 221	java/lang/String:trim	()Ljava/lang/String;
    //   11: invokevirtual 199	java/lang/String:length	()I
    //   14: ifle +45 -> 59
    //   17: goto +324 -> 341
    //   20: invokestatic 145	com/tencent/bugly/proguard/n:a	()Lcom/tencent/bugly/proguard/n;
    //   23: ldc -109
    //   25: aconst_null
    //   26: aload_1
    //   27: aconst_null
    //   28: aconst_null
    //   29: iconst_1
    //   30: invokevirtual 224	com/tencent/bugly/proguard/n:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/m;Z)Landroid/database/Cursor;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +55 -> 90
    //   38: aload_1
    //   39: ifnull +18 -> 57
    //   42: aload_1
    //   43: invokeinterface 227 1 0
    //   48: ifne +9 -> 57
    //   51: aload_1
    //   52: invokeinterface 230 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: iconst_1
    //   60: istore 5
    //   62: goto +279 -> 341
    //   65: new 164	java/lang/StringBuilder
    //   68: dup
    //   69: ldc -24
    //   71: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc -19
    //   80: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_1
    //   87: goto -67 -> 20
    //   90: new 164	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   97: astore_3
    //   98: new 239	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 240	java/util/ArrayList:<init>	()V
    //   105: astore_2
    //   106: aload_1
    //   107: invokeinterface 243 1 0
    //   112: ifeq +136 -> 248
    //   115: aload_1
    //   116: invokestatic 245	com/tencent/bugly/crashreport/biz/a:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/biz/UserInfoBean;
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +48 -> 171
    //   126: aload_2
    //   127: aload 4
    //   129: invokeinterface 249 2 0
    //   134: pop
    //   135: goto -29 -> 106
    //   138: astore_2
    //   139: aload_2
    //   140: invokestatic 110	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   143: ifne +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 113	java/lang/Throwable:printStackTrace	()V
    //   150: aload_1
    //   151: ifnull +18 -> 169
    //   154: aload_1
    //   155: invokeinterface 227 1 0
    //   160: ifne +9 -> 169
    //   163: aload_1
    //   164: invokeinterface 230 1 0
    //   169: aconst_null
    //   170: areturn
    //   171: aload_1
    //   172: aload_1
    //   173: ldc 41
    //   175: invokeinterface 120 2 0
    //   180: invokeinterface 128 2 0
    //   185: lstore 6
    //   187: aload_3
    //   188: ldc -75
    //   190: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc -69
    //   195: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: lload 6
    //   200: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: goto -98 -> 106
    //   207: astore 4
    //   209: ldc -5
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 254	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   218: pop
    //   219: goto -113 -> 106
    //   222: astore_3
    //   223: aload_1
    //   224: astore_2
    //   225: aload_3
    //   226: astore_1
    //   227: aload_2
    //   228: ifnull +18 -> 246
    //   231: aload_2
    //   232: invokeinterface 227 1 0
    //   237: ifne +9 -> 246
    //   240: aload_2
    //   241: invokeinterface 230 1 0
    //   246: aload_1
    //   247: athrow
    //   248: aload_3
    //   249: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: astore_3
    //   253: aload_3
    //   254: invokevirtual 199	java/lang/String:length	()I
    //   257: ifle +43 -> 300
    //   260: aload_3
    //   261: iconst_4
    //   262: invokevirtual 203	java/lang/String:substring	(I)Ljava/lang/String;
    //   265: astore_3
    //   266: ldc_w 256
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: ldc -109
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: invokestatic 145	com/tencent/bugly/proguard/n:a	()Lcom/tencent/bugly/proguard/n;
    //   283: ldc -109
    //   285: aload_3
    //   286: aconst_null
    //   287: aconst_null
    //   288: iconst_1
    //   289: invokevirtual 212	com/tencent/bugly/proguard/n:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/m;Z)I
    //   292: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: aastore
    //   296: invokestatic 254	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   299: pop
    //   300: aload_1
    //   301: ifnull +18 -> 319
    //   304: aload_1
    //   305: invokeinterface 227 1 0
    //   310: ifne +9 -> 319
    //   313: aload_1
    //   314: invokeinterface 230 1 0
    //   319: aload_2
    //   320: areturn
    //   321: astore_1
    //   322: aconst_null
    //   323: astore_2
    //   324: goto -97 -> 227
    //   327: astore_3
    //   328: aload_1
    //   329: astore_2
    //   330: aload_3
    //   331: astore_1
    //   332: goto -105 -> 227
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_1
    //   338: goto -199 -> 139
    //   341: iload 5
    //   343: ifeq -278 -> 65
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -328 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	a
    //   0	351	1	paramString	String
    //   105	22	2	localArrayList	ArrayList
    //   138	9	2	localThrowable1	Throwable
    //   224	106	2	str1	String
    //   335	1	2	localThrowable2	Throwable
    //   97	91	3	localStringBuilder	StringBuilder
    //   222	27	3	localObject1	Object
    //   252	34	3	str2	String
    //   327	4	3	localObject2	Object
    //   119	9	4	localUserInfoBean	UserInfoBean
    //   207	1	4	localThrowable3	Throwable
    //   1	341	5	i	int
    //   185	14	6	l	long
    // Exception table:
    //   from	to	target	type
    //   90	106	138	java/lang/Throwable
    //   106	121	138	java/lang/Throwable
    //   126	135	138	java/lang/Throwable
    //   209	219	138	java/lang/Throwable
    //   248	300	138	java/lang/Throwable
    //   171	204	207	java/lang/Throwable
    //   90	106	222	finally
    //   106	121	222	finally
    //   126	135	222	finally
    //   171	204	222	finally
    //   209	219	222	finally
    //   248	300	222	finally
    //   7	17	321	finally
    //   20	34	321	finally
    //   65	87	321	finally
    //   139	150	327	finally
    //   7	17	335	java/lang/Throwable
    //   20	34	335	java/lang/Throwable
    //   65	87	335	java/lang/Throwable
  }
  
  public final void a()
  {
    this.b = (com.tencent.bugly.proguard.a.e() + 86400000L);
    u.a().a(new b(), this.b - System.currentTimeMillis() + 5000L);
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong)
  {
    int i = 1;
    Object localObject = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    if ((localObject != null) && (!((StrategyBean)localObject).h) && (paramInt != 1) && (paramInt != 3))
    {
      v.e("UserInfo is disable", new Object[0]);
      return;
    }
    if (paramInt == 1) {
      this.c += 1;
    }
    localObject = this.a;
    if (paramInt == 1) {}
    for (;;)
    {
      localObject = com.tencent.bugly.crashreport.common.info.a.a((Context)localObject);
      UserInfoBean localUserInfoBean = new UserInfoBean();
      localUserInfoBean.b = paramInt;
      localUserInfoBean.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
      localUserInfoBean.d = ((com.tencent.bugly.crashreport.common.info.a)localObject).e();
      localUserInfoBean.e = System.currentTimeMillis();
      localUserInfoBean.f = -1L;
      localUserInfoBean.n = ((com.tencent.bugly.crashreport.common.info.a)localObject).l;
      localUserInfoBean.o = i;
      localUserInfoBean.l = ((com.tencent.bugly.crashreport.common.info.a)localObject).q;
      localUserInfoBean.m = ((com.tencent.bugly.crashreport.common.info.a)localObject).r;
      localUserInfoBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).s;
      localUserInfoBean.h = ((com.tencent.bugly.crashreport.common.info.a)localObject).t;
      localUserInfoBean.i = ((com.tencent.bugly.crashreport.common.info.a)localObject).u;
      localUserInfoBean.k = ((com.tencent.bugly.crashreport.common.info.a)localObject).v;
      localUserInfoBean.r = ((com.tencent.bugly.crashreport.common.info.a)localObject).x();
      localUserInfoBean.s = ((com.tencent.bugly.crashreport.common.info.a)localObject).A();
      localUserInfoBean.p = ((com.tencent.bugly.crashreport.common.info.a)localObject).B();
      localUserInfoBean.q = ((com.tencent.bugly.crashreport.common.info.a)localObject).C();
      u.a().a(new a(localUserInfoBean, paramBoolean), 0L);
      return;
      i = 0;
    }
  }
  
  public final void b()
  {
    int k = 1;
    label449:
    label528:
    label534:
    label537:
    label546:
    label555:
    label561:
    label567:
    label570:
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject1 = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
        localObject2 = new ArrayList();
        localObject1 = a((String)localObject1);
        if (localObject1 != null)
        {
          int m = ((List)localObject1).size() - 10;
          if (m > 0)
          {
            i = 0;
            if (i >= ((List)localObject1).size() - 1) {
              break label555;
            }
            j = i + 1;
            if (j >= ((List)localObject1).size()) {
              break label546;
            }
            if (((UserInfoBean)((List)localObject1).get(i)).e <= ((UserInfoBean)((List)localObject1).get(j)).e) {
              break label537;
            }
            localObject3 = (UserInfoBean)((List)localObject1).get(i);
            ((List)localObject1).set(i, ((List)localObject1).get(j));
            ((List)localObject1).set(j, localObject3);
            break label537;
            if (i < m)
            {
              ((List)localObject2).add(((List)localObject1).get(i));
              i += 1;
              continue;
            }
          }
          Object localObject3 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            UserInfoBean localUserInfoBean = (UserInfoBean)((Iterator)localObject3).next();
            if (localUserInfoBean.f != -1L)
            {
              ((Iterator)localObject3).remove();
              if (localUserInfoBean.e < com.tencent.bugly.proguard.a.e()) {
                ((List)localObject2).add(localUserInfoBean);
              }
            }
            if (localUserInfoBean.e <= System.currentTimeMillis() - 600000L) {
              break label534;
            }
            if (localUserInfoBean.b == 1) {
              break label561;
            }
            if (localUserInfoBean.b != 4) {
              break label534;
            }
            break label561;
          }
          if (i <= 15) {
            break label528;
          }
          v.d("[userinfo] userinfo too many times in 10 min: %d", new Object[] { Integer.valueOf(i) });
          i = 0;
          break label570;
          if (((List)localObject2).size() > 0) {
            a((List)localObject2);
          }
          if ((i != 0) && (localObject1 != null))
          {
            i = ((List)localObject1).size();
            if (i != 0) {
              continue;
            }
          }
        }
        else
        {
          localObject1 = new ArrayList();
          i = 1;
          continue;
        }
        v.c("[userinfo] do userinfo, size: %d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
        if (this.c == 1)
        {
          i = k;
          localObject2 = com.tencent.bugly.proguard.a.a((List)localObject1, i);
          if (localObject2 != null) {
            break label449;
          }
          v.d("[biz] create uPkg fail!", new Object[0]);
          continue;
        }
        i = 2;
      }
      finally {}
      continue;
      Object localObject2 = com.tencent.bugly.proguard.a.a((j)localObject2);
      if (localObject2 == null)
      {
        v.d("[biz] send encode fail!", new Object[0]);
      }
      else
      {
        localObject2 = com.tencent.bugly.proguard.a.a(this.a, 640, (byte[])localObject2);
        if (localObject2 == null)
        {
          v.d("request package is null.", new Object[0]);
        }
        else
        {
          r local1 = new r()
          {
            public final void a(int paramAnonymousInt) {}
            
            public final void a(int paramAnonymousInt, ak paramAnonymousak, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              if (paramAnonymousBoolean)
              {
                v.c("up success do final", new Object[0]);
                paramAnonymousLong1 = System.currentTimeMillis();
                paramAnonymousak = localList.iterator();
                while (paramAnonymousak.hasNext())
                {
                  paramAnonymousString = (UserInfoBean)paramAnonymousak.next();
                  paramAnonymousString.f = paramAnonymousLong1;
                  a.a(a.this, paramAnonymousString);
                }
              }
            }
          };
          s.a().a(1001, (aj)localObject2, null, local1, false);
          continue;
          i = 1;
          break label570;
          break label567;
          j += 1;
          continue;
          i += 1;
          continue;
          i = 0;
          continue;
          i += 1;
        }
      }
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean a;
    private UserInfoBean b;
    
    public a(UserInfoBean paramUserInfoBean, boolean paramBoolean)
    {
      this.b = paramUserInfoBean;
      this.a = paramBoolean;
    }
    
    public final void run()
    {
      try
      {
        if (this.b != null)
        {
          UserInfoBean localUserInfoBean = this.b;
          if (localUserInfoBean != null)
          {
            com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.a();
            if (locala != null) {
              localUserInfoBean.j = locala.c();
            }
          }
          v.c("record userinfo", new Object[0]);
          a.a(a.this, this.b);
        }
        if (this.a) {
          a.this.b();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        while (v.a(localThrowable)) {}
        localThrowable.printStackTrace();
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      long l = System.currentTimeMillis();
      if (l < a.a(a.this))
      {
        u.a().a(new b(a.this), a.a(a.this) - l + 5000L);
        return;
      }
      a.b(a.this);
      a.this.a(3, false, 0L);
      a.this.a();
    }
  }
  
  final class c
    implements Runnable
  {
    private long a = 21600000L;
    
    public c(long paramLong)
    {
      this.a = paramLong;
    }
    
    public final void run()
    {
      a.this.b();
      a locala = a.this;
      long l = this.a;
      u.a().a(new c(locala, l), l);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\biz\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */