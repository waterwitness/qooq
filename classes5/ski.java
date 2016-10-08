import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ski
  implements View.OnClickListener
{
  public ski(SendBottomBar paramSendBottomBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    int i = TroopFileUtils.a(SendBottomBar.a(this.a));
    if (i == 0)
    {
      TroopFileError.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131364197));
      this.a.b();
      return;
    }
    if (1 == i)
    {
      skl localskl = new skl(this);
      DialogUtil.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131364178), SendBottomBar.a(this.a).getString(2131364183), 2131367262, 2131364139, localskl, localskl).show();
      return;
    }
    this.a.b();
  }
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a)) {
      return;
    }
    SendBottomBar.a(this.a, true);
    new Handler().postDelayed(new skj(this), 800L);
    int j;
    switch (SendBottomBar.a(this.a).b())
    {
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    default: 
      j = SendBottomBar.a(this.a).a();
      if (j != 1) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (j != 5) {
        break label366;
      }
      this.a.b();
      return;
      if (SendBottomBar.a(this.a).c())
      {
        paramView = new Intent();
        paramView.putParcelableArrayListExtra("reslut_select_file_info_list", FMDataCache.b());
        paramView.putExtra("approval_attachment_customid", SendBottomBar.a(this.a).f());
        SendBottomBar.a(this.a).setResult(-1, paramView);
      }
      SendBottomBar.a(this.a).finish();
      return;
      SendBottomBar.a(this.a);
      return;
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(SplashActivity.sTopActivity, 2131362855, 2131362851, new skk(this));
        return;
      }
      paramView = FMDataCache.b();
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("sFilesSelected", paramView);
      SendBottomBar.a(this.a).setResult(-1, localIntent);
      SendBottomBar.a(this.a).finish();
      return;
      paramView = SendBottomBar.a(this.a).getIntent();
      if (paramView == null) {
        break;
      }
      if (paramView.getStringExtra("posturl") != null)
      {
        paramView.putParcelableArrayListExtra("fileinfo", FMDataCache.b());
        SendBottomBar.a(this.a).setResult(-1, paramView);
        SendBottomBar.a(this.a).finish();
        return;
      }
      SendBottomBar.a(this.a).setResult(-1, paramView);
      SendBottomBar.a(this.a).finish();
      return;
    }
    label366:
    if (i != 0)
    {
      a();
      return;
    }
    this.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ski.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */