package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  public static final String a;
  private EmotionPanelListViewTouchListener a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionPanelListView.class.getSimpleName();
  }
  
  public EmotionPanelListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionPanelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmotionPanelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewTouchListener != null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onTouchEvent lisnter not null");
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewTouchListener.a();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTouchEventListener(EmotionPanelListViewTouchListener paramEmotionPanelListViewTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewTouchListener = paramEmotionPanelListViewTouchListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */