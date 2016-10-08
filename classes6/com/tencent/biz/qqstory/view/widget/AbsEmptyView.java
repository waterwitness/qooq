package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import izz;
import jaa;

public abstract class AbsEmptyView
  extends FrameLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static final int e = 500;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View b;
  private View c;
  private int f;
  private int g;
  private int h;
  
  public AbsEmptyView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 0;
    a(paramContext);
  }
  
  public AbsEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = 0;
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.h != paramInt) {}
    }
    do
    {
      do
      {
        return;
      } while ((this.h == 0) && (paramInt == 3));
      this.h = paramInt;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        return;
      }
      if (paramInt == 3)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        this.c.setVisibility(0);
        this.b.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302880));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302879));
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(0);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298186));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302883));
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2130904480, this);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131302884);
    this.b = super.findViewById(2131302882);
    this.c = super.findViewById(2131302878);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131302881));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298186));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302883));
    this.f = UIUtils.a(getContext());
    this.g = a();
    a(0, true);
    super.postDelayed(new jaa(this), 500L);
  }
  
  public abstract int a();
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    a(paramString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f, 1073741824), View.MeasureSpec.makeMeasureSpec(this.g, 1073741824));
  }
  
  public void setRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new izz(this, paramOnClickListener));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\AbsEmptyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */