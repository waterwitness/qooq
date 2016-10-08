import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import mqq.app.MobileQQ;

public class noh
  implements URLDrawable.URLDrawableListener
{
  public noh(RichStatItemBuilder paramRichStatItemBuilder, RichStatItemBuilder.Holder paramHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a.getApplication().getResources(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a, RichStatItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder), RichStatItemBuilder.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a, false);
    paramURLDrawable = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a.getManager(57)).a(Integer.toString(RichStatItemBuilder.a().tplId));
    if (!TextUtils.isEmpty(paramURLDrawable.p)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.c.setTextColor(Color.parseColor(paramURLDrawable.p));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\noh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */