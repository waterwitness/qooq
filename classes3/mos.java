import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mos
  implements WordMatchManager.MatcherCallback
{
  public mos(TextPreviewActivity paramTextPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(WordMatchManager.WordMatcher paramWordMatcher)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramWordMatcher;
    this.a.f = paramWordMatcher.a(1, this.a.o, 3, this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */