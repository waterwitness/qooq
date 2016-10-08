import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.QLog;

public class mej
  extends BroadcastReceiver
{
  public mej(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.mobileqq.onGetStreetViewUrl"))
    {
      this.a.n = paramIntent.getStringExtra("streetViewUrl");
      QQMapActivity.b(this.a);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramContext.equals("com.tencent.mobileqq.onGetLbsShareSearch"))
          {
            byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
            localObject = new LBSShare.LocationResp();
            paramContext = (Context)localObject;
            if (arrayOfByte != null) {}
            try
            {
              paramContext = (LBSShare.LocationResp)((LBSShare.LocationResp)localObject).mergeFrom(arrayOfByte);
              paramIntent = paramIntent.getExtras().getBundle("req");
              this.a.a(paramContext, paramIntent);
              return;
            }
            catch (InvalidProtocolBufferMicroException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  paramContext.printStackTrace();
                }
                paramContext = null;
              }
            }
          }
          if (!paramContext.equals("com.tencent.mobileqq.onGetLbsShareShop")) {
            break;
          }
          paramContext = paramIntent.getByteArrayExtra("data");
        } while (paramContext == null);
        Object localObject = new LBSShare.NearByShopsResp();
        try
        {
          paramContext = (LBSShare.NearByShopsResp)((LBSShare.NearByShopsResp)localObject).mergeFrom(paramContext);
          paramIntent = paramIntent.getExtras().getBundle("req");
          this.a.a(paramContext, paramIntent);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramContext)
        {
          if (QLog.isColorLevel()) {
            paramContext.printStackTrace();
          }
          this.a.a(null, null);
          return;
        }
      } while (!paramContext.equals("com.tencent.mobileqq.onGetShareShopDetail"));
      paramContext = paramIntent.getByteArrayExtra("data");
    } while (paramContext == null);
    paramIntent = new LBSShare.GetShopsByIdsResp();
    try
    {
      paramContext = (LBSShare.GetShopsByIdsResp)paramIntent.mergeFrom(paramContext);
      this.a.a(paramContext);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramContext)
    {
      if (QLog.isColorLevel()) {
        paramContext.printStackTrace();
      }
      this.a.a(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */