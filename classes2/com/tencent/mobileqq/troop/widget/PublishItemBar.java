package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;

public class PublishItemBar
  extends LinearLayout
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private boolean jdField_c_of_type_Boolean;
  private Handler jdField_d_of_type_AndroidOsHandler;
  private boolean jdField_d_of_type_Boolean;
  
  public PublishItemBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt & 0x1) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if ((paramInt & 0x2) != 2) {
        break label305;
      }
      bool1 = true;
      label26:
      this.jdField_b_of_type_Boolean = bool1;
      if ((paramInt & 0x8) != 8) {
        break label310;
      }
    }
    label305:
    label310:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      bool1 = bool2;
      if ((paramInt & 0x4) == 4) {
        bool1 = true;
      }
      this.jdField_d_of_type_Boolean = bool1;
      if (getChildCount() > 0) {
        removeAllViews();
      }
      ImageButton localImageButton;
      if (this.jdField_a_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(1));
        localImageButton.setImageResource(2130839425);
        localImageButton.setContentDescription(getResources().getString(2131364939));
        a(localImageButton);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(2));
        localImageButton.setImageResource(2130839420);
        localImageButton.setContentDescription(getResources().getString(2131364941));
        a(localImageButton);
      }
      if (this.jdField_c_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(3));
        localImageButton.setImageResource(2130839426);
        localImageButton.setContentDescription(getResources().getString(2131364943));
        a(localImageButton);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(4));
        localImageButton.setImageResource(2130839424);
        localImageButton.setContentDescription(getResources().getString(2131364942));
        a(localImageButton);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
    }
  }
  
  public void a(ImageButton paramImageButton)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    paramImageButton.setPadding(0, 0, (int)DisplayUtils.a(getContext(), 24.0F), 0);
    paramImageButton.setBackgroundResource(2130843537);
    paramImageButton.setLayoutParams(localLayoutParams);
    addView(paramImageButton);
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      switch (((Integer)paramView).intValue())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        } while (this.jdField_d_of_type_AndroidOsHandler == null);
        this.jdField_d_of_type_AndroidOsHandler.sendEmptyMessage(2);
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    } while (this.jdField_b_of_type_AndroidOsHandler == null);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void setAudioCallback(Handler paramHandler)
  {
    this.jdField_d_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setAudioEnable(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ImageButton))
      {
        if (!paramBoolean) {
          break label52;
        }
        ((ImageButton)localView).setImageResource(2130840129);
      }
      for (;;)
      {
        i += 1;
        break;
        label52:
        ((ImageButton)localView).setImageResource(2130840128);
      }
    }
  }
  
  public void setCallback(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setMusicCallback(Handler paramHandler)
  {
    this.jdField_c_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setVideoCallback(Handler paramHandler)
  {
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\PublishItemBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */