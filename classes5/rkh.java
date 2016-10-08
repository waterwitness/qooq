import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class rkh
  extends SyncListener
{
  public rkh(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "upload_finish");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "download_finish");
    }
    this.a.post(new rki(this));
    this.a.e();
    ReportController.b(this.a.a, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    if (this.a.a == null) {}
    while (("overflow".equals(paramCustomEmotionData.RomaingType)) || ("overflow_downloaded".equals(paramCustomEmotionData.RomaingType)) || ("needDownload".equals(paramCustomEmotionData.RomaingType)) || ((paramInt1 > 8) && (paramInt2 % 8 != 0))) {
      return;
    }
    this.a.e();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "roaming_finish");
    }
    if (this.a.a != null) {
      ((FavroamingManager)this.a.a.getManager(102)).removeSyncListener(EmoticonMainPanel.a(this.a));
    }
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */