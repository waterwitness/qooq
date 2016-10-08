import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.weiyun.AlbumBackupInfo;
import cooperation.weiyun.AlbumBackupLaunchProxyActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class rrx
  implements View.OnClickListener
{
  public rrx(QfileFileAssistantActivity paramQfileFileAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!QfileFileAssistantActivity.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i(QfileFileAssistantActivity.e, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      return;
      QfileFileAssistantActivity.a(this.a);
      paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
      if (paramView.a == 0) {
        continue;
      }
      long l = paramView.a;
      Object localObject1;
      label570:
      Object localObject2;
      BusinessInfoCheckUpdate.AppInfo localAppInfo;
      JSONObject localJSONObject;
      switch ((int)l)
      {
      case 18: 
      case 20: 
      default: 
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(QfileFileAssistantActivity.e, 2, "unknow category!!! return onClick");
        return;
      case 12: 
        paramView = new FileManagerReporter.fileAssistantReportData();
        paramView.b = "file_assistant_in";
        paramView.a = 1;
        FileManagerReporter.a(this.a.app.a(), paramView);
        localObject1 = new Intent(this.a.getApplicationContext(), LiteActivity.class);
        paramView = (View)localObject1;
        if (this.a.h)
        {
          FileManagerReporter.a("0X8005534");
          paramView = (View)localObject1;
        }
      case 13: 
      case 14: 
      case 19: 
      case 15: 
        for (;;)
        {
          try
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("category", l);
            paramView.putExtra("bundle", (Bundle)localObject1);
            paramView.putExtra("from", "FileAssistant");
            this.a.startActivityForResult(paramView, 101);
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          paramView = new FileManagerReporter.fileAssistantReportData();
          paramView.b = "file_assistant_in";
          paramView.a = 2;
          FileManagerReporter.a(this.a.app.a(), paramView);
          localObject1 = new Intent(this.a.getApplicationContext(), FMActivity.class);
          ((Intent)localObject1).putExtra("tab_tab_type", 7);
          paramView = (View)localObject1;
          if (this.a.h)
          {
            FileManagerReporter.a("0X8005537");
            paramView = (View)localObject1;
            continue;
            paramView = new FileManagerReporter.fileAssistantReportData();
            paramView.b = "file_assistant_in";
            paramView.a = 3;
            FileManagerReporter.a(this.a.app.a(), paramView);
            QfileFileAssistantActivity.b(this.a);
            if (!this.a.h) {
              break;
            }
            FileManagerReporter.a("0X800553A");
            return;
            paramView = new Bundle();
            paramView.putBoolean("string_from", false);
            paramView.putBoolean("string_uin", false);
            paramView.putLong("device_din", 0L);
            paramView.putInt("sTitleID", 0);
            QQProxyForDataline.a(this.a, paramView, "com.qqdataline.mpfile.LiteMpFileMainActivity");
            if (!this.a.h) {
              break;
            }
            FileManagerReporter.a("0X8005539");
            return;
            paramView = new FileManagerReporter.fileAssistantReportData();
            paramView.b = "file_assistant_in";
            paramView.a = 10;
            FileManagerReporter.a(this.a.app.a(), paramView);
            localObject1 = new Intent(this.a.getApplicationContext(), FMActivity.class);
            ((Intent)localObject1).putExtra("tab_tab_type", 1);
            paramView = (View)localObject1;
            if (this.a.h)
            {
              FileManagerReporter.a("0X8005538");
              paramView = (View)localObject1;
            }
          }
        }
      case 16: 
        if (AlbumBackupInfo.a(this.a.app.getApplication(), this.a.app.a()))
        {
          AlbumBackupProxyActivity.a(this.a, this.a.app.a());
          this.a.overridePendingTransition(2130968590, 2130968591);
          ReportController.b(this.a.app, "CliOper", "", "", "Weiyun_Backup", "Enter_Backup", 0, 0, "", "", "", "");
          if (paramView.c != null)
          {
            localObject1 = (RedTouchManager)this.a.app.getManager(35);
            localObject2 = String.valueOf("100160.100162");
            localAppInfo = ((RedTouchManager)localObject1).a((String)localObject2);
            if ((localAppInfo != null) && (localAppInfo.iNewFlag != null) && (localAppInfo.iNewFlag.get() != 0)) {
              localJSONObject = new JSONObject();
            }
          }
        }
      case 17: 
      case 21: 
        try
        {
          localJSONObject.put("service_type", 2);
          localJSONObject.put("act_id", 1002);
          localJSONObject.put("obj_id", "");
          localJSONObject.put("pay_amt", 0);
          ((RedTouchManager)localObject1).b(localAppInfo, localJSONObject.toString());
          ((RedTouchManager)localObject1).b((String)localObject2);
          paramView.c.setVisibility(8);
          CustomWidgetUtil.a(paramView.c, 0, 0, 0);
          if (!this.a.h) {
            continue;
          }
          FileManagerReporter.a("0X8005536");
          return;
          AlbumBackupLaunchProxyActivity.a(this.a, this.a.app.a());
          break label570;
          QfileFileAssistantActivity.c(this.a);
          paramView = (RedTouchManager)this.a.app.getManager(35);
          localObject1 = paramView.a(String.valueOf("100160.100161"));
          if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
            paramView.b(String.valueOf("100160.100161"));
          }
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("service_type", 2);
            ((JSONObject)localObject2).put("act_id", 1002);
            paramView.b((BusinessInfoCheckUpdate.AppInfo)localObject1, ((JSONObject)localObject2).toString());
            if (!this.a.h) {
              continue;
            }
            FileManagerReporter.a("0X8005535");
            return;
          }
          catch (JSONException paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
            }
          }
          FileManagerUtil.a(this.a, "_is_from_qfile_shortcut", this.a.getString(2131362722), 2130840389);
          FMToastUtil.b(2131362721);
          paramView.e.setClickable(false);
          paramView.e.setOnClickListener(null);
          paramView.e.setText(this.a.getString(2131362720));
          FileManagerReporter.a("0X8005532");
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rrx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */