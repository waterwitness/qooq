package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyActivityView
  extends NearbyTroopsBaseView
{
  public NearbyActivityView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a(Intent paramIntent)
  {
    Object localObject = this.a.a();
    if ((localObject instanceof AbsBaseWebViewActivity))
    {
      localObject = ((AbsBaseWebViewActivity)localObject).a(this);
      ((CustomWebView)localObject).setId(2131296688);
      String str = paramIntent.getStringExtra("url");
      if (!TextUtils.isEmpty(str)) {
        ((CustomWebView)localObject).loadUrl(str);
      }
      setBackgroundColor(getResources().getColor(2131428296));
    }
    paramIntent = paramIntent.getStringExtra("config_res_plugin_item_name");
    if (!TextUtils.isEmpty(paramIntent)) {
      this.a.a(paramIntent);
    }
    for (;;)
    {
      return true;
      this.a.a(2131367336, -1);
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    super.a(paramIntent, paramINearbyTroopContext);
    a(paramIntent);
  }
  
  public void b()
  {
    super.b();
  }
  
  protected void c()
  {
    super.c();
    invalidate();
  }
  
  protected void d() {}
  
  protected void e()
  {
    super.e();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyActivityView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */