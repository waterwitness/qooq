import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.dataline.activities.DLRouterActivity;
import com.dataline.activities.DLRouterSessionInfoActivity;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class m
  implements AdapterView.OnItemClickListener
{
  public m(DLRouterActivity paramDLRouterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (SmartDeviceProxyMgr)this.a.app.a(51);
    paramView = paramAdapterView.a(Long.parseLong(this.a.b));
    if ((paramView == null) || (paramView.userStatus == 20))
    {
      FMToastUtil.a(2131362322);
      return;
    }
    switch (this.a.a.a()[paramInt][1])
    {
    default: 
      return;
    case 2130838151: 
      paramAdapterView = new Bundle();
      paramAdapterView.putBoolean("string_from", false);
      paramAdapterView.putBoolean("string_uin", false);
      paramAdapterView.putLong("device_din", Long.parseLong(this.a.b));
      paramAdapterView.putInt("sTitleID", 2131362388);
      QQProxyForDataline.a(this.a, paramAdapterView, "com.qqdataline.mpfile.LiteMpFileMainActivity");
      return;
    case 2130838162: 
      paramAdapterView = new Intent(this.a, PhotoListActivity.class);
      paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", DLRouterActivity.class.getName());
      paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramAdapterView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      paramAdapterView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      paramAdapterView.putExtra(AlbumConstants.i, 55);
      paramAdapterView.putExtra("uin", this.a.b);
      paramAdapterView.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
      paramAdapterView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      paramAdapterView.getExtras().remove("forward_type");
      paramAdapterView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      this.a.startActivity(paramAdapterView);
      AlbumUtil.a(this.a, false, true);
      return;
    case 2130838169: 
      paramAdapterView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramAdapterView.putExtra("category", 6);
      paramAdapterView.putExtra("selectMode", true);
      paramAdapterView.putExtra("targetUin", this.a.b);
      paramAdapterView.putExtra("busiType", 6);
      paramAdapterView.putExtra("peerType", 6002);
      paramAdapterView.putExtra("tab_tab_type", 5);
      this.a.startActivityForResult(paramAdapterView, 2);
      return;
    case 2130838161: 
      if (((DataLineHandler)this.a.app.a(8)).a().a(this.a.b))
      {
        paramAdapterView = new QQToast(this.a.app.a().getApplicationContext());
        paramAdapterView.b(2131362385);
        paramAdapterView.c(0);
        paramAdapterView.b(this.a.getTitleBarHeight());
        return;
      }
      paramAdapterView = new Bundle();
      paramAdapterView.putBoolean("string_from", false);
      paramAdapterView.putBoolean("string_uin", false);
      paramAdapterView.putLong("device_din", Long.parseLong(this.a.b));
      paramAdapterView.putInt("sTitleID", 0);
      QQProxyForDataline.a(this.a, paramAdapterView, "com.qqdataline.activity.RouterWifiPhotoAlbumBackupActivity");
      return;
    }
    paramView = new Intent(this.a.getApplicationContext(), DLRouterSessionInfoActivity.class);
    paramView.putExtra("uin", this.a.b);
    paramView.putExtra(DLRouterSessionInfoActivity.b, paramAdapterView.a());
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */