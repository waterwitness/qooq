import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;

public class hga
  implements ViewPager.OnPageChangeListener
{
  public hga(TroopCardBanner paramTroopCardBanner)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard != null) && (this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() > 1))
    {
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837549);
      }
      paramInt %= this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size();
      ((ImageView)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).setImageResource(2130837548);
      this.a.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */