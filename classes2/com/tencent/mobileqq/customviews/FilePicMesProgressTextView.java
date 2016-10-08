package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import rbl;
import rbm;

public class FilePicMesProgressTextView
  extends MessageProgressTextView
{
  private static final String jdField_a_of_type_JavaLangString = "ProgressTextView";
  int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FMObserver a;
  public FileManagerEntity a;
  private BaseTransProcessor jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
  rbm jdField_a_of_type_Rbm;
  public boolean a;
  int b;
  public boolean b;
  private boolean e;
  
  public FilePicMesProgressTextView(Context paramContext, QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d();
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new rbl(this);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.e) && (this.jdField_b_of_type_Boolean)) {
      setText(paramInt + "%");
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setLevel((100 - paramInt) * 100);
        if (((localDrawable instanceof AIOSendMask)) && (!this.jdField_b_of_type_Boolean)) {
          ((AIOSendMask)localDrawable).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      return;
      setText("");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\customviews\FilePicMesProgressTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */