import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RandomListener;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.random.RandomWebProtocol.OnRequestListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gke
  implements RandomWebProtocol.OnRequestListener
{
  public gke(RandomController paramRandomController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, gkt paramgkt)
  {
    int j = 0;
    int i = 0;
    if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    for (;;)
    {
      return;
      if ((paramgkt.s == 1) || (paramgkt.s == 2))
      {
        switch (paramInt)
        {
        case -2: 
        default: 
          this.a.g();
          return;
        case 0: 
          this.a.a(paramgkt);
          return;
        case -1: 
          this.a.f();
          return;
        }
        this.a.b(paramgkt);
        return;
      }
      if ((paramgkt.s == -100) || (paramgkt.s == 3))
      {
        if (this.a.k == 1)
        {
          if ((paramInt == 0) && ((paramgkt instanceof gkv)))
          {
            paramgkt = (gkv)paramgkt;
            this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.a = paramgkt.a;
            if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.f()) {
              while (i < this.a.jdField_a_of_type_JavaUtilList.size())
              {
                ((RandomController.RandomListener)this.a.jdField_a_of_type_JavaUtilList.get(i)).a();
                i += 1;
              }
            }
          }
        }
        else if (this.a.k == 2)
        {
          Object localObject2;
          Object localObject1;
          VideoController.GAudioFriends localGAudioFriends;
          if ((paramInt == 0) && ((paramgkt instanceof gkx)))
          {
            localObject2 = (gkx)paramgkt;
            i = j;
            if (((gkx)localObject2).C != 0) {
              if (((gkx)localObject2).C != 2) {
                break label452;
              }
            }
            label452:
            for (localObject1 = ((gkx)localObject2).e;; localObject1 = String.valueOf(((gkx)localObject2).jdField_a_of_type_Long))
            {
              i = j;
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                localGAudioFriends = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1);
                i = j;
                if (localGAudioFriends != null)
                {
                  i = j;
                  if (localObject2 != null)
                  {
                    localGAudioFriends.c = ((gkx)localObject2).c;
                    this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, ((gkx)localObject2).b, ((gkx)localObject2).c);
                    i = j;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + localGAudioFriends.jdField_a_of_type_Long + ", headUrl:" + localGAudioFriends.c);
                      i = j;
                    }
                  }
                }
              }
              while (i < this.a.jdField_a_of_type_JavaUtilList.size())
              {
                ((RandomController.RandomListener)this.a.jdField_a_of_type_JavaUtilList.get(i)).a();
                i += 1;
              }
            }
          }
          if (paramInt == 100)
          {
            localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.b();
            localObject1 = new StringBuffer();
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject2).next();
              ((StringBuffer)localObject1).append(localGAudioFriends.jdField_a_of_type_Long + "|");
            }
            if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol != null)) {
              this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.a.m, 5, ((StringBuffer)localObject1).toString(), this.a.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()), this.a.jdField_a_of_type_Long);
            }
          }
          if ((paramgkt instanceof gkx))
          {
            paramgkt = (gkx)paramgkt;
            if ((!TextUtils.isEmpty(paramgkt.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e)))
            {
              this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e = (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getString(2131363808) + " “" + paramgkt.d + "” ");
              this.a.i = paramgkt.d;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e);
              }
            }
          }
        }
        if (paramInt == -3)
        {
          paramgkt = this.a.jdField_a_of_type_JavaUtilList.iterator();
          while (paramgkt.hasNext()) {
            ((RandomController.RandomListener)paramgkt.next()).a();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */