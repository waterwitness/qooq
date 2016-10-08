import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.litetransfersdk.ProgressInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;

class dd
  implements DialogInterface.OnClickListener
{
  dd(dc paramdc, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Dc.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.a.a(this.jdField_a_of_type_Dc.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    if (DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dc.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).containsKey(Long.valueOf(this.jdField_a_of_type_Dc.jdField_a_of_type_Long)))
    {
      ProgressInfo localProgressInfo = (ProgressInfo)DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dc.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).get(Long.valueOf(this.jdField_a_of_type_Dc.jdField_a_of_type_Long));
      DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dc.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).remove(Long.valueOf(this.jdField_a_of_type_Dc.jdField_a_of_type_Long));
      DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dc.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).remove(localProgressInfo);
      this.jdField_a_of_type_Dc.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.notifyDataSetChanged();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */