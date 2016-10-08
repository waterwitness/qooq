package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import rko;
import rkp;

public abstract class EmotionNeedDownloadAdapter
  extends BaseEmotionAdapter
{
  public static final int l = 1;
  public static final int m = 2;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener;
  EmotionPanelPayBackListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListener;
  protected int n;
  
  public EmotionNeedDownloadAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.n = 2;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListener = new rko(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new rkp(this);
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmotionPanelPayBackListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListener);
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime()).getManager(46)).a(1);
  }
  
  public void a()
  {
    super.a();
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmotionPanelPayBackListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListener);
  }
  
  public void a(int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void b(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionNeedDownloadAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */