import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class nlk
  extends ClickableSpan
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference b;
  
  public nlk(GrayTipsItemBuilder paramGrayTipsItemBuilder, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Context localContext = (Context)this.b.get();
    if ((paramView == null) || (localContext == null)) {}
    while (!(localContext instanceof Activity)) {
      return;
    }
    if (!NetworkUtil.e(localContext))
    {
      QQToast.a(localContext, 2131367256, 0).b(localContext.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    Intent localIntent = new Intent(localContext, QQSpecialCareSettingActivity.class);
    localIntent.putExtra("key_friend_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a.a);
    localContext.startActivity(localIntent);
    VipUtils.a(paramView, "Vip_SpecialRemind", "0X8005057", "0X8005057", 0, 1, new String[0]);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nlk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */