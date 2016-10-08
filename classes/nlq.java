import android.app.Activity;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

public class nlq
  implements AnimationTextView.OnSingleClick
{
  public nlq(LongMsgItemBuilder paramLongMsgItemBuilder, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongMsgItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject;
    float f1;
    float f2;
    float f3;
    int k;
    boolean bool2;
    int j;
    boolean bool1;
    if ((paramView instanceof AnimationTextView))
    {
      localObject = (AnimationTextView)paramView;
      f1 = ((AnimationTextView)localObject).a - LongMsgItemBuilder.a();
      f2 = ((AnimationTextView)localObject).b;
      f3 = LongMsgItemBuilder.b();
      if (this.jdField_a_of_type_Boolean) {
        f1 = ((AnimationTextView)localObject).a - LongMsgItemBuilder.c();
      }
      localObject = ((AnimationTextView)localObject).getText();
      if ((localObject instanceof QQText))
      {
        localObject = (QQText)localObject;
        localObject = (QQText.EmotcationSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), QQText.EmotcationSpan.class);
        if (!(paramView instanceof ETTextView)) {
          break label333;
        }
        paramView = (ETTextView)paramView;
        k = paramView.jdField_a_of_type_Int;
        int m = paramView.b;
        if ((paramView.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (paramView.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 0) || (paramView.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType != 1)) {
          break label315;
        }
        bool2 = true;
        i = k;
        j = m;
        bool1 = bool2;
        if (bool2)
        {
          i = k;
          j = m;
          bool1 = bool2;
          if (paramView.a() != null)
          {
            paramView = paramView.a();
            if (QLog.isColorLevel()) {
              QLog.d(ChatItemBuilder.a, 2, "isHanYiFont, onlyEmoji: " + paramView.jdField_a_of_type_Boolean);
            }
            if (paramView.jdField_a_of_type_Boolean) {
              break label321;
            }
            bool1 = true;
            label249:
            j = m;
          }
        }
      }
    }
    for (int i = k;; i = -1)
    {
      if ((i != -1) && (j != -1)) {}
      for (bool2 = true;; bool2 = false)
      {
        EmoticonUtils.a((QQText.EmotcationSpan[])localObject, f1, f2 - f3, bool2, i, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_AndroidContentContext, bool1);
        return;
        label315:
        bool2 = false;
        break;
        label321:
        bool1 = false;
        break label249;
      }
      label333:
      bool1 = false;
      j = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nlq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */