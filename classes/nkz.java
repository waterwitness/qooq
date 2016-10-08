import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class nkz
  extends ClickableSpan
{
  public nkz(GrayTipsItemBuilder paramGrayTipsItemBuilder, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a instanceof Activity))
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a);
      paramView.a(2131369562);
      paramView.c(2131370838);
      paramView.d(2131367262);
      paramView.a(new nla(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a).getChatFragment().a();
      if ((localBaseChatPie instanceof DiscussChatPie)) {
        ((DiscussChatPie)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */