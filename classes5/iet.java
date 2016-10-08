import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.pubaccount.util.PAH5Manager;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class iet
  extends TransProcessorHandler
{
  public iet(PAH5Manager paramPAH5Manager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || ((localFileMsg.e != 24) && (localFileMsg.e != 32))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while ((localFileMsg.e == 24) && (localFileMsg.f != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localFileMsg.c));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localFileMsg.c);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.c));
              this.a.a(localFileMsg.c);
              this.a.b(localFileMsg.c);
            } while (paramMessage == null);
            if (localFileMsg.e == 32)
            {
              new PublicAccountH5AbilityForPtt();
              paramMessage.putLong("uniseq", localFileMsg.c);
              paramMessage.putString("pic_server_id", PublicAccountH5AbilityForPtt.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localFileMsg.c);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localFileMsg.c);
              paramMessage.putString("pic_server_id", localFileMsg.k);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.c));
            this.a.a(localFileMsg.c);
            this.a.b(localFileMsg.c);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localFileMsg.c);
          }
          paramMessage.putLong("uniseq", localFileMsg.c);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localFileMsg.c));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localFileMsg.c);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.c));
      } while (paramMessage == null);
      if (localFileMsg.e == 32) {
        paramMessage.putString("pic_local_id", new PublicAccountH5AbilityForPtt().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localFileMsg.c);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.c));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */