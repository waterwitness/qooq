import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class seg
  implements INetEventHandler
{
  public seg(FileBrowserActivity paramFileBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if ((AppNetConnInfo.isWifiConn()) && (this.a.isResume()))
    {
      QLog.d("FileBrowserActivity<FileAssistant>[MPFile]", 1, "网络切换到Wifi网络");
      QQToast.a(this.a.getApplicationContext(), 2131362274, 0).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\seg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */