import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyChannelRecommendManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;

public class hxv
  implements Runnable
{
  public hxv(ReadInJoyChannelRecommendManager paramReadInJoyChannelRecommendManager, oidb_cmd0x69f.RspBody paramRspBody)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplicationImpl.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.c = ((AppRuntime)localObject).getAccount();
      }
      ReadInJoyChannelRecommendManager.b = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "channel_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.c;
      localObject = new File(ReadInJoyChannelRecommendManager.b);
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = new FileOutputStream((File)localObject, false);
      ((FileOutputStream)localObject).write(this.jdField_a_of_type_TencentImOidbCmd0x69fOidb_cmd0x69f$RspBody.toByteArray());
      ((FileOutputStream)localObject).close();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.a, 2, "save channelinfo write succ");
      }
      localObject = ReadInJoyUtils.a();
      if (!(localObject instanceof QQAppInterface))
      {
        ReadInJoyHelper.a((AppRuntime)localObject, true);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.a, 2, "update setting true");
        }
      }
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.a, 2, "write file not found " + localFileNotFoundException);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.a, 2, "write Exception " + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */