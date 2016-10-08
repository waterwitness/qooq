package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.PinnedHeaderExpandableListView;

public class QfilePinnedHeaderExpandableListView
  extends PinnedHeaderExpandableListView
{
  public static final float a = 1.73F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float d;
  private int g;
  private int h;
  private int i;
  
  public QfilePinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "QfilePinnedHeaderExpandableListView<FileAssistant>";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.g = -1;
    this.h = -1;
    setNeedCheckSpringback(true);
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "QfilePinnedHeaderExpandableListView<FileAssistant>";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.g = -1;
    this.h = -1;
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "QfilePinnedHeaderExpandableListView<FileAssistant>";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.g = -1;
    this.h = -1;
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setSelector(2131427379);
    setGroupIndicator(paramContext.getResources().getDrawable(2130838372));
  }
  
  public ImageHolder a(int paramInt1, int paramInt2)
  {
    int j = s();
    Object localObject = (ViewGroup)getChildAt(b(paramInt1, paramInt2) - j);
    if (localObject == null) {
      return null;
    }
    paramInt2 = ((ViewGroup)localObject).getChildCount();
    if (this.i == 0) {
      return null;
    }
    if (paramInt1 > this.i * paramInt2) {
      paramInt1 = paramInt2 - 1;
    }
    for (;;)
    {
      localObject = ((ViewGroup)localObject).getChildAt(paramInt1);
      if (localObject != null) {
        break;
      }
      return null;
      paramInt1 /= this.i;
    }
    localObject = ((View)localObject).getTag();
    if ((localObject != null) && ((localObject instanceof ImageHolder))) {
      return (ImageHolder)localObject;
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      j = paramMotionEvent.getAction();
      if ((j != 2) || (!this.jdField_c_of_type_Boolean)) {}
    }
    boolean bool;
    do
    {
      for (;;)
      {
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        switch (j & 0xFF)
        {
        default: 
        case 2: 
        case 0: 
          while (!this.jdField_c_of_type_Boolean)
          {
            return super.onInterceptTouchEvent(paramMotionEvent);
            float f3 = Math.abs(f1 - this.jdField_b_of_type_Float);
            if ((f3 > Math.abs(f2 - this.jdField_c_of_type_Float) * 1.73F) && (f3 > this.d))
            {
              this.jdField_c_of_type_Boolean = true;
              this.jdField_b_of_type_Float = f1;
              this.jdField_c_of_type_Float = f2;
              continue;
              this.jdField_b_of_type_Float = f1;
              this.jdField_c_of_type_Float = f2;
              ImageHolder localImageHolder = a((int)f1, (int)f2);
              if (localImageHolder != null)
              {
                j = localImageHolder.jdField_b_of_type_Int;
                this.g = j;
                this.jdField_a_of_type_Int = j;
                j = localImageHolder.jdField_a_of_type_Int;
                this.h = j;
                this.jdField_b_of_type_Int = j;
              }
            }
          }
        }
      }
      bool = this.jdField_c_of_type_Boolean;
      this.jdField_c_of_type_Boolean = false;
      this.g = -1;
      this.jdField_a_of_type_Int = -1;
      this.h = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = false;
    } while (!bool);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j;
    float f1;
    float f2;
    label130:
    int k;
    if (this.jdField_b_of_type_Boolean)
    {
      j = paramMotionEvent.getAction();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      switch (j & 0xFF)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (this.jdField_c_of_type_Boolean)
          {
            return true;
            if (!this.jdField_c_of_type_Boolean)
            {
              float f3 = Math.abs(f1 - this.jdField_b_of_type_Float);
              if ((f3 > Math.abs(f2 - this.jdField_c_of_type_Float) * 1.73F) && (f3 > this.d))
              {
                this.jdField_c_of_type_Boolean = true;
                this.jdField_b_of_type_Float = f1;
                this.jdField_c_of_type_Float = f2;
              }
            }
            else
            {
              if (!this.jdField_c_of_type_Boolean) {
                continue;
              }
              if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != -1) && (this.jdField_b_of_type_Int != -1))
              {
                if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener != null) {
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
                }
                this.jdField_a_of_type_Boolean = true;
              }
              ImageHolder localImageHolder = a((int)f1, (int)f2);
              if (localImageHolder == null) {
                break label456;
              }
              k = localImageHolder.jdField_b_of_type_Int;
              j = localImageHolder.jdField_a_of_type_Int;
            }
          }
        }
      }
    }
    while ((k != -1) && (j != -1))
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.g = k;
        this.jdField_a_of_type_Int = k;
        this.h = j;
        this.jdField_b_of_type_Int = j;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener.a(true);
        break label130;
      }
      this.g = k;
      this.h = j;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.g, this.h);
      break;
      this.jdField_b_of_type_Float = f1;
      this.jdField_c_of_type_Float = f2;
      break;
      boolean bool = this.jdField_c_of_type_Boolean;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener.b(this.g, this.h);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener.a(false);
      }
      this.g = -1;
      this.jdField_a_of_type_Int = -1;
      this.h = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      if (!bool) {
        break;
      }
      return true;
      return super.onTouchEvent(paramMotionEvent);
      label456:
      j = -1;
      k = -1;
    }
  }
  
  public void setGridSize(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setOnIndexChangedListener(QfilePinnedHeaderExpandableListView.OnSelectListener paramOnSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = paramOnSelectListener;
  }
  
  public void setTouchSlop(Context paramContext)
  {
    this.d = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
  }
  
  public void setWhetherImageTab(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\widget\QfilePinnedHeaderExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */