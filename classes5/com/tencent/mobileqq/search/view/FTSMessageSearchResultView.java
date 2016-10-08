package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FTSMessageSearchResultView
  extends SearchResultView
{
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public FTSMessageSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public FTSMessageSearchResultView(ViewGroup paramViewGroup, int paramInt)
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
    this.e = ((TextView)this.a.findViewById(2131304838));
    this.f = ((TextView)this.a.findViewById(2131304839));
    this.g = ((TextView)this.a.findViewById(2131304840));
    this.h = ((TextView)this.a.findViewById(2131304837));
  }
  
  public TextView b()
  {
    return this.f;
  }
  
  public TextView c()
  {
    return this.g;
  }
  
  public TextView d()
  {
    return this.h;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\view\FTSMessageSearchResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */