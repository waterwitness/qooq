package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LyricViewDetail
  extends LyricView
{
  public LyricViewDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramContext = LayoutInflater.from(paramContext).inflate(2130903108, this);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = ((LyricViewScroll)paramContext.findViewById(2131297154));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = ((LyricViewInternal)paramContext.findViewById(2131297155));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewAttribute);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollEnable(this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\widget\LyricViewDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */