import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tgl
  implements View.OnClickListener
{
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public tgl(MusicPlayerActivity paramMusicPlayerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a(String paramString)
  {
    PackageManager localPackageManager = this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.finish();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
      Object localObject1 = paramView.getTag();
      paramView = paramView.getContext();
      if ((!(localObject1 instanceof tgu)) || (paramView == null)) {
        continue;
      }
      localObject1 = (tgu)localObject1;
      localObject2 = new ArrayList();
      int i = 0;
      while (i <= 3)
      {
        ((List)localObject2).add(ActionSheetAdapter.a(i));
        i += 1;
      }
      Object localObject3 = new ActionSheetAdapter(paramView);
      ((ActionSheetAdapter)localObject3).a((List)localObject2);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(paramView, (ActionSheetAdapter)localObject3, new tgm(this, (tgu)localObject1), null, null, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      if (localObject2 == null) {
        continue;
      }
      localObject1 = Settings.Secure.getString(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.getContentResolver(), "android_id");
      try
      {
        localObject2 = ((IQQPlayerService)localObject2).a();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (SongInfo)localObject2);
        if (!MusicPlayerActivity.a().containsKey(localObject2)) {
          continue;
        }
        localObject3 = paramView.getTag();
        if (paramView.isSelected())
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject2)).longValue(), false);
          paramView.setSelected(false);
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130838702);
          if (!(localObject3 instanceof Integer)) {
            continue;
          }
          i = ((Integer)localObject3).intValue();
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130838702, i);
          return;
        }
      }
      catch (RemoteException paramView)
      {
        QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", paramView);
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject2)).longValue(), true);
      paramView.setSelected(true);
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130838701);
      if (!(localObject3 instanceof Integer)) {
        continue;
      }
      i = ((Integer)localObject3).intValue();
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130838701, i);
      return;
      if (localObject2 == null) {
        continue;
      }
      try
      {
        switch (((IQQPlayerService)localObject2).a())
        {
        case 2: 
          localObject1 = ((IQQPlayerService)localObject2).a();
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            continue;
          }
          i = ((IQQPlayerService)localObject2).g();
          if (i >= 0) {
            if (i < localObject1.length) {}
          }
          break;
        case 3: 
        default: 
          for (;;)
          {
            label536:
            ((IQQPlayerService)localObject2).a(((IQQPlayerService)localObject2).a(), (SongInfo[])localObject1, i);
            if (paramView == null) {
              break;
            }
            localObject1 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, paramView);
            if (!MusicPlayerActivity.b().containsKey(localObject1)) {
              break;
            }
            localObject1 = (tgv)MusicPlayerActivity.b().get(localObject1);
            paramView = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (IQQPlayerService)localObject2, paramView, ((tgv)localObject1).a);
            MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (tgv)localObject1, paramView);
            return;
            ((IQQPlayerService)localObject2).a();
            return;
            ((IQQPlayerService)localObject2).b();
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
            if (a("com.tencent.qqmusic"))
            {
              localObject1 = null;
              paramView = (View)localObject1;
              if (localObject2 != null) {}
              try
              {
                paramView = ((IQQPlayerService)localObject2).a();
                if (paramView == null) {
                  break;
                }
                paramView = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, paramView);
                if (!MusicPlayerActivity.a().containsKey(paramView)) {
                  break;
                }
                paramView = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidqqmusic://form=webpage&mid=23&k1=0&k2=%s&download=1&action=download", new Object[] { String.valueOf(MusicPlayerActivity.a().get(paramView)) })));
                this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.startActivity(paramView);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
                return;
              }
              catch (RemoteException paramView)
              {
                for (;;)
                {
                  QLog.e("MusicPlayerActivity", 1, "music player activity RemoteException ", paramView);
                  paramView = (View)localObject1;
                }
              }
            }
            localObject1 = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, null);
            ((ActionSheet)localObject1).a(2131372587);
            ((ActionSheet)localObject1).a(2131372586, 2);
            ((ActionSheet)localObject1).d(2131372585);
            ((ActionSheet)localObject1).a(new tgo(this, paramView, (ActionSheet)localObject1));
            ((ActionSheet)localObject1).show();
            return;
            paramView = null;
            continue;
            break label536;
            paramView = localObject1[0];
            i = 0;
          }
          return;
        }
      }
      catch (RemoteException paramView) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */