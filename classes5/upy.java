import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class upy
  implements INetEngine.INetEngineListener
{
  upy(upx paramupx, SharedPreferences paramSharedPreferences, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i(PtvTemplateManager.a, 2, "onResp url: " + this.jdField_a_of_type_Upx.a.l + " resultcode: " + paramNetResp.g);
    }
    if (paramNetResp.e == 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("teach_video_download_time", 0).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("download_teach_video_last_time", 0L).commit();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("teach_video_download_time", this.jdField_a_of_type_Int + 1).commit();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("download_teach_video_last_time", System.currentTimeMillis()).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */