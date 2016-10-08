import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.SwipListView;
import java.util.List;

class idd
  implements Runnable
{
  idd(idc paramidc, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i;
    if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a) != null)
    {
      i = SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a).size();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label142;
      }
    }
    label142:
    for (int j = this.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a, this.jdField_a_of_type_JavaUtilList);
      if ((SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a)) && (i != j))
      {
        if (this.jdField_a_of_type_Idc.a.a.g == 2) {
          SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a).setSelectionFromBottom(SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a).getCount() - 1, 0);
        }
        SubscriptFeedsActivity.b(this.jdField_a_of_type_Idc.a, false);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */