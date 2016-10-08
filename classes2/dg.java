import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dg
  implements View.OnClickListener
{
  public dg(DatalineFilesAdapter paramDatalineFilesAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((DatalineFilesAdapter.ItemHolder)localObject2).a.jdField_a_of_type_Long);
    Object localObject1 = DatalineFilesAdapter.a(this.a).a().a(i).b(((DatalineFilesAdapter.ItemHolder)localObject2).a.jdField_a_of_type_Long);
    if (localObject1 == null) {
      return;
    }
    paramView = ((DatalineFilesAdapter.ItemHolder)localObject2).a;
    switch (paramView.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 3: 
      localObject2 = (DataLineHandler)DatalineFilesAdapter.a(this.a).a(8);
      if ((((DataLineMsgRecord)localObject1).strMoloKey != null) && (!((DataLineMsgRecord)localObject1).isReportPause))
      {
        ((DataLineMsgRecord)localObject1).isReportPause = true;
        DataLineReportUtil.m(DatalineFilesAdapter.a(this.a));
      }
      ((DataLineHandler)localObject2).a(((DataLineMsgRecord)localObject1).groupId, ((DataLineMsgRecord)localObject1).sessionid, false);
      if (((DataLineMsgRecord)localObject1).isSendFromLocal())
      {
        paramView.jdField_a_of_type_Int = 1;
        return;
      }
      break;
    case 1: 
    case 2: 
    case 4: 
      if (NetworkUtil.e(DatalineFilesAdapter.a(this.a)))
      {
        if ((FileManagerUtil.a()) && (paramView.b > 3145728L))
        {
          localObject1 = new dh(this, (DataLineMsgRecord)localObject1, (DatalineFilesAdapter.ItemHolder)localObject2);
          localObject2 = new di(this);
          if (paramView.jdField_a_of_type_Int == 1)
          {
            DialogUtil.a(DatalineFilesAdapter.a(this.a), 230, DatalineFilesAdapter.a(this.a).getString(2131362128), DatalineFilesAdapter.a(this.a).getString(2131362851), 2131367262, 2131362134, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
            return;
          }
          DialogUtil.a(DatalineFilesAdapter.a(this.a), 230, DatalineFilesAdapter.a(this.a).getString(2131362131), DatalineFilesAdapter.a(this.a).getString(2131362852), 2131367262, 2131362134, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
          return;
        }
        i = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject1).sessionid);
        DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.a).a(i).a(((DataLineMsgRecord)localObject1).sessionid);
        if (localDataLineMsgSet != null) {
          localDataLineMsgSet.setPaused(false);
        }
        if (paramView.jdField_a_of_type_Int != 1)
        {
          if ((((DataLineMsgRecord)localObject1).fileMsgStatus == 1L) && (((DataLineMsgRecord)localObject1).strMoloKey != null)) {
            DataLineReportUtil.e(DatalineFilesAdapter.a(this.a));
          }
          DatalineFilesAdapter.a(this.a, (DatalineFilesAdapter.ItemHolder)localObject2, (DataLineMsgRecord)localObject1);
          return;
        }
        DatalineFilesAdapter.b(this.a, (DatalineFilesAdapter.ItemHolder)localObject2, (DataLineMsgRecord)localObject1);
        return;
      }
      FMToastUtil.a(2131368805);
      return;
    case 5: 
      DatalineFilesAdapter.a(this.a, (DataLineMsgRecord)localObject1);
      return;
    }
    paramView.jdField_a_of_type_Int = 4;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */