import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

public class qzs
  implements IIconListener
{
  public qzs(SearchResultActivity paramSearchResultActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Int == 0)
      {
        int i = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof qzu)))
          {
            paramBitmap = (qzu)paramBitmap;
            if (paramBitmap.jdField_a_of_type_Int == paramInt1) {
              SearchResultActivity.a(this.a, paramBitmap, paramBitmap.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */