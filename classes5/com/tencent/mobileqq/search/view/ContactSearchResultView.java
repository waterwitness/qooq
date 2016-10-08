package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ContactSearchResultView
  extends SearchResultView
{
  private TextView e;
  
  public ContactSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public ContactSearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TextView a()
  {
    return this.e;
  }
  
  protected void a()
  {
    super.a();
    this.e = ((TextView)this.a.findViewById(2131297457));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\ContactSearchResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */