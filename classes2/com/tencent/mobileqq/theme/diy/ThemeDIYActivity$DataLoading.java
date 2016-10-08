package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ThemeDIYActivity$DataLoading
{
  int count;
  
  ThemeDIYActivity$DataLoading(ThemeDIYActivity paramThemeDIYActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void bindScrollViewGroup(ScrollLayout paramScrollLayout)
  {
    this.count = paramScrollLayout.getChildCount();
    paramScrollLayout.setOnScreenChangeListenerDataLoad(new ThemeDIYActivity.DataLoading.1(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$DataLoading.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */