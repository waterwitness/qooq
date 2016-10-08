package com.tencent.mobileqq.vas;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;
import weg;
import weh;
import wej;
import wek;
import wel;
import wem;
import wen;
import weo;

public class ColorRingPlayer
  implements View.OnClickListener
{
  public static final String a = "ColorRingPlayer";
  public int a;
  public AudioManager.OnAudioFocusChangeListener a;
  public MediaPlayer a;
  public Handler a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public Button a;
  public ImageView a;
  public ProgressBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQBrowserActivity a;
  public Client.onRemoteRespObserver a;
  public PhotoProgressDrawable a;
  public Object a;
  public weo a;
  public boolean a;
  public ImageView b;
  ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public ImageView c;
  TextView c;
  TextView d;
  
  public ColorRingPlayer(QQBrowserActivity paramQQBrowserActivity, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Weo = new weo(this);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = null;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new weg(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new wem(this);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298138));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131303092));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303088));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131297446));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131303089));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301409));
    this.d = ((TextView)paramViewGroup.findViewById(2131303090));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303087));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131303091));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131303086));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  String a(int paramInt)
  {
    if (paramInt > 3599) {
      return "";
    }
    int i = paramInt % 60;
    paramInt /= 60;
    if (paramInt >= 10) {}
    for (String str = "" + paramInt;; str = "" + "0" + paramInt)
    {
      str = str + ":";
      if (i < 10) {
        break;
      }
      return str + i;
    }
    return str + "0" + i;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841668));
      }
      this.jdField_a_of_type_Weo.h = 5;
      return;
    }
  }
  
  void a(long paramLong)
  {
    ??? = new Bundle();
    ((Bundle)???).putLong("id", paramLong);
    ((Bundle)???).putInt("resourceType", 3);
    a(DataFactory.a("stopDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, (Bundle)???));
    synchronized (this.jdField_a_of_type_Weo)
    {
      this.jdField_a_of_type_Weo.h = 2;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841666));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370386));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
  }
  
  /* Error */
  public void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 137	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   16: ldc -14
    //   18: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_1
    //   22: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 47	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   35: astore 4
    //   37: aload 4
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   44: ifnull +15 -> 59
    //   47: aload_0
    //   48: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: invokevirtual 251	android/media/MediaPlayer:release	()V
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   59: aload 4
    //   61: monitorexit
    //   62: aload_0
    //   63: new 155	android/media/MediaPlayer
    //   66: dup
    //   67: invokespecial 252	android/media/MediaPlayer:<init>	()V
    //   70: putfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   73: aload_0
    //   74: getfield 45	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_Weo	Lweo;
    //   77: astore 4
    //   79: aload 4
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 45	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_Weo	Lweo;
    //   86: iconst_4
    //   87: putfield 188	weo:h	I
    //   90: aload 4
    //   92: monitorexit
    //   93: lload_1
    //   94: lconst_0
    //   95: lcmp
    //   96: ifne +257 -> 353
    //   99: aload_0
    //   100: getfield 69	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   103: invokevirtual 174	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   106: ldc -3
    //   108: invokevirtual 257	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   111: astore 4
    //   113: aload 4
    //   115: ifnonnull +75 -> 190
    //   118: aload_0
    //   119: getfield 47	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   122: astore 4
    //   124: aload 4
    //   126: monitorenter
    //   127: aload_0
    //   128: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   131: invokevirtual 251	android/media/MediaPlayer:release	()V
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   139: aload 4
    //   141: monitorexit
    //   142: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc 10
    //   150: iconst_2
    //   151: ldc_w 259
    //   154: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: return
    //   158: astore 5
    //   160: aload 4
    //   162: monitorexit
    //   163: aload 5
    //   165: athrow
    //   166: astore 5
    //   168: aload 4
    //   170: monitorexit
    //   171: aload 5
    //   173: athrow
    //   174: astore 4
    //   176: aload 4
    //   178: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   181: return
    //   182: astore 5
    //   184: aload 4
    //   186: monitorexit
    //   187: aload 5
    //   189: athrow
    //   190: aload_0
    //   191: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   194: aload 4
    //   196: invokevirtual 268	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   199: aload 4
    //   201: invokevirtual 272	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   204: aload 4
    //   206: invokevirtual 275	android/content/res/AssetFileDescriptor:getLength	()J
    //   209: invokevirtual 279	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   212: aload 4
    //   214: invokevirtual 282	android/content/res/AssetFileDescriptor:close	()V
    //   217: aload_0
    //   218: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   221: invokevirtual 285	android/media/MediaPlayer:prepare	()V
    //   224: aload_0
    //   225: getfield 69	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   228: ldc_w 287
    //   231: invokevirtual 291	com/tencent/mobileqq/activity/QQBrowserActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   234: checkcast 293	android/media/AudioManager
    //   237: astore 4
    //   239: aload 4
    //   241: aload_0
    //   242: getfield 60	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
    //   245: iconst_3
    //   246: iconst_1
    //   247: invokevirtual 297	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   250: iconst_1
    //   251: if_icmpne +117 -> 368
    //   254: aload_0
    //   255: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   258: iload_3
    //   259: invokevirtual 300	android/media/MediaPlayer:seekTo	(I)V
    //   262: aload_0
    //   263: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   266: invokevirtual 303	android/media/MediaPlayer:start	()V
    //   269: aload_0
    //   270: invokevirtual 305	com/tencent/mobileqq/vas/ColorRingPlayer:d	()V
    //   273: aload_0
    //   274: getfield 112	com/tencent/mobileqq/vas/ColorRingPlayer:d	Landroid/widget/TextView;
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   282: invokevirtual 308	android/media/MediaPlayer:getDuration	()I
    //   285: sipush 1000
    //   288: idiv
    //   289: invokevirtual 310	com/tencent/mobileqq/vas/ColorRingPlayer:a	(I)Ljava/lang/String;
    //   292: invokevirtual 311	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   295: aload_0
    //   296: getfield 96	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   299: aload_0
    //   300: getfield 69	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   303: invokevirtual 174	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   306: ldc_w 312
    //   309: invokevirtual 181	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   312: invokevirtual 185	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   315: aload_0
    //   316: getfield 96	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   319: iconst_0
    //   320: invokevirtual 224	android/widget/ImageView:setVisibility	(I)V
    //   323: aload_0
    //   324: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   327: new 314	wef
    //   330: dup
    //   331: aload_0
    //   332: aload 4
    //   334: invokespecial 317	wef:<init>	(Lcom/tencent/mobileqq/vas/ColorRingPlayer;Landroid/media/AudioManager;)V
    //   337: invokevirtual 321	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   340: aload_0
    //   341: ldc_w 323
    //   344: ldc_w 323
    //   347: lload_1
    //   348: iconst_0
    //   349: invokevirtual 326	com/tencent/mobileqq/vas/ColorRingPlayer:a	(Ljava/lang/String;Ljava/lang/String;JI)V
    //   352: return
    //   353: aload_0
    //   354: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   357: lload_1
    //   358: iconst_3
    //   359: invokestatic 331	com/tencent/mobileqq/vas/ColorRingManager:a	(JI)Ljava/lang/String;
    //   362: invokevirtual 334	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   365: goto -148 -> 217
    //   368: aload_0
    //   369: getfield 47	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   372: astore 4
    //   374: aload 4
    //   376: monitorenter
    //   377: aload_0
    //   378: getfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   381: invokevirtual 251	android/media/MediaPlayer:release	()V
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 49	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   389: aload 4
    //   391: monitorexit
    //   392: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq -238 -> 157
    //   398: ldc 10
    //   400: iconst_2
    //   401: ldc_w 336
    //   404: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: return
    //   408: astore 5
    //   410: aload 4
    //   412: monitorexit
    //   413: aload 5
    //   415: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	ColorRingPlayer
    //   0	416	1	paramLong	long
    //   0	416	3	paramInt	int
    //   174	39	4	localIOException	java.io.IOException
    //   158	6	5	localObject3	Object
    //   166	6	5	localObject4	Object
    //   182	6	5	localObject5	Object
    //   408	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   40	59	158	finally
    //   59	62	158	finally
    //   160	163	158	finally
    //   82	93	166	finally
    //   168	171	166	finally
    //   73	82	174	java/io/IOException
    //   99	113	174	java/io/IOException
    //   118	127	174	java/io/IOException
    //   142	157	174	java/io/IOException
    //   171	174	174	java/io/IOException
    //   187	190	174	java/io/IOException
    //   190	217	174	java/io/IOException
    //   217	352	174	java/io/IOException
    //   353	365	174	java/io/IOException
    //   368	377	174	java/io/IOException
    //   392	407	174	java/io/IOException
    //   413	416	174	java/io/IOException
    //   127	142	182	finally
    //   184	187	182	finally
    //   377	392	408	finally
    //   410	413	408	finally
  }
  
  void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt != 3)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("id", paramLong);
      ((Bundle)localObject).putInt("resourceType", paramInt);
      ((Bundle)localObject).putString("colorType", paramString);
      a(DataFactory.a("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, (Bundle)localObject));
      return;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      localObject = new wej(this, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getActivity(), 2131558973);
      ((QQCustomDialog)localObject).setContentView(2130903241);
      ((QQCustomDialog)localObject).setTitle("温馨提示");
      ((QQCustomDialog)localObject).setMessage(2131368354);
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setNegativeButton(2131367262, new wek(this));
      ((QQCustomDialog)localObject).setPositiveButton(2131367263, new wel(this, paramLong, paramInt, paramString));
      ((QQCustomDialog)localObject).show();
      return;
    }
    b(paramLong, paramInt, paramString);
  }
  
  void a(long paramLong, String paramString)
  {
    if ("colorring".equals(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370398);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(paramString);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(paramString);
      if (paramLong != 0L) {
        break label261;
      }
      a(paramLong, 0);
      if (!a(paramLong, paramString)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370391));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841667));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841665));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370392));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
      if ("comering".equals(paramString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370399);
      }
    }
    if (paramString.equals("colorring")) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370387));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      break;
      if (paramString.equals("comering")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370388));
      }
    }
    label261:
    if (a(paramLong, paramString)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (!new File(ColorRingManager.a(paramLong, 3)).exists())
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841666));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramString.equals("colorring"))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370387));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        a(paramLong, 3, paramString);
        label368:
        if (new File(ColorRingManager.a(paramLong, 1)).exists()) {
          break label610;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841664));
        a(paramLong, 1, paramString);
      }
    }
    for (;;)
    {
      if (new File(ColorRingManager.a(paramLong, 2)).exists()) {
        break label631;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      a(paramLong, 2, paramString);
      return;
      if (!paramString.equals("comering")) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370388));
      break;
      a(paramLong, 0);
      if (a(paramLong, paramString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370391));
        break label368;
      }
      if (paramString.equals("colorring")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370387));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        break;
        if (paramString.equals("comering")) {
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370388));
        }
      }
      label610:
      if (ColorRingManager.a(paramLong) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ColorRingManager.a(paramLong));
      }
    }
    label631:
    a(ColorRingManager.a(paramLong));
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String arg5)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Weo)
      {
        if (this.jdField_a_of_type_Weo.jdField_a_of_type_Long == paramLong)
        {
          if (paramInt != 0) {
            break label205;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370391));
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          if (!paramString1.equals("colorring")) {
            continue;
          }
          if (paramInt == 0)
          {
            paramInt = i;
            a("0X8004A24", "0X8004A24", paramLong, paramInt);
            Bundle localBundle = new Bundle();
            localBundle.putLong("id", paramLong);
            localBundle.putString("colorType", paramString1);
            a(DataFactory.a("colorRingSetup", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, localBundle));
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
          return;
        }
        paramInt = 1;
        continue;
        if (!paramString1.equals("comering")) {
          continue;
        }
        if (paramInt == 0)
        {
          paramInt = j;
          a("0X8005003", "0X8005003", paramLong, paramInt);
        }
      }
      paramInt = 1;
      continue;
      label205:
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "setup failure.");
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Weo.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_Weo.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      if (this.jdField_a_of_type_Weo.h == 6) {
        a(paramLong, 0);
      }
      return;
    }
    if (this.jdField_a_of_type_Weo.h == 1) {
      a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long);
    }
    b();
    this.jdField_a_of_type_Weo.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Weo.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Weo.b = paramString2;
    this.jdField_a_of_type_Weo.h = 0;
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    a(paramLong, paramString1);
  }
  
  public void a(Bundle paramBundle)
  {
    if (!WebIPCOperator.a().a())
    {
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), "正在初始化服务，请稍候尝试", 0).show();
      return;
    }
    WebIPCOperator.a().b(paramBundle);
  }
  
  public void a(String arg1)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841668));
    }
    synchronized (this.jdField_a_of_type_Weo)
    {
      this.jdField_a_of_type_Weo.h = 6;
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      return;
    }
  }
  
  void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new wen(this, paramString1, paramString2, paramLong, paramInt));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "initColorRingDetail, detail is null");
      }
      return;
    }
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramJSONObject.getString("singer"));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramJSONObject.getString("name"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  boolean a(long paramLong, String paramString)
  {
    Object localObject = (BrowserAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getAppRuntime();
    EntityManager localEntityManager = ((BrowserAppInterface)localObject).a(null).createEntityManager();
    localObject = (ExtensionInfo)localEntityManager.a(ExtensionInfo.class, ((BrowserAppInterface)localObject).getAccount());
    localEntityManager.a();
    if (localObject == null) {
      return false;
    }
    if (("colorring".equals(paramString)) && (((ExtensionInfo)localObject).colorRingId == paramLong)) {
      return true;
    }
    return ("comering".equals(paramString)) && (((ExtensionInfo)localObject).commingRingId == paramLong);
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      return;
    }
  }
  
  public void b(long paramLong, int paramInt, String arg4)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("id", paramLong);
    ((Bundle)localObject1).putInt("resourceType", paramInt);
    ((Bundle)localObject1).putString("colorType", ???);
    a(DataFactory.a("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, (Bundle)localObject1));
    synchronized (this.jdField_a_of_type_Weo)
    {
      this.jdField_a_of_type_Weo.h = 1;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ??? = null;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable == null) {}
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources(), 2130842480);
        ??? = (String)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;) {}
      }
      localObject1 = ???;
      if (??? == null) {
        localObject1 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = new PhotoProgressDrawable((Bitmap)localObject1, (int)(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().density * 12.0F));
      ??? = new Rect();
      ???.set(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131493200), this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131493201));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(???);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.invalidateSelf();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131370385));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  public void c()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          synchronized (this.jdField_a_of_type_Weo)
          {
            long l = this.jdField_a_of_type_Weo.jdField_a_of_type_Long;
            a(l, this.jdField_a_of_type_Int);
            d();
            this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841667));
          }
        }
      }
      synchronized (this.jdField_a_of_type_Weo)
      {
        this.jdField_a_of_type_Weo.h = 4;
        return;
        localObject4 = finally;
        throw ((Throwable)localObject4);
        localObject2 = finally;
        throw ((Throwable)localObject2);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
    }
  }
  
  void d()
  {
    ThreadManager.a(new weh(this), 8, null, true);
  }
  
  public void e()
  {
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    ??? = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("audio");
    if (??? == null) {
      return;
    }
    ((AudioManager)???).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      return;
    }
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841668));
      }
      synchronized (this.jdField_a_of_type_Weo)
      {
        this.jdField_a_of_type_Weo.h = 6;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void onClick(View arg1)
  {
    String str4 = (String)???.getTag();
    String str1 = str4;
    if (str4 == null) {
      str1 = "colorring";
    }
    switch (???.getId())
    {
    default: 
      return;
    case 2131303088: 
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Weo)
        {
          if (this.jdField_a_of_type_Weo.h == 4)
          {
            a();
            return;
          }
        }
        if (this.jdField_a_of_type_Weo.h == 5)
        {
          c();
        }
        else if (this.jdField_a_of_type_Weo.h == 6)
        {
          a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long, 0);
        }
        else if (this.jdField_a_of_type_Weo.h == 1)
        {
          a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long);
          this.jdField_a_of_type_Weo.h = 2;
        }
        else if (this.jdField_a_of_type_Weo.h == 2)
        {
          a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long, 3, str2);
        }
        else if (this.jdField_a_of_type_Weo.h == 0)
        {
          a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long, 3, str2);
        }
        else if (this.jdField_a_of_type_Weo.h == 3)
        {
          a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long, 0);
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Weo)
      {
        if (this.jdField_a_of_type_Weo.h == 1)
        {
          a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long);
          return;
        }
      }
      if (this.jdField_a_of_type_Weo.h == 2)
      {
        a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long, 3, str3);
      }
      else if (this.jdField_a_of_type_Weo.h == 0)
      {
        a(this.jdField_a_of_type_Weo.jdField_a_of_type_Long, 3, str3);
      }
      else if (this.jdField_a_of_type_Weo.h >= 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getWebView().a(this.jdField_a_of_type_Weo.b, new String[] { "{'result':0,'message':'OK'}" });
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\ColorRingPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */