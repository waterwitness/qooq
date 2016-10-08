import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.HightlightHotWordText;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.ContainerView;

public class mor
  implements WordMatchManager.MatchCallback
{
  public mor(TextPreviewActivity paramTextPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    paramArrayOfHotWordItem = new QQText(HightlightHotWordText.a(this.a.app, this.a.o, paramArrayOfHotWordItem), 13, 32, this.a.c);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTextQQText = paramArrayOfHotWordItem;
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTextQQText = null;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramArrayOfHotWordItem);
    this.a.f = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */