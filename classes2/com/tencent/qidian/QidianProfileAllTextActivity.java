package com.tencent.qidian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QidianProfileAllTextActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "title";
  public static final String b = "content";
  
  public QidianProfileAllTextActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("content");
    super.setContentView(2130904034);
    ((TextView)this.mContentView.findViewById(2131297123)).setText(paramBundle);
    ((TextView)this.mContentView.findViewById(2131297013)).setText(str);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\QidianProfileAllTextActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */