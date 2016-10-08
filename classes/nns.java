import android.graphics.drawable.BitmapDrawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nns
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  public nns(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder, RelativeLayout paramRelativeLayout, MessageForQQWalletMsg paramMessageForQQWalletMsg, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {}
    while (paramRedPacketInfo.a == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources(), paramRedPacketInfo.a));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType == 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.background = paramRedPacketInfo.a;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */