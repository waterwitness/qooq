import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.MpFileConstant;

public class sbu
  extends BroadcastReceiver
{
  public sbu(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      long l;
      int i;
      int j;
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
        } while (paramContext == null);
        if (!MpFileConstant.d.equalsIgnoreCase(paramContext)) {
          break;
        }
        paramContext = paramIntent.getExtras();
        l = paramIntent.getLongExtra(MpFileConstant.f, 0L);
        i = paramContext.getInt(MpFileConstant.e);
        j = paramContext.getInt("result");
        if ((i == 0) && (j == 0)) {
          BaseActionBarDataLineFile.a(this.a, true);
        }
        QLog.d(BaseActionBarDataLineFile.a() + "[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
      } while (BaseActionBarDataLineFile.a(this.a) != l);
      if (i == 0)
      {
        i = paramContext.getInt("result");
        paramIntent = paramContext.getByteArray("bytes_json");
        j = paramContext.getInt("power");
        this.a.a(j);
        boolean bool = paramContext.getBoolean("inputPwdError", false);
        switch (i)
        {
        default: 
          QLog.d(BaseActionBarDataLineFile.a(), 1, "andorid 6.3.0 accept valid C2C response:" + i);
          return;
        case 0: 
          this.a.g();
          return;
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          BaseActionBarDataLineFile.a(this.a, i + 2000);
          this.a.a.b().setVisibility(8);
          return;
        case 5: 
          this.a.a(paramIntent, bool);
          return;
        case 6: 
          this.a.a(paramIntent);
          return;
        case 7: 
          this.a.h();
          return;
        }
        this.a.i();
        return;
      }
      if (i == 1013)
      {
        FMToastUtil.a(2131362293);
        return;
      }
      if (i == 1014)
      {
        FMToastUtil.a(2131362262);
        return;
      }
      BaseActionBarDataLineFile.a(this.a, i);
      this.a.a.b().setVisibility(8);
      return;
    } while (!MpFileConstant.s.equalsIgnoreCase(paramContext));
    BaseActionBarDataLineFile.a(this.a, false);
    QLog.d(BaseActionBarDataLineFile.a() + "[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */