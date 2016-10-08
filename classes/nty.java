import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import mqq.os.MqqHandler;

public final class nty
  extends AsyncTask
{
  public nty(Context paramContext, int paramInt, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, StructMsgForImageShare paramStructMsgForImageShare)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    paramVarArgs = ((MessageForPic)this.jdField_a_of_type_ComTencentImageURLDrawable.getTag()).path;
    paramVarArgs = AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs);
    if (paramVarArgs != null)
    {
      AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    if (!AbsDownloader.a(paramVarArgs)) {
      return Integer.valueOf(1);
    }
    paramVarArgs = SecUtil.getFileMd5(AbsDownloader.a(paramVarArgs).getAbsolutePath());
    if (("".equals(paramVarArgs)) || (paramVarArgs == null)) {
      return Integer.valueOf(1);
    }
    FileUtils.b(AppConstants.bs + ".nomedia");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramVarArgs = AppConstants.bs + str + paramVarArgs + ".jpg";
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(paramVarArgs);
      return Integer.valueOf(AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare));
    }
    catch (IOException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      QLog.d("AIOGalleryUtils", 1, paramVarArgs, new Object[0]);
    }
    return Integer.valueOf(1);
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131368690), 0).b(this.jdField_a_of_type_Int);
      paramInteger = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (paramInteger != null) {
        paramInteger.obtainMessage(10).sendToTarget();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInteger.intValue() == 1)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131368779), 0).b(this.jdField_a_of_type_Int);
          return;
        }
        if (paramInteger.intValue() == 2)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131368694), 0).b(this.jdField_a_of_type_Int);
          return;
        }
      } while (paramInteger.intValue() != 3);
      paramInteger = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
    } while (paramInteger == null);
    paramInteger.obtainMessage(53).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */