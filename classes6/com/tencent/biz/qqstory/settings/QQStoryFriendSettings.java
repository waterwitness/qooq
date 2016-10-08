package com.tencent.biz.qqstory.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class QQStoryFriendSettings
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  ViewGroup a;
  
  public QQStoryFriendSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2130904379, null);
    ((TextView)localView.findViewById(2131297123)).setText(paramString);
    ((TextView)localView.findViewById(2131297124)).setText("");
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130837959);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, AIOUtils.a(20.0F, getResources()), 0, 0);
    this.a = paramBundle;
    paramBundle = a(0, "不看他（她）的日迹");
    this.a.addView(paramBundle);
    paramBundle.setOnClickListener(this);
    paramBundle.setBackgroundResource(2130838357);
    paramBundle = a(1, "不让他（她）看我的日迹");
    this.a.addView(paramBundle);
    paramBundle.setOnClickListener(this);
    paramBundle.setBackgroundResource(2130838352);
    super.setContentView(this.a);
    super.setTitle("日迹设置");
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = new Intent(this, QQStoryShieldListActivity.class);
    switch (i)
    {
    }
    for (;;)
    {
      super.startActivity(paramView);
      return;
      paramView.putExtra("sheild_type", 2);
      ReportController.b(null, "dc00899", "grp_story", "", "friend_story_settings", "clk_notletsee", 0, 0, "", "", "", "");
      continue;
      paramView.putExtra("sheild_type", 1);
      ReportController.b(null, "dc00899", "grp_story", "", "friend_story_settings", "clk_notsee", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\settings\QQStoryFriendSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */