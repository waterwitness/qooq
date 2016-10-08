package com.tencent.mobileqq.richmedia.dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ugg;
import ugh;

public class DCAIOPreview
  extends DataCollector
  implements ReportEvent
{
  public static final String a = "sender";
  public static final String b = "receiver";
  public static final String c = "large";
  public static final String d = "original";
  public static final String e = "long";
  public static final String f = "extra";
  public static final String g = "large";
  public static final String h = "mid";
  public static final String i = "small";
  public static final String j = "dynamic";
  public static final String k = "static";
  private SparseArray a;
  private String at;
  private Handler b;
  
  public DCAIOPreview(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new SparseArray();
    this.b = new ugg(this, a());
    int m = ((Activity)paramContext).getIntent().getIntExtra("forward_source_uin_type", -1);
    if (m == 0)
    {
      this.at = "c2c";
      return;
    }
    if (m == 1)
    {
      this.at = "grp";
      return;
    }
    if (m == 3000)
    {
      this.at = "dis";
      return;
    }
    this.at = "other";
  }
  
  private ugh a(int paramInt)
  {
    ugh localugh2 = (ugh)this.a.get(paramInt);
    ugh localugh1 = localugh2;
    if (localugh2 == null)
    {
      localugh1 = new ugh(paramInt, this.at);
      this.a.put(paramInt, localugh1);
    }
    return localugh1;
  }
  
  public void a()
  {
    this.b.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    ugh.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    ugh localugh = (ugh)this.a.get(paramInt);
    String str;
    if (localugh != null)
    {
      paramInt = PhotoUtils.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      ugh.b(localugh, str);
      return;
      str = "long";
      continue;
      str = "small";
      continue;
      str = "mid";
      continue;
      str = "large";
      continue;
      str = "extra";
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    ugh localugh = (ugh)this.a.get(paramInt);
    if (localugh != null) {
      ugh.d(localugh, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ugh localugh = (ugh)this.a.get(paramInt);
    if (localugh != null) {
      ugh.a(localugh, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    ugh localugh = (ugh)this.a.get(paramInt);
    if ((localugh != null) && (ugh.a(localugh))) {
      ugh.b(localugh);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    ugh localugh = (ugh)this.a.get(paramInt);
    if (localugh != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      ugh.c(localugh, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    ugh localugh = (ugh)this.a.get(paramInt);
    if ((localugh != null) && (ugh.a(localugh))) {
      ugh.c(localugh);
    }
  }
  
  public void d(int paramInt)
  {
    ugh localugh = (ugh)this.a.get(paramInt);
    if ((localugh != null) && (ugh.a(localugh))) {
      ugh.a(localugh, "sender");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\dc\DCAIOPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */