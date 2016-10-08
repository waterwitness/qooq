import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.biz.troopgift.GridListAdapter;
import com.tencent.biz.troopgift.GridListAdapter.Holder;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class jen
  implements Runnable
{
  public jen(GridListAdapter paramGridListAdapter, GridListAdapter.Holder paramHolder, TroopGiftAioItemData paramTroopGiftAioItemData, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 5.0F);
    Paint localPaint = new Paint();
    localPaint.setTextSize(DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 11.0F));
    float f1 = localPaint.measureText(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.l);
    float f2 = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 2.0F);
    int m = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 1.0F);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a.getResources(), this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a(i, j, k, f2 + f1, m, this.jdField_a_of_type_Int)));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */