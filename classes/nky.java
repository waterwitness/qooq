import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongPluginHelper;

public class nky
  extends ClickableSpan
{
  public nky(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString, MessageForGrayTips paramMessageForGrayTips)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = Integer.parseInt(this.jdField_a_of_type_JavaLangString);
    DingdongPluginHelper.a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a, i, this.jdField_a_of_type_ComTencentMobileqqDataMessageForGrayTips.getExtInfoFromExtStr("approval_workid"));
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */