import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class uvg
  implements View.OnLongClickListener
{
  public uvg(StructMsgForGeneralShare paramStructMsgForGeneralShare, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramView.getTag();
    if (!TextUtils.isEmpty(localAbsStructMsgElement.m)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localAbsStructMsgElement.m).intValue();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onLongClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */