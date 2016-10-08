import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import mqq.app.MobileQQ;

public class am
  implements View.OnClickListener
{
  public am(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, DataLineMsgSet paramDataLineMsgSet, Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (2131305415 == paramView.getId())
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_copy");
      ((ClipboardManager)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg);
    }
    int i;
    label384:
    label487:
    label493:
    do
    {
      return;
      if (2131305406 == paramView.getId())
      {
        StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_delete");
        paramView = new an(this);
        localObject1 = new ao(this);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131362133), this.jdField_a_of_type_AndroidContentContext.getString(2131362159), 2131367262, 2131362134, paramView, (DialogInterface.OnClickListener)localObject1).show();
        return;
      }
      if (2131297425 == paramView.getId())
      {
        StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_forward");
        if (this.jdField_a_of_type_Int == 64536)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("forward_text", new QQText(paramView.msg, 13, 32, 6000).toString());
          ((Intent)localObject1).putExtra("forward_type", -1);
          ((Intent)localObject1).putExtra("isFromShare", true);
          ForwardBaseOption.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject1, 4);
          return;
        }
        if (FileUtils.b(this.jdField_a_of_type_JavaLangString))
        {
          l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
          paramView = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
          localObject1 = new ForwardFileInfo();
          ((ForwardFileInfo)localObject1).b(10000);
          ((ForwardFileInfo)localObject1).d(6);
          ((ForwardFileInfo)localObject1).d(paramView);
          ((ForwardFileInfo)localObject1).d(l);
          ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_JavaLangString);
          ((ForwardFileInfo)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.entityID);
          localObject2 = new Intent();
          if (this.jdField_a_of_type_Boolean)
          {
            ((Intent)localObject2).putExtra("forward_text", paramView);
            if (!this.jdField_a_of_type_Boolean) {
              break label487;
            }
            i = 1;
            ((Intent)localObject2).putExtra("forward_type", i);
            ((Intent)localObject2).putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
            ((Intent)localObject2).putExtra("not_forward", true);
            ((Intent)localObject2).putExtra("isFromShare", true);
            if (!this.jdField_a_of_type_Boolean) {
              break label493;
            }
            ((Intent)localObject2).putExtra("forward_thumb", this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path);
          }
          for (;;)
          {
            ForwardBaseOption.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject2, 4);
            return;
            paramView = "已选择" + paramView + "。";
            break;
            i = 0;
            break label384;
            ((Intent)localObject2).putExtra("k_favorites", false);
          }
        }
        ActionBarUtil.a(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, 10009);
        return;
      }
      if (2131299841 == paramView.getId())
      {
        if (this.jdField_a_of_type_JavaLangString.isEmpty())
        {
          QfavBuilder.a(null, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
          QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 1);
          return;
        }
        QfavBuilder.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 3);
        return;
      }
    } while (2131305416 != paramView.getId());
    StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_save2weiyun");
    long l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
    if (((DataLineMsgRecord)localObject2).nWeiyunSessionId != 0L) {}
    for (paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);; paramView = null)
    {
      if ((FileManagerUtil.a()) && (l > 3145728L))
      {
        FMDialogUtil.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), 2131362855, 2131362851, new ap(this, (DataLineMsgRecord)localObject2, paramView, (String)localObject1));
        return;
      }
      if (paramView == null)
      {
        i = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject2).sessionid);
        FMToastUtil.b(FileManagerUtil.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131362813));
        ((DataLineMsgRecord)localObject2).nWeiyunSessionId = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false).nSessionId;
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(i).c(((DataLineMsgRecord)localObject2).msgId);
        return;
      }
      FMToastUtil.b(FileManagerUtil.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131362813));
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */