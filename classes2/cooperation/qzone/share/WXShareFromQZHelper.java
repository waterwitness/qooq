package cooperation.qzone.share;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import ypn;
import ypo;
import ypp;

public class WXShareFromQZHelper
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WXShareFromQZHelper jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper;
  public static String a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b;
  public static final String c = "http://a.myapp.com/h/?g_f=990542#id=appdetail&appid=48157&icfa=13145982048157020000";
  public static final String d = "wx34b037fdb0f655ee";
  private IWXAPI jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.a(), "wx34b037fdb0f655ee", true);
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = WXShareFromQZHelper.class.getSimpleName();
    b = AppConstants.bj + "photo/";
  }
  
  private WXShareFromQZHelper()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    a();
  }
  
  public static WXShareFromQZHelper a()
  {
    if (jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper == null) {
        jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper = new WXShareFromQZHelper();
      }
      return jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    localIntent.putExtra("url", QzoneConfig.a().a("H5Url", "WeiXinDownload", "http://a.myapp.com/h/?g_f=990542#id=appdetail&appid=48157&icfa=13145982048157020000"));
    localIntent.putExtra("fromQZone", true);
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    return paramString + System.currentTimeMillis();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.registerApp("wx34b037fdb0f655ee");
  }
  
  public void a(WXShareFromQZHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramWXShareListener);
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new WXTextObject(paramString);
    paramString = new WXMediaMessage();
    paramString.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
    localObject = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject).transaction = a("text");
    ((SendMessageToWX.Req)localObject).message = paramString;
    ((SendMessageToWX.Req)localObject).scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq((BaseReq)localObject)) {
      ThreadManager.c().post(new ypp(this));
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = new WXMediaMessage(new WXWebpageObject(paramString3));
    paramString3.description = paramString2;
    paramString3.title = paramString1;
    paramString3.thumbData = WXShareHelper.a(paramBitmap, false, true);
    paramString1 = new SendMessageToWX.Req();
    paramString1.transaction = a("webpage");
    paramString1.message = paramString3;
    paramString1.scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq(paramString1)) {
      ThreadManager.c().post(new ypn(this));
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.imagePath = paramString;
    paramString = new WXMediaMessage();
    paramString.mediaObject = localWXImageObject;
    if (paramInt == 0)
    {
      paramString.thumbData = paramArrayOfByte;
      if ((paramString.thumbData == null) || ((paramString.thumbData != null) && (paramString.thumbData.length > 32768))) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "wxmsg.thumbData is invalid");
      }
    }
    paramArrayOfByte = new SendMessageToWX.Req();
    paramArrayOfByte.transaction = a("img");
    paramArrayOfByte.message = paramString;
    paramArrayOfByte.scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq(paramArrayOfByte)) {
      ThreadManager.c().post(new ypo(this));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public void b(WXShareFromQZHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramWXShareListener);
      }
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.isWXAppSupportAPI();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((WXShareFromQZHelper.WXShareListener)localIterator.next()).a(paramBaseResp);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\share\WXShareFromQZHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */