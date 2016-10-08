package com.tencent.mobileqq.activity.qqcard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ObtainableCardBuilder$ViewHolder
  extends BaseCardItemBuilder.BaseHolder
{
  public ImageView a;
  public TextView a;
  public TextView b;
  public TextView c;
  
  public ObtainableCardBuilder$ViewHolder(View paramView)
  {
    super(paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296790));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297123));
    this.b = ((TextView)paramView.findViewById(2131297013));
    this.c = ((TextView)paramView.findViewById(2131303259));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\ObtainableCardBuilder$ViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */