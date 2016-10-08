package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;

public class ContactSearchActivity
  extends BaseSearchActivity
{
  private int d;
  private int e;
  
  public ContactSearchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return ContactSearchFragment.a(this.e, this.d);
  }
  
  protected String a()
  {
    switch (this.d)
    {
    default: 
      return "搜索";
    }
    return "搜索联系人";
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1300) && (-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        String str = ContactUtils.a(this.app, getActivity().getApplicationContext(), paramIntent);
        Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
        localIntent.putExtra("uin", paramIntent);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", str);
        RecentUtil.a(localIntent);
        startActivity(localIntent);
        ReportController.b(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.a = true;
    this.e = getIntent().getIntExtra("fromType", -1);
    this.d = getIntent().getIntExtra("contactSearchSource", 197501);
    super.doOnCreate(paramBundle);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\activity\ContactSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */