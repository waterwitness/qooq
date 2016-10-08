import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyChannelRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.FileInputStream;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;

public class hxw
  implements Runnable
{
  public hxw(ReadInJoyChannelRecommendManager paramReadInJoyChannelRecommendManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = ReadInJoyUtils.a();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    for (;;)
    {
      return;
      localObject = new oidb_cmd0x69f.RspBody();
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(ReadInJoyChannelRecommendManager.b);
        byte[] arrayOfByte = new byte[localFileInputStream.available()];
        localFileInputStream.read(arrayOfByte);
        localFileInputStream.close();
        ((oidb_cmd0x69f.RspBody)localObject).mergeFrom(arrayOfByte);
        ReadInJoyHelper.a(BaseApplicationImpl.a().a(), false);
        if ((localObject == null) || (!((oidb_cmd0x69f.RspBody)localObject).rpt_recomm_channel_list.has()) || (((oidb_cmd0x69f.RspBody)localObject).rpt_recomm_channel_list.get() == null) || (((oidb_cmd0x69f.RspBody)localObject).rpt_recomm_channel_list.size() <= 0)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "load channelinfo from file, size:" + ((oidb_cmd0x69f.RspBody)localObject).rpt_recomm_channel_list.size());
        }
        ReadInJoyMSFHandlerUtils.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, ((oidb_cmd0x69f.RspBody)localObject).rpt_recomm_channel_list.get());
        ReadInJoyLogicEngineEventDispatcher.a().b(true);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "read Exception " + localException);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */