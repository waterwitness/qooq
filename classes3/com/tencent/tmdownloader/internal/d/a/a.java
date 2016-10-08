package com.tencent.tmdownloader.internal.d.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmdownloader.internal.d.c.b;
import com.tencent.tmdownloader.internal.d.c.c;

public class a
  extends d
{
  protected static d a = null;
  private static final Class<?>[] b = { b.class, c.class, com.tencent.tmdownloader.internal.d.c.a.class };
  
  public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public static d c()
  {
    try
    {
      if (a == null)
      {
        localObject1 = f.a().b();
        if (localObject1 != null) {
          a = new a((Context)localObject1, "tmassistant_sdk_v2.db", null, 4);
        }
      }
      Object localObject1 = a;
      return (d)localObject1;
    }
    finally {}
  }
  
  public int a()
  {
    return 4;
  }
  
  public Class<?>[] b()
  {
    return b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */