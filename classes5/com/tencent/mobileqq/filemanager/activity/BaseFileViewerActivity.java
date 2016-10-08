package com.tencent.mobileqq.filemanager.activity;

import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BaseFileViewerActivity
  extends IphoneTitleBarActivity
{
  public BaseFileViewerActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void setContentViewForImage(int paramInt)
  {
    super.setContentViewNoTitle(2130904009);
    ((RelativeLayout)findViewById(2131300982)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    init(getIntent());
  }
  
  public void startViewerTitleProgress()
  {
    startTitleProgress();
  }
  
  public void stopViewerTitleProgress()
  {
    stopTitleProgress();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\BaseFileViewerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */