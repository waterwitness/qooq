package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class HotChatFragment$HotChatWebView$HotChatTouchWebView
  extends TouchWebView
{
  public HotChatFragment$HotChatWebView$HotChatTouchWebView(HotChatFragment.HotChatWebView paramHotChatWebView, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent, paramView);
    int j = paramMotionEvent.getAction();
    float f = paramMotionEvent.getY();
    f = this.a.jdField_a_of_type_Int + f;
    paramMotionEvent = this.a.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_JavaUtilArrayList.iterator();
    do
    {
      if (!paramMotionEvent.hasNext()) {
        break;
      }
      paramView = (Rect)paramMotionEvent.next();
    } while ((f <= paramView.top) || (f >= paramView.bottom));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (j != 0) {
          break label131;
        }
        paramMotionEvent = (ViewGroup)getParent();
        if (paramMotionEvent != null)
        {
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          if (QLog.isDevelopLevel()) {
            QLog.e(HotChatFragment.jdField_a_of_type_JavaLangString, 4, "HotChatFrgmentWebView onTouchEvent action down requestDisallowInterceptTouchEvent true");
          }
        }
      }
      label131:
      do
      {
        do
        {
          do
          {
            return bool;
          } while ((j != 3) && (j != 1));
          paramMotionEvent = (ViewGroup)getParent();
        } while (paramMotionEvent == null);
        paramMotionEvent.requestDisallowInterceptTouchEvent(false);
      } while (!QLog.isDevelopLevel());
      QLog.e(HotChatFragment.jdField_a_of_type_JavaLangString, 4, "HotChatFrgmentWebView onTouchEvent action cancel or up requestDisallowInterceptTouchEvent false");
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\HotChatFragment$HotChatWebView$HotChatTouchWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */