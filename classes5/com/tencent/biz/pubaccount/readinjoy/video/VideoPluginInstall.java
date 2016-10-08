package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import ial;
import iam;

public class VideoPluginInstall
{
  public static final int a = 0;
  public static final int b = 1;
  private static boolean b = false;
  public static final int c = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoPluginInstall.OnVideoPluginInstallListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener;
  private TVK_SDKMgr.InstallListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_SDKMgr$InstallListener;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoPluginInstall(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_SDKMgr$InstallListener = new ial(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new iam(this));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void c()
  {
    try
    {
      if (!b)
      {
        b = true;
        TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean))
    {
      c();
      TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_SDKMgr$InstallListener);
    }
  }
  
  public void a(VideoPluginInstall.OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener = paramOnVideoPluginInstallListener;
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_SDKMgr$InstallListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\video\VideoPluginInstall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */