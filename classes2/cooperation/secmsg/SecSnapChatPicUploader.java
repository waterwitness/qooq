package cooperation.secmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.SnapChatPicUpProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import java.util.concurrent.ConcurrentHashMap;
import yss;

public class SecSnapChatPicUploader
  implements ISecMsgUploader
{
  private static final int jdField_a_of_type_Int = 32;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  public SecSnapChatPicUploader.OnSnapChatUploadListener a;
  public ConcurrentHashMap a;
  
  public SecSnapChatPicUploader(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new yss(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { SnapChatPicUpProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = null;
  }
  
  public void a(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_secmsg_id");
    Object localObject1 = paramBundle.getString("key_secgroup_id");
    long l2 = paramBundle.getLong("key_secgroupuin");
    boolean bool = paramBundle.getBoolean("key_is_snapchat_pic");
    paramBundle = paramBundle.getString("key_secmsg_localpath");
    if ((l1 == 0L) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramBundle))) {}
    long l3;
    Object localObject2;
    do
    {
      return;
      l3 = ((String)localObject1).hashCode() + l1;
      String str = String.valueOf(l2);
      if (((SecSnapChatPicUploader.PicUploadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l3)) != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(str, l3);
        if ((localObject2 != null) && ((localObject2 instanceof SnapChatPicUpProcessor))) {
          ((SnapChatPicUpProcessor)localObject2).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l3));
      }
      localObject2 = new SecSnapChatPicUploader.PicUploadInfo();
      ((SecSnapChatPicUploader.PicUploadInfo)localObject2).jdField_a_of_type_JavaLangString = paramBundle;
      ((SecSnapChatPicUploader.PicUploadInfo)localObject2).jdField_a_of_type_Boolean = bool;
      ((SecSnapChatPicUploader.PicUploadInfo)localObject2).jdField_a_of_type_Long = l1;
      ((SecSnapChatPicUploader.PicUploadInfo)localObject2).b = ((String)localObject1);
      ((SecSnapChatPicUploader.PicUploadInfo)localObject2).f = str;
      localObject1 = new TransferRequest();
      ((TransferRequest)localObject1).c = ((SecSnapChatPicUploader.PicUploadInfo)localObject2).f;
      ((TransferRequest)localObject1).jdField_a_of_type_Boolean = true;
      ((TransferRequest)localObject1).i = paramBundle;
      ((TransferRequest)localObject1).b = 23;
      ((TransferRequest)localObject1).f = l3;
      ((TransferRequest)localObject1).k = bool;
      ((TransferRequest)localObject1).jdField_a_of_type_Long = l1;
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a((TransferRequest)localObject1);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l3), localObject2);
  }
  
  public void a(SecSnapChatPicUploader.OnSnapChatUploadListener paramOnSnapChatUploadListener)
  {
    this.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener = paramOnSnapChatUploadListener;
  }
  
  public void b(Bundle paramBundle)
  {
    long l = paramBundle.getLong("key_secmsg_id");
    paramBundle = paramBundle.getString("key_secgroup_id");
    if ((l == 0L) || (TextUtils.isEmpty(paramBundle))) {}
    do
    {
      do
      {
        return;
        l += paramBundle.hashCode();
        paramBundle = (SecSnapChatPicUploader.PicUploadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
      } while ((paramBundle == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null));
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramBundle.f, l);
    } while ((paramBundle == null) || (!(paramBundle instanceof SnapChatPicUpProcessor)));
    ((SnapChatPicUpProcessor)paramBundle).b();
  }
  
  public void c(Bundle paramBundle)
  {
    long l = paramBundle.getLong("key_secmsg_id");
    paramBundle = paramBundle.getString("key_secgroup_id");
    if ((l == 0L) || (TextUtils.isEmpty(paramBundle))) {}
    do
    {
      return;
      l += paramBundle.hashCode();
      paramBundle = (SecSnapChatPicUploader.PicUploadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
    } while (paramBundle == null);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramBundle.f, l);
      if ((paramBundle != null) && ((paramBundle instanceof SnapChatPicUpProcessor))) {
        ((SnapChatPicUpProcessor)paramBundle).b();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
  }
  
  public void d(Bundle paramBundle)
  {
    long l = paramBundle.getLong("key_secmsg_id");
    Object localObject = paramBundle.getString("key_secgroup_id");
    if ((l == 0L) || (TextUtils.isEmpty((CharSequence)localObject))) {}
    do
    {
      return;
      l += ((String)localObject).hashCode();
      localObject = (SecSnapChatPicUploader.PicUploadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) && (localObject != null))
      {
        IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(((SecSnapChatPicUploader.PicUploadInfo)localObject).f, l);
        if ((localIHttpCommunicatorListener != null) && ((localIHttpCommunicatorListener instanceof SnapChatPicUpProcessor))) {
          ((SnapChatPicUpProcessor)localIHttpCommunicatorListener).a();
        }
      }
    } while (localObject != null);
    a(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\SecSnapChatPicUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */