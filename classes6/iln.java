import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

class iln
  implements Runnable
{
  iln(ilm paramilm, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Ilm.jdField_a_of_type_JavaLangString, null);
    this.jdField_a_of_type_Ilm.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a.setScaleType(ImageView.ScaleType.FIT_START);
    int i = DisplayUtil.a(this.jdField_a_of_type_Ilm.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.getContext(), 19.0F);
    int j = this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth() * i / this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Ilm.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a.getLayoutParams();
    localLayoutParams.width = j;
    localLayoutParams.height = i;
    this.jdField_a_of_type_Ilm.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Ilm.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a.setImageDrawable(localURLDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */