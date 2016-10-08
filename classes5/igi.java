import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.os.MqqHandler;

class igi
  implements Runnable
{
  igi(igh paramigh, boolean paramBoolean, Bundle paramBundle)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    j = 0;
    int k = 0;
    i = 0;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 0) {
      for (;;)
      {
        try
        {
          localObject4 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("data");
          if (localObject4 == null) {
            break label466;
          }
          i = j;
          localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          i = j;
          localGetPublicAccountDetailInfoResponse.mergeFrom((byte[])localObject4);
          i = j;
          if (!localGetPublicAccountDetailInfoResponse.ret_info.has()) {
            break label466;
          }
          i = j;
          if (!((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has()) {
            break label466;
          }
          i = j;
          if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() != 0) {
            break label466;
          }
          i = j;
          localObject4 = new AccountDetail(localGetPublicAccountDetailInfoResponse);
          i = j;
          localObject5 = this.jdField_a_of_type_Igh.a.a(this.jdField_a_of_type_Igh.a.getAccount()).createEntityManager();
          if (localObject5 == null) {
            break label466;
          }
          i = j;
          ((EntityManager)localObject5).b((Entity)localObject4);
          if (localObject4 != null)
          {
            i = j;
            localObject5 = (PublicAccountDataManager)this.jdField_a_of_type_Igh.a.getManager(55);
            if (localObject5 != null)
            {
              i = j;
              ((PublicAccountDataManager)localObject5).a((AccountDetail)localObject4);
              i = j;
              if (((PublicAccountDataManager)localObject5).b(((AccountDetail)localObject4).uin) == null)
              {
                i = j;
                if (((AccountDetail)localObject4).followType == 1)
                {
                  i = j;
                  ((PublicAccountDataManager)localObject5).a(PublicAccountInfo.createPublicAccount((AccountDetail)localObject4, 0L));
                }
              }
            }
          }
          i = j;
          j = k;
        }
        catch (Exception localException1)
        {
          Object localObject4;
          mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse;
          Object localObject5;
          label439:
          continue;
        }
        for (;;)
        {
          try
          {
            if (PublicAccountUtil.a != null)
            {
              j = k;
              PublicAccountUtil.a.sendEmptyMessage(36);
              i = 1;
            }
          }
          finally
          {
            i = j;
            break label439;
          }
          try
          {
            if ((PublicAccountUtil.a() != null) && (localGetPublicAccountDetailInfoResponse.uin.has()))
            {
              localObject5 = Message.obtain();
              ((Message)localObject5).obj = String.valueOf(localGetPublicAccountDetailInfoResponse.uin.get());
              ((Message)localObject5).what = 200;
              PublicAccountUtil.a().sendMessage((Message)localObject5);
            }
            j = i;
          }
          finally
          {
            break label439;
          }
        }
        try
        {
          if (localGetPublicAccountDetailInfoResponse.uin.has())
          {
            j = i;
            if (localObject4 != null)
            {
              ServiceAccountFolderManager.a().a(this.jdField_a_of_type_Igh.a, (AccountDetail)localObject4);
              j = i;
            }
          }
          i = j;
        }
        catch (Exception localException2)
        {
          continue;
        }
        if (i == 0) {}
        try
        {
          if (PublicAccountUtil.a != null) {
            PublicAccountUtil.a.sendEmptyMessage(36);
          }
          return;
        }
        finally {}
        j = k;
        localObject5 = this.jdField_a_of_type_Igh.a.a(Conversation.class);
        if (localObject5 == null) {
          break;
        }
        j = k;
        ((MqqHandler)localObject5).sendEmptyMessage(1014);
        break;
        j = i;
        throw localGetPublicAccountDetailInfoResponse;
        label466:
        j = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\igi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */