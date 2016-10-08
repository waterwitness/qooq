import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.common.DownloadReceiver;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.open.downloadnew.common.NoticeParam;

public class wxq
  implements Runnable
{
  public wxq(DownloadReceiver paramDownloadReceiver, String paramString1, NoticeParam paramNoticeParam, String paramString2, String paramString3, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
    boolean bool;
    if (localObject2 == null) {
      if ((this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d != null) && (!this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d.trim().equals("")))
      {
        bool = true;
        localObject2 = new DownloadInfo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.b, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a, 0, bool);
        if (!(IntentFactory.c + "." + this.b).equals(this.c)) {
          break label324;
        }
        localObject1 = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
        if ((localObject1 != null) && (((DownloadInfo)localObject1).a() != 2) && (((DownloadInfo)localObject1).a() != 20))
        {
          ((DownloadInfo)localObject2).a(3);
          DownloadManager.a().a(3, (DownloadInfo)localObject2);
        }
        DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
      }
    }
    label215:
    label238:
    label261:
    label300:
    label308:
    label316:
    label324:
    do
    {
      return;
      bool = false;
      break;
      if (TextUtils.isEmpty(((DownloadInfo)localObject2).c))
      {
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e;
        ((DownloadInfo)localObject2).c = ((String)localObject1);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)) {
          break label300;
        }
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d;
        ((DownloadInfo)localObject2).d = ((String)localObject1);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject2).jdField_g_of_type_JavaLangString)) {
          break label308;
        }
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_g_of_type_JavaLangString;
        ((DownloadInfo)localObject2).jdField_g_of_type_JavaLangString = ((String)localObject1);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject2).e)) {
          break label316;
        }
      }
      for (localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.b;; localObject1 = ((DownloadInfo)localObject2).e)
      {
        ((DownloadInfo)localObject2).e = ((String)localObject1);
        break;
        localObject1 = ((DownloadInfo)localObject2).c;
        break label215;
        localObject1 = ((DownloadInfo)localObject2).d;
        break label238;
        localObject1 = ((DownloadInfo)localObject2).jdField_g_of_type_JavaLangString;
        break label261;
      }
      if ((IntentFactory.b + "." + this.b).equals(this.c))
      {
        DownloadManager.a().a((DownloadInfo)localObject2);
        return;
      }
      if ((IntentFactory.d + "." + this.b).equals(this.c))
      {
        DownloadManager.a().a((DownloadInfo)localObject2);
        return;
      }
      if ((IntentFactory.e + "." + this.b).equals(this.c))
      {
        AppUtil.a(this.jdField_a_of_type_AndroidContentContext, DownloadManager.a().a(this.jdField_a_of_type_JavaLangString));
        return;
      }
    } while (!(IntentFactory.jdField_g_of_type_JavaLangString + "." + this.b).equals(this.c));
    if ((MyAppApi.a().c()) && (localObject2 != null) && (((DownloadInfo)localObject2).h == 1))
    {
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a == null) {}
      for (localObject1 = new Bundle();; localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a.getExtras())
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Bundle();
        }
        ((Bundle)localObject3).putString(DownloadConstants.jdField_a_of_type_JavaLangString, ((DownloadInfo)localObject2).b);
        ((Bundle)localObject3).putString(DownloadConstants.b, ((DownloadInfo)localObject2).i);
        ((Bundle)localObject3).putString(DownloadConstants.c, ((DownloadInfo)localObject2).j);
        ((Bundle)localObject3).putString(DownloadConstants.e, ((DownloadInfo)localObject2).d);
        ((Bundle)localObject3).putInt(DownloadConstants.d, ((DownloadInfo)localObject2).jdField_g_of_type_Int);
        MyAppApi.a().a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), (Bundle)localObject3, true, true);
        return;
      }
    }
    Object localObject3 = new Intent();
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a == null) {}
    for (Object localObject1 = new Bundle();; localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a.getExtras())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Intent)localObject3).putExtras((Bundle)localObject2);
      ((Intent)localObject3).setClass(CommonDataAdapter.a().a(), QZoneAppWebViewActivity.class);
      ((Intent)localObject3).addFlags(872415232);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */