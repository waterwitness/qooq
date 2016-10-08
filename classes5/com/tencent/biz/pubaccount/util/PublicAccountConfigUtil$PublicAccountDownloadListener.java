package com.tencent.biz.pubaccount.util;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.LebaIconDownloader.IDownloadListener;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PublicAccountConfigUtil$PublicAccountDownloadListener
  implements LebaIconDownloader.IDownloadListener
{
  PublicAccountConfigUtil.PublicAccountConfigFolder jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public PublicAccountConfigUtil$PublicAccountDownloadListener(PublicAccountConfigUtil.PublicAccountConfigFolder paramPublicAccountConfigFolder, QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder = paramPublicAccountConfigFolder;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail, status: " + paramInt + " | icon: " + paramDrawable + " | mFolder: " + this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder);
    }
    if ((paramInt == 2) && (paramDrawable != null) && (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder.a = paramDrawable;
    }
    try
    {
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(1).a(4, true, new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail", paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PublicAccountConfigUtil$PublicAccountDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */