import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.GuideViewBuilder;
import com.tencent.mobileqq.widget.GuideViewBuilder.GuideLayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class wmj
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  int[] jdField_a_of_type_ArrayOfInt;
  
  public wmj(GuideViewBuilder paramGuideViewBuilder, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(wmi paramwmi, GuideViewBuilder.GuideLayoutParams paramGuideLayoutParams)
  {
    if (paramGuideLayoutParams.width == -9) {
      paramGuideLayoutParams.width = (paramwmi.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -paramGuideLayoutParams.c * 2);
    }
    if (paramGuideLayoutParams.height == -9) {
      paramGuideLayoutParams.height = (paramwmi.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -paramGuideLayoutParams.d * 2);
    }
    if (paramGuideLayoutParams.c != Integer.MAX_VALUE)
    {
      paramGuideLayoutParams.gravity |= 0x3;
      paramGuideLayoutParams.leftMargin = (paramwmi.jdField_a_of_type_ArrayOfInt[0] + paramGuideLayoutParams.c - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (paramGuideLayoutParams.d != Integer.MAX_VALUE)
    {
      paramGuideLayoutParams.gravity |= 0x30;
      paramGuideLayoutParams.topMargin = (paramwmi.jdField_a_of_type_ArrayOfInt[1] + paramGuideLayoutParams.d - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return paramGuideLayoutParams;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
      {
        wmi localwmi = (wmi)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
        if (localwmi.jdField_a_of_type_ArrayOfInt == null)
        {
          localwmi.jdField_a_of_type_ArrayOfInt = new int[2];
          localwmi.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localwmi.jdField_a_of_type_ArrayOfInt);
        }
        i += 1;
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuideView", 2, "getLocationOnScreen Null Pointer");
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
    {
      wmi localwmi = (wmi)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localwmi.jdField_a_of_type_ArrayOfInt[0], localwmi.jdField_a_of_type_ArrayOfInt[1], localwmi.jdField_a_of_type_ArrayOfInt[0] + localwmi.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localwmi.jdField_a_of_type_ArrayOfInt[1] + localwmi.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localwmi.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
    {
      wmi localwmi = (wmi)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(paramInt1);
      Iterator localIterator = localwmi.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localwmi, (GuideViewBuilder.GuideLayoutParams)localPair.second);
          }
          if (localObject != null) {
            addViewInLayout((View)localPair.first, -1, (ViewGroup.LayoutParams)localObject);
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i = 0;
      while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
      {
        wmi localwmi = (wmi)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
        if ((paramMotionEvent.getX() > localwmi.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localwmi.jdField_a_of_type_ArrayOfInt[0] + localwmi.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localwmi.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localwmi.jdField_a_of_type_ArrayOfInt[1] + localwmi.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localwmi.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder.a.dismiss();
          localwmi.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localwmi.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */