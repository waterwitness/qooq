package com.tencent.mobileqq.musicpendant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tgw;
import tgx;

public class MusicPendantManager
  implements Handler.Callback
{
  public static final int a = 10000;
  private static MusicPendantManager jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager;
  public static String a;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final int jdField_b_of_type_Int = 1000;
  private static final String jdField_b_of_type_JavaLangString = "MusicPendantManager";
  private static WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private static final int jdField_c_of_type_Int = 1001;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MusicPendantManager");
  private QQPlayerService.QQPlayerCallback jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback = new tgw(this);
  public WeakReference a;
  private boolean jdField_a_of_type_Boolean;
  private SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangString = "";
  }
  
  private MusicPendantManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public static Intent a(Context paramContext, AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext();
        localObject = new Intent((Context)localObject, QQBrowserActivity.class);
        paramContext = "http://y.qq.com/m/personal_music/index.html?_wv=3&_bid=2032";
        if (paramAppInterface != null) {}
        try
        {
          paramContext = "http://y.qq.com/m/personal_music/index.html?_wv=3&_bid=2032" + "&uin=" + paramAppInterface.a();
          paramAppInterface = paramContext;
          if (!TextUtils.isEmpty(paramString)) {
            paramAppInterface = paramContext + "&guestuin=" + paramString;
          }
          if (!paramBoolean) {
            continue;
          }
          paramContext = paramAppInterface + "&ADTAG=GXYY_GUAJIAN";
          ((Intent)localObject).putExtra("url", paramContext);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          return (Intent)localObject;
        }
        catch (Exception paramAppInterface)
        {
          paramContext = (Context)localObject;
        }
        QLog.e("MusicPendantManager", 1, "openMusicPendantSettingPage() app is null.");
        continue;
      }
      catch (Exception paramAppInterface)
      {
        paramContext = null;
        continue;
      }
      QLog.e("MusicPendantManager", 1, "getPlayBarIntent() exception", paramAppInterface);
      return paramContext;
      paramContext = paramAppInterface + "&ADTAG=GXYY_TOPCELL";
    }
  }
  
  public static MusicPendantManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager == null) {
      jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager = new MusicPendantManager();
    }
    return jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    try
    {
      jdField_a_of_type_JavaLangString = QQPlayerService.a(6, "MusicPendantManager");
      return jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPendantManager", 1, "MusicPendantManager() exception", localException);
      }
    }
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 164	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +198 -> 204
    //   9: iconst_4
    //   10: invokestatic 167	com/tencent/mobileqq/music/QQPlayerService:a	()I
    //   13: if_icmpge +37 -> 50
    //   16: ldc 16
    //   18: iconst_1
    //   19: new 92	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   26: ldc -87
    //   28: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokestatic 167	com/tencent/mobileqq/music/QQPlayerService:a	()I
    //   34: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 175	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Landroid/content/Context;
    //   47: invokestatic 178	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   50: new 180	android/os/Bundle
    //   53: dup
    //   54: invokespecial 181	android/os/Bundle:<init>	()V
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore 7
    //   61: lload 7
    //   63: lstore 5
    //   65: aload_0
    //   66: getfield 183	com/tencent/mobileqq/musicpendant/MusicPendantManager:c	Ljava/lang/String;
    //   69: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +15 -> 87
    //   75: aload_0
    //   76: getfield 183	com/tencent/mobileqq/musicpendant/MusicPendantManager:c	Ljava/lang/String;
    //   79: invokestatic 189	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   82: invokevirtual 192	java/lang/Long:longValue	()J
    //   85: lstore 5
    //   87: aload_2
    //   88: ldc -62
    //   90: lload 5
    //   92: invokevirtual 198	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   95: aload_2
    //   96: ldc -56
    //   98: iconst_1
    //   99: invokevirtual 204	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   102: aload_2
    //   103: invokestatic 207	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/os/Bundle;)V
    //   106: aload_0
    //   107: iconst_0
    //   108: invokevirtual 210	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	(Z)Landroid/content/Intent;
    //   111: astore_2
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokestatic 213	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Intent;)V
    //   120: bipush 102
    //   122: invokestatic 215	com/tencent/mobileqq/music/QQPlayerService:a	(I)V
    //   125: iload_1
    //   126: iflt +87 -> 213
    //   129: iload_1
    //   130: istore 4
    //   132: iload_1
    //   133: aload_0
    //   134: getfield 164	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   137: arraylength
    //   138: if_icmple +6 -> 144
    //   141: goto +72 -> 213
    //   144: aload_0
    //   145: getfield 58	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback	Lcom/tencent/mobileqq/music/QQPlayerService$QQPlayerCallback;
    //   148: invokestatic 218	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService$QQPlayerCallback;)V
    //   151: aload_0
    //   152: invokevirtual 175	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Landroid/content/Context;
    //   155: getstatic 42	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 164	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   162: iload 4
    //   164: invokestatic 221	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Context;Ljava/lang/String;[Lcom/tencent/mobileqq/music/SongInfo;I)V
    //   167: return
    //   168: astore_2
    //   169: ldc 16
    //   171: iconst_1
    //   172: ldc -33
    //   174: aload_2
    //   175: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: goto -128 -> 50
    //   181: astore_2
    //   182: ldc 16
    //   184: iconst_1
    //   185: ldc -31
    //   187: aload_2
    //   188: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: return
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   197: lload 7
    //   199: lstore 5
    //   201: goto -114 -> 87
    //   204: ldc 16
    //   206: iconst_1
    //   207: ldc -26
    //   209: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: return
    //   213: iconst_0
    //   214: istore 4
    //   216: goto -72 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	MusicPendantManager
    //   0	219	1	paramInt	int
    //   4	113	2	localObject	Object
    //   168	7	2	localException1	Exception
    //   181	7	2	localException2	Exception
    //   192	2	3	localException3	Exception
    //   130	85	4	i	int
    //   63	137	5	l1	long
    //   59	139	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   9	50	168	java/lang/Exception
    //   0	5	181	java/lang/Exception
    //   50	58	181	java/lang/Exception
    //   87	112	181	java/lang/Exception
    //   116	120	181	java/lang/Exception
    //   120	125	181	java/lang/Exception
    //   132	141	181	java/lang/Exception
    //   144	167	181	java/lang/Exception
    //   169	178	181	java/lang/Exception
    //   193	197	181	java/lang/Exception
    //   204	212	181	java/lang/Exception
    //   65	87	192	java/lang/Exception
  }
  
  public static boolean a(SongInfo[] paramArrayOfSongInfo1, SongInfo[] paramArrayOfSongInfo2)
  {
    if ((paramArrayOfSongInfo1 == null) || (paramArrayOfSongInfo2 == null)) {}
    int j;
    do
    {
      return false;
      if (paramArrayOfSongInfo1 == paramArrayOfSongInfo2) {
        return true;
      }
      i = paramArrayOfSongInfo1.length;
      j = paramArrayOfSongInfo2.length;
    } while ((i != j) || (i == 0));
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label62;
      }
      if (paramArrayOfSongInfo1[i].a != paramArrayOfSongInfo2[i].a) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  public Context a()
  {
    if (b != null) {}
    for (Activity localActivity = (Activity)b.get();; localActivity = null)
    {
      Object localObject = localActivity;
      if (localActivity == null) {
        localObject = BaseApplication.getContext();
      }
      return (Context)localObject;
    }
  }
  
  public Intent a(boolean paramBoolean)
  {
    Activity localActivity;
    if (b != null)
    {
      localActivity = (Activity)b.get();
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        break label50;
      }
    }
    label50:
    for (QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localQQAppInterface = null)
    {
      return a(localActivity, localQQAppInterface, this.c, paramBoolean);
      localActivity = null;
      break;
    }
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public Card a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        String str = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
        FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(50);
        if (localFriendsManager != null)
        {
          if (!TextUtils.isEmpty(str)) {
            return localFriendsManager.b(str);
          }
          QLog.e("MusicPendantManager", 1, "localUserUinString is empty");
          return null;
        }
        QLog.e("MusicPendantManager", 1, "FriendsManager is null");
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "mAppInterface is null");
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "getLocalUserCard() exception", localException);
    }
    return null;
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        CardHandler localCardHandler = (CardHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
        if (localCardHandler != null) {
          localCardHandler.a(b(), paramInt1, paramInt2);
        }
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() mAppInterface is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() exception", localException);
    }
  }
  
  public void a(Card paramCard)
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.b(paramCard);
        }
      }
      return;
    }
    catch (Exception paramCard)
    {
      QLog.e("MusicPendantManager", 1, "setUin() exception", paramCard);
    }
  }
  
  public void a(MusicPendantListener paramMusicPendantListener)
  {
    ArrayList localArrayList = jdField_a_of_type_JavaUtilArrayList;
    if (paramMusicPendantListener != null) {}
    for (;;)
    {
      try
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() != paramMusicPendantListener)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramMusicPendantListener));
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
          continue;
        }
        str = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
        if (!paramString.equalsIgnoreCase(str)) {
          continue;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase(this.c))) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = null;
        }
      }
      catch (Exception localException)
      {
        String str;
        boolean bool;
        QLog.e("MusicPendantManager", 1, "setUin() exception", localException);
        continue;
      }
      this.c = paramString;
      return;
      str = "";
      continue;
      bool = false;
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (paramActivity != null) {}
    for (;;)
    {
      try
      {
        b = new WeakReference(paramActivity);
        if (paramQQAppInterface == null) {
          break label81;
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
        a(paramString);
        f();
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 100L);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("MusicPendantManager", 1, "init(uinString) exception", paramString);
        return;
      }
      b = null;
      continue;
      label81:
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void a(SongInfo[] paramArrayOfSongInfo)
  {
    int m = 0;
    if (paramArrayOfSongInfo != null) {}
    for (;;)
    {
      int k;
      try
      {
        j = paramArrayOfSongInfo.length;
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (j != this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length)) {
          break label122;
        }
        k = 0;
        i = m;
        if (k < j)
        {
          if (paramArrayOfSongInfo[k].a == this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[k].a) {
            break label113;
          }
          i = 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = paramArrayOfSongInfo;
        if (i != 0)
        {
          ThreadManager.a(new tgx(this), 8, null, true);
          return;
        }
        QLog.i("MusicPendantManager", 1, "setMusicPendantSongList(SongInfo) isPlayListChanged:false.");
        return;
      }
      catch (Exception paramArrayOfSongInfo)
      {
        QLog.e("MusicPendantManager", 1, "setMusicPendantSongList(SongInfo) exception", paramArrayOfSongInfo);
        return;
      }
      int j = -1;
      continue;
      label113:
      k += 1;
      continue;
      label122:
      int i = 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public SongInfo[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) {
          break label145;
        }
        Object localObject = QQPlayerService.a();
        if (localObject == null) {
          break label155;
        }
        localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + "";
        if ((TextUtils.isEmpty(this.c)) || (!this.c.equalsIgnoreCase((String)localObject)) || (!jdField_a_of_type_JavaLangString.equalsIgnoreCase(QQPlayerService.a()))) {
          break label139;
        }
        int i = QQPlayerService.a();
        if ((i == 2) || (i == 1))
        {
          localObject = QQPlayerService.a();
          if (a(this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo, (SongInfo[])localObject)) {
            break label154;
          }
          a(0);
          return;
        }
        if (i == 3)
        {
          QQPlayerService.b(a());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPendantManager", 1, "play() exception", localException);
        return;
      }
      a(0);
      return;
      label139:
      a(0);
      return;
      label145:
      QLog.e("MusicPendantManager", 1, "play() mMusicPendantSongs is null!");
      label154:
      return;
      label155:
      String str = "";
    }
  }
  
  public void b(MusicPendantListener paramMusicPendantListener)
  {
    ArrayList localArrayList = jdField_a_of_type_JavaUtilArrayList;
    if (paramMusicPendantListener != null) {}
    int i;
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList == null) {
        break label100;
      }
      i = jdField_a_of_type_JavaUtilArrayList.size();
    }
    finally {}
    if (i >= 0)
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localWeakReference != null) && ((localWeakReference.get() == null) || (localWeakReference.get() == paramMusicPendantListener))) {
        jdField_a_of_type_JavaUtilArrayList.remove(localWeakReference);
      }
    }
    else
    {
      return;
    }
    for (;;)
    {
      i -= 1;
      break;
      i -= 1;
      break;
      label100:
      i = 0;
    }
  }
  
  public void c()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) {
          break label132;
        }
        Object localObject = QQPlayerService.a();
        if (localObject == null) {
          break label142;
        }
        localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + "";
        if ((TextUtils.isEmpty(this.c)) || (!this.c.equalsIgnoreCase((String)localObject)) || (!jdField_a_of_type_JavaLangString.equalsIgnoreCase(QQPlayerService.a()))) {
          break label126;
        }
        int i = QQPlayerService.a();
        if ((i == 2) || (i == 1))
        {
          QQPlayerService.a(a());
          return;
        }
        if (i == 3)
        {
          QQPlayerService.b(a());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPendantManager", 1, "playOrPause() exception", localException);
        return;
      }
      a(0);
      return;
      label126:
      a(0);
      return;
      label132:
      QLog.e("MusicPendantManager", 1, "playOrPause() mMusicPendantSongs is null!");
      return;
      label142:
      String str = "";
    }
  }
  
  public void d()
  {
    try
    {
      Object localObject = QQPlayerService.a();
      if (localObject != null) {}
      for (localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + ""; (!TextUtils.isEmpty(this.c)) && (this.c.equalsIgnoreCase((String)localObject)) && (jdField_a_of_type_JavaLangString.equalsIgnoreCase(QQPlayerService.a())); localObject = "")
      {
        QQPlayerService.a(a());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "pause() exception", localException);
    }
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.a();
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          QLog.e("MusicPendantManager", 1, "destroy() exception1", localException1);
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            this.jdField_a_of_type_JavaLangRefWeakReference.clear();
            this.jdField_a_of_type_JavaLangRefWeakReference = null;
          }
          if (b != null)
          {
            b.clear();
            b = null;
          }
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("MusicPendantManager", 1, "destroy() exception2", localException2);
        }
        a();
      }
    }
  }
  
  public void f()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        CardHandler localCardHandler = (CardHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
        if (localCardHandler != null) {
          localCardHandler.c(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), b());
        }
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "request4MusicPendantSongList() mAppInterface is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "request4MusicPendantSongList() exception", localException);
    }
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        CardHandler localCardHandler = (CardHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
        if (localCardHandler != null) {
          localCardHandler.b(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), b());
        }
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() mAppInterface is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() exception", localException);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    if (paramMessage != null)
    {
      try
      {
        i = paramMessage.what;
      }
      catch (Exception paramMessage)
      {
        QLog.e("MusicPendantManager", 1, "CallBack.handleMessage() exception", paramMessage);
        return true;
      }
      a(0);
      return true;
      g();
      return true;
    }
    switch (i)
    {
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\musicpendant\MusicPendantManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */