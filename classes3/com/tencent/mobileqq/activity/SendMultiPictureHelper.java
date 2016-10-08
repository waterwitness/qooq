package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mkg;
import mkh;
import mki;
import mkj;
import mkk;
import mkl;
import mkn;
import mqq.os.MqqHandler;

public class SendMultiPictureHelper
{
  static final String jdField_a_of_type_JavaLangString = "SendMultiPictureHelper";
  public int a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  protected Bundle a;
  protected SendMultiPictureHelper.SendingFileInfo a;
  public BaseActivity a;
  public QQAppInterface a;
  public FMObserver a;
  INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  public QQCustomDialog a;
  public ArrayList a;
  public List a;
  public boolean a;
  public int b;
  DialogInterface.OnClickListener b;
  protected String b;
  public boolean b;
  public int c;
  DialogInterface.OnClickListener c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  protected String e;
  public String f;
  
  public SendMultiPictureHelper(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new mkg(this);
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new mkh(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new mki(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new mkj(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new mkk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    this.f = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370340);
  }
  
  private long a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (FileUtils.a(paramString1))
    {
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1001) && (paramInt != 3000)) {
        break label185;
      }
      ImageUtil.a(-1L, paramInt, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
      String str = ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, paramInt);
      ImageInfo localImageInfo = new ImageInfo();
      ImageUtil.a(4, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, str, true, localImageInfo, paramInt);
      paramString1 = localImageInfo.jdField_b_of_type_JavaLangString;
    }
    label185:
    for (;;)
    {
      long l1;
      if (!ImageUtil.a(null, paramString1, 1, null, "SendMultiPictureHelper.doSendPictues")) {
        l1 = 0L;
      }
      long l2;
      do
      {
        return l1;
        l2 = a(paramString1, paramString2, paramString3, paramInt);
        a(paramInt, paramString3, paramString1, l2, 1009);
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("streamptt", 2, "ChatActivity.handleForwardData uploadImage,uniseq:" + l2 + ",filePath:" + paramString1 + ",curType:" + paramInt);
      return l2;
      return 0L;
    }
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    long l = 0L;
    if (paramString1 != null)
    {
      paramString2 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = PicReq.a();
      paramString2.md5 = HexUtil.a(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      l = paramString2.uniseq;
    }
    return l;
  }
  
  private void a(int paramInt, String paramString, long paramLong)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString + paramLong);
    if ((paramString instanceof BaseTransProcessor)) {
      ((BaseTransProcessor)paramString).k();
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.jdField_c_of_type_JavaLangString = paramString1;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.e = paramInt2;
    localTransferRequest.i = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
  }
  
  private void e()
  {
    BaseTransProcessor localBaseTransProcessor = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
    if (localBaseTransProcessor != null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.w("SendMultiPictureHelper", 2, this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long + "has error");
        localBaseTransProcessor.j();
        a();
      }
      for (;;)
      {
        QLog.w("SendMultiPictureHelper", 2, "continue send " + this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        return;
        localBaseTransProcessor.a();
      }
    }
    QLog.w("SendMultiPictureHelper", 2, "processor null");
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long == -1L) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
      }
    }
    do
    {
      do
      {
        return;
        BaseTransProcessor localBaseTransProcessor = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        if (localBaseTransProcessor == null) {
          break;
        }
        localBaseTransProcessor.j();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      } while (!QLog.isColorLevel());
      QLog.d("SendMultiPictureHelper", 2, "stop send " + this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("SendMultiPictureHelper", 2, "processor null");
  }
  
  private void g() {}
  
  private void h()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      SendMultiPictureHelper.SendingFileInfo localSendingFileInfo = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      QLog.w("SendMultiPictureHelper", 2, "pauseSendFile index=" + this.jdField_a_of_type_Int + ",uniseq=" + localSendingFileInfo.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, localSendingFileInfo.jdField_a_of_type_Long, this.jdField_c_of_type_Int);
      return;
    }
  }
  
  private void i()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      SendMultiPictureHelper.SendingFileInfo localSendingFileInfo = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, localSendingFileInfo.jdField_a_of_type_Long, this.jdField_c_of_type_Int);
      return;
    }
  }
  
  public long a(SendMultiPictureHelper.SendingFileInfo paramSendingFileInfo, String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendMultiPictureHelper", 2, "why FileManagerRSCenter is null???");
      }
      return 0L;
    }
    paramSendingFileInfo = paramSendingFileInfo.jdField_a_of_type_JavaLangString;
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSendingFileInfo, paramString1, paramString2, paramInt, true).uniseq;
  }
  
  public void a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SendMultiPictureHelper", 2, "sendNext " + (this.jdField_a_of_type_Int + 1));
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label257;
        }
        SendMultiPictureHelper.SendingFileInfo localSendingFileInfo = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        Object localObject2 = localSendingFileInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = localSendingFileInfo;
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists())
        {
          this.jdField_c_of_type_Boolean = true;
          Toast.makeText(BaseApplicationImpl.a(), ((File)localObject2).getName() + "发送失败，己被移动或删除！", 0).show();
          if (!this.jdField_b_of_type_Boolean) {
            a();
          }
          return;
        }
        if (((File)localObject2).length() == 0L)
        {
          if (this.jdField_c_of_type_Int == 0) {
            Toast.makeText(BaseApplicationImpl.a(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370477), 0).show();
          }
        }
        else
        {
          a(localSendingFileInfo, this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
      Toast.makeText(BaseApplicationImpl.a(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370478), 0).show();
      continue;
      label257:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      c();
    }
  }
  
  public void a(SendMultiPictureHelper.SendingFileInfo paramSendingFileInfo, int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.a().post(new mkn(this, paramSendingFileInfo, paramInt, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle, ArrayList paramArrayList)
  {
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Int = paramInt;
    this.e = paramString3;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPicUploadProcessor.class, ForwardImageProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.e, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370343), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramString1 = paramArrayList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramString3 = new SendMultiPictureHelper.SendingFileInfo(this);
      paramString3.jdField_a_of_type_JavaLangString = paramString2;
      paramString3.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
    }
    paramString1 = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = 0;
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.f, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
        a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        paramInt += 1;
      }
      c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.f, new Object[] { Integer.valueOf(1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
    if (new File(paramString1).length() == 0L)
    {
      if (this.jdField_c_of_type_Int != 0) {
        break label521;
      }
      Toast.makeText(BaseApplicationImpl.a(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370477), 0).show();
    }
    for (;;)
    {
      a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new mkl(this);
      }
      AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      return;
      label521:
      Toast.makeText(BaseApplicationImpl.a(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370478), 0).show();
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370341);
    localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368978), (String)localObject, 2131370481, 2131367259, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
  
  public void c()
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler != null) {
        AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SendMultiPictureHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */