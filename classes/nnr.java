import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nnr
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  public nnr(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, MessageForQQWalletMsg paramMessageForQQWalletMsg, TextView paramTextView3, RelativeLayout paramRelativeLayout, TextView paramTextView4, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {}
    while (paramRedPacketInfo.b == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidWidgetImageView.getResources(), paramRedPacketInfo.b));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.customizeBg = paramRedPacketInfo.b;
    paramRedPacketInfo = new RelativeLayout.LayoutParams(-2, -2);
    paramRedPacketInfo.addRule(14);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder.D;
    label231:
    QQAppInterface localQQAppInterface;
    if (this.c.getText().length() > 7)
    {
      paramInt = 2;
      paramRedPacketInfo.topMargin = (paramInt * i);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramRedPacketInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend()) {
        break label300;
      }
      paramRedPacketInfo = new SpannableStringBuilder("QQ红包个性版");
      paramRedPacketInfo.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, 4, 34);
      paramRedPacketInfo.setSpan(new ForegroundColorSpan(Color.parseColor("#D13D4B")), 4, paramRedPacketInfo.length(), 34);
      this.d.setText(paramRedPacketInfo);
      this.d.setMovementMethod(LinkMovementMethod.getInstance());
      this.d.setLayoutParams(QQWalletMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder));
      this.d.setVisibility(0);
      this.d.setOnClickListener(QQWalletMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder));
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder.a;
      if (!this.jdField_a_of_type_Boolean) {
        break label338;
      }
    }
    label300:
    label338:
    for (paramRedPacketInfo = "1";; paramRedPacketInfo = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006133", "0X8006133", 0, 0, paramRedPacketInfo, "1", "", "");
      return;
      paramInt = 3;
      break;
      this.d.setTextColor(Color.parseColor("#00A5E0"));
      this.d.setText("查看领取详情");
      this.d.setLayoutParams(QQWalletMsgItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder));
      break label231;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */