package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import iar;
import ias;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import mqq.util.WeakReference;

public class VideoVolumeControl
{
  private static VideoVolumeControl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl;
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video.VideoVolumeControl";
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private iar jdField_a_of_type_Iar;
  private ias jdField_a_of_type_Ias;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Map jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public VideoVolumeControl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new WeakHashMap();
    this.jdField_b_of_type_JavaUtilMap = new WeakHashMap();
    this.f = true;
  }
  
  /* Error */
  public static VideoVolumeControl a()
  {
    // Byte code:
    //   0: getstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   3: ifnull +7 -> 10
    //   6: getstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   9: areturn
    //   10: ldc 2
    //   12: monitorenter
    //   13: getstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   16: ifnonnull +13 -> 29
    //   19: new 2	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl
    //   22: dup
    //   23: invokespecial 79	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:<init>	()V
    //   26: putstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   29: getstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   32: invokestatic 85	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   35: invokestatic 90	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;)Z
    //   38: putfield 35	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_Boolean	Z
    //   41: getstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   44: getstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   47: getfield 35	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_Boolean	Z
    //   50: putfield 37	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_b_of_type_Boolean	Z
    //   53: ldc 2
    //   55: monitorexit
    //   56: getstatic 78	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   59: areturn
    //   60: astore_0
    //   61: ldc 9
    //   63: iconst_1
    //   64: ldc 92
    //   66: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: goto -16 -> 53
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   60	1	0	localException	Exception
    //   72	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	53	60	java/lang/Exception
    //   13	29	72	finally
    //   29	53	72	finally
    //   53	56	72	finally
    //   61	69	72	finally
    //   73	76	72	finally
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getCallState();
      return (i == 1) || (i == 2);
    }
    catch (Exception paramContext)
    {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "obtain inCall info failed " + paramContext.toString());
    }
    return false;
  }
  
  public void a()
  {
    if (!this.c) {
      a(this.jdField_a_of_type_Boolean, "start auto play");
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "errParam");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "inKandianModule origin:" + this.jdField_a_of_type_AndroidAppActivity + " act:" + paramActivity);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "real inKandianModule origin:" + this.jdField_a_of_type_AndroidAppActivity + " act:" + paramActivity);
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("audio"));
    this.jdField_a_of_type_Ias = new ias(this, null);
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramActivity.addAction("android.intent.action.HEADSET_PLUG");
    paramActivity.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramActivity.addAction("android.media.RINGER_MODE_CHANGED");
    this.f = true;
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_Ias, paramActivity);
    paramActivity = (TelephonyManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("phone");
    this.jdField_a_of_type_Iar = new iar(this);
    paramActivity.listen(this.jdField_a_of_type_Iar, 32);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramImageView));
  }
  
  public void a(VideoPlayMgr paramVideoPlayMgr)
  {
    if (paramVideoPlayMgr != null)
    {
      paramVideoPlayMgr.a(a());
      if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramVideoPlayMgr)) {
        this.jdField_b_of_type_JavaUtilMap.put(paramVideoPlayMgr, Boolean.valueOf(true));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "addVideoMgr :" + paramVideoPlayMgr + " list:" + this.jdField_b_of_type_JavaUtilMap);
    }
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null)
    {
      paramVideoPlayManager.a(a());
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramVideoPlayManager)) {
        this.jdField_a_of_type_JavaUtilMap.put(paramVideoPlayManager, Boolean.valueOf(true));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "addVideoManager :" + paramVideoPlayManager + " list:" + this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!this.c) {
      this.c = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "setMute :" + paramBoolean + " reason:" + paramString);
    }
    boolean bool = paramBoolean;
    int i;
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if ((!paramBoolean) && ("user_click".equals(paramString)) && (i == 0))
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, (int)(this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3) * 0.3D), 0);
        bool = paramBoolean;
      }
    }
    else
    {
      paramString = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      i = 0;
    }
    Object localObject;
    int j;
    while (paramString.hasNext())
    {
      localObject = (VideoPlayManager)paramString.next();
      if (localObject == null) {
        break label532;
      }
      ((VideoPlayManager)localObject).a(bool);
      j = ((VideoPlayManager)localObject).a() | i;
      continue;
      if ((paramBoolean) || (j == 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        bool = paramBoolean;
        break;
      }
    }
    paramString = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (paramString.hasNext())
    {
      localObject = (VideoPlayMgr)paramString.next();
      if (localObject != null)
      {
        ((VideoPlayMgr)localObject).a(bool);
        j |= ((VideoPlayMgr)localObject).a();
      }
    }
    if ((!bool) && (j != 0) && (this.jdField_a_of_type_AndroidMediaAudioManager != null)) {
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
    }
    this.jdField_b_of_type_Boolean = bool;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      j = 0;
    }
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          paramString = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if ((paramString == null) || (paramString.get() == null)) {
            break label535;
          }
          if (!bool) {
            break label458;
          }
          if (((ImageView)paramString.get()).getId() != 2131296593) {
            break label429;
          }
          ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130841359));
        }
      }
      catch (Exception paramString)
      {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "failed to update volume view:" + paramString.toString());
      }
      return;
      label429:
      ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130841361));
      break label535;
      label458:
      if (((ImageView)paramString.get()).getId() == 2131296593)
      {
        ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130841360));
      }
      else
      {
        ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130841362));
        break label535;
        label532:
        break;
      }
      label535:
      int k;
      j += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(Activity paramActivity)
  {
    if (paramActivity == this.jdField_a_of_type_AndroidAppActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "really outKandianModule origin:" + this.jdField_a_of_type_AndroidAppActivity + " act:" + paramActivity);
      }
      if (!this.d)
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.setRingerMode(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_b_of_type_Int, 0);
      }
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_Ias);
        ((TelephonyManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("phone")).listen(this.jdField_a_of_type_Iar, 0);
      }
      this.jdField_a_of_type_Iar = null;
      this.jdField_a_of_type_Ias = null;
      this.jdField_a_of_type_AndroidAppActivity = null;
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
      if (!this.d)
      {
        a(this.jdField_a_of_type_Boolean, "outKandianModule");
        this.c = false;
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.d = false;
        this.e = false;
      }
    }
    QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "outKandianModule origin:" + this.jdField_a_of_type_AndroidAppActivity + " act:" + paramActivity);
  }
  
  public void b(VideoPlayMgr paramVideoPlayMgr)
  {
    if (paramVideoPlayMgr != null) {
      this.jdField_b_of_type_JavaUtilMap.remove(paramVideoPlayMgr);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "removeVideoMgr :" + paramVideoPlayMgr + " list:" + this.jdField_b_of_type_JavaUtilMap);
    }
  }
  
  public void b(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramVideoPlayManager);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "removeVideoManager :" + paramVideoPlayManager + " list:" + this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (VideoPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoPlayManager)localObject).a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          ((VideoPlayManager)localObject).c(true);
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoPlayMgr)localIterator.next();
        if ((localObject != null) && (((VideoPlayMgr)localObject).a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          ((VideoPlayMgr)localObject).b(true);
        }
      }
    }
  }
  
  public boolean b()
  {
    return !this.c;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (paramBoolean) {
      this.e = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\video\VideoVolumeControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */