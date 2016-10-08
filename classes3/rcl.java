import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class rcl
  extends ClickableSpan
{
  private HotChatShare jdField_a_of_type_ComTencentMobileqqAppHotChatShare;
  private ShareHotChatGrayTips jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference b;
  
  public rcl(QQAppInterface paramQQAppInterface, Context paramContext, ShareHotChatGrayTips paramShareHotChatGrayTips, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips = paramShareHotChatGrayTips;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = new HotChatShare((BaseActivity)paramContext, paramQQAppInterface, null);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (((Context)this.b.get() != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips != null))
    {
      paramView = ((HotChatManager)paramView.getManager(59)).a(this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips.mTroopUin);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */