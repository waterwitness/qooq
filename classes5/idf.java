import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;

class idf
  implements Runnable
{
  idf(idc paramidc, Serializable paramSerializable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a));
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a).a = true;
      localSubscriptFeedsActivity = this.jdField_a_of_type_Idc.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Idc.a).f != 1) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      SubscriptFeedsActivity.a(localSubscriptFeedsActivity, false, false, bool);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */