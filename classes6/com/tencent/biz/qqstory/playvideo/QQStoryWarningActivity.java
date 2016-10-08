package com.tencent.biz.qqstory.playvideo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQStoryWarningActivity
  extends QQStoryBaseActivity
{
  public static final String a = "tipsResource";
  
  public QQStoryWarningActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904509);
    super.setTitle(2131366427);
    this.leftView.setText(2131366637);
    paramBundle = (TextView)super.findViewById(2131298186);
    int i = super.getIntent().getExtras().getInt("tipsResource");
    if (i > 0) {
      paramBundle.setText(i);
    }
    for (;;)
    {
      return true;
      paramBundle.setText("出错啦！");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\QQStoryWarningActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */