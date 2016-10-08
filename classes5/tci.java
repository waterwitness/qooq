import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity.UiHandler;
import com.tencent.qphone.base.util.QLog;

public class tci
  extends SosoInterface.OnLocationListener
{
  public tci(VipMapRoamActivity paramVipMapRoamActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      Message localMessage = this.a.a.obtainMessage();
      localMessage.what = 300;
      localMessage.obj = paramSosoLbsInfo;
      this.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */