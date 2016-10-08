package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import wli;
import wlj;
import wlk;

public class ContainerView$SelectableTextView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SelectableTextView jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView;
  
  public ContainerView$SelectableTextView(ContainerView paramContainerView, Context paramContext)
  {
    this(paramContainerView, paramContext, null);
  }
  
  public ContainerView$SelectableTextView(ContainerView paramContainerView, Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContainerView, paramContext, paramAttributeSet, 0);
  }
  
  public ContainerView$SelectableTextView(ContainerView paramContainerView, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView = this;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new wlj(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    clearFocus();
    setTextIsSelectable(true);
    setBackgroundColor(17170445);
    setGravity(19);
    setScroller(null);
    setHighlightColor(1722605812);
    setTextSelectHandle(2130843424);
    setTextSelectHandleLeft(2130843423);
    setTextSelectHandleRight(2130843425);
    setTextSize(28.0F);
    setTextColor(-16777216);
    setVisibility(4);
    if (Build.VERSION.SDK_INT >= 11) {
      setCustomSelectionActionModeCallback(new wli(this, paramContainerView));
    }
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return Integer.MIN_VALUE;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = getScrollX();
    return localLayout.getOffsetForHorizontal(localLayout.getLineForVertical((int)(paramMotionEvent.getY() + getScrollY())), f1 + f2);
  }
  
  private void a()
  {
    try
    {
      Method localMethod = TextView.class.getDeclaredMethod("hideSelectionModifierCursorController", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      Selection.removeSelection((Spannable)getText());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean a(Context paramContext)
  {
    return getSelectionEnd() - getSelectionStart() > 0;
  }
  
  protected boolean getDefaultEditable()
  {
    return false;
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return ArrowKeyMovementMethod.getInstance();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    Object localObject;
    if (ContainerView.a)
    {
      int i = getSelectionStart();
      if (((i != getSelectionEnd()) || (i < 0)) && (paramMotionEvent.getActionMasked() == 0))
      {
        localObject = getText();
        setText(null);
        setText((CharSequence)localObject);
      }
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      localObject = new Rect();
      getGlobalVisibleRect((Rect)localObject);
      if (!((Rect)localObject).contains((int)f1, (int)f2)) {
        break label160;
      }
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_a_of_type_Int = a(paramMotionEvent);
        if ((getSelectionEnd() - getSelectionStart() > 0) && ((this.jdField_a_of_type_Int < getSelectionStart()) || (this.jdField_a_of_type_Int > getSelectionEnd()))) {
          a();
        }
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        label160:
        if (!QLog.isColorLevel()) {
          break label184;
        }
        QLog.e("ContainerView", 2, paramMotionEvent.toString());
      }
      a();
    }
    label184:
    return true;
  }
  
  public void setTextIsSelectable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setTextIsSelectable(paramBoolean);
      return;
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    setClickable(paramBoolean);
    setOnLongClickListener(new wlk(this));
  }
  
  public void setTextSelectHandle(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mTextSelectHandleRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setTextSelectHandleLeft(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mTextSelectHandleLeftRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setTextSelectHandleRight(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mTextSelectHandleRightRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ContainerView$SelectableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */